package com.addrbook.frontend.controller;

import com.addrbook.backend.domain.TomcatUsers;
import com.addrbook.backend.exception.PersonNotFoundException;
import com.addrbook.backend.json.UserJson;
import com.addrbook.backend.service.PersonService;
import com.addrbook.backend.util.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * REST layer for managing people.
 *
 * @author Adapted from http://codetutr.com/2013/04/09/spring-mvc-easy-rest-based-json-services-with-responsebody/
 */
@Controller
@Validated
public class UserController {

    //   (Stateless Spring Security Part 2: Stateless Authentication) http://www.javacodegeeks.com/2014/10/stateless-spring-security-part-2-stateless-authentication.html
    // * (Асинхронная обработка данных в web-приложениях на Java) https://www.youtube.com/watch?v=08Kf6pa4TAY

    private PersonService personService;
    private DataFactory personDataFactory;

    private class ProductActive{
        private String status;
        private String message;
        public String getStatus(){
            return status;
        }
        public String getMessage(){
            return message;
        }
        public void setStatus(String status){
            this.status = status;
        }
        public void setMessage(String message){
            this.message = message;
        }
    }

    @Autowired
    public UserController(PersonService personService, DataFactory personDataFactory) {
        this.personService = personService;
        this.personDataFactory = personDataFactory;
    }

    /**
     * @param name
     * @return Returns the person with the given id.
     */
    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public TomcatUsers getUserById(@PathVariable("name") String name) {
        return personDataFactory.createUser(personService.getUserById(name));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserJson getAllUsers(){
        return personDataFactory.createUser("success", "Data selected from database", personService.getAllUsers());
    }

    /**
     * Creates a new user.
     * @param request
     * @return Returns the id for the new person.
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String createUser(@RequestBody TomcatUsers request) {
        TomcatUsers user = new TomcatUsers();
        user.setUserName(request.getUserName());
        user.setUserPass(request.getUserPass());
        user.setUserFio(request.getUserFio());
        user.setUserLdap(request.getUserLdap());
        user.setEmail(request.getEmail());
        user.setGroupName(request.getGroupName());
        user.setIp("10.13.71.153");
        user.setRegdate(new Date());
        user.setStatus(request.getStatus());
        personService.saveUser(user);
        return user.getUserName();
    }

    // http://www.dineshonjava.com/2012/12/using-namedparameterjdbctemplate-in.html#.VTTGPxf7t0w
    @RequestMapping(value = "/users/{name}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public boolean deleteUser(@PathVariable("name") String name) {
        personService.deleteUser(name);
        return true;
    }

    // (mvn -P=systest test) http://habrahabr.ru/post/146984/
    // (spring @requestmapping request body)
    // http://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
    // http://stackoverflow.com/questions/19468572/spring-mvc-why-not-able-to-use-requestbody-and-requestparam-together
    // http://stackoverflow.com/questions/20400233/spring-mvc-requestmapping-from-json
    // http://blog.zenika.com/index.php?post/2013/07/11/Documenting-a-REST-API-with-Swagger-and-Spring-MVC
    // (Building REST APIs With Spring Boot) http://ryanjbaxter.com/2014/12/17/building-rest-apis-with-spring-boot/
    // * (java.util.concurrent) http://www.infoq.com/articles/boot-microservices
    @RequestMapping(value = "/users/{name}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ProductActive getUserUpdateId(@PathVariable("name") String name, @RequestBody @Valid TomcatUsers user) {
        ProductActive  active = new ProductActive();
        TomcatUsers updateUser = personDataFactory.createUser(personService.getUserById(name));
        updateUser.setUserPass(user.getUserPass());
        updateUser.setUserFio(user.getUserFio());
        updateUser.setEmail(user.getEmail());
        updateUser.setGroupName(user.getGroupName());
        updateUser.setUpdateIp("0.0.0.0");
        updateUser.setUpdateRegdate(new Date());
        updateUser.setStatus(user.getStatus());
        active.setStatus("success");
        active.setMessage("User information Full-Updated Successfully.");
        personService.updateUser(updateUser);
        return active;
    }


    // ... -> этот эксепшит вываливается когда отсутствует какой-то из параметров в теле запроса...
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    @ResponseStatus(value = HttpStatus.NOT_MODIFIED)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletResponse response) {
        BindingResult bindingResult = ex.getBindingResult();

        TomcatUsers updateUser = personDataFactory.createUser(personService.getUserById(bindingResult.getFieldValue("name").toString()));
        updateUser.setStatus( bindingResult.getFieldValue("status").toString());
        personService.updateUser(updateUser);

        List<FieldError> errors = bindingResult.getFieldErrors();
        StringBuffer customMessage = new StringBuffer();
        for( FieldError error : errors ){
            customMessage.append(error.getObjectName() + "." + error.getField() + " " + error.getDefaultMessage() + "\n");
        }
        return customMessage.toString();
    }

    // JSON convert exception -> этот эксепшит вываливается когда имеем (совсем) другой параметр в теле запроса...
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletResponse response) {
        return "json convert failure!";
    }

    // --- Error handlers (это мой класс, который обрабатывает исключение)
    @ExceptionHandler(value = PersonNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handlePersonNotFoundException(PersonNotFoundException e) {
        return e.getMessage();
    }

//    // NullPointerException
//    @ExceptionHandler(value = NullPointerException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public String handleHttpMessageNotReadableException(NullPointerException ex) {
//        return "NullPointerException!";
//    }
//    // IOException
//    @ExceptionHandler(value = IOException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public String handleIOException(MethodArgumentNotValidException ex) {
//        return "IOException";
//    }
}

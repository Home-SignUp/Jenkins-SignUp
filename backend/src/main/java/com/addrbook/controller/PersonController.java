package com.addrbook.controller;

import com.addrbook.domain.Customer;
import com.addrbook.domain.Person;
import com.addrbook.domain.Product;
import com.addrbook.exception.PersonNotFoundException;
import com.addrbook.json.PersonJson;
import com.addrbook.json.PersonJsonList;
import com.addrbook.json.ProductJson;
import com.addrbook.json.save.SavePersonRequest;
import com.addrbook.service.PersonService;
import com.addrbook.util.DataFactory;
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
import java.util.List;

/**
* REST layer for managing people.
*
* @author Adapted from http://codetutr.com/2013/04/09/spring-mvc-easy-rest-based-json-services-with-responsebody/
*/
@Controller
//@RestController
@Validated
public class PersonController {

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
	public PersonController(PersonService personService, DataFactory personDataFactory) {
		this.personService = personService;
		this.personDataFactory = personDataFactory;
	}

	/**
	 * @param id
	 * @return Returns the person with the given id.
	 */
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PersonJson getPersonById(@PathVariable("id") Integer id) {
		return personDataFactory.createPerson(personService.getPersonById(id));
	}

	/**
	 * Creates a new person.
	 * @param request
	 * @return Returns the id for the new person.
	 */
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	@ResponseBody
	public Integer createPerson(@RequestBody SavePersonRequest request) {
		Person person = new Person();
		person.setFirstName(request.getFirstName());
		person.setLastName(request.getLastName());
		person.setUserName(request.getUserName());
		personService.savePerson(person);
		return person.getId();
	}

    @RequestMapping(value = "/persons", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PersonJsonList getAllPersons(){
        return personDataFactory.createPerson(personService.getAllPersons());
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Customer getCustomer(){
        return personService.getCustomer();
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Customer> getAllCustomers(){
        return personService.getAllCustomers();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ProductJson getAllProducts(){
        return personDataFactory.createProduct("success", "Data selected from database", personService.getAllProducts());
    }

    // (mvn -P=systest test) http://habrahabr.ru/post/146984/
    // (spring @requestmapping request body)
    // http://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
    // http://stackoverflow.com/questions/19468572/spring-mvc-why-not-able-to-use-requestbody-and-requestparam-together
    // http://stackoverflow.com/questions/20400233/spring-mvc-requestmapping-from-json
    // http://blog.zenika.com/index.php?post/2013/07/11/Documenting-a-REST-API-with-Swagger-and-Spring-MVC
    // * http://ryanjbaxter.com/2014/12/17/building-rest-apis-with-spring-boot/
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ProductActive getProductUpdateId(@PathVariable("id") Integer id, @RequestBody @Valid Product product) {
        ProductActive  active = new ProductActive();
        Product updateProduct = personDataFactory.createProduct(personService.getProductById(id));
        updateProduct.setCategory(product.getCategory());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setImage(product.getImage());
        updateProduct.setMrp(product.getMrp());
        updateProduct.setName(product.getName());
        updateProduct.setPacking(product.getPacking());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setSku(product.getSku());
        updateProduct.setStatus(product.getStatus());
        updateProduct.setStock(product.getStock());
        active.setStatus("success");
        active.setMessage("Product information Full-Updated Successfully.");
        personService.updateProduct(updateProduct);
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

        Product updateProduct = personDataFactory.createProduct(personService.getProductById( Integer.parseInt(bindingResult.getFieldValue("id").toString()) ));
        updateProduct.setStatus( bindingResult.getFieldValue("status").toString());
        personService.updateProduct(updateProduct);

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

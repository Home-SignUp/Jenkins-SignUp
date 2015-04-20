package com.addrbook.frontend.controller;

import com.addrbook.backend.domain.Product;
import com.addrbook.backend.exception.PersonNotFoundException;
import com.addrbook.backend.json.ProductJson;
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
import java.util.List;
import java.util.Random;

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
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product getProductById(@PathVariable("id") Integer id) {
        return personDataFactory.createProduct(personService.getProductById(id));
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ProductJson getAllProducts(){
        return personDataFactory.createProduct("success", "Data selected from database", personService.getAllProducts());
    }

    /**
     * Creates a new person.
     * @param request
     * @return Returns the id for the new person.
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Integer createProduct(@RequestBody Product request) {
        Random    random = new Random();
        Integer      sku = random.nextInt(9999) + 99;
        double       mrp = 99 + (999 - 99) * random.nextDouble();
        Integer category = random.nextInt(200) + 100;

        Product product = new Product();
        product.setCategory(category);
        product.setDescription(request.getDescription());
//        product.setImage(request.getImage());
        product.setMrp(mrp);
        product.setName(request.getName());
        product.setPacking(request.getPacking());
        product.setPrice(request.getPrice());
        product.setSku(sku);
        product.setStatus(request.getStatus());
        product.setStock(request.getStock());
        personService.saveProduct(product);
        return product.getId();
    }

    // http://www.dineshonjava.com/2012/12/using-namedparameterjdbctemplate-in.html#.VTTGPxf7t0w
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public boolean deleteProduct(@PathVariable("id") Integer id) {
        personService.deleteProduct(id);
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

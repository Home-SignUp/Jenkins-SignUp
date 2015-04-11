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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
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

    class Test{
        public Test(){}
        public Test(int a, String b){
            this.a = a;
            this.b = b;
        }

        private int a = 10;
        private String b = "MyTest";

        public int getA() {
            return a;
        }
        public String getB() {
            return b;
        }
    }
    class Tests{
        private List<Test> tests;

        public void setTests(List<Test> tests){
            this.tests = tests;
        }
        public List<Test> getTests(){
            return tests;
        }
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
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ProductActive getProductActiveId(@PathVariable("id") Integer id, @RequestBody @NotNull @Valid final Product product, BindingResult bindingResult) {

//        if(product.getCategory() != null) System.out.println(product.getCategory());
//        if(product.getDescription() != null) System.out.println(product.getDescription());
//        if(product.getImage() != null) System.out.println(product.getImage());
//        if(product.getMrp() != null) System.out.println(product.getMrp());
//        if(product.getName() != null) System.out.println(product.getName());
//        if(product.getPacking() != null) System.out.println(product.getPacking());
//        if(product.getPrice() != null) System.out.println(product.getPrice());
//        if(product.getSku() != null) System.out.println(product.getSku());
//        if(product.getStatus() != null) System.out.println(product.getStatus());
//        if(product.getStock() != null) System.out.println(product.getStock());

        ProductActive  active = new ProductActive();
        Product updateProduct = personDataFactory.createProduct(personService.getProductById(id));
        if( product.getName() != null
                && product.getPrice() != null
                && product.getDescription() != null
                && product.getPacking() != null
                && product.getCategory() != null
                && product.getStock() != null
                && product.getStatus() != null ){
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
        } else {
            updateProduct.setStatus(product.getStatus());
            active.setStatus("success");
            active.setMessage("Product information Status-Updated Successfully.");
        }
        personService.updateProduct(updateProduct);

        return active;

//        updateProduct.setStatus(product.getStatus());
//        personService.updateProduct(updateProduct);
//        try {
//            updateProduct.setCategory(product.getCategory());
//            updateProduct.setDescription(product.getDescription());
//            updateProduct.setImage(product.getImage());
//            updateProduct.setMrp(product.getMrp());
//            updateProduct.setName(product.getName());
//            updateProduct.setPacking(product.getPacking());
//            updateProduct.setPrice(product.getPrice());
//            updateProduct.setSku(product.getSku());
//            updateProduct.setStatus(product.getStatus());
//            updateProduct.setStock(product.getStock());
//            personService.updateProduct(updateProduct);
//            active.setStatus("success");
//            active.setMessage("Product information Full-Updated Successfully.");
//        } catch (Exception e){
//            active.setStatus("success");
//            active.setMessage("Product information Status-Updated Successfully.");
//        } finally {}
    }

    // http://elleinfonotes.blogspot.com/2013/01/spring-30-validation-and-errorhandling.html
    // http://blog.goyello.com/2011/12/16/enhancements-spring-mvc31/
    // http://www.infoq.com/articles/boot-microservices
    /// http://ryanjbaxter.com/2014/12/17/building-rest-apis-with-spring-boot/
    // http://langmnm.iteye.com/blog/2078439
    // http://www.codesandnotes.be/2014/12/18/validating-spring-rest-controllers-beans-using-the-bean-validation-api-and-writing-the-tests-for-it/
    // http://www.petrikainulainen.net/programming/spring-framework/spring-from-the-trenches-adding-validation-to-a-rest-api/
    // http://www.petrikainulainen.net/programming/jooq/using-jooq-with-spring-crud/
    // http://www.captechconsulting.com/blogs/versioned-validated-and-secured-rest-services-with-spring-40
    // http://www.petrikainulainen.net/programming/spring-framework/creating-a-rest-api-with-spring-boot-and-mongodb/
    /// http://fruzenshtein.com/spring-rest-exception-handling-3/
    // http://stackoverflow.com/questions/18613027/validator-for-methodargumentnotvalidexception-only-handles-constraint-of-same-ty
    // http://elleinfonotes.blogspot.com/2013/01/spring-30-validation-and-errorhandling.html
    // http://www.jayway.com/2012/09/23/improve-your-spring-rest-api-part-ii/

    class ProductActive{
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


    @RequestMapping(value = "/tests", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Test> getTest(){
        List<Test> tests = new ArrayList<Test>();
        tests.add(new Test(1, "MyTest1"));
        tests.add(new Test(2, "MyTest2"));
        tests.add(new Test(3, "MyTest3"));

        return tests;
    }
//    public Tests getTest(){
//        List<Test> tests = new ArrayList<Test>();
//        tests.add(new Test(1, "MyTest1"));
//        tests.add(new Test(2, "MyTest2"));
//        tests.add(new Test(3, "MyTest3"));
//
//        Tests testsJson = new Tests();
//        testsJson.setTests(tests);
//
//     return testsJson;
//    }
	
	// --- Error handlers

	@ExceptionHandler(PersonNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handlePersonNotFoundException(PersonNotFoundException e) {
		return e.getMessage();
	}

//    // valid exception
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        BindingResult bindingResult = ex.getBindingResult();
//        String errorMesssage = "Invalid Request:";
//
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            errorMesssage += fieldError.getDefaultMessage() + ", ";
//        }
//        return "Invalid Request:";
//    }

    // JSON convert exception
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return "json convert failure!";
    }

    // JSON convert exception
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleHttpMessageNotReadableException(NullPointerException ex) {
        return "json NullPointerException!";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        StringBuffer customMessage = new StringBuffer();
        for (FieldError error : errors ) {
            customMessage.append(error.getObjectName() +"." + error.getField() +" "+ error.getDefaultMessage()+"\n");
        }
        return customMessage.toString();
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleIOException(MethodArgumentNotValidException ex) {
        return "MethodArgumentNotValidException";
    }
}

package com.addrbook.controller;

import com.addrbook.domain.Customer;
import com.addrbook.domain.Person;
import com.addrbook.exception.PersonNotFoundException;
import com.addrbook.json.PersonJson;
import com.addrbook.json.PersonJsonList;
import com.addrbook.json.save.SavePersonRequest;
import com.addrbook.service.PersonService;
import com.addrbook.util.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST layer for managing people.
 * 
 * @author Adapted from http://codetutr.com/2013/04/09/spring-mvc-easy-rest-based-json-services-with-responsebody/
 */
@Controller
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
//    public CustomerJsonList getAllCustomers(){
//        return personDataFactory.createCustomer(personService.getAllCustomers());
//    }

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

}

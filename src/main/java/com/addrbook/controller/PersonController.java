package com.addrbook.controller;

import com.addrbook.domain.Person;
import com.addrbook.dto.PersonDto;
import com.addrbook.dto.save.SavePersonRequest;
import com.addrbook.exception.PersonNotFoundException;
import com.addrbook.service.PersonService;
import com.addrbook.service.PersonServiceImpl;
import com.addrbook.util.DtoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * REST layer for managing people.
 * 
 * @author Adapted from http://codetutr.com/2013/04/09/spring-mvc-easy-rest-based-json-services-with-responsebody/
 */
@Controller
public class PersonController {

	private PersonService personService;
	private DtoFactory personDtoFactory;
    private PersonServiceImpl personServiceImp;

	@Autowired
	public PersonController(PersonService personService, DtoFactory personDtoFactory) {
		this.personService = personService;
		this.personDtoFactory = personDtoFactory;
	}

	/**
	 * @param id
	 * @return Returns the person with the given id.
	 */
	@RequestMapping("person/{id}")
	@ResponseBody
	public PersonDto getPersonById(@PathVariable Integer id) {
		return personDtoFactory.createPerson(personService.getPersonById(id));
	}

	/**
	 * Same as above method, just showing different URL mapping
	 * @param id
	 * @return Returns the person with the given id.
	 */
	@RequestMapping(value = "person", params = "id")
	@ResponseBody
//    @RequestMapping(value = "/person/{id}")
//    @ResponseBody
//    public PersonDto getPersonByIdFromParam(@PassParams id Integer id) {
	public PersonDto getPersonByIdFromParam(@RequestParam Integer id) {
		return personDtoFactory.createPerson(personService.getPersonById(id));
	}

	/**
	 * Creates a new person.
	 * @param request
	 * @return Returns the id for the new person.
	 */
	@RequestMapping(value = "person", method = RequestMethod.POST)
	@ResponseBody
	public Integer createPerson(@RequestBody SavePersonRequest request) {
		Person person = new Person();
		person.setFirstName(request.getFirstName());
		person.setLastName(request.getLastName());
		person.setUserName(request.getUserName());
		personService.savePerson(person);
		return person.getId();
	}

//    @RequestMapping(value = "/persons")
//    @ResponseBody
//    public List<PersonDto> getPersonsList(){
//        return personServiceImp.getPersonsList();
//    }
	
	// --- Error handlers
	
	@ExceptionHandler(PersonNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public String handlePersonNotFoundException(PersonNotFoundException e) {
		return e.getMessage();
	}

}

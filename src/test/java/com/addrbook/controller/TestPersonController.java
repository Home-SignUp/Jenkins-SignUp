package com.addrbook.controller;

import com.addrbook.controller.fixture.ControllerTestFixture;
import com.addrbook.domain.Person;
import com.addrbook.exception.PersonNotFoundException;
import com.addrbook.json.save.SavePersonRequest;
import com.addrbook.service.PersonService;
import com.addrbook.springconfig.ControllerTestConfig;
import com.addrbook.util.DataFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests the controller, including JSON serialization.
 * 
 * @author Trey
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ControllerTestConfig.class })
public class TestPersonController {

	@Autowired private PersonService mockPersonService;
	@Autowired private DataFactory dtoFactory;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new PersonController(mockPersonService, dtoFactory)).build();
	}

	@Test
	public void test_getPersonById() throws Exception {
		ControllerTestFixture f = new ControllerTestFixture();
		Person person = f.createTrey();
		when(mockPersonService.getPersonById(anyInt())).thenReturn(person);

		mockMvc.perform(get("/person/{id}", 1)
				.accept(TestUtil.APPLICATION_JSON_UTF8)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.fullname", is(person.getFirstName() + " " + person.getLastName())))
				.andReturn();
	}

	@Test
	public void test_getPersonById_NotFound() throws Exception {
		final String errorMessage = "Mocking 404 message";
		when(mockPersonService.getPersonById(anyInt())).thenAnswer(new Answer<Person>() {
			public Person answer(InvocationOnMock invocation) throws Throwable {
				throw new PersonNotFoundException(errorMessage);
			}
		});

		mockMvc.perform(get("/person/{id}", -1)
				.accept(TestUtil.APPLICATION_JSON_UTF8)
				)
				.andExpect(status().isNotFound())
				.andExpect(content().string(errorMessage))
				.andReturn();
	}

	@Test
	public void test_getPersonByIdFromParam() throws Exception {
		ControllerTestFixture f = new ControllerTestFixture();
		Person person = f.createTrey();
		when(mockPersonService.getPersonById(anyInt())).thenReturn(person);

//        mockMvc.perform(get("/person?id={id}", 1)
		mockMvc.perform(get("/person/{id}", 1)
				.accept(TestUtil.APPLICATION_JSON_UTF8)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.fullname", is(person.getFirstName() + " " + person.getLastName())))
				.andReturn();
	}

	@Test
	public void test_savePerson() throws Exception {
		ControllerTestFixture f = new ControllerTestFixture();
		Person person = f.createTrey();
		final Integer newId = person.getId();
		person.setId(null);
		
		doAnswer(new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Person p = (Person) args[0];
				p.setId(newId); // emulate the successful save populating the id
	            return "called with arguments: " + args;
			}
		}).when(mockPersonService).savePerson((Person) anyObject());

		SavePersonRequest spr = new SavePersonRequest();
		spr.setUserName(person.getUserName());
		spr.setFirstName(person.getFirstName());
		spr.setLastName(person.getLastName());
		
		mockMvc.perform(post("/person")
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(spr))
				.accept(TestUtil.APPLICATION_JSON_UTF8)
				)
				.andExpect(status().isOk())
				.andExpect(content().string(newId.toString()))
				.andReturn();
	}
	
}


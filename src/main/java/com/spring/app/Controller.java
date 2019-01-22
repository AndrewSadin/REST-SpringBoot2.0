package com.spring.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
    private Person person = (Person) ctx.getBean("person");

    @RequestMapping("/")
    public String healthCheck() {
        return "OK";
    }

    @RequestMapping("/person/get")
    public Person getPerson(@RequestParam(name="name", required=false, defaultValue="Unknown") String name) {
        person.setName(name);
        return person;
    }

	@RequestMapping(value="/person/update", method=RequestMethod.POST)
	public Person updatePerson(@RequestParam(name="name", required=true) String name) {
		person.setName(name);
		return person;
	}
}

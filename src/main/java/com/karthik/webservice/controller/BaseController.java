package com.karthik.webservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import com.springrest.BooksRestfulWebservice.controller.HelloWorldBean;

@RestController
//@RequestMapping("/req")
public class BaseController {

	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public String helloWorld() {
		return "First RESTFul WebService for Demo purpose !!!";
	}
	
	@GetMapping(path = "/getTest",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public  List<String> getTest() {
		List<String> stList = Arrays.asList("apple","banana","custard","dench","eug");
		return stList;
	}

	@PostMapping(path = "/postTest")
	public @ResponseBody ResponseEntity<String> postTest() {
		return new ResponseEntity<String>("Response from POST", HttpStatus.OK);
	}

	@PutMapping(path = "/putTest")
	public @ResponseBody ResponseEntity<String> putTest() {
		return new ResponseEntity<String>("Response from PUT", HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteTest")
	public @ResponseBody ResponseEntity<String> deleteTest() {
		return new ResponseEntity<String>("Response from DELETE", HttpStatus.OK);
	}

	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World!");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean getHelloWorldUsingPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World , %s", name));
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource res = new ResourceBundleMessageSource();
		res.setBasename("messages");
		return res;
	}
}

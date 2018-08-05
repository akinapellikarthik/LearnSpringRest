package com.karthik.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping(path = "/v1/person")
	public com.karthik.webservice.versioning.PersonV1 PersonV1() {

		return new PersonV1("Karthik Akinapelli");
	}

	@GetMapping(path = "/v2/person")
	public com.karthik.webservice.versioning.PersonV2 PersonV2() {
		
		return new PersonV2(new Name("karthik","akinapelli"));

	}
}

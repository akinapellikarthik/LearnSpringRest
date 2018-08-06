package com.karthik.webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	/**
	 * Different types of versioning available to us are as follows Each has its own
	 * advantages and disadvantages 1. URI Versioning used in Twitter 2. Media Type
	 * Versioning - a.k.a Content Negoitation or accept header used in GitHub 3.
	 * Custom Header Versioning used in Microsoft 4. Parameter versioning used in
	 * Amazon
	 * 
	 * Factors 1. URI Pollution 2. Misuse of HTTP Headers 3. Caching 4. Can we
	 * execute them on a browser directly 5. What will be the API Documentation
	 * 
	 * There is no perfect solution and its upto us to select the versioning
	 * 
	 */

	/** URI Versioning Pattern starts here **/
	@GetMapping(path = "/v1/person")
	public com.karthik.webservice.versioning.PersonV1 PersonV1() {

		return new PersonV1("Karthik Akinapelli");
	}

	@GetMapping(path = "/v2/person")
	public com.karthik.webservice.versioning.PersonV2 PersonV2() {

		return new PersonV2(new Name("karthik", "akinapelli"));

	}

	/** URI Versioning Pattern ends here **/

	/** Media Type Versioning - starts here **/

	@GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public com.karthik.webservice.versioning.PersonV1 MediaTypeV1() {

		return new PersonV1("Karthik Akinapelli");
	}

	@GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public com.karthik.webservice.versioning.PersonV2 MediaTypeV2() {

		return new PersonV2(new Name("karthik", "akinapelli"));

	}

	/** Media Type Versioning - ends here **/

	/** Parameter versioning starts here **/

	@GetMapping(path = "/person/param", params = "version=1")
	public com.karthik.webservice.versioning.PersonV1 ParamTypeV1() {

		return new PersonV1("Karthik Akinapelli");
	}

	@GetMapping(path = "/person/param", params = "version=2")
	public com.karthik.webservice.versioning.PersonV2 ParamTypeV2() {

		return new PersonV2(new Name("karthik", "akinapelli"));

	}

	/** Parameter versioning ends here **/
	
	/** Custom Header versioning starts here **/
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public com.karthik.webservice.versioning.PersonV1 CustomHeaderTypeV1() {

		return new PersonV1("Karthik Akinapelli");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public com.karthik.webservice.versioning.PersonV2 CustomHeaderTypeV2() {

		return new PersonV2(new Name("karthik", "akinapelli"));

	}
	
	
	
	/** Custom Header versioning ends here **/

}

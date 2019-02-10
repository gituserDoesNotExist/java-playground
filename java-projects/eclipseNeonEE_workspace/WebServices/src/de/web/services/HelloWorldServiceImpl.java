package de.web.services;

import javax.jws.WebService;

@WebService(endpointInterface = "de.web.services.HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String getHelloWorldAsString() {
		return "hello world";
	}

}

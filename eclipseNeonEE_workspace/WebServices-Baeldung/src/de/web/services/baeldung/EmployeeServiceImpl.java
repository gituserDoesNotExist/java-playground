package de.web.services.baeldung;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "EmployeeServiceddddImpl", endpointInterface = "de.web.services.baeldung.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@WebMethod
	public Employee getEmployee(int id) {
		return new Employee();
	}

	@WebMethod
	public Employee updateEmployee(int id, String name) {
		return new Employee();
	}
}
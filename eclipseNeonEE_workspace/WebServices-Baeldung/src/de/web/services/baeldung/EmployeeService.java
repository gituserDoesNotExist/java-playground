package de.web.services.baeldung;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface EmployeeService {

	@WebMethod
	Employee getEmployee(@WebParam(name = "notarg0") int id);

	@WebMethod
	Employee updateEmployee(int id, String name);
}

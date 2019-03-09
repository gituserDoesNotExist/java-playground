package org.fancypackage.service;

import java.util.HashMap;
import java.util.Map;

import org.fancypackage.dto.UserDTO;

public class UserService {

	Map<String, UserDTO> users = new HashMap<String, UserDTO>();

	public UserService() {
		users.put("user1", new UserDTO("user1", 1234));
		users.put("user2", new UserDTO("user2", 5678));
	}

	public UserDTO getUser(String userName) {
		return users.get(userName);
	}

}

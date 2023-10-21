package com.abc.ecommerce.controller;

import com.abc.ecommerce.entity.UserInfo;
import com.abc.ecommerce.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserInfoService userService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/user")
	public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {
		logger.info("Request arrived to fetch all users");
		List<UserInfo> userInfos = userService.getAllActiveUserInfo();
		if (userInfos == null || userInfos.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return userInfos;
	}

	@PostMapping("/user/signup")
	public UserInfo addUser(@RequestBody UserInfo userRecord) {
		logger.info("Request arrived to add user");
		return userService.addUser(userRecord);
	}

	@PutMapping("/user/{id}")
	public UserInfo updateUser(@RequestBody UserInfo userRecord, @PathVariable Integer id) {
		logger.info("Request arrived to update user");
		return userService.updateUser(id,userRecord);
	}
	
	@PutMapping("/user/changePassword/{id}")
	public UserInfo updateUserPassword(@RequestBody UserInfo userRecord, @PathVariable Integer id) {
		logger.info("Request arrived to update password");
		return userService.updatePassword(id,userRecord);
	}


	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		logger.info("Request arrived to delete user");
		userService.deleteUser(id);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserInfo> getUserById(@PathVariable Integer id) {
		logger.info("Request arrived to get user by Id");
		UserInfo userInfo = userService.getUserInfoById(id);
		if (userInfo == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userInfo, HttpStatus.OK);
	}
}

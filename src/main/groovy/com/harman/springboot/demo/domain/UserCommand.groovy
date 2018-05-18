package com.harman.springboot.demo.domain

import org.springframework.stereotype.Component

@Component
class UserCommand {
	Long userId;
	String username;
	String password;
}

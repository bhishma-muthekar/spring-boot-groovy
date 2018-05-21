package com.harman.springboot.demo.controller


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.harman.springboot.demo.command.UserCommand
import com.harman.springboot.demo.service.RegistrationService


@Controller
public class SignupController {

	@Autowired
	RegistrationService registrationService;

	@RequestMapping("/signup")
	public String signupView(Model model) {
		model.addAttribute("userCommand", new UserCommand());
		return "/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute UserCommand userCommand,Model model) {
		userCommand=registrationService.registerUser(userCommand);

		return "/login";
	}
}

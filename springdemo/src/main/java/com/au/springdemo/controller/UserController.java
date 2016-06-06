package com.au.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.au.springdemo.dao.UserDAO;
import com.au.springdemo.model.User;

/**
 * As you know, you can do the configuration in xml file in order to inform
 * Spring that some class is a Bean. Another way is that other classes enclosed
 * with a @Controller or @Service annotation in the scanning scope of Spring are
 * also considered as Beans by Spring.
 * 
 * @Autowired annotation is attached to fields belonging to Controller class or
 *            Service class for ordering Spring automatically to have a
 *            dependency injection.
 * @author company
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userDAO.listUser());
		return "users";
	}

	// For add and update person both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p) {

		if (p.getId() == 0) {
			// new person, add it
			this.userDAO.addUser(p);
		} else {
			// existing person, call update
			this.userDAO.updateUser(p);
		}

		return "redirect:/users";

	}

	@RequestMapping("/user/delete/{id}")
	public String removeUser(@PathVariable("id") int id) {

		this.userDAO.removeUser(id);
		return "redirect:/users";
	}

	@RequestMapping("/user/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", this.userDAO.getUserById(id));
		model.addAttribute("listUsers", this.userDAO.listUser());
		return "users";
	}
}

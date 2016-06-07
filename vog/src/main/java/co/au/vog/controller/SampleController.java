package co.au.vog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import co.au.vog.dao.UserDAO;
import co.au.vog.exception.GenericException;
import co.au.vog.model.Tag;
import co.au.vog.model.entity.User;
import co.au.vog.utils.Log;

@EnableWebMvc
@Controller
public class SampleController {

	// @RequestMapping("/test1")
	// public String anyName(Model model) {
	// model.addAttribute("greeting", "Hello test 1");
	// System.out.println("It come here 2");
	// This will return a view name
	// return "test_1";
	// }

	// Test response body
	// Simple example, method returns String.
	@RequestMapping(value = "/test1")
	@ResponseBody
	public String authorInfo(Model model) {
		return "this is a response body, not a view ";
	}

	//----------------------------------------------------------------------------
	
	@RequestMapping(value = "/testTags")
	public String openTagPage(Model model) {
		return "samples/testTags";
	}

	/**
	 * Test jquery autocomplete ------
	 */

	List<Tag> data = new ArrayList<Tag>();

	public SampleController() {
		data.add(new Tag(1, "ruby"));
		data.add(new Tag(2, "rails"));
		data.add(new Tag(3, "c / c++"));
		data.add(new Tag(4, ".net"));
		data.add(new Tag(5, "python"));
		data.add(new Tag(6, "java"));
		data.add(new Tag(7, "javascript"));
		data.add(new Tag(8, "jscript"));
	}

	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody List<Tag> getTags(@RequestParam String tagName) {
		return simulateSearchResult(tagName);
	}

	private List<Tag> simulateSearchResult(String tagName) {

		List<Tag> result = new ArrayList<Tag>();

		// iterate a list and filter by tagName
		for (Tag tag : data) {
			if (tag.tagName.contains(tagName)) {
				result.add(tag);
			}
		}

		return result;
	}
	
	//----------------------------------------------------------------------------
	

	/**
	 * Test path
	 * 
	 * @param model
	 * @param sitePrefix
	 * @param language
	 * @param id
	 * @param naturalText
	 * @return
	 */
	@RequestMapping("/web/fe/{sitePrefix}/{language}/document/{id}/{naturalText}")
	public String documentView(Model model, @PathVariable(value = "sitePrefix") String sitePrefix,
			@PathVariable(value = "language") String language, @PathVariable(value = "id") Long id,
			@PathVariable(value = "naturalText") String naturalText) {

		model.addAttribute("sitePrefix", sitePrefix);
		model.addAttribute("language", language);
		model.addAttribute("id", id);
		model.addAttribute("naturalText", naturalText);

		String documentName = "Java tutorial for Beginners";
		if (id == 8108) {
			documentName = "Spring MVC for Beginners";
		}

		model.addAttribute("documentName", documentName);

		return "samples/documentView";
	}

	//----------------------------------------------------------------------------
	
	
	@RequestMapping("/res")
	public String resourceTest(Model model) {
		Log.d("Calling res");
		// Test log
		Log.d("debug log");
		Log.i("info log");
		Log.e("error log");
		return "samples/resourcesTest";
	}
	
	//----------------------------------------------------------------------------
	

	/**
	 * User
	 * -------------------------------------------------------------------------
	 * As you know, you can do the configuration in xml
	 * file in order to inform Spring that some class is a Bean. Another way is
	 * that other classes enclosed with a @Controller or @Service annotation in
	 * the scanning scope of Spring are also considered as Beans by Spring.
	 * 
	 * @Autowired annotation is attached to fields belonging to Controller class
	 *            or Service class for ordering Spring automatically to have a
	 *            dependency injection.
	 */
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUser(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userDAO.listUser());
		return "samples/users";
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
		return "samples/users";
	}

	
	//-------------------------------
	@RequestMapping("/exception_custom")
	@ResponseBody
	public String tryCustomEx(Model model) {
		throw new GenericException("400", "None");
	}
	
	@RequestMapping("/exception_bysystem")
	@ResponseBody
	public String trySystemException(Model model) throws IOException {
		throw new IOException();
	}
}

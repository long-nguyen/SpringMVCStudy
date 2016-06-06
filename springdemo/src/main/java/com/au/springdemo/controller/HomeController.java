package com.au.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.au.springdemo.utils.Log;

@Controller
public class HomeController {

	// Hàm đơn giản nhất
	// @RequestMapping("/")
	// // Tên hàm là gì cũng được
	// public String index(Model model) {
	// model.addAttribute("greeting", "Hello Spring MVC");
	// System.out.println("It come here");
	// // Trả về tên view
	// return "home";
	// }

	/**
	 * Test home function
	 * 
	 * @param model
	 * @param name
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model, @RequestParam(value = "name", defaultValue = "Guest") String name) {
		Log.d("Calling index");
		Log.d("With name: " + name);
		model.addAttribute("name", name);

		if ("admin".equals(name)) {
			model.addAttribute("email", "admin@example.com");
		} else {
			model.addAttribute("email", "not set");
		}
		return "home";
	}

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

		return "documentView";
	}

	@RequestMapping("/res")
	public String resourceTest(Model model) {
		Log.d("Calling res");
		//Test log 
		Log.d("debug log");
		Log.i("info log");
		Log.e("error log");
		return "resourcesTest";
	}
	
}
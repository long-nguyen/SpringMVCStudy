package co.au.vog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.au.vog.utils.Log;

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

}
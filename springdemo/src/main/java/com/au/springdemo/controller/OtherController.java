package com.au.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.au.springdemo.model.Tag;

@EnableWebMvc
@Controller
public class OtherController {

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

	@RequestMapping(value = "/testTags")
	public String openTagPage(Model model) {
		return "testTags";
	}

	/**
	 * Test jquery autocomplete
	 */

	List<Tag> data = new ArrayList<Tag>();

	public OtherController() {
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

}

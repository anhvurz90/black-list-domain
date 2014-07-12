package com.anhvurz90.blacklisteddomain.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anhvurz90.blacklisteddomain.entities.Domain;

@Controller
public class DomainController {
	@RequestMapping(value = "/domain", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("domain", "command", new Domain(""));
	}
	
	@RequestMapping(value = "addDomain", method = RequestMethod.POST)
	public String addDomain(@ModelAttribute("SpringWeb")Domain domain, ModelMap model) {
		model.addAttribute("value", domain.getValue());
		return "listDomain";
	}
}

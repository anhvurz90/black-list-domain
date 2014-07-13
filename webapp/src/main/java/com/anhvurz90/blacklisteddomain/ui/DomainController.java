package com.anhvurz90.blacklisteddomain.ui;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anhvurz90.blacklisteddomain.api.DomainManager;
import com.anhvurz90.blacklisteddomain.entities.Domain;

@Controller
public class DomainController  implements BeanFactoryAware {
	
	private DomainManager domainManager;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		domainManager = (DomainManager)beanFactory.getBean("domainManager");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "listDomain";
	}
	
	@RequestMapping(value = "/addDomain", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("addDomain", "command", new Domain(""));
	}
	
	@RequestMapping(value = "listDomain", method = RequestMethod.POST)
	public String addDomain(@ModelAttribute("SpringWeb")Domain domain, ModelMap model) {
		domainManager.addDomain(domain);
		model.addAttribute("domains", domainManager.getAllDomains());
		return "listDomain";
	}
	
	@RequestMapping(value = "listDomain", method = RequestMethod.GET)
	public String addDomain2(ModelMap model) {
		model.addAttribute("domains", domainManager.getAllDomains());
		return "listDomain";
	}
	
	@RequestMapping(value = "deleteDomain", method = RequestMethod.GET)
	public String deleteDomain(@RequestParam("domainName") String domainName, ModelMap model) {
		domainManager.removeDomain(domainName);
		model.addAttribute("domains", domainManager.getAllDomains());
		return "listDomain";
	}
	
	@RequestMapping(value = "checkEmail", method = RequestMethod.POST)
	public String checkEmail(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("blackListed", domainManager.isBlacklisted(email));
		return "checkEmail";
	}
}

package com.atguigu.springmvc.handlers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class I18NHandler {
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping("/testI18N")
	public String testI18N(Locale locale){
		
		String username = messageSource.getMessage("i18n.user", new String[]{"ok"}, locale);
		
		System.out.println("username="+username);
		
		return "i18n";
	}
	
}

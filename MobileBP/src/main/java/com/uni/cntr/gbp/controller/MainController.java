package com.uni.cntr.gbp.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.education.service.UserService;
import com.uni.education.vo.UserVO;


@Controller
@RequestMapping(value="/gbp")
public class MainController {
	
	private static Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(HttpSession session) {
        logger.debug("Call Main-Page for GBP");
        
        return "redirect:gbp/salesGBP";
    }
}

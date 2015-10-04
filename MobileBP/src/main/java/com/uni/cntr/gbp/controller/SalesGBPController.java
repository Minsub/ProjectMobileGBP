package com.uni.cntr.gbp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.cntr.gbp.service.SalesGBPService;
import com.uni.cntr.gbp.util.Utils;
import com.uni.cntr.gbp.vo.SalesGBPVO;


@Controller
@RequestMapping(value="/gbp/salesGBP")
public class SalesGBPController {
	private static Logger logger = Logger.getLogger(SalesGBPController.class);
	
	@Autowired
	private SalesGBPService salesGBPService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(String week, Integer diff, Model model, HttpSession session) {
        logger.info("Call SalesGBP GET week:" + week + ", diff: " + diff);
        
        List<SalesGBPVO> list = null;
        String sSales = (String)session.getAttribute("sales");
        if (sSales == null || sSales.equalsIgnoreCase("")) {
        	session.setAttribute("sales", Utils.getDefaultSales());
        	sSales = Utils.getDefaultSales();
        }
        
        if (week == null) {
        	list = salesGBPService.getAll(sSales);
        } else {
        	list = salesGBPService.getAll(sSales, week, diff);
		}
        
        logger.info("result from DB / size:" + list.size());   
		model.addAttribute("items", list);
		
        if (list.size() > 0) {
			model.addAttribute("week1", list.get(0).getWeek1());
			model.addAttribute("week2", list.get(0).getWeek2());
			model.addAttribute("week3", list.get(0).getWeek3());
		} else {
			model.addAttribute("week1", 0);
			model.addAttribute("week2", 0);
			model.addAttribute("week3", 0);
		}
		
        return "gbp/salesGBPbyRoute";
    }

	@RequestMapping(method = RequestMethod.POST)
    public String processGetList(String week, Integer diff, Model model, HttpSession session) {
		try {
	        //logger.debug("Call SalesGBP POST param: week" + week + ", diff: " + diff);
	        
			model.addAttribute("week", week);
			model.addAttribute("diff", diff);
			 return "redirect:/gbp/salesGBP";
		} catch (Exception e) {
			 return "redirect:/gbp/salesGBP";
		}
    }
}

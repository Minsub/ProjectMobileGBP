package com.uni.cntr.gbp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uni.cntr.gbp.service.SalesGBPbyAccService;
import com.uni.cntr.gbp.util.Utils;
import com.uni.cntr.gbp.vo.SalesGBPbyAccVO;


@Controller
@RequestMapping(value="/gbp/salesGBPbyAcc")
public class SalesGBPbyAccController {
	private static Logger logger = Logger.getLogger(SalesGBPbyAccController.class);
	
	@Autowired
	private SalesGBPbyAccService salesGBPbyAccService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(String trade, String bound, String route, String week, Integer diff, Model model, HttpSession session) {
        logger.info("Call salesGBPbyAcc GET trade " + trade + " bound: " + bound + " route" + route + ", week: " + week + " diff: " + diff);
        
        String sSales = (String)session.getAttribute("sales");
        if (sSales == null || sSales.equalsIgnoreCase("")) {
        	session.setAttribute("sales", Utils.getDefaultSales());
        	sSales = Utils.getDefaultSales();
        }
        
        if (diff == null) {
        	diff = 0;
        }
        
        List<SalesGBPbyAccVO> list = null;
        
    	list = salesGBPbyAccService.getAll(sSales, trade, bound, route, week, diff);
		logger.info("result from DB / size:" + list.size());   
		model.addAttribute("items", list);
		model.addAttribute("trade", trade);
		model.addAttribute("bound", bound);
		model.addAttribute("route", route);
		
		if (list.size() > 0) {
			model.addAttribute("week1", list.get(0).getWeek1());
			model.addAttribute("week2", list.get(0).getWeek2());
			model.addAttribute("week3", list.get(0).getWeek3());
		} else {
			model.addAttribute("week1", 0);
			model.addAttribute("week2", 0);
			model.addAttribute("week3", 0);
		}
		
        return "gbp/salesGBPbyAcc";
    }
}

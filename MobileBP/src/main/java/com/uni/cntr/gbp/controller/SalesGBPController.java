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
import com.uni.cntr.gbp.vo.SalesGBPVO;
import com.uni.education.service.UserService;
import com.uni.education.vo.LectureUserVO;
import com.uni.education.vo.RegistrationLectureVO;
import com.uni.education.vo.UserVO;


@Controller
@RequestMapping(value="/gbp/salesGBP")
public class SalesGBPController {
	private final static String DEFAULT_SALES = "0123";
	
	private static Logger logger = Logger.getLogger(SalesGBPController.class);
	
	@Autowired
	private SalesGBPService salesGBPService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(String week, Integer diff, Model model, HttpSession session) {
        logger.info("Call SalesGBP GET week" + week + ", diff: " + diff);
        
        List<SalesGBPVO> list = null;
        if (week == null) {
        	list = salesGBPService.getAll(DEFAULT_SALES);
    		logger.info("result from DB / size:" + list.size());   
    		model.addAttribute("items", list);
    		model.addAttribute("week", "Week38");
    		
        } else {
        	list = salesGBPService.getAll(DEFAULT_SALES, week, diff);
			logger.info("result from DB / size:" + list.size());   
			model.addAttribute("items", list);
			
			if (list.size() > 0) {
				model.addAttribute("week", "week" + list.get(0).getWeek());
			} else {
				model.addAttribute("week", "-");
			}
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

package cf.crawler.server.web.controllers;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cf.crawler.server.gateways.ImageUnitGateway;

@Controller
public class FrontController {
	
	@Autowired
	ImageUnitGateway imageUnitGateway;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String front(Model model,
			HttpServletRequest request, 
			HttpSession session){
		
		return "front";
	}
	
	@RequestMapping(value = "/crawle", method = RequestMethod.POST)
	public @ResponseBody String crawle(Model model,
			HttpServletRequest request, 
			HttpSession session){
		String targetUrl = request.getParameter("target_url");
		try {
			imageUnitGateway.sendImageUnits(new URL(targetUrl));
		} catch (MalformedURLException e) {
			return e.getMessage();
		}
		return "s";
	}
}

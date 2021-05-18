package com.geoLink3D.toolsregistry.demo.controller;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geoLink3D.toolsregistry.demo.model.Tool;
import com.geoLink3D.toolsregistry.demo.service.ToolService;

@Controller
@RequestMapping("/GeoLink3D/tools-registry")
public class ForUserController {

	@Autowired
	private ToolService toolService;
	
	@GetMapping("/login")
	public String goLoginPage(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login";
	}
	
	@GetMapping("/registration")
	public String goRegistrationPage() {
		return "registration";
	}
	
	@GetMapping("/user-account")
	public String goUserAccount(Model model, HttpServletRequest request) {
		
		model.addAttribute("places", Arrays.asList("Dunakeszi", "Debrecen", "Kecskemét"));
		model.addAttribute("tools", toolService.getTools());
		
		return "user-account";
	}
	
	@GetMapping("/takeTool")
	public String takeTool(@RequestParam("id") int id, Model model) {
		
		Tool tool = toolService.getTools().get(id - 1);
		tool.setIsUsed(true);
		tool.setPickUpDate(new Date(System.currentTimeMillis()));
		tool.setPickUpPlace("Dunakeszi");
		tool.setToolUser("Dolgozó2");
		model.addAttribute("tool");
		
		return "taken-tools";
	}
	
}

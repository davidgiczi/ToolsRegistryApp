package com.geoLink3D.toolsregistry.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
		toolService.destroyToolList();
		return "login";
	}
	
	@GetMapping("/registration")
	public String goRegistrationPage() {
		return "registration";
	}
	
	@GetMapping("/tools")
	public String goUserAccount(Model model, HttpServletRequest request) {
		
		model.addAttribute("places", Arrays.asList("Dunakeszi", "Debrecen", "Kecskemét"));
		model.addAttribute("tools", toolService.getTools());
		
		return "tools-list";
	}
	
	@GetMapping("/takeAwayTool")
	public String takeAwayTool(@RequestParam("id") int id, @RequestParam("place") String place, HttpServletRequest request, Model model) {
		
		
		@SuppressWarnings(value = "unchecked")
		List<Tool> takens = (List<Tool>) request.getSession().getAttribute("tools");
		if(takens == null) {
			takens = new ArrayList<>();
		}
		if(id == -1) {
			model.addAttribute("takens", takens);
			model.addAttribute("places", Arrays.asList("Dunakeszi", "Debrecen", "Kecskemét"));
			return "taken-tools";
		}
		
		id-=1;
		Tool tool = toolService.getTools().get(id);
		tool.setIsUsed(true);
		tool.setPickUpDate(new Date(System.currentTimeMillis()));
		tool.setPickUpPlace(place);
		tool.setToolUser("Dolgozó2");
		takens.add(tool);
		toolService.save(tool, id);
		request.getSession().setAttribute("tools", takens);
		model.addAttribute("takens", takens);
		model.addAttribute("places", Arrays.asList("Dunakeszi", "Debrecen", "Kecskemét"));
		
		return "taken-tools";
	}
	
	@GetMapping("/bringBackTool")
	public String bringBackTool(@RequestParam("serial") String serialNumber, @RequestParam("place") String place, HttpServletRequest request, Model model) {
	
		Optional<Tool> bringBackTool = toolService.getToolBySerialNumber(serialNumber);
		
		if(bringBackTool.isPresent()) {
			int id = toolService.getId(bringBackTool.get());
			@SuppressWarnings(value = "unchecked")
			List<Tool> takens = (List<Tool>) request.getSession().getAttribute("tools");
			takens.remove(bringBackTool.get());
			request.getSession().setAttribute("tools", takens);
			bringBackTool.get().setIsUsed(false);
			bringBackTool.get().setPutDownPlace(place);
			bringBackTool.get().setPickUpPlace(place);
			bringBackTool.get().setPutDownDate(new Date(System.currentTimeMillis()));
			toolService.save(bringBackTool.get(), id);
		}
		
		return "redirect:/GeoLink3D/tools-registry/tools";
	}
	
}

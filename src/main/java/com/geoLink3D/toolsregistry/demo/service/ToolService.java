package com.geoLink3D.toolsregistry.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.geoLink3D.toolsregistry.demo.model.Tool;

@Service
public class ToolService {

	private List<Tool> tools;
	
	
	public List<Tool> getTools(){
		
		if(tools == null || tools.isEmpty()) {
		tools = new ArrayList<>();
		Tool totalStation = new Tool("Total Station","604RMMD8U923");
		totalStation.setPickUpPlace("Kecskemét");
		tools.add(totalStation);
		Tool scanner = new Tool("Laser Scanner","93654887892");
		scanner.setPickUpPlace("Dunakeszi");
		tools.add(scanner);
		Tool drone = new Tool("Drone", "163DF840012345");
		drone.setPickUpPlace("Debrecen");
		tools.add(drone);
		}
		
		return tools;
	}
	
	public void save(Tool tool, int index) {
		
		tools.set(index, tool);
	}
	
	public void destroyToolList() {
		if(tools != null) {
			tools.clear();	
		}
		
	}
	
	public Optional<Tool> getToolBySerialNumber(String serial) {
		
		return tools.stream().filter(t -> t.getSerialNumber().equals(serial)).findFirst();
	}
	
	public int getId(Tool tool) {
		return tools.indexOf(tool);
	}
}

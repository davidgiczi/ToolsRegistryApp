package com.geoLink3D.toolsregistry.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.geoLink3D.toolsregistry.demo.model.Tool;

@Service
public class ToolService {

	private List<Tool> tools;
	
	
	public List<Tool> getTools(){
		
		tools = new ArrayList<>();
		Tool totalStation = new Tool("Total Station","604RMMD8U923");
		tools.add(totalStation);
		Tool scanner = new Tool("Laser Scanner","93654887892");
		scanner.setIsUsed(true);
		scanner.setToolUser("Dolgozó1");
		tools.add(scanner);
		Tool drone = new Tool("Drone", "163DF840012345");
		tools.add(drone);
		return tools;
	}
	
}

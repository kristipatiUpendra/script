package com.slokam.script.service;

import java.util.List;

import com.slokam.script.dto.LocationTypeDto;
import com.slokam.script.entity.LocationType;

public interface IlocationService {
	
	
	public LocationTypeDto save(LocationTypeDto loctypedto);
	public LocationTypeDto getbyid(Integer id);
	public List<LocationTypeDto> getbyall();
	public LocationTypeDto deletebyid(Integer id);
	

}

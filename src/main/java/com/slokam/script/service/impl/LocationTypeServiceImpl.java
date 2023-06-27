package com.slokam.script.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.script.dao.IlocationTypeDao;
import com.slokam.script.dto.LocationTypeDto;
import com.slokam.script.entity.LocationType;
import com.slokam.script.service.IlocationService;

@Service
public class LocationTypeServiceImpl implements IlocationService {
	
	@Autowired
	private IlocationTypeDao ilocdao;

	@Override
	public LocationTypeDto save(LocationTypeDto loctypedto) {
		
		   LocationType locationtype = new LocationType();
		   locationtype.setDescription(loctypedto.getDescription());
		   ilocdao.save(locationtype);
		   loctypedto.setId(locationtype.getId());
		   
		return loctypedto;
	}
	
	
	                   	
	
	

}

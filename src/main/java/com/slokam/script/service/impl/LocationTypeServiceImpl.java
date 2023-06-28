package com.slokam.script.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.script.dao.IlocationTypeDao;
import com.slokam.script.dto.LocationTypeDto;
import com.slokam.script.dto.ScriptDTO;
import com.slokam.script.entity.LocationType;
import com.slokam.script.entity.Script;
import com.slokam.script.service.IlocationService;

@Service
public class LocationTypeServiceImpl implements IlocationService {
	
	@Autowired
	private IlocationTypeDao ilocdao;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public LocationTypeDto save(LocationTypeDto loctypedto) {
		         
		   LocationType locationtype =  modelmapper.map(loctypedto, LocationType.class);       
		   ilocdao.save(locationtype);
		   loctypedto.setId(locationtype.getId());
		   
		return loctypedto;
	}

	@Override
	public LocationTypeDto getbyid(Integer id) {
	
		LocationTypeDto loctypedto = null;
		   Optional<LocationType> loctype =  ilocdao.findById(id);
		    if(loctype.isPresent())
		     {
		        LocationType loc =  loctype.get();
		  	 loctypedto =  	modelmapper.map(loc, LocationTypeDto.class);
		     }
		return loctypedto;
	}

	@Override
	public List<LocationTypeDto> getbyall() {
		 List<LocationTypeDto> locationtypedto = new ArrayList<>();
		 LocationTypeDto locationdto = null;
	     List<LocationType>  loclist =   ilocdao.findAll();
	   
	     for(LocationType loc : loclist)
	     {
	    	 locationdto =  modelmapper.map(loc, LocationTypeDto.class);
	    	 locationtypedto.add(locationdto);
	    	
	     }
		return locationtypedto;
	}

	@Override
	public LocationTypeDto deletebyid(Integer id) {
		     LocationTypeDto loctypedto =  getbyid(id);
		      ilocdao.deleteById(id);
		return loctypedto;
	}
	
	
	                   	
	
	

}

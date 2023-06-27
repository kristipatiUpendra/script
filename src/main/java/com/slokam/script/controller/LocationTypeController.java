package com.slokam.script.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.script.dto.LocationTypeDto;
import com.slokam.script.service.IlocationService;

@RestController
@RequestMapping("script")
public class LocationTypeController {
	
	@Autowired
	private IlocationService ilocservice;
	
	@PostMapping("savelocationtype")
	public ResponseEntity<LocationTypeDto> savelocationtype(@RequestBody LocationTypeDto locdto)
	{
		       LocationTypeDto loctypedto = ilocservice.save(locdto); 
		        ResponseEntity<LocationTypeDto> re;
		        re = new ResponseEntity<LocationTypeDto>(loctypedto,HttpStatus.OK);
		        return re;
	}
	
	

}

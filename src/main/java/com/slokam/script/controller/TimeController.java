package com.slokam.script.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.script.dto.TimeDTO;
import com.slokam.script.entity.Time;
import com.slokam.script.service.ITimeService;
import com.slokam.script.service.impl.TimeServiceImpl;

@RestController
@RequestMapping("Time")
public class TimeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TimeController.class);

	@Autowired
	private ITimeService timeserv;

	@PostMapping("/savetimedata")
	public ResponseEntity<TimeDTO> savetimedata(@RequestBody TimeDTO tdto) {
		LOGGER.info("entered into the method");
		TimeDTO timedto = timeserv.save(tdto);

		LOGGER.info("exit from the method");
		return ResponseEntity.ok(timedto);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TimeDTO> getdataByID(@PathVariable Integer id)
	{
	  TimeDTO timedto =	timeserv.getbyId(id);
		return ResponseEntity.status(HttpStatus.OK).body(timedto);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<TimeDTO>> getAll()
	{
	  List<TimeDTO> timedto =	timeserv.getall();
		return ResponseEntity.status(HttpStatus.OK).body(timedto);	
	}
	
	@DeleteMapping("/deleteby/{id}")
	public ResponseEntity<TimeDTO> deletebyId(@PathVariable Integer id)
	{
		TimeDTO timedto =	timeserv.deletebyid(id);
		return ResponseEntity.status(HttpStatus.OK).body(timedto);
	}
	
	
}

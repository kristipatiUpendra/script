package com.slokam.script.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.script.dto.TimeDTO;
import com.slokam.script.entity.Time;
import com.slokam.script.service.impl.TimeServiceImpl;

@RestController
@RequestMapping("Time")
public class TimeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TimeController.class);

	@Autowired
	private TimeServiceImpl timeserv;

	@PostMapping("/savetimedata")
	public ResponseEntity<TimeDTO> savetimedata(@RequestBody TimeDTO tdto) {
		LOGGER.info("entered into the method");
		TimeDTO timedto = timeserv.save(tdto);

		LOGGER.info("exit from the method");
		return ResponseEntity.ok(timedto);

	}
}

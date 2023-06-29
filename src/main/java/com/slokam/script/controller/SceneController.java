package com.slokam.script.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.script.dto.SceneDTO;
import com.slokam.script.exception.ApplicationException;
import com.slokam.script.exception.DataNotFoundException;
import com.slokam.script.service.ISceneService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("scene")
public class SceneController {
	
	@Autowired
	private ISceneService sceneService;
	@PostMapping
	public ResponseEntity<SceneDTO> saveScene(@RequestBody SceneDTO sceneDto)
	throws DataNotFoundException,ApplicationException,Exception{
		log.debug(sceneDto.toString());
		sceneService.saveScene(sceneDto);
		return null;
	}
}

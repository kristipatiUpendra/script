package com.slokam.script.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.script.dto.ScriptDTO;
import com.slokam.script.exception.ApplicationException;
import com.slokam.script.service.IScriptService;

@RestController
@RequestMapping("script")
public class ScriptController {

	@Autowired
	private IScriptService scriptService;
	
	@PostMapping
	public ResponseEntity<ScriptDTO> saveScript(@RequestBody ScriptDTO scriptDto) 
	throws ApplicationException, Exception{
		
		scriptDto = scriptService.saveScript(scriptDto);
		
		return ResponseEntity.status(HttpStatus.CREATED)
		              .body(scriptDto);
		              
	}
 	
}

package com.slokam.script.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.script.dto.ScriptCharectorDTO;
import com.slokam.script.exception.ApplicationException;
import com.slokam.script.exception.DataNotFoundException;
import com.slokam.script.service.IScriptCharectorService;

@RestController
@RequestMapping("charector")
public class ScriptCharectorController {

	@Autowired
	private IScriptCharectorService scriptCharectorService;
	
	@PostMapping
	public ResponseEntity<ScriptCharectorDTO> 
	saveScriptCharector(@RequestBody ScriptCharectorDTO scriptCharDto) throws ApplicationException,Exception{
		
		scriptCharDto = scriptCharectorService.saveScriptCharector(scriptCharDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(scriptCharDto);
	}
	
	@DeleteMapping("/{sci}")
	public ResponseEntity<ScriptCharectorDTO> deleteScriptCharector(@PathVariable("sci") Long scriptCharectorId)
	throws  ApplicationException,DataNotFoundException, Exception {
		ScriptCharectorDTO dto =	scriptCharectorService.deletecriptCharector(scriptCharectorId);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@GetMapping("/{sci}")
	public ResponseEntity<ScriptCharectorDTO> getScriptCharectorById(@PathVariable("sci") Long scriptCharectorId)
	throws  ApplicationException,DataNotFoundException, Exception {
		ScriptCharectorDTO dto =	scriptCharectorService.getScriptCharectorById(scriptCharectorId);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	@GetMapping("/all")
	public ResponseEntity<List<ScriptCharectorDTO>> getAllScriptCharectorById()
	throws  ApplicationException,DataNotFoundException, Exception {
		List<ScriptCharectorDTO> dtoList =	scriptCharectorService.getAllCharector();
		return ResponseEntity.status(HttpStatus.OK).body(dtoList);
	}
	
}

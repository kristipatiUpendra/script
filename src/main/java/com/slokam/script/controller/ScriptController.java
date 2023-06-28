package com.slokam.script.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.script.dto.ScriptDTO;

import com.slokam.script.exception.UserInputException;

import com.slokam.script.exception.ApplicationException;

import com.slokam.script.service.IScriptService;

@RestController
@RequestMapping("script")
public class ScriptController {
	
	@Autowired
	private IScriptService iscriptser;

	@PostMapping("/savescript")
	public ResponseEntity<ScriptDTO> savescript(@RequestBody ScriptDTO scriptdto) throws UserInputException, Exception
	{
	  scriptdto = iscriptser.savescript(scriptdto);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(scriptdto);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ScriptDTO> getbyId(@PathVariable Long id) {
		ScriptDTO scriptdto = iscriptser.getbyId(id);


		return ResponseEntity.status(HttpStatus.OK).body(scriptdto);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ScriptDTO>> getAll()
	{
	 List<ScriptDTO> listsdto =	iscriptser.getall();
	 
		return ResponseEntity.status(HttpStatus.OK).body(listsdto);
		
	}
	
	

}

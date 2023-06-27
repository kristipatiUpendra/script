package com.slokam.script.controller;

import java.util.List;

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
	@GetMapping("/{id}")
	public ResponseEntity<ScriptDTO> getById(@PathVariable Long id)
			throws ApplicationException, Exception{
		
		ScriptDTO scriptDto=scriptService.getScriptById(id);
		return ResponseEntity.status(HttpStatus.OK)
							 .body(scriptDto);
		
	}
	@DeleteMapping("/delete/{scriptId}")
	public ResponseEntity<ScriptDTO> deleteScript(@PathVariable Long scriptId) throws ApplicationException, Exception {
		ScriptDTO scriptDto=scriptService.getScriptById(scriptId);
		scriptService.deleteScript(scriptId);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(scriptDto);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<ScriptDTO>> getAllScripts()  throws ApplicationException, Exception {
		List<ScriptDTO> scriptDtoList= scriptService.getScriptList();
		return ResponseEntity.status(HttpStatus.OK).body(scriptDtoList); 
	}
	
 	
}

package com.slokam.script.service;


import java.util.List;

import com.slokam.script.dto.ScriptDTO;
import com.slokam.script.exception.UserInputException;

public interface IScriptService {

	public ScriptDTO savescript(ScriptDTO scriptdTO) throws UserInputException, Exception;
	
	public ScriptDTO getbyId(Long id);
	
	public List<ScriptDTO> getall();
	
	public ScriptDTO deletebyId();


}

package com.slokam.script.service;

import java.util.List;

import com.slokam.script.dto.ScriptDTO;
import com.slokam.script.exception.ApplicationException;

public interface IScriptService {

	public ScriptDTO saveScript(ScriptDTO scriptDto) throws ApplicationException ,Exception;
	public ScriptDTO deleteScript(Long scriptId) throws ApplicationException ,Exception;
	public ScriptDTO getScriptById(Long scriptId) throws ApplicationException ,Exception;
	public List<ScriptDTO> getScriptList() throws ApplicationException ,Exception;
}

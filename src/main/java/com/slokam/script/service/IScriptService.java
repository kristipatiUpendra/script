package com.slokam.script.service;

import com.slokam.script.dto.ScriptDTO;
import com.slokam.script.exception.ApplicationException;

public interface IScriptService {

	public ScriptDTO saveScript(ScriptDTO scriptDto) throws ApplicationException ,Exception;
	public ScriptDTO deleteScript(Long scriptId);
	public ScriptDTO getScriptById(Long scriptId);
}

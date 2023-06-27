package com.slokam.script.service;

import com.slokam.script.dto.ScriptCharectorDTO;
import com.slokam.script.exception.ApplicationException;

public interface IScriptCharectorService {
	public ScriptCharectorDTO createScriptCharector(ScriptCharectorDTO scriptCharDto) throws ApplicationException, Exception;

}

package com.slokam.script.service;

import java.util.List;

import com.slokam.script.dto.ScriptCharectorDTO;
import com.slokam.script.exception.ApplicationException;

public interface IScriptCharectorService {

	public ScriptCharectorDTO  saveScriptCharector(ScriptCharectorDTO charector)throws ApplicationException,Exception;
    public ScriptCharectorDTO  getScriptCharectorById(Long charectorId) throws ApplicationException,Exception; 
    public ScriptCharectorDTO  deletecriptCharector(Long charectorId)throws ApplicationException,Exception;
    public List<ScriptCharectorDTO> getAllCharector() throws ApplicationException,Exception;
 
}

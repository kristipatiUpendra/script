package com.slokam.script.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.script.dao.IScriptDAO;
import com.slokam.script.dto.ScriptDTO;
import com.slokam.script.entity.Script;
import com.slokam.script.exception.ApplicationException;
import com.slokam.script.exception.DataNotFoundException;
import com.slokam.script.exception.UserInputException;
import com.slokam.script.service.IScriptService;

@Service
public class ScriptServiceImpl implements IScriptService{

	private static final Logger LOGGER  = LoggerFactory.getLogger(ScriptServiceImpl.class);
	@Autowired
	private IScriptDAO scriptDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ScriptDTO saveScript(ScriptDTO scriptDto) throws ApplicationException, Exception{
		if(scriptDto ==null)
			throw new UserInputException("There is not data in scriptDto."); 
		
		
		LOGGER.debug("Input Script DTO Data :"+scriptDto.toString());
		  
		Script script = modelMapper.map(scriptDto, Script.class);
		if(script == null) {
			throw new ApplicationException("Model Mapper Conversion Problem.");
		}
		
		LOGGER.debug("conveted tp script entity Data :"+script.toString());
		
		scriptDao.save(script);
		
		LOGGER.debug("After save:"+script.toString());
		scriptDto.setId(script.getId());
		return scriptDto;
	}

	@Override
	public ScriptDTO deleteScript(Long scriptId) throws ApplicationException, Exception {
		if(scriptId==null) {
			throw new UserInputException("given scriptId is not prasent."); 
		}
		LOGGER.info("Input Script id for delete "+scriptId);
		
		Optional<Script> optscript=scriptDao.findById(scriptId);
		Script script=optscript.get();
		ScriptDTO scriptDto=modelMapper.map(script, ScriptDTO.class);
		
		LOGGER.info("method ended with returning the scriptDto "+scriptDto.toString());
		scriptDao.deleteById(scriptId);
		
		return scriptDto;
	}

	@Override
	public ScriptDTO getScriptById(Long scriptId) throws ApplicationException ,Exception{
		if(scriptId==null) {
			throw new UserInputException("given scriptId is not prasent");
		}
		LOGGER.info("Input id "+scriptId);
		ScriptDTO scriptDto=null;
		Optional<Script> optionalScript=scriptDao.findById(scriptId);
		
		if(optionalScript.isPresent()) {
			
			Script script=optionalScript.get();
			LOGGER.info("Script is prasent with given id "+script.toString());
			
			scriptDto=modelMapper.map(script, ScriptDTO.class);
			LOGGER.info("method ended with returning scriptDto {}"+scriptDto.toString());
		}
		else {
			throw new DataNotFoundException("no script prasent with given id");
		}
		return scriptDto;
	}

	@Override
	public List<ScriptDTO> getScriptList() throws ApplicationException ,Exception{
		List<ScriptDTO> scriptDtoList=null;
		List<Script> scriptList= scriptDao.findAll();
		if(scriptList.isEmpty()) {
			throw new ApplicationException("no data is available ");
		}
		LOGGER.info("List of scripts "+scriptList.toString());
		scriptDtoList= modelMapper.map(scriptList,new TypeToken<List<ScriptDTO>>(){}.getType());
		
		LOGGER.info("method ended with returning the scriptDtoList {}"+scriptDtoList.toString());
		return scriptDtoList;
	}
	

	
}

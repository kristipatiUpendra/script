package com.slokam.script.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.script.dao.IScriptDAO;
import com.slokam.script.dto.ScriptDTO;
import com.slokam.script.entity.Script;
import com.slokam.script.exception.ApplicationException;
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
	public ScriptDTO deleteScript(Long scriptId) {
		LOGGER.debug(null);
		
		return null;
	}

	@Override
	public ScriptDTO getScriptById(Long scriptId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

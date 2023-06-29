package com.slokam.script.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.script.dao.IActionDAO;
import com.slokam.script.dao.ILocationDAO;
import com.slokam.script.dao.ISceneDAO;
import com.slokam.script.dao.ISceneElementOrderDAO;
import com.slokam.script.dto.ActionDTO;
import com.slokam.script.dto.LocationDTO;
import com.slokam.script.dto.SceneDTO;
import com.slokam.script.entity.Action;
import com.slokam.script.entity.Location;
import com.slokam.script.entity.Scene;
import com.slokam.script.entity.SceneElementOrder;
import com.slokam.script.exception.ApplicationException;
import com.slokam.script.exception.DataNotFoundException;
import com.slokam.script.service.ISceneService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SceneServiceImpl implements ISceneService {

	@Autowired
	private ILocationDAO locationDao;
	@Autowired
	private ISceneDAO sceneDao;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ISceneElementOrderDAO seoDao;
	
	@Autowired
	private IActionDAO actionDao;
	
	
	@Override
	public SceneDTO saveScene(SceneDTO sceneDTO) throws DataNotFoundException, ApplicationException, Exception {
		// TODO Auto-generated method stub
		// location save or location get
		//  save scene
		Location location =null;
		if(sceneDTO.getLocationDto().getId() !=null) {
		  Optional<Location> opt =  locationDao.findById(sceneDTO.getLocationDto().getId());
		  if(!opt.isPresent()) {
			  throw new DataNotFoundException("Location is not available");
		  }
		  location = opt.get();
		}else {
			LocationDTO locationDto = sceneDTO.getLocationDto();
			location = mapper.map(locationDto, Location.class);
			locationDao.save(location);
		}
		
		Scene scene = mapper.map(sceneDTO, Scene.class);
		scene.setLocation(location);
		
		sceneDao.save(scene);
		List<ActionDTO> actionDTOList = sceneDTO.getActionList();
		
		for (ActionDTO actionDTO : actionDTOList) {
			Action action  = mapper.map(actionDTO, Action.class);
			action.setScene(scene);
		
			SceneElementOrder seo = new SceneElementOrder();
			seo.setScene(scene);
			seo.setSequenceOrderNumber(actionDTO.getSceneElementOrderId());
			seoDao.save(seo);
			action.setSceneElementOrder(seo);
			actionDao.save(action);
		}
		
		
		
		log.debug("SCENE DTO ::"+sceneDTO.toString());
		log.debug("SCENE ENTITY ::"+scene.toString());
		
		
		
		//
		return sceneDTO;
	}
	
}

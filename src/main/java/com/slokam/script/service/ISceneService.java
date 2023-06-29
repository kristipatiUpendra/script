package com.slokam.script.service;

import com.slokam.script.dto.SceneDTO;
import com.slokam.script.exception.ApplicationException;
import com.slokam.script.exception.DataNotFoundException;

public interface ISceneService {

	public SceneDTO saveScene(SceneDTO sceneDTO)
	  throws DataNotFoundException,ApplicationException,Exception;
}

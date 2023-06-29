package com.slokam.script.dto;

import java.util.List;

import lombok.Data;

@Data
public class SceneDTO {

	private Long id;
	private LocationDTO locationDto;
	private Integer timeId;
	private Long scriptId;
	private List<ActionDTO> actionList;
    private List<DialogueDTO> dialogueList;
    
    
    

}

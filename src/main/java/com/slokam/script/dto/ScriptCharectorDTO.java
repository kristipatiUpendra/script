package com.slokam.script.dto;

import com.slokam.script.entity.Script;

import lombok.Data;

@Data
public class ScriptCharectorDTO {
	private Long id;
	private String name;
	private Script script;

}

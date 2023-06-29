package com.slokam.script.dto;

import lombok.Data;

@Data
public class DialogueDTO {
  private Long id;
  private String content;
  private String parantical;
  private Long sceneID;
  private Integer sceneElementOrderId;
  private ScriptCharectorDTO scDTO;
}

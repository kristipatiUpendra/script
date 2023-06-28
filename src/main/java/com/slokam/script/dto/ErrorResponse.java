package com.slokam.script.dto;

import lombok.Data;

@Data
public class ErrorResponse {

	private Integer errorResponseCode;
	private String message;
}

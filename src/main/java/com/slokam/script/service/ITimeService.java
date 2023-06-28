package com.slokam.script.service;

import java.util.List;

import com.slokam.script.dto.TimeDTO;

public interface ITimeService {

	public TimeDTO save(TimeDTO timedto);
	
	public TimeDTO getbyId(Integer id);
	
	public List<TimeDTO> getall();
	
	public TimeDTO deletebyid(Integer id);
}

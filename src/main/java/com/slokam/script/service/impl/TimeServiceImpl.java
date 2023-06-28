package com.slokam.script.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.script.controller.TimeController;
import com.slokam.script.dao.ITimeDAO;
import com.slokam.script.dto.TimeDTO;
import com.slokam.script.entity.Time;
import com.slokam.script.service.ITimeService;



@Service
public class TimeServiceImpl implements ITimeService {

	@Autowired
	private ITimeDAO timedao;
	
	@Autowired
	private ModelMapper modelmapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TimeController.class);

	
	@Override
	public TimeDTO save(TimeDTO timedto) {
		LOGGER.debug("input dto data "+timedto.toString());
		Time time = new Time();
		LOGGER.debug("output ebtity data "+time.toString());
		time.setDescription(timedto.getDescription());
		timedao.save(time);

		timedto.setId(time.getId());
		return timedto;
	}

	
	@Override
	public TimeDTO getbyId(Integer id) {
		
	Optional<Time> opttime =	timedao.findById(id);
	
	TimeDTO timedto = null;
	if(opttime.isPresent())
	{
		Time time = opttime.get();
		timedto =	modelmapper.map(time, TimeDTO.class);
		
	}
		return timedto;
	}


	@Override
	public List<TimeDTO> getall() {
		
		List<Time> listtime = timedao.findAll();
		List<TimeDTO> listTimedto = new ArrayList<>();
		
		for(Time time:listtime)
		{
			TimeDTO timedto =modelmapper.map(time, TimeDTO.class);
			listTimedto.add(timedto);
		}
		return listTimedto;
	}
	
	@Override
	public TimeDTO deletebyid(Integer id)
	{
		
		TimeDTO timedto = null;
		Optional<Time> opt = timedao.findById(id);
		if(opt.isPresent())
		{
			Time time = opt.get();
			 timedto =modelmapper.map(time, TimeDTO.class);
			timedao.deleteById(id);
	}
		return timedto;
	
	}

}

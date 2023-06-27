package com.slokam.script.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam.script.dao.ITimeDAO;
import com.slokam.script.dto.TimeDTO;
import com.slokam.script.entity.Time;
import com.slokam.script.service.ITimeService;

@Service
public class TimeServiceImpl implements ITimeService {

	@Autowired
	private ITimeDAO timedao;
	
	@Override
	public TimeDTO save(TimeDTO timedto) {
		Time time = new Time();
		time.setDescription(timedto.getDescription());
		timedao.save(time);

		timedto.setId(time.getId());
		return timedto;
	}

}

package com.slokam.script.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.script.entity.Script;
import com.slokam.script.entity.Time;

@Repository
public interface ITimeDAO extends JpaRepository<Time, Integer>{

}

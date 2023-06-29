package com.slokam.script.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.script.entity.Location;
@Repository
public interface ILocationDAO extends JpaRepository<Location, Long>{

}

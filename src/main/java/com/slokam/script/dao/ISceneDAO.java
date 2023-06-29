package com.slokam.script.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.script.entity.Scene;

@Repository
public interface ISceneDAO extends JpaRepository<Scene, Long>{

}

package com.slokam.script.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.script.entity.ScriptCharector;
@Repository
public interface IScriptCharectorDAO extends JpaRepository<ScriptCharector, Long>{

}

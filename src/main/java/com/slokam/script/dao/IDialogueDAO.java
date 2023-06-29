package com.slokam.script.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.script.entity.Dialogue;
@Repository
public interface IDialogueDAO extends JpaRepository<Dialogue, Long>{

}

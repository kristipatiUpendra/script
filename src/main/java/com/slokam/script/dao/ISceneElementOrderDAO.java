package com.slokam.script.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.script.entity.SceneElementOrder;
@Repository
public interface ISceneElementOrderDAO extends JpaRepository<SceneElementOrder, Long>{

}

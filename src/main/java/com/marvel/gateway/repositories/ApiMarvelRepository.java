package com.marvel.gateway.repositories;

import com.marvel.gateway.models.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiMarvelRepository extends JpaRepository<Hero, Long>, JpaSpecificationExecutor<Hero> {

}
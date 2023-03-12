package com.ev.evproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.evproject.entity.ImageNames;

public interface ImageRepository extends JpaRepository<ImageNames, Long> {

}

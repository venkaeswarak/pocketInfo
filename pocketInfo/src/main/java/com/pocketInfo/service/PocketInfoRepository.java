package com.pocketInfo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pocketInfo.entity.PocketInfoEntity;

@Repository
public interface PocketInfoRepository extends JpaRepository<PocketInfoEntity, Long>{

}

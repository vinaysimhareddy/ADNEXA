package com.adnexa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adnexa.entity.InfluencerProfile;
import com.adnexa.entity.User;

public interface InfluencerProfileRepository
        extends JpaRepository<InfluencerProfile, Long>,
                org.springframework.data.jpa.repository.JpaSpecificationExecutor<InfluencerProfile> {

    Optional<InfluencerProfile> findByUser(User user);
}
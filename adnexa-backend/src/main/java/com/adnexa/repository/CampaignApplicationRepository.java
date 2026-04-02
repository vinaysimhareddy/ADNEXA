package com.adnexa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adnexa.entity.CampaignApplication;
import com.adnexa.entity.User;

public interface CampaignApplicationRepository extends JpaRepository<CampaignApplication, Long> {



    List<CampaignApplication> findByInfluencer(User influencer);
    
    List<CampaignApplication> findByCampaignId(Long campaignId);
    Optional<CampaignApplication> findById(Long id);
    
    boolean existsByCampaignIdAndInfluencerId(Long campaignId, Long influencerId);

}
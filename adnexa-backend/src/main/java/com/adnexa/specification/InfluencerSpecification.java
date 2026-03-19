package com.adnexa.specification;

import org.springframework.data.jpa.domain.Specification;

import com.adnexa.entity.InfluencerProfile;

public class InfluencerSpecification {

    public static Specification<InfluencerProfile> hasCategory(String category) {
        return (root, query, cb) -> 
            category == null ? null : cb.equal(root.get("category"), category);
    }

    public static Specification<InfluencerProfile> hasMinFollowers(Long minFollowers) {
        return (root, query, cb) -> {
            if (minFollowers == null) return null;

            return cb.or(
                cb.greaterThanOrEqualTo(root.get("instagramFollowers"), minFollowers),
                cb.greaterThanOrEqualTo(root.get("youtubeFollowers"), minFollowers),
                cb.greaterThanOrEqualTo(root.get("tiktokFollowers"), minFollowers)
            );
        };
    }

    public static Specification<InfluencerProfile> hasMaxPrice(Double maxPrice) {
        return (root, query, cb) -> 
            maxPrice == null ? null : cb.lessThanOrEqualTo(root.get("pricePerPost"), maxPrice);
    }

    public static Specification<InfluencerProfile> hasLocation(String location) {
        return (root, query, cb) -> 
            location == null ? null : cb.like(cb.lower(root.get("location")), "%" + location.toLowerCase() + "%");
    }
}
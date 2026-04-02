package com.adnexa.mapper;

import com.adnexa.dto.InfluencerCardResponse;
import com.adnexa.entity.InfluencerProfile;

public class InfluencerMapper {

    public static InfluencerCardResponse toCardResponse(InfluencerProfile profile) {
        long totalFollowers =
                (profile.getInstagramFollowers() != null ? profile.getInstagramFollowers() : 0) +
                (profile.getYoutubeFollowers()   != null ? profile.getYoutubeFollowers()   : 0) +
                (profile.getTiktokFollowers()    != null ? profile.getTiktokFollowers()    : 0);

        return new InfluencerCardResponse(
                profile.getUser().getName(),
                profile.getCategory(),
                totalFollowers,
                profile.getPricePerPost(),
                profile.getLocation(),
                profile.getBio()
        );
    }
}
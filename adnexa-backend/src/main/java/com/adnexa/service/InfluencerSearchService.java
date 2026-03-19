package com.adnexa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.adnexa.dto.InfluencerCardResponse;
import com.adnexa.dto.InfluencerSearchRequest;
import com.adnexa.dto.PageResponse;
import com.adnexa.entity.InfluencerProfile;
import com.adnexa.mapper.InfluencerMapper;
import com.adnexa.repository.InfluencerProfileRepository;
import com.adnexa.specification.InfluencerSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InfluencerSearchService {

    private final InfluencerProfileRepository influencerRepository;

    public PageResponse<InfluencerCardResponse> searchInfluencers(
            InfluencerSearchRequest request,
            int page,
            int size,
            String sortBy,
            String direction) {

        Specification<InfluencerProfile> spec = (root, query, cb) -> cb.conjunction();

        if (request.getCategory() != null) {
            spec = spec.and(InfluencerSpecification.hasCategory(request.getCategory()));
        }

        if (request.getMinFollowers() != null) {
            spec = spec.and(InfluencerSpecification.hasMinFollowers(request.getMinFollowers()));
        }

        if (request.getMaxPrice() != null) {
            spec = spec.and(InfluencerSpecification.hasMaxPrice(request.getMaxPrice()));
        }

        if (request.getLocation() != null) {
            spec = spec.and(InfluencerSpecification.hasLocation(request.getLocation()));
        }

        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<InfluencerProfile> result =
                influencerRepository.findAll(spec, pageable);

        List<InfluencerCardResponse> data =
                result.getContent()
                      .stream()
                      .map(InfluencerMapper::toCardResponse)
                      .toList();

        return new PageResponse<>(
                data,
                result.getNumber(),
                result.getSize(),
                result.getTotalElements(),
                result.getTotalPages()
        );
    }
}
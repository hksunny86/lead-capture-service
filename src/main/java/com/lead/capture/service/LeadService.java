package com.lead.capture.service;

import com.lead.capture.dto.LeadDto;
import com.lead.capture.exception.ResourceNotFoundException;
import com.lead.capture.model.Lead;
import com.lead.capture.model.repo.LeadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadDto saveLead(LeadDto request) {
        Lead lead = Lead.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .companyName(request.getCompanyName())
                .notes(request.getNotes())
                .build();

        lead = leadRepository.save(lead);
        log.info("Lead saved successfully with ID: {}", lead.getId());
        return new LeadDto(lead.getId(), lead.getFullName(), lead.getEmail(), lead.getPhone(), lead.getCompanyName(), lead.getNotes());
    }

    public List<LeadDto> getAllLeads() {
        return leadRepository.findAll().stream()
                .map(lead -> new LeadDto(lead.getId(), lead.getFullName(), lead.getEmail(), lead.getPhone(), lead.getCompanyName(), lead.getNotes()))
                .collect(Collectors.toList());
    }

    public void deleteLead(UUID id) throws ResourceNotFoundException {
        Optional<Lead> leadOptional = leadRepository.findById(id);
        if (leadOptional.isPresent()) {
            leadRepository.deleteById(id);
            log.info("Lead with ID {} deleted successfully", id);
        } else {
            log.warn("Attempted to delete a non-existent lead with ID {}", id);
            throw new ResourceNotFoundException("Lead not found with ID: " + id);
        }

    }
}

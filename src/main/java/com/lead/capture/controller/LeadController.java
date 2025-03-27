package com.lead.capture.controller;

import com.lead.capture.dto.LeadDto;
import com.lead.capture.exception.ResourceNotFoundException;
import com.lead.capture.service.LeadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/leads")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
@Slf4j
@Validated
public class LeadController {

    private final LeadService leadService;

    @PostMapping("/addLead")
    public ResponseEntity<String> addLead(@Valid @RequestBody LeadDto lead) {
        try {
            leadService.saveLead(lead);
            log.info("Lead successfully added: {}", lead.getEmail());
            return ResponseEntity.ok("Lead added successfully!");
        } catch (Exception e) {
            log.error("Error while adding lead: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving lead!");
        }
    }

    @GetMapping("/getLeads")
    public ResponseEntity<List<LeadDto>> getLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLead(@PathVariable String id) {
        try {
            UUID uuid = UUID.fromString(id);
            leadService.deleteLead(uuid);
            log.info("Lead deleted with ID: {}", id);
            return ResponseEntity.ok("Lead deleted successfully.");
        } catch (Exception | ResourceNotFoundException e) {
            log.error("Error while deleting lead: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lead not found!");
        }
    }
}


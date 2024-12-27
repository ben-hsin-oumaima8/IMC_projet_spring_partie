package com.formation.spring.Controller;

import com.formation.spring.Services.ImcService;
import com.formation.spring.Shared.DTO.ImcDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {

    @Autowired
    ImcService imcService;

    @PostMapping
    public ResponseEntity<ImcDTO> createImcProfile(@RequestBody ImcDTO imcDTO) {
        ImcDTO createdProfile = imcService.createImcProfile(imcDTO);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ImcDTO> getImcProfile(@PathVariable String userId) {
        ImcDTO imcProfile = imcService.getImcProfile(userId);
        return ResponseEntity.ok(imcProfile);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ImcDTO> updateImcProfile(
            @PathVariable String userId,
            @RequestBody ImcDTO imcDTO) {
        ImcDTO updatedProfile = imcService.updateImcProfile(userId, imcDTO);
        return ResponseEntity.ok(updatedProfile);
    }
}
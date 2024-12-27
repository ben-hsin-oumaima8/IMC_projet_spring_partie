package com.formation.spring.Services;

import com.formation.spring.Shared.DTO.ImcDTO;

public interface ImcService {
    ImcDTO createImcProfile(ImcDTO imcDTO);
    ImcDTO getImcProfile(String userId);
    ImcDTO updateImcProfile(String userId, ImcDTO imcDTO);
}
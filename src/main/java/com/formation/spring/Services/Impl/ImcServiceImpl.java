package com.formation.spring.Services.Impl;

import com.formation.spring.Entities.ImcDataEntity;
import com.formation.spring.Entities.UserEntity;
import com.formation.spring.Repositories.ImcRepository;
import com.formation.spring.Repositories.UserRepository;
import com.formation.spring.Services.ImcService;
import com.formation.spring.Shared.DTO.ImcDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImcServiceImpl implements ImcService {

    @Autowired
    ImcRepository imcRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ImcDTO createImcProfile(ImcDTO imcDTO) {
        ImcDataEntity imcEntity = new ImcDataEntity();
        BeanUtils.copyProperties(imcDTO, imcEntity);

        // Get user
        UserEntity userEntity = userRepository.findByUserId(imcDTO.getUserId());
        imcEntity.setUser(userEntity);

        // Calculate BMI
        double heightInMeters = imcDTO.getHeight() / 100;
        double bmi = imcDTO.getWeight() / (heightInMeters * heightInMeters);
        imcEntity.setBmi(Math.round(bmi * 100.0) / 100.0);

        // Set BMI Classification
        imcEntity.setBmiClassification(calculateBmiClassification(bmi));

        ImcDataEntity storedImc = imcRepository.save(imcEntity);

        ImcDTO returnValue = new ImcDTO();
        BeanUtils.copyProperties(storedImc, returnValue);

        return returnValue;
    }

    private String calculateBmiClassification(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else if (bmi >= 30 && bmi < 35) {
            return "Obesity Class I";
        } else if (bmi >= 35 && bmi < 40) {
            return "Obesity Class II";
        } else {
            return "Obesity Class III";
        }
    }

    @Override
    public ImcDTO getImcProfile(String userId) {
        ImcDataEntity imcEntity = imcRepository.findByUserUserId(userId);
        ImcDTO returnValue = new ImcDTO();
        BeanUtils.copyProperties(imcEntity, returnValue);
        return returnValue;
    }

    @Override
    public ImcDTO updateImcProfile(String userId, ImcDTO imcDTO) {
        ImcDataEntity imcEntity = imcRepository.findByUserUserId(userId);

        if (imcEntity == null) return null;

        BeanUtils.copyProperties(imcDTO, imcEntity);

        // Recalculate BMI
        double heightInMeters = imcDTO.getHeight() / 100;
        double bmi = imcDTO.getWeight() / (heightInMeters * heightInMeters);
        imcEntity.setBmi(Math.round(bmi * 100.0) / 100.0);
        imcEntity.setBmiClassification(calculateBmiClassification(bmi));

        ImcDataEntity updatedImc = imcRepository.save(imcEntity);

        ImcDTO returnValue = new ImcDTO();
        BeanUtils.copyProperties(updatedImc, returnValue);

        return returnValue;
    }
}
package com.amodecodes.health.usercontroller;

import com.amodecodes.health.entity.MedicalServiceSystem;
import com.amodecodes.health.service.MedicalServiceSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hms/user/medical-services")
public class MedicalServiceSystemUserController {

    private final MedicalServiceSystemService medicalServiceSystemService;

    @Autowired
    public MedicalServiceSystemUserController(MedicalServiceSystemService medicalServiceSystemService) {
        this.medicalServiceSystemService = medicalServiceSystemService;
    }

    @GetMapping
    public List<MedicalServiceSystem> getAllMedicalServices() {
        return medicalServiceSystemService.getAllMedicalServices();
    }
}


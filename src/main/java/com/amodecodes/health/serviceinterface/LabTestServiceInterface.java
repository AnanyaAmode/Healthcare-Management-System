package com.amodecodes.health.serviceinterface;

import com.amodecodes.health.entity.LabTest;

import java.util.List;

public interface LabTestServiceInterface {

    List<LabTest> getAllLabTests();
    LabTest getLabTestById(Long labTestId);
    LabTest addNewLabTest(LabTest labTest);
    LabTest updateLabTest(Long labTestId, LabTest labTestUpdatedDetails);
    void deleteLabTest(Long labTestId);
    LabTest connectLabTestToPatient(Long labTestId, Long patientId);
}

package cs.miu.edu.cs489appsd.adsmgmtsys.service;

import cs.miu.edu.cs489appsd.adsmgmtsys.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Long id);
    void deletePatient(Long id);
}

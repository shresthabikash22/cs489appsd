package cs.miu.edu.cs489appsd.adsmgmtsys.service;

import cs.miu.edu.cs489appsd.adsmgmtsys.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    Dentist saveDentist(Dentist dentist);
    List<Dentist> getAllDentists();
    Optional<Dentist> getDentistById(Long id);
    void deleteDentist(Long id);
}

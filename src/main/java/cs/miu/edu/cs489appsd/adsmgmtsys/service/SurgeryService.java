package cs.miu.edu.cs489appsd.adsmgmtsys.service;

import cs.miu.edu.cs489appsd.adsmgmtsys.model.Surgery;

import java.util.List;
import java.util.Optional;

public interface SurgeryService {
    Surgery saveSurgery(Surgery surgery);
    List<Surgery> getAllSurgeries();
    Optional<Surgery> getSurgeryById(Long id);
    void deleteSurgery(Long id);
}

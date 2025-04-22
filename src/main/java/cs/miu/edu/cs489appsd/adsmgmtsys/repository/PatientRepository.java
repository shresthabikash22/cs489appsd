package cs.miu.edu.cs489appsd.adsmgmtsys.repository;

import cs.miu.edu.cs489appsd.adsmgmtsys.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}

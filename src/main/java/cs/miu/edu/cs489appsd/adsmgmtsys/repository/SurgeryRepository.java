package cs.miu.edu.cs489appsd.adsmgmtsys.repository;

import cs.miu.edu.cs489appsd.adsmgmtsys.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery,Long> {
}

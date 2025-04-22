package cs.miu.edu.cs489appsd.adsmgmtsys.repository;

import cs.miu.edu.cs489appsd.adsmgmtsys.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}

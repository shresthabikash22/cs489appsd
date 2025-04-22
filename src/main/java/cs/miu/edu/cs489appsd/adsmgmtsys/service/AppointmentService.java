package cs.miu.edu.cs489appsd.adsmgmtsys.service;

import cs.miu.edu.cs489appsd.adsmgmtsys.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Optional<Appointment> getAppointmentById(Long id);
    void deleteAppointment(Long id);
}

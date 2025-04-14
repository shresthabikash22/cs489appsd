package cs.miu.edu.cs489appsd.adsmgmtsys.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean hasUnpaidBill;

    @Column(nullable = false)
    private LocalDate datOfBirth;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false,unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name="address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

}

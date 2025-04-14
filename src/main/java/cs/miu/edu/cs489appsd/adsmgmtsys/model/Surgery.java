package cs.miu.edu.cs489appsd.adsmgmtsys.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "surgeries")
@Data
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false, unique = true)
    private Address address;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}

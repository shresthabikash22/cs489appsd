package cs.miu.edu.cs489appsd.adsmgmtsys.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "roles")
@Data
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_id;
    private String role_name;

    @ManyToMany(mappedBy = "roles")
    private List< User> users;

    public Roles(String role_name) {
        this.role_name = role_name;
    }


    @Override
    public String toString() {
        return "role_name='" + role_name + '\'';
    }
}

package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAgence;

    String nom;
    String ville;
    String adresse;
    String telephone;
    @OneToMany(mappedBy = "agence")
    Set<Vehicule> vehicules;
    @OneToMany(mappedBy = "agence")
    Set<Employe> employe;

}
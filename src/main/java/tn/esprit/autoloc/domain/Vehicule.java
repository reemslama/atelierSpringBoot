package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity //jeya mn JPA
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Vehicule {
    @Id //JPA
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVehicule;
    String immatricule;
    String marque;
    String modele;
    @Enumerated(value = EnumType.STRING)
    CategorieVehicule categorie;
    BigDecimal tarifJournalier;
    @Enumerated(value = EnumType.STRING)
    StatutVehicule statut;
    @JsonBackReference // class parent
   @ManyToOne
    Agence agence;
   @ManyToMany
    Set<Equipement> equipements = new HashSet<>();
    @OneToMany(mappedBy = "vehicule")
    Set<Reservation> reservations;
}

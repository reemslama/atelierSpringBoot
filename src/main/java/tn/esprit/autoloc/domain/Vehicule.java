package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
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
    long idVehicule;
    String immatricule;
    String marque;
    String modele;
    @Enumerated(value = EnumType.STRING)
    CategorieVehicule categorie;
    BigDecimal tarifJournalier;
    @Enumerated(value = EnumType.STRING)
    StatutVehicule statut;
   @ManyToOne
    Agence agence;
   @ManyToMany
    Set<Equipement> equipements;
    @OneToMany(mappedBy = "vehicule")
    Set<Reservation> reservations;
}

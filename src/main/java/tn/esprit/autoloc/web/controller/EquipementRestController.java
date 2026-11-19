
package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipement;

import java.util.List;

@Tag(name = "EquipementRim", description = "Gestion : Equipement")
@RestController
@RequestMapping("/Equipements")
@RequiredArgsConstructor
public class EquipementRestController {

    private final IEquipement iEquipement;

    // 1. Ajouter une Equipement
    @Operation(summary = "Ajouter une Equipement")
    @PostMapping("/add")
    public Equipement createEquipement(@RequestBody Equipement Equipement) {
        return iEquipement.addEquipement(Equipement);
    }

    // 2. Afficher une Equipement par ID
    @Operation(summary = "Afficher une Equipement par ID")
    @GetMapping("/{idEquipement}")
    public Equipement afficherEquipement(
            @PathVariable("idEquipement") Long idEquipement) {

        return iEquipement.getById(idEquipement);
    }

    // 3. Modifier une Equipement
    @Operation(summary = "Modifier une Equipement")
    @PutMapping("/update/{idEquipement}")
    public Equipement modifierEquipement(
            @PathVariable("idEquipement") Long idEquipement,
            @RequestBody Equipement Equipement) {

        return iEquipement.updateEquipement(idEquipement, Equipement);
    }

    // 4. Supprimer une Equipement
    @Operation(summary = "Supprimer une Equipement")
    @DeleteMapping("/{idEquipement}")
    public void supprimerEquipement(
            @PathVariable("idEquipement") Long idEquipement) {

        iEquipement.deleteEquipement(idEquipement);
    }

    // 5. Afficher toutes les Equipements
    @Operation(summary = "Afficher toutes les Equipements")
    @GetMapping("/getAll")
    public List<Equipement> afficherEquipements() {
        return iEquipement.findAll();
    }
}

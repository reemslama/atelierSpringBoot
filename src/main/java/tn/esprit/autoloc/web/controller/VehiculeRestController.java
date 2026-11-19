
package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehicule;

import java.util.List;

@Tag(name = "VéhiculesRim", description = "Gestion : Véhicule")
@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehicule iVehicule;

    // 1. Ajouter un véhicule
    @Operation(summary = "Ajouter un véhicule")
    @PostMapping("/add")
    public Vehicule createVehicule(
            @RequestBody Vehicule vehicule) {

        return iVehicule.addVehicule(vehicule);
    }

    // 2. Afficher un véhicule par ID
    @Operation(summary = "Afficher un véhicule par ID")
    @GetMapping("/{idVehicule}")
    public Vehicule afficherVehicule(
            @PathVariable("idVehicule") Long idVehicule) {

        return iVehicule.getById(idVehicule);
    }

    // 3. Modifier un véhicule
    @Operation(summary = "Modifier un véhicule")
    @PutMapping("/update/{idVehicule}")
    public Vehicule modifierVehicule(
            @PathVariable("idVehicule") Long idVehicule,
            @RequestBody Vehicule vehicule) {

        return iVehicule.updateVehicule(idVehicule, vehicule);
    }

    // 4. Supprimer un véhicule
    @Operation(summary = "Supprimer un véhicule")
    @DeleteMapping("/{idVehicule}")
    public void supprimerVehicule(
            @PathVariable("idVehicule") Long idVehicule) {

        iVehicule.deleteVehicule(idVehicule);
    }

    // 5. Afficher tous les véhicules
    @Operation(summary = "Afficher tous les véhicules")
    @GetMapping("/getAll")
    public List<Vehicule> afficherVehicules() {
        return iVehicule.findAll();
    }

    // 6. Affecter un véhicule à une agence
    @Operation(summary = "Affecter un véhicule à une agence")
    @PutMapping("/{idVehicule}/{idAgence}")
    public Vehicule assignToAgence(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idAgence") Long idAgence) {

        return iVehicule.assignToAgence(idVehicule, idAgence);
    }
    @PutMapping("/assignToEquipement/{idVehicule}/{idEquipement}")
    Vehicule assignToEquipement(@PathVariable("idVehicule") Long idVehicule,@PathVariable("idEquipement") Long idEquipement){
        return iVehicule.assignToEquipement(idVehicule, idEquipement);
    }
    @PutMapping("/unassign/{idVehicule}/{idEquipement}")
    Vehicule unassignToEquipement(@PathVariable("idVehicule") Long idVehicule,@PathVariable("idEquipement") Long idEquipement){
        return iVehicule.UnassignToEquipements(idVehicule,idEquipement);
    }
    @PutMapping("/unassignToAgence/{idVehicule}/{idAgence}")
    public Vehicule unassignToAgence(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idAgence") Long idAgence) {

        return iVehicule.UnassignToAgence(idVehicule, idAgence);
    }


}

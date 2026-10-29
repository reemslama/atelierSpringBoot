package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehicule;

import java.util.List;
@Tag(name="VéhiculesRim", description = "Gestion : Véhicule" )
@RestController
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehicule iVehicule; //eviter la couplage fort
    @Operation(summary = "ajouter : Véhicules")
    @PostMapping("/add")
    Vehicule createVehicule(@RequestBody Vehicule vehicule) {
        return iVehicule.addVehicule(vehicule);
    }
    @Operation(summary = "Lister par id : Véhicules")
    @GetMapping("{id}")
     Vehicule afficherVehicule(@PathVariable Long id) {
        return iVehicule.getById(id);
    }
    @Operation(summary = "modifier : Véhicules")
    @PutMapping("update/{id}")
     Vehicule modifierVehicule(@PathVariable Long id , @RequestBody Vehicule vehicule){
        return iVehicule.updateVehicule(id,vehicule);
    }
    @Operation(summary = "supprimer : Véhicules")
    @DeleteMapping("{id}")
    void supprimerVehicule(@PathVariable Long id){
        iVehicule.deleteVehicule(id);
    }
    @Operation(summary = "Lister : Véhicules")
    @GetMapping("getAll")
    List<Vehicule> afficherVehicules(){
        return iVehicule.findAll();
    }

}
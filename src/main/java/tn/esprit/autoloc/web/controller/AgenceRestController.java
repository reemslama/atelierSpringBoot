
package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgence;

import java.util.List;

@Tag(name = "AgenceRim", description = "Gestion : Agence")
@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceRestController {

    private final IAgence iAgence;

    // 1. Ajouter une agence
    @Operation(summary = "Ajouter une agence")
    @PostMapping("/add")
    public Agence createAgence(@RequestBody Agence agence) {
        return iAgence.addAgence(agence);
    }

    // 2. Afficher une agence par ID
    @Operation(summary = "Afficher une agence par ID")
    @GetMapping("/{idAgence}")
    public Agence afficherAgence(
            @PathVariable("idAgence") Long idAgence) {

        return iAgence.getById(idAgence);
    }

    // 3. Modifier une agence
    @Operation(summary = "Modifier une agence")
    @PutMapping("/update/{idAgence}")
    public Agence modifierAgence(
            @PathVariable("idAgence") Long idAgence,
            @RequestBody Agence agence) {

        return iAgence.updateAgence(idAgence, agence);
    }

    // 4. Supprimer une agence
    @Operation(summary = "Supprimer une agence")
    @DeleteMapping("/{idAgence}")
    public void supprimerAgence(
            @PathVariable("idAgence") Long idAgence) {

        iAgence.deleteAgence(idAgence);
    }

    // 5. Afficher toutes les agences
    @Operation(summary = "Afficher toutes les agences")
    @GetMapping("/getAll")
    public List<Agence> afficherAgences() {
        return iAgence.findAll();
    }
}

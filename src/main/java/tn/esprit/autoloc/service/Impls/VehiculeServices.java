package tn.esprit.autoloc.service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.repository.IEquipementRepository;
import tn.esprit.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.service.IVehicule;

import java.util.List;
@Service
@RequiredArgsConstructor // injecter la dépondance (le whiling )
public class VehiculeServices implements IVehicule {
    private final IVehiculeRepository iVehiculeRepository;// bel final
    private final IAgenceRepository iAgenceRepository;
    private  final IEquipementRepository iEquipementRepository;

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule updateVehicule(Long id ,Vehicule vehicule) {
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteVehicule(Long id) {
        iVehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule getById(Long id) { //type de retour c pas un objet donc on va le convertir
        return iVehiculeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("vehicule not found"));
    }

    @Override
    public List<Vehicule> findAll() {
        return iVehiculeRepository.findAll();
    }

    @Override
    public Vehicule assignToAgence(Long idVehicule, Long idAgence) {
        Vehicule vehicule = getById(idVehicule);
        Agence agence= iAgenceRepository.findById(idAgence).orElseThrow(()-> new EntityNotFoundException("agence not found"));
        //affectation
        vehicule.setAgence(agence);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule assignToEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = getById(idVehicule);
        Equipement equipement = iEquipementRepository.findById(idEquipement).orElseThrow(()-> new EntityNotFoundException("equipement not found"));
        vehicule.getEquipements().add(equipement);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule UnassignToEquipements(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = getById(idVehicule);
        Equipement equipement = iEquipementRepository.findById(idEquipement).orElseThrow(()-> new EntityNotFoundException("equipement not found"));
        vehicule.getEquipements().remove(equipement);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule UnassignToAgence(Long idVehicule, Long idAgence) {
        Vehicule vehicule = getById(idVehicule);
        Agence agence= iAgenceRepository.findById(idAgence).orElseThrow(()-> new EntityNotFoundException("agence not found"));
        //Déaffectation
        vehicule.setAgence(null);
        return iVehiculeRepository.save(vehicule);
    }


}

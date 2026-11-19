package tn.esprit.autoloc.service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;
import tn.esprit.autoloc.repository.IEquipementRepository;
import tn.esprit.autoloc.service.IEquipement;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EquipementServices implements IEquipement {
    private final IEquipementRepository iEquipementRepository;// bel final
    @Override
    public Equipement addEquipement(Equipement Equipement) {
        return iEquipementRepository.save(Equipement);
    }

    @Override
    public Equipement updateEquipement(Long id ,Equipement Equipement) {
        return iEquipementRepository.save(Equipement);
    }

    @Override
    public void deleteEquipement(Long id) {
        iEquipementRepository.deleteById(id);
    }

    @Override
    public Equipement getById(Long id) { //type de retour c pas un objet donc on va le convertir
        return iEquipementRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Equipement not found"));
    }

    @Override
    public List<Equipement> findAll() {
        return iEquipementRepository.findAll();
    }
}

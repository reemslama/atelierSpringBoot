package tn.esprit.autoloc.service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.service.IVehicule;

import java.util.List;
@Service
@RequiredArgsConstructor // injecter la dépondance (le whiling )
public class VehiculeServices implements IVehicule {
    private final IVehiculeRepository iVehiculeRepository; // bel final

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
}

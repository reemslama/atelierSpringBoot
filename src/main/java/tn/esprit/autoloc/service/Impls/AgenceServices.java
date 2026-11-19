package tn.esprit.autoloc.service.Impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.repository.IAgenceRepository;
import tn.esprit.autoloc.service.IAgence;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AgenceServices implements IAgence {
    private final IAgenceRepository iAgenceRepository;// bel final
    @Override
    public Agence addAgence(Agence Agence) {
        return iAgenceRepository.save(Agence);
    }

    @Override
    public Agence updateAgence(Long id ,Agence Agence) {
        return iAgenceRepository.save(Agence);
    }

    @Override
    public void deleteAgence(Long id) {
        iAgenceRepository.deleteById(id);
    }

    @Override
    public Agence getById(Long id) { //type de retour c pas un objet donc on va le convertir
        return iAgenceRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Agence not found"));
    }

    @Override
    public List<Agence> findAll() {
        return iAgenceRepository.findAll();
    }
}

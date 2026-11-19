package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IAgence {
    Agence addAgence(Agence Agence);
    Agence updateAgence(Long id ,Agence Agence);
    void deleteAgence(Long id);
    Agence getById(Long id);
    List<Agence> findAll();
}

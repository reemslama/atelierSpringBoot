package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipement {
    Equipement addEquipement(Equipement Equipement);
    Equipement updateEquipement(Long id ,Equipement Equipement);
    void deleteEquipement(Long id);
    Equipement getById(Long id);
    List<Equipement> findAll();
}

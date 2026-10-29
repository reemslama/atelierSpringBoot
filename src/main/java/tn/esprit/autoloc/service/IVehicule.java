package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehicule {
    Vehicule addVehicule(Vehicule vehicule);
    Vehicule updateVehicule(Long id ,Vehicule vehicule);
    void deleteVehicule(Long id);
    Vehicule getById(Long id);
    List<Vehicule> findAll();
}
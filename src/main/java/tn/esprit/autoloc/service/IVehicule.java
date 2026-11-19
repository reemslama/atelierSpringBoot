package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehicule {
    Vehicule addVehicule(Vehicule vehicule);
    Vehicule updateVehicule(Long id ,Vehicule vehicule);
    void deleteVehicule(Long id);
    Vehicule getById(Long id);
    List<Vehicule> findAll();
    Vehicule assignToAgence(Long idVehicule , Long idAgence);
    Vehicule assignToEquipement(Long idVehicule , Long idEquipement);
    Vehicule UnassignToEquipements(Long idVehicule , Long idEquipement);
    Vehicule UnassignToAgence(Long idVehicule , Long idAgence);

}
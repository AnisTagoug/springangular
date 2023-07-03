package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Material;

import java.util.List;

public interface IMaterialService {

    public List<Material> retrieveAllMaterials();

    public Material updateMaterial (Material material);

    public Material addMaterial (Material material);

    public Material retrieveMaterial (Integer  codeMaterial);

    public Material removeMaterial(Integer codeMaterial);

}

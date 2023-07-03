package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Material;
import tn.esprit.spring.interfaces.IMaterialService;
import tn.esprit.spring.repositories.MaterialRepository;

import java.util.List;
@Service
@Slf4j
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Override
    public List<Material> retrieveAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public Material updateMaterial(Material material) { return materialRepository.save(material);}

    @Override
    public Material addMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material retrieveMaterial(Integer codeMaterial) {
        return null;
    }

    @Override
    public Material removeMaterial(Integer codeMaterial) {

        return null;
    }
}

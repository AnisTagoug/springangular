package tn.esprit.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Material;
import tn.esprit.spring.entities.Supplier;
import tn.esprit.spring.interfaces.IMaterialService;
import tn.esprit.spring.interfaces.ISupplierService;

@RestController
@Slf4j
@RequestMapping("/material")

public class MaterialRestController {

    @Autowired
    IMaterialService materialService;
    @PostMapping("/add-material")
    public void addMaterial(@RequestBody Material material) {
        materialService.addMaterial(material);
    }


    @PutMapping("/update-material")
    public Material updateMaterial(@RequestBody Material material) {

        return materialService.updateMaterial(material);

    }

    @PutMapping("/remove-Material/{codeMaterial}")
    public Material removeMaterial(@PathVariable("codeMaterial") Integer codeMaterial) {

        return materialService.removeMaterial(codeMaterial);

    }
}

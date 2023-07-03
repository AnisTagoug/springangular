package tn.esprit.spring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Supplier;
import tn.esprit.spring.interfaces.ISupplierService;

@RestController
@Slf4j
@RequestMapping("/supplier")
public class SupplierRestController {

    @Autowired
    ISupplierService supplierService;
    @PostMapping("/add-supplier")
    public void addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
    }


    @PutMapping("/update-supplier")
    public Supplier updateSupplier(@RequestBody Supplier supplier) {

        return supplierService.updateSupplier(supplier);

    }

    @PutMapping("/remove-Supplier/{idSupplier}")
    public Supplier removeSupplier(@PathVariable("idSupplier") Integer idSupplier) {

        return supplierService.removeSupplier(idSupplier);

    }
}

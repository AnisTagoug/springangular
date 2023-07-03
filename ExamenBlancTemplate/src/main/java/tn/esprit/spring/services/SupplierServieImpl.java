package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Supplier;
import tn.esprit.spring.interfaces.ISupplierService;
import tn.esprit.spring.repositories.SupplierRepository;

import java.util.List;

@Service
@Slf4j

public class SupplierServieImpl implements ISupplierService {


    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<Supplier> retrieveAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }



    @Override
    public Supplier addSupplier(Supplier supplier) { return supplierRepository.save(supplier);}


    @Override
    public Supplier retrieveSupplier(Integer idSupplier) {
        return null;
    }

    @Override
    public Supplier removeSupplier(Integer idSupplier) {

        return null;
    }
}

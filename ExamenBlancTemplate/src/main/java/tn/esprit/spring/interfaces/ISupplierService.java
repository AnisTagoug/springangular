package tn.esprit.spring.interfaces;

import tn.esprit.spring.entities.Supplier;

import java.util.List;

public interface ISupplierService {

    public List<Supplier> retrieveAllSuppliers();

    public Supplier updateSupplier (Supplier  supplier);

    public  Supplier addSupplier (Supplier supplier);

    public Supplier retrieveSupplier (Integer  idSupplier);

    public Supplier removeSupplier(Integer idSupplier);

}

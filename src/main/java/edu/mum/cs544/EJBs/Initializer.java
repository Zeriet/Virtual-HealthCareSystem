/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs544.EJBs;

import edu.mum.cs544.boundary.AddressFacade;
import edu.mum.cs544.boundary.CategoryFacade;
import edu.mum.cs544.boundary.DoctorFacade;
import edu.mum.cs544.boundary.PatientFacade;
import edu.mum.cs544.boundary.SymptomFacade;
import edu.mum.cs544.model.Address;
import edu.mum.cs544.model.Patient;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author zeriet
 */
@Singleton
@Startup
public class Initializer {
  @Inject
    private PatientFacade patientFacade;
    
    @Inject
    private DoctorFacade doctorFacade;    
     @Inject
    private CategoryFacade categoryFacade;
    @Inject
    private AddressFacade addressFacade;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
   
    
    @PostConstruct
    public void init() {
        
        Address address1 = new Address();
        address1.setState("IA");
        address1.setStreet("100N 4th");
        address1.setZip("52557");
        
        Patient patient1 = new Patient();
        patient1.setFirstName("Yared");
        patient1.setLastName("Asefaw");
        patient1.setDob(null);
        patient1.setGender("M");
        patient1.setEmail("zeriet@gmail.com");
        patient1.setPassword("yared");
        patient1.setAddress(address1); 
        
        System.out.println("+++++++++++Test++++++++"+patient1.getAddress().getState());
       
        this.patientFacade.create(patient1);       
        
        
 
    }

}

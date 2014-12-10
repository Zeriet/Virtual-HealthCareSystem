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
import edu.mum.cs544.model.Category;
import edu.mum.cs544.model.Doctor;
import edu.mum.cs544.model.Patient;
import edu.mum.cs544.model.Symptom;
import java.util.Date;
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
    @EJB
    private SymptomFacade symptomFacade;

    @Inject
    private CategoryFacade categoryFacade;
    @Inject
    private PatientFacade patientFacade;
    @Inject
    private DoctorFacade doctorFacade;    
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
        patient1.setEmail("yared@gmail.com");
        patient1.setPassword("");
        patient1.setAddress(address1);
        patient1.setDob( new Date(11/11/1983));
        
        this.patientFacade.create(patient1);
        
        Category category1 = new Category();
        category1.setTitle("Phsyiotherapy");
        this.categoryFacade.create(category1);
        Category category2 = new Category();
        category2.setTitle("General Practioner"); 
        this.categoryFacade.create(category2);
        
        Symptom symptom1 = new Symptom();
        symptom1.setSystolic(100);
        symptom1.setDizziness(true);
        symptom1.setTemperature(100);
        symptom1.setNausea(true);
        symptom1.setCategory(category1);
        symptom1.setPatient(patient1);
//        symptom1.setPatient(patient1);
        this.symptomFacade.create(symptom1);
        
        Doctor doctor1 = new Doctor();
        doctor1.setFirstName("Zeriet");
        doctor1.setLastName("Tekie");
        doctor1.setEmail("zeriet@gmail.com");
        doctor1.setWorkExp(3);
        doctor1.setCategory(category1);
        doctor1.setAddress(address1);
        doctor1.setPassword("");
        this.doctorFacade.create(doctor1);  
        System.out.println("+++++++++++Test++++++++" + patient1.getAddress().getState());


    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs544.Controller;

import edu.mum.cs544.boundary.AddressFacade;
import edu.mum.cs544.boundary.CategoryFacade;
import edu.mum.cs544.boundary.DoctorFacade;
import edu.mum.cs544.boundary.PatientFacade;
import edu.mum.cs544.backingBeans.Registration;
import edu.mum.cs544.model.Address;
import edu.mum.cs544.model.Category;
import edu.mum.cs544.model.Doctor;
import edu.mum.cs544.model.Patient;
import edu.mum.cs544.model.Symptom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import webServices.BundleMessages;
import webServices.MailService;

/**
 *
 * @author zeriet
 */
@Stateless
public class RegistrationEJB {

    @EJB
    private PatientFacade patientFacade;
    @EJB
    private AddressFacade addressFacade;
    @EJB
    private DoctorFacade doctorFacade;
    @EJB
    private CategoryFacade categoryFacade;
    
    //email service
    private String recipient;
    private String subject="Welcome to VHC";
   
    private String statusMessage = "";
 
    //


    private BundleMessages bundle1=new BundleMessages();
     private String message=bundle1.getPatientWelcome();

    
    public void registeruser(Patient patient, Address address) {

        patient.setAddress(address);
        this.addressFacade.create(address);
        this.patientFacade.create(patient);

        recipient = patient.getEmail();
        try {
            MailService.sendMessage(recipient, subject, message);
        } catch (MessagingException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

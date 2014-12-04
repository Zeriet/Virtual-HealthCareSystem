/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs544.controller;

import edu.mum.cs544.boundary.CategoryFacade;
import edu.mum.cs544.boundary.SymptomFacade;
import edu.mum.cs544.model.Doctor;
import edu.mum.cs544.model.Symptom;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author hiwot
 */
@Named("doctor")
public class DoctorBean implements Serializable{
    private Doctor doctor = new Doctor();
    private List<Doctor> doctors;
    private List<Symptom> symptoms;
    private Symptom symptom = new Symptom();
    
    @EJB
    private CategoryFacade categoryFacade;
     @EJB
    private SymptomFacade symptomFacade;
    
    private EntityManager em;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public CategoryFacade getCategoryFacade() {
        return categoryFacade;
    }

    public void setCategoryFacade(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    public SymptomFacade getSymptomFacade() {
        return symptomFacade;
    }

    public void setSymptomFacade(SymptomFacade symptomFacade) {
        this.symptomFacade = symptomFacade;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    public String viewMyAssignments(){
        String doctorCategory = doctor.getCategory().getTitle();
        String query = "SELECT symptom FROM Symptom symptom WHERE symptom.category.title =:catTitle";
//        query.setParameter("catTitle",doctorCategory);
//        symptoms = query.getResultList();
        symptoms= symptomFacade.findListByQuery(symptoms, query, "catTitle", doctorCategory);
        return "viewAssignments";
    } 
    public String symptomDetail(Symptom s){
        symptom = s;
        return "viewSymptomDetail";
    }
    public String writePrescription(Symptom s){
        symptom = s;
        return "prescriptionForm";
    }
}
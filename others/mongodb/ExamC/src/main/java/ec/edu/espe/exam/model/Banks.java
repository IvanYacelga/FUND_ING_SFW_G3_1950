/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.exam.model;

import javax.swing.text.Document;
import javax.xml.crypto.Data;

/**
 *
 * @author leydi
 */
public class Banks {
    private int id;
    private String name;
    private String lastName;
    private int amount;

    public Banks() {
    }

    
    public Banks(int id, String name, String surnam, Data data) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.amount = amount;
    } 
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    
    public void setLastName(String lastName) {    
        this.lastName = lastName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}

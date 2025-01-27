/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.exam.controller;

import ec.edu.espe.exam.model.Banks;
import java.util.List;
import util.MethodsBanks;

/**
 *
 * @author leydi
 */
public class BankController {
    public static List<Banks> ListBanks() {
        return new MethodsBanks().ListBanks();
    }
    
    public Banks BuscarId(int idData) {
        MethodsBanks methodsBanks = new MethodsBanks();
        List<Banks> listBanks = methodsBanks.ListBanks();

        for (Banks bank : listBanks) {
            if (bank.getId() == idData) {
                return bank;
            }
        }
        return null;
    }
}

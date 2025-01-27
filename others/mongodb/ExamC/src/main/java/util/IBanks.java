/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

import ec.edu.espe.exam.model.Banks;
import java.util.List;

/**
 *
 * @author leydi
 */
public interface IBanks {
    public List<Banks> ListBanks();
    public Banks BuscarId( int idData);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import util.IBanks;
import util.Conection;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.exam.model.Banks;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author leydi
 */
public class MethodsBanks implements IBanks{

    Conection conn = new Conection();
    MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public MethodsBanks() {
        if (conn != null) {
            this.conn = conn.createConection();
            this.database = conn.getMongoDatabase();
            this.coleccion = database.getCollection("data");

        }
    }

    private void cerrarConexion() {
        try {
            conn.getMongoClient().close();
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.toString());
        }
    }
    private Integer getIntegerFromDocument(Document doc, String key) {
    Object value = doc.get(key);
    if (value instanceof Integer) {
        return (Integer) value;
    } else if (value instanceof String) {
        try {
            return Integer.parseInt((String) value);
        } catch (NumberFormatException e) {
            return null;  // O maneja el error según tus necesidades
        }
    } else {
        return null;
    }
}

    @Override
    public List<Banks> ListBanks() {
        List<Banks> listBank = new ArrayList<>();
    FindIterable<Document> documentos;

    try {
        documentos = coleccion.find();
        for (Document temp : documentos) {
            Banks bank = new Banks();
            Integer identityCard = getIntegerFromDocument(temp, "identity_Card");
            bank.setName(temp.getString("name"));
            bank.setLastName(temp.getString("last_name"));
            Integer amount = getIntegerFromDocument(temp, "amount");

            if (identityCard != null) {
                bank.setId(identityCard);  // Suponiendo que 'cedula' es el id
            }
            if (amount != null) {
                bank.setAmount(amount);
            }

            listBank.add(bank);
        }
    } catch (MongoException ex) {
        JOptionPane.showMessageDialog(null, "Error en la consulta de datos: " + ex.getMessage());
    } finally {
        cerrarConexion();
    }

    return listBank;
    }
    
    @Override
    public Banks BuscarId(int idData) {
        Banks banks = null;

        try {
            System.out.println("Buscando pedido con ID: " + idData);
            Document filtro = new Document("id", idData);
            FindIterable<Document> resultados = coleccion.find(filtro);
            Document resultado = resultados.first();

            if (resultado != null) {
                banks = new Banks();
                Integer identityCard = resultado.getInteger("identity_Card");
                banks.setName(resultado.getString("name"));
                banks.setLastName(resultado.getString("last_name"));
                Integer amount = resultado.getInteger("amount");
                
                
                
            } else {
                System.out.println("No se encontraron resultados para el ID: " + idData);
            }
        } catch (MongoException ex) {
            ex.printStackTrace();  // Imprimir la traza completa del error
            JOptionPane.showMessageDialog(null, "Error al buscar datos: " + ex.toString());
        } finally {
            cerrarConexion();
        }

        return banks;
    }   
    
}

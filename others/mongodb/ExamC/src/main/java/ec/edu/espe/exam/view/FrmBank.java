/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.exam.view;

import ec.edu.espe.exam.controller.BankController;
import ec.edu.espe.exam.model.Banks;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leydi
 */
public class FrmBank extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;
    private List<Banks> listBanks;
    int id = 0;
    
    public FrmBank() {
        initComponents();
        CargarPedidos();
        cmbBank.addActionListener((e) -> cargarTablaPedidoSeleccionado());
        
    }

     public void CargarPedidos() {
   cmbBank.removeAllItems();
    cmbBank.addItem("Todos");

    try {
        BankController bankController = new BankController();
        listBanks = bankController.ListBanks();
        cargarTablaTodosPedidos(listBanks);
        cargarComboIdPedidos(listBanks);
        cmbBank.setSelectedItem("Todos");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void cargarComboIdPedidos(List<Banks> listBanks) {
    for (Banks banks : listBanks) {
        cmbBank.addItem(banks.getId() + "-" + banks.getName());
    }
}

public void limpiarTabla() {
    modeloTabla = (DefaultTableModel) tblBank.getModel();
    modeloTabla.setRowCount(0);
}
   public void cargarTablaTodosPedidos(List<Banks> listBanks) {
    limpiarTabla();
    for (Banks banks : listBanks) {
        modeloTabla.addRow(new Object[]{
            banks.getId(),
            banks.getName(),
            banks.getLastName(),
            banks.getAmount()
        });
    }
}


    public void cargarTablaPedidoSeleccionado() {
    limpiarTabla();

    String selectedItem = (String) cmbBank.getSelectedItem();

    if ("Todos".equalsIgnoreCase(selectedItem)) {
        cargarTablaTodosPedidos(listBanks);
    } else {
        try {
            int idData = Integer.parseInt(selectedItem.split("-")[0].trim());
            Banks banks = new BankController().BuscarId(idData);

            if (banks != null) {
             
                
                modeloTabla.addRow(new Object[]{
                    banks.getId(),
                    banks.getName(),
                    banks.getLastName(),
                    banks.getAmount(),
                    
                });
            } else {
                JOptionPane.showMessageDialog(this, "Pedido no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error al procesar el ID del pedido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbBank = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBank = new javax.swing.JTable();
        btnUpDate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblBank.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identification Card", "Name", "Last Name", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tblBank);

        btnUpDate.setText("UpDate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpDate))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(cmbBank, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cmbBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnUpDate)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBank().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpDate;
    private javax.swing.JComboBox<String> cmbBank;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBank;
    // End of variables declaration//GEN-END:variables
}
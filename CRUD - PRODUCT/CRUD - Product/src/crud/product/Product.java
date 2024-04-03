
package crud.product;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    public Product() {
        initComponents();
       
        mostrarProduct();
    }
    
    
        public void mostrarProduct(){
        try{
            Conexion cn = new Conexion();
            
            Statement statement = cn.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Product");
            
            DefaultTableModel modelo = (DefaultTableModel)tblProducts.getModel();
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            String[] columns = {"ProductId", "ProductName", "SupplierId", "CategoryId", "QuantityPerUnit", "UnitPrice", "UnitsInStock", "UnitsOnOrder", "ReorderLevel","Discontinued"};
            
            for(String column: columns){
                modelo.addColumn(column);
            }
            
            while(resultSet.next()){
                String[] row = {
                    String.valueOf(resultSet.getInt("ProductId")),
                    resultSet.getString("ProductName"),
                    resultSet.getString("SupplierId"),
                    resultSet.getString("CategoryId"),
                    resultSet.getString("quantityPerUnit"),
                    resultSet.getString("UnitPrice"),
                    resultSet.getString("unitsInStock"),
                    resultSet.getString("unitsOnOrder"),
                    resultSet.getString("ReorderLevel"),
                    resultSet.getString("discontinued")
                };
                modelo.addRow(row);
        }
        tblProducts.setModel(modelo);
        } catch(SQLException e){
            e.printStackTrace();           
        }
    }

        
        public void eliminarProduct(){
        try{
            int id;
            id = Integer.parseInt(txtId.getText());        
            Conexion cn = new Conexion();
        
            PreparedStatement preparedStatement = cn.conectar().prepareStatement("DELETE FROM Product WHERE ProductId = ?");
            preparedStatement.setInt(1, id); 
        
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Delete row succesfull");
                mostrarProduct();
            } else {
                JOptionPane.showMessageDialog(null, "Delete row fail");
        }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
        
        public void insertarProduct(){
        try{
            int id = Integer.parseInt(txtId.getText());
            String product = txtProductName.getText();
            int supplier = Integer.parseInt(txtSupplier.getText());
            int category = Integer.parseInt(txtCategory.getText());
            String quantity = txtQuantity.getText();
            int unitprice = Integer.parseInt(txtUnitPrice.getText());
            String unitsinstock = txtStock.getText();
            String unitsinorder =  txtOnorde.getText();
            String reorder = txtReorder.getText();
            int discontinued = Integer.parseInt(txtDiscuntinued.getText());
            
            Conexion cn = new Conexion();
            
            PreparedStatement ps = 
                     cn.conectar().prepareStatement("INSERT INTO Product VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1,id);
            ps.setString(2,product);
            ps.setInt(3,supplier);
            ps.setInt(4,category);
            ps.setString(5,quantity);
            ps.setInt(6,unitprice);
            ps.setString(7,unitsinstock);
            ps.setString(8,unitsinorder);
            ps.setString(9,reorder);
            ps.setInt(10,discontinued);
             
            int rows = ps.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Insert row succesfull");
                mostrarProduct();
            } else {
                JOptionPane.showMessageDialog(null, "Insert row fail");
        } 
        } catch(SQLException e){
            e.printStackTrace();
}
    }
public void actualizarProduct() {
    try {
            int id = Integer.parseInt(txtId.getText());
            String product = txtProductName.getText();
            int supplier = Integer.parseInt(txtSupplier.getText());
            int category = Integer.parseInt(txtCategory.getText());
            String quantity = txtQuantity.getText();
            int unitprice = Integer.parseInt(txtUnitPrice.getText());
            String unitsinstock = txtStock.getText();
            String unitsinorder = txtOnorde.getText();
            String reorder = txtReorder.getText();
            int discontinued = Integer.parseInt(txtDiscuntinued.getText());
            
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
        
            PreparedStatement ps = 
                     cn.conectar().prepareStatement("UPDATE Product SET ProductName = ?, SupplierId = ?, CategoryId = ?, QuantityPerUnit = ?, UnitPrice = ?, UnitsInStock = ?, UnitsOnOrder = ?, ReorderLevel = ?, Discontinued = ? WHERE ProductId = ?");
        
            ps.setString(1,product);
            ps.setInt(2,supplier);
            ps.setInt(3,category);
            ps.setString(4,quantity);
            ps.setInt(5,unitprice);
            ps.setString(6,unitsinstock);
            ps.setString(7,unitsinorder);
            ps.setString(8,reorder);
            ps.setInt(9,discontinued);
            ps.setInt(10,id);
        
        int rows = ps.executeUpdate();
        
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Update row succesfull");
            mostrarProduct();
        } else {
            JOptionPane.showMessageDialog(null, "Update row succesfull");
        }
        
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
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

        btnInsertar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        txtSupplier = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btninsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        txtOnorde = new javax.swing.JTextField();
        txtReorder = new javax.swing.JTextField();
        txtDiscuntinued = new javax.swing.JTextField();

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Crud Product");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel2.setText("Id:");

        jLabel3.setText("ProductName:");

        jLabel4.setText("supplier Id:");

        jLabel5.setText("Category Id:");

        jLabel6.setText("quantityPerUnit:");

        jLabel7.setText("UnitPrice:");

        jLabel8.setText("UnitInStock:");

        jLabel9.setText("UnistOnOrder:");

        jLabel10.setText("ReorderLevel:");

        jLabel11.setText("Discuntinued:");

        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });

        txtSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierActionPerformed(evt);
            }
        });

        txtCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryActionPerformed(evt);
            }
        });

        txtUnitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitPriceActionPerformed(evt);
            }
        });

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        btninsertar.setText("Insertar");
        btninsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtOnorde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOnordeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(txtSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(txtCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                    .addComponent(txtQuantity)
                                    .addComponent(txtStock)
                                    .addComponent(txtOnorde)
                                    .addComponent(txtReorder)
                                    .addComponent(txtDiscuntinued)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btninsertar)
                                .addGap(41, 41, 41)
                                .addComponent(btnActualizar)
                                .addGap(53, 53, 53)
                                .addComponent(btnEliminar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtOnorde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtReorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDiscuntinued, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btninsertar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void txtSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierActionPerformed

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void txtUnitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitPriceActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizarProduct();
       
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btninsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarActionPerformed
        // TODO add your handling code here:
        insertarProduct();
        
    }//GEN-LAST:event_btninsertarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarProduct();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtOnordeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOnordeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOnordeActionPerformed

 
     private void tblProductMouseClicked(java.awt.event.MouseEvent evt){
        int columns = tblProducts.getSelectedColumn();
        int row = tblProducts.getSelectedRow();
        
        tblProducts.getModel().getValueAt(row, 1);
        tblProducts.getModel().getValueAt(row, 2);
        tblProducts.getModel().getValueAt(row, 3);
        tblProducts.getModel().getValueAt(row, 4);
        tblProducts.getModel().getValueAt(row, 5);
        tblProducts.getModel().getValueAt(row, 6);
        tblProducts.getModel().getValueAt(row, 7);
        tblProducts.getModel().getValueAt(row, 8);
        tblProducts.getModel().getValueAt(row, 9);
        tblProducts.getModel().getValueAt(row, 10);
        
        txtId.setText(String.valueOf(tblProducts.getModel().getValueAt(row, 0)));
        txtProductName.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 1)));
        txtSupplier.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 2)));
        txtCategory.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 3)));
        txtQuantity.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 4)));
        txtUnitPrice.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 5)));
        txtStock.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 6)));
        txtOnorde.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 7)));
        txtReorder.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 8)));
        txtDiscuntinued.setText(String.valueOf(tblProducts.getModel().getValueAt(row+1, 9)));
    }  
    
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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btninsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtDiscuntinued;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtOnorde;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReorder;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtSupplier;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}

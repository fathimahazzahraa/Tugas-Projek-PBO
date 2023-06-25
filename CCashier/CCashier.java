package CCashier;

import Com.Config.DatabaseConnection;
import Com.Config.MyConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CCashier extends javax.swing.JFrame {

    private Statement St;
    private Connection Con;
    private ResultSet Rs;
//    private String sql = "";
    private DefaultTableModel model;

    public void clear() {
        TextFieldNama.setText("");
        TextFieldHarga.setText("");
        TextFieldJumlah.setText("");
        TextFieldNama.requestFocus();
    }

    public void insertData() {
        DefaultTableModel model = (DefaultTableModel) TableCipa.getModel();
        int row = TableCipa.getRowCount();
        model.addRow(new Object[]{
            row += 1,
            TextFieldNama.getText(),
            TextFieldHarga.getText(),
            TextFieldJumlah.getText()
        });
    }

    public double hitungTotal() {
        DefaultTableModel model = (DefaultTableModel) TableCipa.getModel();
//        int[] selectedRows = TblBarang.getSelectedRows();
        int rowCount = model.getRowCount();
        double total = 0.0;

//        double total = 0.0;
//        for(int row : selectedRows){
//            double harga = Double.parseDouble(model.getValueAt(row, 2).toString());
//            int jumlah = Integer.parseInt(model.getValueAt(row, 3).toString());
//            total += harga*jumlah;
//        }
        for (int i = 0; i < rowCount; i++) {
            double harga = Double.parseDouble(model.getValueAt(i, 2).toString());
            int jumlah = Integer.parseInt(model.getValueAt(i, 3).toString());
            total += harga * jumlah;
        }
        return total;

    }

    public void Show() {
        MyConfig connect = new MyConfig();
        try {
            Con = connect.getConnect();
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM utils");
            int i = 1;
            while (Rs.next()) {
                String[] row = {Integer.toString(i), Rs.getString(2), Rs.getString(3), Rs.getString(4)};
                model.addRow(row);
                i++;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public CCashier() {
        initComponents();
        String[] header = {"ID", "NAMA", "HARGA", "STOK"};
        model = new DefaultTableModel(header, 0);
        TableCipa.setModel(model);
        Show();
//  KoneksiDatabase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ButtonNama = new javax.swing.JButton();
        ButtonHarga = new javax.swing.JButton();
        ButtonJumlah = new javax.swing.JButton();
        TextFieldNama = new javax.swing.JTextField();
        TextFieldHarga = new javax.swing.JTextField();
        TextFieldJumlah = new javax.swing.JTextField();
        ButtonTambah = new javax.swing.JButton();
        ButtonClear = new javax.swing.JButton();
        ButtonEdit = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        ButtonTotal = new javax.swing.JButton();
        ButtonUang = new javax.swing.JButton();
        ButtonKembalian = new javax.swing.JButton();
        TextFieldTotal = new javax.swing.JTextField();
        TextFieldUang = new javax.swing.JTextField();
        TextFieldKembalian = new javax.swing.JTextField();
        ButtonSimpan = new javax.swing.JButton();
        ButtonBayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCipa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("CCashier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(278, 278, 278))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        ButtonNama.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonNama.setText("Nama Barang");
        ButtonNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNamaActionPerformed(evt);
            }
        });

        ButtonHarga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonHarga.setText("Harga Barang");

        ButtonJumlah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonJumlah.setText("Jumlah Barang");

        TextFieldNama.setBackground(new java.awt.Color(204, 204, 204));

        TextFieldHarga.setBackground(new java.awt.Color(204, 204, 204));
        TextFieldHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldHargaActionPerformed(evt);
            }
        });

        TextFieldJumlah.setBackground(new java.awt.Color(204, 204, 204));

        ButtonTambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonTambah.setText("Tambah");
        ButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahActionPerformed(evt);
            }
        });

        ButtonClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonClear.setText("Clear");
        ButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonClearActionPerformed(evt);
            }
        });

        ButtonEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonEdit.setText("Edit");
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });

        ButtonDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonDelete.setText("Delete");
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        ButtonTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonTotal.setText("Total");

        ButtonUang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonUang.setText("Uang");

        ButtonKembalian.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonKembalian.setText("Kembalian");

        ButtonSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonSimpan.setText("Simpan");
        ButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSimpanActionPerformed(evt);
            }
        });

        ButtonBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButtonBayar.setText("Bayar");
        ButtonBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(ButtonTambah)
                        .addGap(170, 170, 170)
                        .addComponent(ButtonEdit)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ButtonTotal)
                                    .addComponent(ButtonUang)
                                    .addComponent(ButtonKembalian))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldTotal)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(ButtonClear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ButtonDelete)
                                        .addGap(31, 31, 31))
                                    .addComponent(TextFieldUang)
                                    .addComponent(TextFieldKembalian)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ButtonHarga)
                                    .addComponent(ButtonJumlah)
                                    .addComponent(ButtonNama))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TextFieldJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                                        .addComponent(TextFieldHarga))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ButtonSimpan)
                                .addGap(59, 59, 59)
                                .addComponent(ButtonBayar)
                                .addGap(55, 55, 55)))
                        .addGap(19, 19, 19))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonNama))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonHarga)
                    .addComponent(TextFieldHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonJumlah)
                    .addComponent(TextFieldJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonTambah)
                            .addComponent(ButtonEdit)
                            .addComponent(ButtonDelete))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonClear)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonTotal)
                    .addComponent(TextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonUang)
                    .addComponent(TextFieldUang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(ButtonKembalian))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(TextFieldKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSimpan)
                    .addComponent(ButtonBayar))
                .addGap(30, 30, 30))
        );

        TableCipa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Barang", "Harga Barang", "Jumlah Barang"
            }
        ));
        jScrollPane1.setViewportView(TableCipa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonNamaActionPerformed

    private void TextFieldHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldHargaActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        // TODO add your handling code here
         DefaultTableModel model = (DefaultTableModel) TableCipa.getModel();
        int rowSelect = TableCipa.getSelectedRow();
        
        if(ButtonEdit.getText()== "Edit"){
            ButtonNama.setEnabled(false);
            ButtonHarga.setEnabled(false);
            ButtonJumlah.setText("Update");
            
            TextFieldNama.setText(model.getValueAt(rowSelect, 1).toString());
            TextFieldHarga.setText(model.getValueAt(rowSelect, 2).toString());
            TextFieldJumlah.setText(model.getValueAt(rowSelect, 3).toString());
            
        }else {
            ButtonNama.setEnabled(true);
            ButtonHarga.setEnabled(true);
            ButtonJumlah.setText("Edit");
            
            String name = TextFieldNama.getText();
            String price = TextFieldHarga.getText();
            String stock = TextFieldJumlah.getText();
            
            model.setValueAt(name, rowSelect, 1);
            model.setValueAt(price, rowSelect, 2);
            model.setValueAt(stock, rowSelect, 3);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEditActionPerformed

    private void ButtonBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBayarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        double total = hitungTotal();
        TextFieldTotal.setText("Rp." + String.valueOf(total));
        
        try {
            String totalText = TextFieldTotal.getText().substring(3);
            double total1 = Double.parseDouble(totalText);
            double bayar = Double.parseDouble(TextFieldUang.getText());
            double kembali = bayar - total1;
            TextFieldKembalian.setText("Rp." + String.valueOf(kembali));
            
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Input tidak Valid");
        }
    }//GEN-LAST:event_ButtonBayarActionPerformed

    private void ButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSimpanActionPerformed
         // TODO add your handling code here:
        try{
           Connection Con = DriverManager.getConnection();
           
           int rowCount = TableCipa.getRowCount();
           for(int i = 0; i < rowCount; i++){
               String Column1 = TableCipa.getValueAt(i, 1).toString();
               String Column2 = TableCipa.getValueAt(i, 2).toString();
               String Column3 = TableCipa.getValueAt(i, 3).toString();
               
               String sql = "INSERT INTO muti_table (NAMA, HARGA, STOK) VALUES (?,?,?)";
               PreparedStatement statement = Con.prepareStatement(sql);
               
               statement.setString(1, Column1);
               statement.setString(2, Column2);
               statement.setString(3, Column3);
               
               statement.executeUpdate();
           }   
           
           JOptionPane.showMessageDialog(this, "Data berhasil disimpan ke database.");
           Con.close();
           
             }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data ke database.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonSimpanActionPerformed

    private void ButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahActionPerformed
        // TODO add your handling code here:
        if(TextFieldNama.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Barang Belum di Masukan");
        }else if(TextFieldHarga.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Harga Barang Belum di Masukan");
        }else if(TextFieldJumlah.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Jumlah Barang Belum di Masukan");
        }else{
            insertData();
            clear();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonTambahActionPerformed

    private void ButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonClearActionPerformed
        clear();        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonClearActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TableCipa.getModel();
        int rowSelect = TableCipa.getSelectedRow();
        
        if(rowSelect == -1){
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
          int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin menghapus data ini?", 
                  "Konfirmasi Pengahapusan Data",JOptionPane.YES_NO_OPTION);
          if(confirm == JOptionPane.YES_OPTION){
              model.removeRow(rowSelect);
          }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(CCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CCashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CCashier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBayar;
    private javax.swing.JButton ButtonClear;
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JButton ButtonHarga;
    private javax.swing.JButton ButtonJumlah;
    private javax.swing.JButton ButtonKembalian;
    private javax.swing.JButton ButtonNama;
    private javax.swing.JButton ButtonSimpan;
    private javax.swing.JButton ButtonTambah;
    private javax.swing.JButton ButtonTotal;
    private javax.swing.JButton ButtonUang;
    private javax.swing.JTable TableCipa;
    private javax.swing.JTextField TextFieldHarga;
    private javax.swing.JTextField TextFieldJumlah;
    private javax.swing.JTextField TextFieldKembalian;
    private javax.swing.JTextField TextFieldNama;
    private javax.swing.JTextField TextFieldTotal;
    private javax.swing.JTextField TextFieldUang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

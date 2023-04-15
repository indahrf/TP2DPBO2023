/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tp2_dpbo;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author indah
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private Boolean isUpdate = false;    
    
    public Home(int id_akun) {
        initComponents();
        setPanel(id_akun);
    }
    
    public void setTextLabel(String name){
        labelTest.setText(name);
    }
    
    public void setPanel(int id_akun) {
        fieldId_akun.setText(Integer.toString(id_akun));
        fieldId.setVisible(false);
        fieldId_akun.setVisible(false);
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(0, 1));
        try{
            String sql = "SELECT * FROM playlist WHERE id_akun = '"+id_akun+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.executeQuery();
            ResultSet res = pst.getResultSet();

            
            while(res.next()){
                mainPanel.add(new Card(Integer.parseInt(res.getString("id")), res.getString("judul"), res.getString("penyanyi"), Integer.parseInt(res.getString("id_akun")), res.getString("image")));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
       
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public void setPanel2(int id, String judul, String penyanyi, int id_akun, String path) {
        this.isUpdate = true;
        fieldId.setText(Integer.toString(id));
        fieldJudul.setText(judul);
        fieldPenyanyi.setText(penyanyi);
        fieldId_akun.setText(Integer.toString(id_akun));
        fieldId.setVisible(false);
        fieldId_akun.setVisible(false);
        fieldFoto.setText(path);
        
        
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(0, 1));
        try{
            String sql = "SELECT * FROM playlist WHERE id_akun = '"+id_akun+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.executeQuery();
            ResultSet res = pst.getResultSet();
            while(res.next()){
                mainPanel.add(new Card(id, res.getString("judul"), res.getString("penyanyi"), id_akun, res.getString("image")));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
       
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public void insertData(int id_akun) {
        
        String judul = fieldJudul.getText();
        String penyanyi = fieldPenyanyi.getText();
        String foto = fieldFoto.getText();
        
        int cek = 0;
        try{
            if(judul.isEmpty() || penyanyi.isEmpty()){
                JOptionPane.showMessageDialog(null, "Data belum lengkap!");
            }else{
                try{
                    String sql = "SELECT * FROM playlist WHERE id_akun = '"+id_akun+"'";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    pst.executeQuery();
                    ResultSet res = pst.getResultSet();
                    while(res.next()){
                        if(judul.equals(res.getString("judul")))
                        {
                            cek = 1;
                        }
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
                if(cek == 0){
                    String sql = "INSERT INTO playlist (judul, penyanyi, image, id_akun) VALUES ('"+judul+"','"+penyanyi+"','"+foto+"', '"+id_akun+"')";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    pst.execute();
                    setPanel(id_akun);
                    JOptionPane.showMessageDialog(null, "Add data Berhasil");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Judul pada data yang anda input tidak sudah ada");
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void updateData() {
        // Get Data from Form
        String judul = fieldJudul.getText();
        String penyanyi = fieldPenyanyi.getText();
        int id = Integer.parseInt(fieldId.getText());
        int id_akun = Integer.parseInt(fieldId_akun.getText());
//        String deskripsi = fieldDeskripsi.getText();
        try{
            if(judul.isEmpty() || penyanyi.isEmpty()){
                JOptionPane.showMessageDialog(null, "Data belum lengkap!");
            }else{
                
                String sql = "UPDATE playlist SET judul = '"+judul+"', penyanyi = '"+penyanyi+"' WHERE id= '"+id+"' AND id_akun= '"+id_akun+"'";
                java.sql.Connection conn=(Connection)Config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();
                setPanel(id_akun);
                resetForm();
                // Show Information
                System.out.println("Update Success!");
                JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Nama tidak bisa diubah");
        }    
    }
    
    public void resetForm() {
        // Set All Value Form to Empty
        fieldJudul.setText("");
        fieldPenyanyi.setText("");
        fieldId.setText("");
        fieldFoto.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTest = new javax.swing.JLabel();
        lblNim = new javax.swing.JLabel();
        fieldJudul = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        fieldPenyanyi = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        fieldId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        fieldId_akun = new javax.swing.JTextField();
        lblNama1 = new javax.swing.JLabel();
        fieldFoto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(174, 194, 182));

        labelTest.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        labelTest.setText("PLAYLIST MUSIC");

        lblNim.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNim.setForeground(new java.awt.Color(255, 255, 255));
        lblNim.setText("Judul");

        fieldJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldJudulActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        fieldPenyanyi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPenyanyiActionPerformed(evt);
            }
        });

        lblNama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Penyanyi");

        btnCancel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        fieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(174, 194, 182));

        mainPanel.setBackground(new java.awt.Color(174, 194, 182));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainPanel);

        fieldId_akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldId_akunActionPerformed(evt);
            }
        });

        lblNama1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lblNama1.setForeground(new java.awt.Color(255, 255, 255));
        lblNama1.setText("Foto");

        fieldFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNama)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fieldPenyanyi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNim)
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldId_akun, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNama1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fieldFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(labelTest)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(labelTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(fieldId_akun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldPenyanyi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNama1)
                            .addComponent(fieldFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnAdd)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldJudulActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        // If Add (data not clicked)
        if(isUpdate == false)
        {
            int id_akun = Integer.parseInt(fieldId_akun.getText());
            insertData(id_akun);
            resetForm();
        }else{
            updateData();
            btnAdd.setText("Add");
            this.isUpdate = false;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void fieldPenyanyiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPenyanyiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPenyanyiActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        // Cancel Input Form
        btnAdd.setText("Add");
//        btnDelete.setVisible(false);
        this.isUpdate = false;
        
        // Reset Form
        resetForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void fieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdActionPerformed
        // TODO add your handling code here:
        fieldId.setVisible(false);
    }//GEN-LAST:event_fieldIdActionPerformed

    private void fieldId_akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldId_akunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldId_akunActionPerformed

    private void fieldFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFotoActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
//                int id_akun = Integer.parseInt(fieldId_akun.getText());
                new Home(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JTextField fieldFoto;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldId_akun;
    private javax.swing.JTextField fieldJudul;
    private javax.swing.JTextField fieldPenyanyi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTest;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNama1;
    private javax.swing.JLabel lblNim;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}

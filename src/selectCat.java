/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Qureshi Home
 */
import java.awt.event.*;
import java.sql.*;
public class selectCat extends javax.swing.JFrame implements ActionListener {
ResultSet rs=null;
ResultSet bs=null;
variable v= new variable();
    /**
     * Creates new form selectCat
     */
public selectCat() {
        initComponents();
        ComboCheck();
}
    public selectCat(variable v) {
        initComponents();
        ComboCheck();
        this.v=v;
        
        
    }
    void ComboCheck(){
        DAO d = new DAO();
        rs=d.getCat();bs=d.getCat();
        
        try{
           while(rs.next()){
               cat_name1.addItem(rs.getString(2).toString());
               cat_name2.addItem(rs.getString(2).toString());
               cat_name3.addItem(rs.getString(2).toString());
        } 
        }catch(Exception ex){
            
        }
         cat_name2.removeItem(cat_name1.getModel().getSelectedItem());
         cat_name3.removeItem(cat_name1.getModel().getSelectedItem());
         cat_name3.removeItem(cat_name2.getModel().getSelectedItem());
         cat_name2.removeItem(cat_name3.getModel().getSelectedItem());
        cat_name1.addActionListener(this);
        cat_name2.addActionListener(this);
        cat_name3.addActionListener(this);
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
        x4 = new javax.swing.JLabel();
        minimize2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cat_name1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cat_name2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cat_name3 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        x4.setBackground(new java.awt.Color(153, 0, 0));
        x4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        x4.setForeground(new java.awt.Color(255, 255, 255));
        x4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x4.setText("X");
        x4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        x4.setOpaque(true);
        x4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                x4MouseClicked(evt);
            }
        });

        minimize2.setBackground(new java.awt.Color(0, 0, 0));
        minimize2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        minimize2.setForeground(new java.awt.Color(255, 255, 255));
        minimize2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize2.setText("_");
        minimize2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        minimize2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        minimize2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimize2.setOpaque(true);
        minimize2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize2MouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Category 1");

        cat_name1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Category 2");

        cat_name2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Category 3");

        cat_name3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Courses");

        jButton1.setText("Start Paper");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(minimize2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cat_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cat_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cat_name3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(x4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimize2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cat_name2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cat_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cat_name3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void x4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_x4MouseClicked
        //this.dispose;
        System.exit(0);
    }//GEN-LAST:event_x4MouseClicked

    private void minimize2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize2MouseClicked
        this.setState(javax.swing.JFrame.ICONIFIED);
    }//GEN-LAST:event_minimize2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      v.cat_name1=cat_name1.getModel().getSelectedItem().toString();
      v.cat_name2=cat_name2.getModel().getSelectedItem().toString();
      v.cat_name3=cat_name3.getModel().getSelectedItem().toString();
      DAO d=new DAO();
      d.checkPaper(v.cat_name1);
      d.checkPaper(v.cat_name2);
      d.checkPaper(v.cat_name3);
      rs=d.pickPaper(v);
      if(rs!=null){
      QuestionPaper q =new QuestionPaper(v,rs);
      q.setVisible(true);
      }
      
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(selectCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selectCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selectCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectCat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selectCat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cat_name1;
    private javax.swing.JComboBox<String> cat_name2;
    private javax.swing.JComboBox<String> cat_name3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minimize2;
    private javax.swing.JLabel x4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        
     if(ae.getSource()==cat_name1){
        try{
            rs.beforeFirst();
            cat_name2.removeAllItems();
           while(rs.next()){
               cat_name2.addItem(rs.getString(2).toString());
        } 
        }catch(Exception ex){
            
        }
         cat_name2.removeItem(cat_name1.getModel().getSelectedItem());
         cat_name3.removeItem(cat_name1.getModel().getSelectedItem());
         cat_name3.removeItem(cat_name2.getModel().getSelectedItem());
         cat_name2.removeItem(cat_name3.getModel().getSelectedItem());
     }else if(ae.getSource()==cat_name2){
         try{
            bs.beforeFirst();
            cat_name3.removeAllItems();
           while(bs.next()){
               cat_name3.addItem(bs.getString(2).toString());
        } 
        }catch(Exception ex){
            
        }
        cat_name3.removeItem(cat_name2.getModel().getSelectedItem());
        cat_name3.removeItem(cat_name1.getModel().getSelectedItem());
     }
     
     
    }
     
    
}

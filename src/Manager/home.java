package Manager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class home extends javax.swing.JFrame {
DefaultTableModel tmodel;
Statement st;
ResultSet rs;
Connection con;
ConnectForm conn=new ConnectForm();
int index=0;
static int newName;
public static String tableName="";

public void connect(){
    try
    {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+conn.db+"","root","");
    } catch (SQLException ex) 
    {
        JOptionPane.showMessageDialog(this,"Connection failed :"+ex.getMessage());
    }
    
    }
    public home() {
        
        initComponents();
        connect();
    try {
        st=con.createStatement();
        String qry="show tables";
        rs=st.executeQuery(qry);
        
        while(rs.next()){
            tmodel=(DefaultTableModel)tablesList.getModel();
            tablesList.setModel(tmodel);
            Object obj[]={index,rs.getString(1)};
            tmodel.addRow(obj);
            index++;
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"Failed to retrieve tables "+ex.getMessage());
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hometab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablesList = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        optionTable = new javax.swing.JTextField();
        viewRecords = new javax.swing.JButton();
        truncateTable = new javax.swing.JButton();
        dropTable = new javax.swing.JButton();
        createNew = new javax.swing.JButton();
        descTable = new javax.swing.JButton();
        refreshbtn = new javax.swing.JToggleButton();
        logoutbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        setResizable(false);

        hometab.setPreferredSize(new java.awt.Dimension(400, 257));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Easy Mysql");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("This is a software application that makes the managment and manipulation\nof mysql database components easy.\nThe Tab TABLES contains all information about the database u just\nconnected the application to.\nENJOY Easy Mysql");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        hometab.addTab("HOME", jPanel2);

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        titleLabel.setText("Welcome To your Database");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Tables:");

        tablesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Indexes", "Table Names"
            }
        ));
        jScrollPane2.setViewportView(tablesList);

        jLabel2.setText("Type name of table:");

        optionTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionTableActionPerformed(evt);
            }
        });

        viewRecords.setText("View Record");
        viewRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRecordsActionPerformed(evt);
            }
        });

        truncateTable.setText("Truncate ");
        truncateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                truncateTableActionPerformed(evt);
            }
        });

        dropTable.setText("Drop");
        dropTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropTableActionPerformed(evt);
            }
        });

        createNew.setText("Create Table");
        createNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewActionPerformed(evt);
            }
        });

        descTable.setText("Desc Table");
        descTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descTableActionPerformed(evt);
            }
        });

        refreshbtn.setText("Refresh");
        refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbtnActionPerformed(evt);
            }
        });

        logoutbtn.setText("Log Out");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(504, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(logoutbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshbtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dropTable, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createNew, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(descTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(viewRecords, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(optionTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                    .addComponent(truncateTable))))
                        .addGap(36, 36, 36))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addGap(196, 196, 196))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(optionTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewRecords)
                            .addComponent(descTable))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(truncateTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dropTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createNew, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(refreshbtn)
                            .addComponent(logoutbtn))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        hometab.addTab("TABLES", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hometab, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hometab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewActionPerformed

        createTables create=new createTables();
        create.show();
        
        
    }//GEN-LAST:event_createNewActionPerformed

    private void viewRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRecordsActionPerformed
        connect();
        tableName= optionTable.getText();
        if(tableName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Table name can't be empty");
        }
        else{
        
        try{
            viewTable view=new viewTable();
            view.show();

        }catch(Exception e){
            JOptionPane.showMessageDialog(this," Someting went Wonrg: " +e);
        }
        }
    }//GEN-LAST:event_viewRecordsActionPerformed

    private void optionTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_optionTableActionPerformed

    private void descTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descTableActionPerformed
        connect();

        tableName= optionTable.getText();
        if(tableName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Table name can't be empty");
        }
        else{
            try{
                descTable desc=new descTable();
                desc.show();

            }catch(Exception e){
                JOptionPane.showMessageDialog(this," Someting went Wonrg: " +e);
                
            }
        }
    }//GEN-LAST:event_descTableActionPerformed

    private void truncateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_truncateTableActionPerformed
        connect();
        tableName= optionTable.getText();
        if(tableName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Table name can't be empty");
        }
        else{
        try{
            st=con.createStatement();
            String qry02="truncate "+tableName+"";
            st.executeUpdate(qry02);
            JOptionPane.showMessageDialog(this,"Table "+tableName+" truncated");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"Truncate failed" +ex);
        }
        }
    }//GEN-LAST:event_truncateTableActionPerformed

    private void dropTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropTableActionPerformed
        connect();
        tableName= optionTable.getText();
        if(tableName.isEmpty()){
            JOptionPane.showMessageDialog(this, "Table name can't be empty");
        }
        else{
        try{
            st=con.createStatement();
            String qry03="drop table "+tableName+"";
            st.executeUpdate(qry03);
            JOptionPane.showMessageDialog(this,"Table "+tableName+" Dropped");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this,"Drop Failed" +ex);
        }
        }
    }//GEN-LAST:event_dropTableActionPerformed

    private void refreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshbtnActionPerformed
        connect();
        tmodel.setRowCount(0);
        try {
        st=con.createStatement();
        String qry004="show tables";
        rs=st.executeQuery(qry004);
        index=0;
        while(rs.next()){
            tmodel=(DefaultTableModel)tablesList.getModel();
            tablesList.setModel(tmodel);
            Object obj[]={index,rs.getString(1)};
            tmodel.addRow(obj);
            index++;
        }
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,"Failed to retrieve tables "+ex.getMessage());
    }
    }//GEN-LAST:event_refreshbtnActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        ConnectForm conn=new ConnectForm();
        conn.show();
        dispose();
    }//GEN-LAST:event_logoutbtnActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createNew;
    private javax.swing.JButton descTable;
    private javax.swing.JButton dropTable;
    private javax.swing.JTabbedPane hometab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextField optionTable;
    private javax.swing.JToggleButton refreshbtn;
    private javax.swing.JTable tablesList;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton truncateTable;
    private javax.swing.JButton viewRecords;
    // End of variables declaration//GEN-END:variables
}

package Manager;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class viewTable extends javax.swing.JFrame {
public int numCols;
Connection con;
ConnectForm conn=new ConnectForm();
home home=new home();
Statement stmt;
ResultSetMetaData md;
ResultSet rs;

private JTable viewTable;
    public viewTable() {
        try {
            initComponents();
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+conn.db+"","root","");
           
            viewPanel.setLayout(new BorderLayout());
            Vector data = getDataFromDatabase();

            // Create the JTable
            viewTable = new JTable(data, getColumnNames());

            // Add the JTable to the JPanel
            JScrollPane scrollPane = new JScrollPane(viewTable);
            viewPanel.add(scrollPane, BorderLayout.CENTER);

            // Add the JPanel to the JFrame
            getContentPane().add(viewPanel);
            
            viewPanel.setVisible(true);
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(this,"Need To connect "+ex);
        }
    }
       private Vector getDataFromDatabase() {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        try {
           
            // Connect to the database
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+conn.db+"","root","");
            stmt =con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM "+home.tableName+"");

                // Get the metadata for the result set
            md = rs.getMetaData();
            numCols = md.getColumnCount();

            while (rs.next()) {
                Vector<Object> row = new Vector<Object>();

                for (int i = 1; i <= numCols; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
            }

            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return data;
    }
       private Vector<String> getColumnNames() {
        Vector<String> columnNames = new Vector<String>();

        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+conn.db+"","root","");
            stmt =con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM "+home.tableName+"");

                // Get the metadata for the result set
            md = rs.getMetaData();
            numCols = md.getColumnCount();

            // Loop through the columns and add each column name to the Vector
            for (int i = 1; i <= numCols; i++) {
                String columnName = md.getColumnName(i);
                columnNames.add(columnName);
            }

            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return columnNames;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        setResizable(false);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TABLE CONTENTS");

        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addContainerGap(320, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backbtn))
                .addGap(39, 39, 39)
                .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        dispose();
    }//GEN-LAST:event_backbtnActionPerformed

   
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
            java.util.logging.Logger.getLogger(viewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}

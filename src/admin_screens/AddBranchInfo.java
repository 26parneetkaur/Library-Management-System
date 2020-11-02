/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_screens;

import javax.swing.JOptionPane;
import model.dao.BranchinfoDAO;
import model_to.BranchinfoTO;
import model_to.StudentinfoTO;
import utility.Validations;

/**
 *
 * @author HP
 */
public class AddBranchInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddBranchInfo
     */
    public AddBranchInfo() {
        initComponents();
    }

    public AddBranchInfo(BranchinfoTO record) {
        this();
        if (record != null) {

            jtfbranchid.setText(record.getBranchid());
            jtfbranchname.setText(record.getBranchname());
            String maximumissue = (String.valueOf(record.getMaximumissue()));
            itfmaximumissue.setText(maximumissue);
            btn_addbranchinfo.setText("update branch details");
            setTitle("update branch details");
            jtfbranchid.setVisible(true);
            jtfbranchid.setEditable(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmi_branchid = new javax.swing.JLabel();
        jmi_branchname = new javax.swing.JLabel();
        jmi_maximumissue = new javax.swing.JLabel();
        jtfbranchid = new javax.swing.JTextField();
        jtfbranchname = new javax.swing.JTextField();
        btn_addbranchinfo = new javax.swing.JButton();
        itfmaximumissue = new controls.IntTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add Branch Info");
        setPreferredSize(new java.awt.Dimension(638, 504));
        getContentPane().setLayout(null);

        jmi_branchid.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jmi_branchid.setForeground(new java.awt.Color(255, 255, 255));
        jmi_branchid.setText("branch id:");
        getContentPane().add(jmi_branchid);
        jmi_branchid.setBounds(100, 102, 140, 22);

        jmi_branchname.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jmi_branchname.setForeground(new java.awt.Color(255, 255, 255));
        jmi_branchname.setText("branch name:");
        getContentPane().add(jmi_branchname);
        jmi_branchname.setBounds(100, 185, 140, 22);

        jmi_maximumissue.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jmi_maximumissue.setForeground(new java.awt.Color(255, 255, 255));
        jmi_maximumissue.setText("maximum issue:");
        getContentPane().add(jmi_maximumissue);
        jmi_maximumissue.setBounds(100, 271, 140, 22);

        jtfbranchid.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        getContentPane().add(jtfbranchid);
        jtfbranchid.setBounds(301, 99, 288, 28);

        jtfbranchname.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        getContentPane().add(jtfbranchname);
        jtfbranchname.setBounds(301, 182, 288, 28);

        btn_addbranchinfo.setBackground(new java.awt.Color(153, 153, 0));
        btn_addbranchinfo.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btn_addbranchinfo.setText("add branchinfo");
        btn_addbranchinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addbranchinfoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addbranchinfo);
        btn_addbranchinfo.setBounds(177, 345, 276, 62);

        itfmaximumissue.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        getContentPane().add(itfmaximumissue);
        itfmaximumissue.setBounds(301, 268, 288, 28);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/d.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addbranchinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addbranchinfoActionPerformed
        String message = "";
        // maximumissue=4;
        boolean allvalid = true;
        String branchid = jtfbranchid.getText().trim();
        String branchname = jtfbranchname.getText().trim();
        if (Validations.isEmpty(branchid) || Validations.isEmpty(branchname)) {
            message = "please fill all the boxes";
        }
        String maximumissue = itfmaximumissue.getText().trim();
        if (Validations.isEmpty(maximumissue)) {
            message += "please enter maximum issue";
            allvalid = false;
        } else if (Validations.isInteger(maximumissue)) {
            int q = Integer.parseInt(maximumissue);
            if (q > 4) {
                message += "only 4 books are allowed to be issued";
                allvalid = false;
            }
        } else {
            message += "please enter value less than 4";
        }
        if (allvalid) {
            BranchinfoTO record = new BranchinfoTO();
            record.setBranchid(branchid);
            record.setBranchname(branchname);
            record.setMaximumissue(Integer.parseInt(maximumissue));
            BranchinfoDAO action = new BranchinfoDAO();
            if (btn_addbranchinfo.getText().contains("add")) {
                if (action.insertRecord(record)) {
                    message = "new branchinfo is saved in system database";
                } else {
                    message = "insertion failure:" + action.getError_message();
                }
                JOptionPane.showMessageDialog(this, message);
            }
            if (btn_addbranchinfo.getText().contains("update")) {
                if (action.updateRecord(record)) {
                    message = "new branchinfo is updated in system database";
                } else {
                    message = "updation failure:" + action.getError_message();
                }
                JOptionPane.showMessageDialog(this, message);

            }

    }//GEN-LAST:event_btn_addbranchinfoActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addbranchinfo;
    private controls.IntTextField itfmaximumissue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jmi_branchid;
    private javax.swing.JLabel jmi_branchname;
    private javax.swing.JLabel jmi_maximumissue;
    private javax.swing.JTextField jtfbranchid;
    private javax.swing.JTextField jtfbranchname;
    // End of variables declaration//GEN-END:variables
}

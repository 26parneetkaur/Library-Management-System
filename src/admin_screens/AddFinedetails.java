/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_screens;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.dao.BookinfoDAO;
import model.dao.BranchinfoDAO;
import model.dao.DataConnection;
import model.dao.IssuedetailsDAO;
import model.dao.StudentinfoDAO;
import model_to.BookinfoTO;
import model_to.BranchinfoTO;
import model_to.IssuedetailsTO;
import model_to.StudentinfoTO;
import utility.Operations;
import utility.Validations;

public class AddFinedetails extends javax.swing.JInternalFrame {

    private List<IssuedetailsTO> students;
    private int selected_row;
    private List<StudentinfoTO> student;
    StudentinfoDAO action = new StudentinfoDAO();
    StudentinfoTO record = new StudentinfoTO();
    IssuedetailsDAO actions = new IssuedetailsDAO();
    IssuedetailsTO rec = new IssuedetailsTO();

    public AddFinedetails() {
        initComponents();
        bindCombo();
        bindTableIssuedetails();

        selected_row = -1;
    }

    private void bindCombo() {
        jcbstudentid.removeAllItems();
        jcbstudentid.addItem("CHOOSE STUDENT");
        student = action.getAllRecord();

        for (StudentinfoTO st : student) {
            jcbstudentid.addItem(st);
        }
    }

    private void bindTableIssuedetails() {
        String[] col_names = {"BookID", "StudentID", "Totalfine"
        };
        Object[][] records = null;
        int stid = record.getStudentid();
        System.out.println(stid);

        students = new IssuedetailsDAO().getRecord(stid);
        // students=new StudentinfoDAO().getAllRecord();
        if (students != null && students.size() > 0) {
            records = new Object[students.size()][col_names.length];
            int index = 0;
            for (IssuedetailsTO st : students) {

                records[index] = new Object[]{st.getBookid(),
                    st.getStudentid(), st.getFineamount()
                };
                index++;
            }

        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Information Present",
                "No Information Present", "No Information Present"
            };

        }

        DefaultTableModel model = new DefaultTableModel(records, col_names);
        tblfinedetails.setModel(model);
    }

    /*   private void show_details() {
        IssuedetailsTO detail = new IssuedetailsTO();
        detail = students.get(selected_row);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String a = df.format(detail.getReturndate());

        System.out.println(a);
        java.util.Date dd = new java.util.Date();
        String s = df.format(dd);
        try {
            java.util.Date returndate = df.parse(a);
            java.util.Date todaydate = df.parse(s);
            if (todaydate.getTime() > returndate.getTime()) {
                long diff = todaydate.getTime()- returndate.getTime();
                long days = TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
               // label3.setText(String.valueOf(days));
                long fine=days*2; 
              //  label.setText(String.valueOf(fine));
            } else {
              //  label3.setText( " No Late Days ");
            }
            //int stid=detail.getStudentid();
            //long fine=String.valueOf(days)*2;
            
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblfine_id = new javax.swing.JLabel();
        jcbstudentid = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblfinedetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Fine details");
        setMinimumSize(new java.awt.Dimension(113, 34));
        setPreferredSize(new java.awt.Dimension(638, 504));
        getContentPane().setLayout(null);

        lblfine_id.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lblfine_id.setForeground(new java.awt.Color(255, 255, 255));
        lblfine_id.setText("Student ID:");
        getContentPane().add(lblfine_id);
        lblfine_id.setBounds(117, 76, 110, 22);

        jcbstudentid.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        jcbstudentid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbstudentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbstudentidActionPerformed(evt);
            }
        });
        getContentPane().add(jcbstudentid);
        jcbstudentid.setBounds(267, 77, 303, 28);

        tblfinedetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblfinedetails);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 140, 549, 246);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/d.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 690, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbstudentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbstudentidActionPerformed
        if (jcbstudentid.getSelectedIndex() > 0) {
            record = (StudentinfoTO) jcbstudentid.getSelectedItem();

            bindTableIssuedetails();
            // show_details();
        }

    }//GEN-LAST:event_jcbstudentidActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<java.lang.Object> jcbstudentid;
    private javax.swing.JLabel lblfine_id;
    private javax.swing.JTable tblfinedetails;
    // End of variables declaration//GEN-END:variables
}

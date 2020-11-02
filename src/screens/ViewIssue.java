/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;
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

public class ViewIssue extends javax.swing.JInternalFrame {
         private List<IssuedetailsTO> students;
      private int selected_row;
    private List<StudentinfoTO> student;
    StudentinfoDAO action = new StudentinfoDAO();
    StudentinfoTO record = new StudentinfoTO();
    IssuedetailsDAO actions = new IssuedetailsDAO();
    IssuedetailsTO rec = new IssuedetailsTO();
    public ViewIssue() {
        initComponents();
        setSize(714,514);
         bindCombo();
        bindTableIssuedetails();

        selected_row = -1;
    }
          private void bindCombo() {
        jcbstudent.removeAllItems();
        jcbstudent.addItem("CHOOSE STUDENT");
        student = action.getAllRecord();

        for (StudentinfoTO st : student) {
            jcbstudent.addItem(st);
        }
    }
        private void bindTableIssuedetails() {
        String[] col_names = {"BookID","Issuedate","No of days","StudentID"
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
                records[index] = new Object[]{st.getBookid(),st.getIssuedate(),st.getNoofdays(),
                    st.getStudentid()
                };
                index++;
            }

        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Information Present", 
                "No Information Present", "No Information Present","No Information Present"
            };

        }

        DefaultTableModel model = new DefaultTableModel(records, col_names);
        tblissues.setModel(model);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblstudent = new javax.swing.JLabel();
        jcbstudent = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblissues = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Issue Details");
        getContentPane().setLayout(null);

        lblstudent.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        lblstudent.setText("Student id:");
        getContentPane().add(lblstudent);
        lblstudent.setBounds(101, 78, 113, 22);

        jcbstudent.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        jcbstudent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbstudentActionPerformed(evt);
            }
        });
        getContentPane().add(jcbstudent);
        jcbstudent.setBounds(259, 75, 297, 28);

        tblissues.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        tblissues.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblissues);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(53, 148, 574, 296);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pankaj.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbstudentActionPerformed
       if (jcbstudent.getSelectedIndex() > 0) {
            record = (StudentinfoTO) jcbstudent.getSelectedItem();

            bindTableIssuedetails();
        }
    }//GEN-LAST:event_jcbstudentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<java.lang.Object> jcbstudent;
    private javax.swing.JLabel lblstudent;
    private javax.swing.JTable tblissues;
    // End of variables declaration//GEN-END:variables
}

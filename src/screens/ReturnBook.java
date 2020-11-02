/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import admin_screens.AddBookinfo;
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

public class ReturnBook extends javax.swing.JInternalFrame {

    private List<IssuedetailsTO> students;
    private JPopupMenu popup;

    private int selected_row;
    private List<StudentinfoTO> student;
    StudentinfoDAO action = new StudentinfoDAO();
    StudentinfoTO record = new StudentinfoTO();
    IssuedetailsDAO actions = new IssuedetailsDAO();
    IssuedetailsTO rec = new IssuedetailsTO();

    public ReturnBook() {
        initComponents();
        setSize(620,575);
        preparePopupMenu();
        bindCombo();
        bindTableIssuedetails();

        selected_row = -1;
    }

    private void preparePopupMenu() {
        popup = new JPopupMenu();
        Font newfont = new Font("Consolas", Font.BOLD, 24);
        ImageIcon edit_icon = new ImageIcon(getClass().getResource("/icons/edit.png"));
        JMenuItem delete_item = new JMenuItem("Calculate Fine");
        //delete_item.setFont(newfont);
        // popup.add(delete_item);
        delete_item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // return_book();
            }
        });
    }
    int issueid;

    /*  public void return_book() {
        if (selected_row != -1 && students != null && selected_row < students.size()) {
            int result = JOptionPane.showConfirmDialog(this, "are you sure to return book?", "suggestions from system", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                IssuedetailsTO bt = students.get(selected_row);
                IssuedetailsDAO action = new IssuedetailsDAO();
                String message = "";
                if (action.deleteRecord(bt.getBookid())) {
                    message = "book is returned";
                    bindTableIssuedetails();
                } else {
                    message = "failure due to" + action.getError_message();
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        selected_row = -1;
    }*/
    private void bindCombo() {
        jcbstudentid.removeAllItems();
        jcbstudentid.addItem("CHOOSE STUDENT");
        student = action.getAllRecord();

        for (StudentinfoTO st : student) {
            jcbstudentid.addItem(st);
        }
    }

    private void bindTableIssuedetails() {
        String[] col_names = {"BookID", "IssueDate", "NoOfDays", "StudentID"
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
                    st.getIssuedate(), st.getNoofdays(), st.getStudentid()
                };
                index++;
            }

        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Information Present", "No Information Present",
                "No Information Present", "No Information Present"
            };

        }

        DefaultTableModel model = new DefaultTableModel(records, col_names);
        tblissuedetails.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblstudentid = new javax.swing.JLabel();
        jcbstudentid = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblissuedetails = new javax.swing.JTable();
        lblreturndate = new javax.swing.JLabel();
        lbl_todaysdate = new javax.swing.JLabel();
        lbllatedays = new javax.swing.JLabel();
        lbltotalfine = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        btreturnbook = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Return Book");
        getContentPane().setLayout(null);

        lblstudentid.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        lblstudentid.setText("StudentID");
        getContentPane().add(lblstudentid);
        lblstudentid.setBounds(62, 41, 112, 28);

        jcbstudentid.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        jcbstudentid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbstudentid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbstudentidMouseClicked(evt);
            }
        });
        jcbstudentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbstudentidActionPerformed(evt);
            }
        });
        getContentPane().add(jcbstudentid);
        jcbstudentid.setBounds(178, 41, 349, 28);

        tblissuedetails.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        tblissuedetails.setModel(new javax.swing.table.DefaultTableModel(
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
        tblissuedetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblissuedetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblissuedetails);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(75, 96, 452, 136);

        lblreturndate.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        lblreturndate.setText("Estimated Return Date");
        getContentPane().add(lblreturndate);
        lblreturndate.setBounds(35, 271, 193, 22);

        lbl_todaysdate.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        lbl_todaysdate.setText("Todays date");
        getContentPane().add(lbl_todaysdate);
        lbl_todaysdate.setBounds(66, 335, 104, 22);

        lbllatedays.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        lbllatedays.setText("Late Days");
        getContentPane().add(lbllatedays);
        lbllatedays.setBounds(66, 390, 82, 22);

        lbltotalfine.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        lbltotalfine.setText("Total fine");
        getContentPane().add(lbltotalfine);
        lbltotalfine.setBounds(64, 447, 84, 22);

        jLabel1.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(316, 265, 0, 0);

        label.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        label.setText("null");
        getContentPane().add(label);
        label.setBounds(285, 447, 278, 22);

        label1.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        label1.setText("null");
        getContentPane().add(label1);
        label1.setBounds(285, 271, 272, 23);

        label2.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        label2.setText("null");
        getContentPane().add(label2);
        label2.setBounds(285, 333, 272, 27);

        label3.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        label3.setText("null");
        getContentPane().add(label3);
        label3.setBounds(285, 389, 272, 24);

        btreturnbook.setFont(new java.awt.Font("Gisha", 1, 18)); // NOI18N
        btreturnbook.setText("return book");
        btreturnbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btreturnbookActionPerformed(evt);
            }
        });
        getContentPane().add(btreturnbook);
        btreturnbook.setBounds(191, 487, 182, 32);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pankaj.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 600, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbstudentidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbstudentidMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbstudentidMouseClicked

    private void jcbstudentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbstudentidActionPerformed
        if (jcbstudentid.getSelectedIndex() > 0) {
            record = (StudentinfoTO) jcbstudentid.getSelectedItem();

            bindTableIssuedetails();
        }
    }//GEN-LAST:event_jcbstudentidActionPerformed

    private void tblissuedetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblissuedetailsMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            // System.out.println("RIGHT MOUSE CLICK HAPPEN");
            int row_point = tblissuedetails.rowAtPoint(evt.getPoint());
            tblissuedetails.getSelectionModel().setSelectionInterval(row_point, row_point);
            popup.show(tblissuedetails, evt.getX(), evt.getY());
            // System.out.println(tablebookjtfreturndateectedRow());
            selected_row = tblissuedetails.getSelectedRow();

            show_details();
        }

    }//GEN-LAST:event_tblissuedetailsMouseClicked

    private void btreturnbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btreturnbookActionPerformed
       
        System.out.println(" Selected Row : " + selected_row);
        if (selected_row != -1 && students != null && selected_row < students.size()) {
            IssuedetailsTO bt = students.get(selected_row);
            String message = "";
            boolean allvalid = true;
            bt.setLatedays(Integer.parseInt(label3.getText()));
            bt.setFineamount(Integer.parseInt(label.getText()));
            bt.setReturndate((bt.getReturndate()));
            System.out.println(" Issue ID " + bt.getIssueid());
            IssuedetailsDAO action = new IssuedetailsDAO();
            if (action.updateRecord(bt)) {
                message += "issue details are updated in system database";
            } else {
                message = "insertion failure:" + action.getError_message();
            }
            if (allvalid  ) {
                JOptionPane.showMessageDialog(this, message);
            } else {
                JOptionPane.showMessageDialog(this, message, "failure in working", JOptionPane.ERROR_MESSAGE);
            }

        }

        //selected_row=-1;
    }//GEN-LAST:event_btreturnbookActionPerformed
    private void show_details() {
        if (selected_row != -1 && students != null && students.size() > 0) {
            IssuedetailsTO detail = new IssuedetailsTO();
            detail = students.get(selected_row);
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            String a = df.format(detail.getReturndate());

            System.out.println(a);
            label1.setText(a);
            java.util.Date dd = new java.util.Date();
            String s = df.format(dd);
            label2.setText(s);
            try {
                java.util.Date returndate = df.parse(a);
                java.util.Date todaydate = df.parse(s);
                if (todaydate.getTime() > returndate.getTime()) {
                    long diff = todaydate.getTime() - returndate.getTime();
                    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    label3.setText(String.valueOf(days));
                    long fine = days * 2;
                    label.setText(String.valueOf(fine));
                } else {
                    label3.setText(" No Late Days ");
                }
                //int stid=detail.getStudentid();
                //long fine=String.valueOf(days)*2;

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btreturnbook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<java.lang.Object> jcbstudentid;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel lbl_todaysdate;
    private javax.swing.JLabel lbllatedays;
    private javax.swing.JLabel lblreturndate;
    private javax.swing.JLabel lblstudentid;
    private javax.swing.JLabel lbltotalfine;
    private javax.swing.JTable tblissuedetails;
    // End of variables declaration//GEN-END:variables
}

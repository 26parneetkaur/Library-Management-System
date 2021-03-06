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
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.BookinfoDAO;
import model.dao.BranchinfoDAO;
import model_to.BookinfoTO;
import model_to.BranchinfoTO;
import utility.Operations;

/**
 *
 * @author HP
 */
public class ViewBranchinfo extends javax.swing.JInternalFrame {

    private List<BranchinfoTO> branches;

    private JPopupMenu popup;
    private int selected_row;

    public ViewBranchinfo() {
        initComponents();
        setSize(563,482);
        bindTableBranchinfo();
        preparePopupMenu();
        selected_row = -1;
    }

    private void preparePopupMenu() {
        popup = new JPopupMenu();
        Font newfont = new Font("Consolas", Font.BOLD, 24);
        ImageIcon edit_icon = new ImageIcon(getClass().getResource("/icons/edit.png"));
        JMenuItem delete_item = new JMenuItem("delete this record");
        JMenuItem edit_item = new JMenuItem("edit this record");
        edit_item.setIcon(edit_icon);
        delete_item.setFont(newfont);
        edit_item.setFont(newfont);
        popup.add(delete_item);
        popup.add(edit_item);
        delete_item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete_branchinfo();
            }
        });
        edit_item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edit_branchinfo();
            }
        });
    }

    public void delete_branchinfo() {
        if (selected_row != -1 && branches != null && selected_row < branches.size()) {
            int result = JOptionPane.showConfirmDialog(this, "are you sure to remove this record?", "suggestions from system", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                BranchinfoTO bt = branches.get(selected_row);
                BranchinfoDAO action = new BranchinfoDAO();
                String message = "";
                if (action.deleteRecord(bt.getBranchid())) {
                    message = "record is removed from system";
                    bindTableBranchinfo();
                } else {
                    message = "failure due to" + action.getError_message();
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        selected_row = -1;
    }

    public void edit_branchinfo() {
        if (selected_row != -1 && branches != null && selected_row < branches.size()) {
            BranchinfoTO bt = branches.get(selected_row);
            AddBranchInfo abd = new AddBranchInfo(bt);
            Operations.openInternalFrame(getDesktopPane(), abd);
            dispose();
        }
        selected_row = -1;
    }

    private void bindTableBranchinfo() {
        String[] col_names = {"Branch ID", "Branch Name", "Maximum Issue"};
        Object[][] records = null;
        branches = new BranchinfoDAO().getAllRecord();
        if (branches != null && branches.size() > 0) {
            records = new Object[branches.size()][col_names.length];
            int index = 0;
            for (BranchinfoTO bt : branches) {
                records[index] = new Object[]{bt.getBranchid(),
                    bt.getBranchname(), bt.getMaximumissue()};
                index++;
            }

        } else {
            records = new Object[1][col_names.length];
            records[0] = new Object[]{"No Information Present", "No Information Present",
                "No Information Present"};

        }
        DefaultTableModel model = new DefaultTableModel(records, col_names);
        tablebranchinfo.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablebranchinfo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Branch Details");
        getContentPane().setLayout(null);

        tablebranchinfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablebranchinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebranchinfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablebranchinfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(27, 11, 452, 375);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pankaj.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablebranchinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebranchinfoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            // System.out.println("RIGHT MOUSE CLICK HAPPEN");
            int row_point = tablebranchinfo.rowAtPoint(evt.getPoint());
            tablebranchinfo.getSelectionModel().setSelectionInterval(row_point, row_point);
            popup.show(tablebranchinfo, evt.getX(), evt.getY());
            // System.out.println(tablebookinfo.getSelectedRow());
            selected_row = tablebranchinfo.getSelectedRow();
        }
    }//GEN-LAST:event_tablebranchinfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablebranchinfo;
    // End of variables declaration//GEN-END:variables
}

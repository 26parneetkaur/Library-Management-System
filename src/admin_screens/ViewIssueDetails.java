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
import model.dao.IssuedetailsDAO;
import model_to.BookinfoTO;
import model_to.BranchinfoTO;
import model_to.IssuedetailsTO;
import utility.Operations;

public class ViewIssueDetails extends javax.swing.JInternalFrame {

    private List<IssuedetailsTO> students;
     private JPopupMenu popup;
   private int selected_row;
    public ViewIssueDetails() {
        initComponents();
        setSize(599,453);
        bindTableissuedetails();
         preparePopupMenu();
        selected_row=-1;
    }

    private void preparePopupMenu(){
        popup=new JPopupMenu();
        Font newfont=new Font("Consolas",Font.BOLD,24);
        ImageIcon edit_icon=new ImageIcon(getClass().getResource("/icons/edit.png"));
        JMenuItem delete_item=new JMenuItem("delete this record");
        JMenuItem edit_item=new JMenuItem("edit this record");
        edit_item.setIcon(edit_icon);
        delete_item.setFont(newfont);
        edit_item.setFont(newfont);
            popup.add(delete_item);
                    popup.add(edit_item);
                    delete_item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            delete_issuedetails();
                        }
                    });
                    edit_item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            edit_issuedetails();
                        }
                    });
    }
    
     public void delete_issuedetails(){
        if(selected_row!=-1 && students!=null && selected_row<students.size()){
            int result=JOptionPane.showConfirmDialog(this,"are you sure to remove this record?","suggestions from system",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
                IssuedetailsTO st=students.get(selected_row);
                IssuedetailsDAO action=new IssuedetailsDAO();
                String message="";
                if(action.deleteRecord(st.getBookid())){
                    message="record is removed from system";
                    bindTableissuedetails();
                }else{
                    message="failure due to"+action.getError_message();
                }
                JOptionPane.showMessageDialog(this,message);
            }
        }
        selected_row=-1;
    }
     
      public void edit_issuedetails(){
        if(selected_row!=-1 && students!=null && selected_row<students.size()){
            IssuedetailsTO st=students.get(selected_row);
            AddStudentInfo abd=new AddStudentInfo();
            Operations.openInternalFrame(getDesktopPane(), abd);
            dispose();
        }
        selected_row=-1;
    }
      
       private void bindTableissuedetails(){
            String[] col_names = {"Book ID","Issue date","no of days","return date",
                    "student ID"};
            Object[][] records=null;
            students=new IssuedetailsDAO().getAllRecord();
            if(students!=null && students.size()>0){
                records= new Object[students.size()][col_names.length];
                int index=0;
                for(IssuedetailsTO st : students){
                    records[index]=new Object[]{
                    st.getBookid(),st.getIssuedate(),st.getNoofdays(),st.getReturndate()
                    ,st.getStudentid()};
                    index++;
                    }
                            
            }else{
                records= new Object[1][col_names.length];
                records[0]=new Object[]{"No Information Present","No Information Present","No Information Present",
                    "No Information Present","No Information Present"                  
                    };
                
            }
             DefaultTableModel model=new DefaultTableModel(records,col_names);
            tableissuedetails.setModel(model);
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableissuedetails = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("View IssueDetails");
        getContentPane().setLayout(null);

        tableissuedetails.setModel(new javax.swing.table.DefaultTableModel(
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
        tableissuedetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableissuedetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableissuedetails);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(51, 59, 478, 281);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pankaj.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableissuedetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableissuedetailsMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON3){
           // System.out.println("RIGHT MOUSE CLICK HAPPEN");
           int row_point = tableissuedetails.rowAtPoint(evt.getPoint());
           tableissuedetails.getSelectionModel().setSelectionInterval(row_point,row_point);
           popup.show(tableissuedetails,evt.getX(),evt.getY());
          // System.out.println(tablebookinfo.getSelectedRow());
          selected_row=tableissuedetails.getSelectedRow();
        }
    }//GEN-LAST:event_tableissuedetailsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableissuedetails;
    // End of variables declaration//GEN-END:variables
}

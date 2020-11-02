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
import model.dao.StudentinfoDAO;
import model_to.BookinfoTO;
import model_to.BranchinfoTO;
import model_to.StudentinfoTO;
import utility.Operations;

/**
 *
 * @author HP
 */
public class ViewStudentinfo extends javax.swing.JInternalFrame {
    private List<StudentinfoTO> students;
     private JPopupMenu popup;
   private int selected_row;
    public ViewStudentinfo() {
        initComponents();
        setSize(836,378);
        bindTableStudentinfo();
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
                            delete_studentinfo();
                        }
                    });
                    edit_item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            edit_studentinfo();
                        }
                    });
    }
    public void delete_studentinfo(){
        if(selected_row!=-1 && students!=null && selected_row<students.size()){
            int result=JOptionPane.showConfirmDialog(this,"are you sure to remove this record?","suggestions from system",JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
                StudentinfoTO st=students.get(selected_row);
                StudentinfoDAO action=new StudentinfoDAO();
                String message="";
                if(action.deleteRecord(st.getStudentid())){
                    message="record is removed from system";
                    bindTableStudentinfo();
                }else{
                    message="failure due to"+action.getError_message();
                }
                JOptionPane.showMessageDialog(this,message);
            }
        }
        selected_row=-1;
    }
    public void edit_studentinfo(){
        if(selected_row!=-1 && students!=null && selected_row<students.size()){
            StudentinfoTO st=students.get(selected_row);
            AddStudentInfo abd=new AddStudentInfo(st);
            Operations.openInternalFrame(getDesktopPane(), abd);
            dispose();
        }
        selected_row=-1;
    }
    
        private void bindTableStudentinfo(){
            String[] col_names = {"Branch ID","Student ID","Student name","father name",
                     "contact no.","e-mail ID"};
            Object[][] records=null;
            students=new StudentinfoDAO().getAllRecord();
            if(students!=null && students.size()>0){
                records= new Object[students.size()][col_names.length];
                int index=0;
                for(StudentinfoTO st : students){
                    records[index]=new Object[]{st.getBranchid(),
                    st.getStudentid(),st.getStudentname(),st.getFathername()
                    ,st.getContactno(),st.getEmailid()};
                    index++;
                    }
                            
            }else{
                records= new Object[1][col_names.length];
                records[0]=new Object[]{"No Information Present","No Information Present",
                    "No Information Present","No Information Present","No Information Present",
                    "No Information Present"};
                
            }
            DefaultTableModel model=new DefaultTableModel(records,col_names);
            tableStudentinfo.setModel(model);
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
        tableStudentinfo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Studentinfo");
        getContentPane().setLayout(null);

        tableStudentinfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tableStudentinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStudentinfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableStudentinfo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(22, 11, 773, 240);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pankaj.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 820, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableStudentinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableStudentinfoMouseClicked
       if(evt.getButton()==MouseEvent.BUTTON3){
           int row_point = tableStudentinfo.rowAtPoint(evt.getPoint());
           tableStudentinfo.getSelectionModel().setSelectionInterval(row_point,row_point);
           popup.show(tableStudentinfo,evt.getX(),evt.getY());
          // System.out.println(tablebookinfo.getSelectedRow());
          selected_row=tableStudentinfo.getSelectedRow();
       }
    }//GEN-LAST:event_tableStudentinfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableStudentinfo;
    // End of variables declaration//GEN-END:variables
}
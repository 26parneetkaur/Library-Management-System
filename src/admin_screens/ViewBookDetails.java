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
public class ViewBookDetails extends javax.swing.JInternalFrame {

   private List<BookinfoTO> books;
   private JPopupMenu popup;
   private int selected_row;
    public ViewBookDetails() {
        initComponents();
        setSize(538,339);
        bindTableBookinfo();
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
                            delete_bookdetails();
                        }
                    });
                    edit_item.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            edit_bookdetails();
                        }
                    });
    }
    
     public void delete_bookdetails() {
        if (selected_row != -1 && books != null && selected_row < books.size()) {
            int result = JOptionPane.showConfirmDialog(this, "are you sure to remove this record?", "suggestions from system", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                BookinfoTO bt = books.get(selected_row);
                BookinfoDAO action = new BookinfoDAO();
                String message = "";
                if (action.deleteRecord(bt.getBookid())) {
                    message = "record is removed from system";
                    bindTableBookinfo();
                } else {
                    message = "failure due to" + action.getError_message();
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        selected_row = -1;
    }

    
    public void edit_bookdetails(){
        if(selected_row!=-1 && books!=null && selected_row<books.size()){
            BookinfoTO bt=books.get(selected_row);
            AddBookinfo abd=new AddBookinfo(bt);
            Operations.openInternalFrame(getDesktopPane(), abd);
            dispose();
        }
        selected_row=-1;
    }
    
        private void bindTableBookinfo(){
            String[] col_names = {"Book ID","Book Name","Author Name",
                "Price","Edition","Quantity"};
            Object[][] records=null;
            books=new BookinfoDAO().getAllRecord();
            if(books!=null && books.size()>0){
                records= new Object[books.size()][col_names.length];
                int index=0;
                for(BookinfoTO bt : books){
                    records[index]=new Object[]{bt.getBookid(),bt.getBookname(),
                        bt.getAuthorname(),bt.getPrice(),bt.getEdition(),
                        bt.getQuantity()};
                    index++;
                    }
                            
            }else{
                records= new Object[1][col_names.length];
                records[0]=new Object[]{"No Information Present","No Information Present",
                    "No Information Present","No Information Present",
                    "No Information Present","No Information Present"};
                
            }
            DefaultTableModel model=new DefaultTableModel(records,col_names);
            tablebookinfo.setModel(model);
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spbookinfo = new javax.swing.JScrollPane();
        tablebookinfo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Book Details");
        getContentPane().setLayout(null);

        spbookinfo.setPreferredSize(new java.awt.Dimension(638, 514));

        tablebookinfo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablebookinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebookinfoMouseClicked(evt);
            }
        });
        spbookinfo.setViewportView(tablebookinfo);

        getContentPane().add(spbookinfo);
        spbookinfo.setBounds(24, 11, 470, 280);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pankaj.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 530, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablebookinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebookinfoMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==MouseEvent.BUTTON3){
           // System.out.println("RIGHT MOUSE CLICK HAPPEN");
           int row_point = tablebookinfo.rowAtPoint(evt.getPoint());
           tablebookinfo.getSelectionModel().setSelectionInterval(row_point,row_point);
           popup.show(tablebookinfo,evt.getX(),evt.getY());
          // System.out.println(tablebookinfo.getSelectedRow());
          selected_row=tablebookinfo.getSelectedRow();
        }
    }//GEN-LAST:event_tablebookinfoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane spbookinfo;
    private javax.swing.JTable tablebookinfo;
    // End of variables declaration//GEN-END:variables
}

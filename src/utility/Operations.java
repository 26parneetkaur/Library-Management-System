/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author HP
 */
public class Operations {
    public static void openInternalFrame(JDesktopPane deskpane,JInternalFrame jif){
        deskpane.add(jif);
        jif.setVisible(true);
    }
     public static void setApplicationIcon(JFrame frm){
         try{
            ImageIcon image=new ImageIcon(frm.getClass().getResource("/icons/bk1_1.png"));
           frm.setIconImage(image.getImage());
        }catch(Exception ex){
          ErrorHandler.showErrorStack(ex);
        }
    }
}

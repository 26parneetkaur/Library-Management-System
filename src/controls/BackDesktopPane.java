/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import utility.ErrorHandler;

public class BackDesktopPane extends JDesktopPane {
     private Image backimage;

    public BackDesktopPane() {
       try{
            ImageIcon image=new ImageIcon(getClass().getResource("/icons/shelf2.jpg"));
           backimage=image.getImage();
        }catch(Exception ex){
          ErrorHandler.showErrorStack(ex);
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        if(backimage!=null){
            g.drawImage(backimage,0,0,getWidth(),getHeight(),this);
        }else{
            super.paintComponent(g);
        }
    }
}



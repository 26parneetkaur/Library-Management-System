/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.event.KeyAdapter;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class IntTextField extends JTextField {
    public IntTextField(){
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                char ch=evt.getKeyChar();
                if(!Character.isDigit(ch)){
                    evt.consume();
                }
            }
        
            });
    }
}

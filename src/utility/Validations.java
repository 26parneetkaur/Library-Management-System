/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;


public class Validations {
    
    public static boolean isEmpty(String value){
        if(value!=null){
            return value.trim().isEmpty();
        }
        return false;
    }
     public static boolean isInteger(String value){
         try{        
        if(value!=null){
            Integer.parseInt(value.trim());
            return true;
        }}catch(NumberFormatException ex){}
        return false;
    }
      public static boolean isFloat(String value){
         try{        
        if(value!=null){
            Float.parseFloat(value.trim());
            return true;
        }}catch(NumberFormatException ex){}
        return false;
    }
      public static boolean onlyLetterAndSpace(String value){
          if(value!=null){
              value=value.trim();
              for(int index=0;index<value.length();index++){
                  char ch=value.charAt(index);
                  if(Character.isLetter(ch) || Character.isWhitespace(ch)){
                      
                  }else{
                      return false;
                  }
              }
              return true;
          }
          return false;
      }
}

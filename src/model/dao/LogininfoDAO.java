/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model_to.LogininfoTO;
import utility.ErrorHandler;


public class LogininfoDAO extends DAO{
    public boolean insertRecord(LogininfoTO record){
        try{
           String query= " insert into logininfo ";
           query +=" (username,password,rolename) ";
           query +=" values(?,?,?) ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setString(1,record.getUsername());
           stmt.setString(2,record.getPassword());
           stmt.setString(3,record.getRolename());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
          ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
    public boolean updateRecord(LogininfoTO record){
        try{
           String query= " update logininfo ";
           
           query +=" set password=?,rolename=?,lastlogin=? ";
           query +=" where username=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setString(1,record.getPassword());
           stmt.setString(2,record.getRolename());
           stmt.setTimestamp(3,record.getLastlogin());
           stmt.setString(4,record.getUsername());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
           ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
   public boolean deleteRecord(String username){
        try{
           String query= " delete from logininfo ";
           
           query +=" where username=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setString(1,username);
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
 public LogininfoTO getRecord(String username){
        try{
           String query= " select username,password,rolename,lastlogin ";
           query+=" from logininfo ";
           query +=" where username=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setString(1,username);
           LogininfoTO result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new LogininfoTO();
               result.setUsername(rs.getString("username"));
               result.setPassword(rs.getString("password"));
               result.setRolename(rs.getString("rolename"));
               result.setLastlogin(rs.getTimestamp("lastlogin"));
           }
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return null;
        }
    }
  public List<LogininfoTO> getAllRecord(){
        try{
           String query= " select username,password,rolename,lastlogin ";
           query+=" from logininfo ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           List<LogininfoTO> result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new ArrayList<>();
               do{
                   LogininfoTO res=new LogininfoTO();
               
               res.setUsername(rs.getString("username"));
               res.setPassword(rs.getString("password"));
               res.setRolename(rs.getString("rolename"));
               res.setLastlogin(rs.getTimestamp("lastlogin"));
               result.add(res);
               }while(rs.next());
           
               }
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
           ErrorHandler.showErrorStack(ex);
            return null;
        }
    }
}


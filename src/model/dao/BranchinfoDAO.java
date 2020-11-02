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
import model_to.BranchinfoTO;
import utility.ErrorHandler;

/**
 *
 * @author HP
 */
public class BranchinfoDAO extends DAO{
    public boolean insertRecord(BranchinfoTO record){
        try{
           String query= " insert into branchinfo ";
           query +=" (branchid,branchname,maximumissue) ";
           query +=" values(?,?,?) ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setString(1,record.getBranchid());
           stmt.setString(2,record.getBranchname());
           stmt.setInt(3,record.getMaximumissue());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
          ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
    public boolean updateRecord(BranchinfoTO record){
        try{
           String query= " update branchinfo ";
           query +=" set branchname=? , maximumissue=? ";
           query +=" where branchid=? ";
           
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           
           stmt.setString(1,record.getBranchname());
           stmt.setInt(2,record.getMaximumissue());
           stmt.setString(3,record.getBranchid());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
           ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
   public boolean deleteRecord(String branchid){
        try{
           String query= " delete from branchinfo ";
           
           query +=" where branchid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setString(1,branchid);
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
 public BranchinfoTO getRecord(int branchid){
        try{
           String query= " select branchid,branchname,maximumissue ";
           query+=" from branchinfo ";
           query +=" where branchid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,branchid);
           BranchinfoTO result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new BranchinfoTO();
               result.setBranchid(rs.getString("branchid"));
               result.setBranchname(rs.getString("branchname"));
               result.setMaximumissue(rs.getInt("maximumissue"));
           }
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return null;
        }
    }
  public List<BranchinfoTO> getAllRecord(){
        try{
           String query= " select branchid,branchname,maximumissue ";
           query+=" from branchinfo ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           List<BranchinfoTO> result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new ArrayList<>();
               do{
                   BranchinfoTO res=new BranchinfoTO();
               
               res.setBranchid(rs.getString("branchid"));
               res.setBranchname(rs.getString("branchname"));
               res.setMaximumissue(rs.getInt("maximumissue"));
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

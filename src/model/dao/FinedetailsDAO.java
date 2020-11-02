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
import model_to.FinedetailsTO;
import utility.ErrorHandler;

/**
 *
 * @author HP
 */
public class FinedetailsDAO extends DAO{
    public boolean insertRecord(FinedetailsTO record){
        try{
           String query= " insert into finedetails ";
           query +=" (minday,maxday,amount) ";
           query +=" values(?,?,?) ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,record.getMinday());
           stmt.setInt(2,record.getMaxday());
           stmt.setFloat(3,record.getAmount());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
          ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
    public boolean updateRecord(FinedetailsTO record){
        try{
           String query= " update finedetails ";
           query +=" set minday=? ";
           query +=" set maxday=? ";
           query +=" set amount=? ";
           query+=" fineid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           
           stmt.setInt(1,record.getMinday());
           stmt.setInt(2,record.getMaxday());
           stmt.setFloat(3,record.getAmount());
           stmt.setInt(4,record.getFineid());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
           ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
   public boolean deleteRecord(int fineid){
        try{
           String query= " delete from finedetails ";
           
           query +=" where fineid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,fineid);
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
 public FinedetailsTO getRecord(int fineid){
        try{
           String query= " select fineid,minday,maxday,amount ";
           query+=" from finedetails ";
           query +=" where fineid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,fineid);
           FinedetailsTO result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new FinedetailsTO();
               result.setFineid(rs.getInt("fineid"));
               result.setMinday(rs.getInt("minday"));
               result.setMaxday(rs.getInt("maxday"));
               result.setAmount(rs.getFloat("amount"));
           }
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return null;
        }
    }
  public List<FinedetailsTO> getAllRecord(){
        try{
           String query= " select fineid,minday,maxday,amount ";
           query+=" from finedetails ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           List<FinedetailsTO> result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new ArrayList<>();
               do{
                  FinedetailsTO res=new FinedetailsTO();
               
               res.setFineid(rs.getInt("fineid"));
               res.setMinday(rs.getInt("minday"));
               res.setMaxday(rs.getInt("maxday"));
               res.setAmount(rs.getFloat("amount"));
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

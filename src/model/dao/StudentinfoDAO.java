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
import model_to.StudentinfoTO;
import utility.ErrorHandler;

/**
 *
 * @author HP
 */
public class StudentinfoDAO extends DAO{
    public boolean insertRecord(StudentinfoTO record){
        try{
           String query= " insert into studentinfo ";
           query +=" (studentid,studentname,fathername,contactno,emailid,branchid) ";
           query +=" values(?,?,?,?,?,?) ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,record.getStudentid());
           stmt.setString(2,record.getStudentname());
           stmt.setString(3,record.getFathername());
           stmt.setString(4,record.getContactno());
           stmt.setString(5,record.getEmailid());
           stmt.setString(6,record.getBranchid());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
          ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
    public boolean updateRecord(StudentinfoTO record){
        try{
           String query= " update studentinfo ";
           
           query +=" set studentname=? ";
           query +=" set fathername=? ";
           query +=" set contactno=? ";
           query +=" set emailid=? ";
           query +=" set branchid=? ";
           query +=" where studentid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           
           stmt.setString(1,record.getStudentname());
           stmt.setString(2,record.getFathername());
           stmt.setString(3,record.getContactno());
           stmt.setString(4,record.getEmailid());
           stmt.setString(5,record.getBranchid());
           stmt.setInt(6,record.getStudentid());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
           ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
   public boolean deleteRecord(int studentid){
        try{
           String query= " delete from studentinfo ";
           
           query +=" where studentid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,studentid);
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
 public List<StudentinfoTO> getRecord(int studentid){
        try{
           String query= " select studentid,studentname,fathername,contactno,emailid,branchid ";
           query+=" from studentinfo "; 
           query +=" where studentid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,studentid);
           List<StudentinfoTO> result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new ArrayList<>();
               do{
               StudentinfoTO rest=new StudentinfoTO();
               rest.setStudentid(rs.getInt("studentid"));
               rest.setStudentname(rs.getString("studentname"));
               rest.setFathername(rs.getString("fathername"));
               rest.setContactno(rs.getString("contactno"));
               rest.setEmailid(rs.getString("emailid"));
               rest.setBranchid(rs.getString("branchid"));
               result.add(rest);
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
  public List<StudentinfoTO> getAllRecord(){
        try{
           String query= " select studentid,studentname,fathername,contactno,emailid,branchid ";
           query+=" from studentinfo ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           List<StudentinfoTO> result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new ArrayList<>();
               do{
                   StudentinfoTO res=new StudentinfoTO();
                res.setStudentid(rs.getInt("studentid"));
               res.setStudentname(rs.getString("studentname"));
               res.setFathername(rs.getString("fathername"));
               res.setContactno(rs.getString("contactno"));
               res.setEmailid(rs.getString("emailid"));
               res.setBranchid(rs.getString("branchid"));
               
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

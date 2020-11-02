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


import model_to.BookinfoTO;
import utility.ErrorHandler;

/**
 *
 * @author HP
 */
public class BookinfoDAO extends DAO{
    public boolean insertRecord(BookinfoTO record){
        try{
           String query= " insert into bookinfo ";
           query +=" (bookid,bookname,authorname,price,edition,quantity) ";
           query +=" values(?,?,?,?,?,?) ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,record.getBookid());
           stmt.setString(2,record.getBookname());
           stmt.setString(3,record.getAuthorname());
           stmt.setFloat(4,record.getPrice());
           stmt.setInt(5,record.getEdition());
           stmt.setInt(6,record.getQuantity());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
          ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
    public boolean updateRecord(BookinfoTO record){
        try{
           String query= " update bookinfo ";
           
           query +=" set bookname=?, ";
           query +="  authorname=?, ";
           query +="  price=?, ";
           query +="  edition=?, ";
           query +="  quantity=? ";
           query +=" where bookid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           
           stmt.setString(1,record.getBookname());
           stmt.setString(2,record.getAuthorname());
           stmt.setFloat(3,record.getPrice());
           stmt.setInt(4,record.getEdition());
           stmt.setInt(5,record.getQuantity());
           stmt.setInt(6,record.getBookid());
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
           ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
   public boolean deleteRecord(int bookid){
        try{
           String query= " delete from bookinfo ";
           
           query +=" where bookid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,bookid);
           boolean result =stmt.executeUpdate()>0;
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return false;
        }
    }
 public BookinfoTO getRecord(int bookid){
        try{
           String query= " select bookid,bookname,authorname,price,edition,quantity ";
           query+=" from bookinfo ";
           query +=" where bookid=? ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           stmt.setInt(1,bookid);
           BookinfoTO result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new BookinfoTO();
               result.setBookid(rs.getInt("bookid"));
               result.setBookname(rs.getString("bookname"));
               result.setAuthorname(rs.getString("authorname"));
               result.setPrice(rs.getFloat("price"));
               result.setEdition(rs.getInt("edition"));
               result.setQuantity(rs.getInt("quantity"));
           }
           stmt.close();
           return result;
        }catch(Exception ex){
            error_message=ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return null;
        }
    }
  public List<BookinfoTO> getAllRecord(){
        try{
           String query= " select bookid,bookname,authorname,price,edition,quantity ";
           query+=" from bookinfo ";
           PreparedStatement stmt=DataConnection.prepareStatement(query);
           List<BookinfoTO> result =null;
           ResultSet rs=stmt.executeQuery();
           if(rs.next()){
               result=new ArrayList<>();
               do{
                   BookinfoTO res=new BookinfoTO();
               
               res.setBookid(rs.getInt("bookid"));
               res.setBookname(rs.getString("bookname"));
               res.setAuthorname(rs.getString("authorname"));
               res.setPrice(rs.getFloat("price"));
               res.setEdition(rs.getInt("edition"));
               res.setQuantity(rs.getInt("quantity"));
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

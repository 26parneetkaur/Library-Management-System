/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import utility.ConfigurationDetails;

/**
 *
 * @author HP
 */
public class DataConnection {

    
    private DataConnection(){
}
    private static Connection con=null;
    public static Connection getConnection() throws Exception{
        if(con==null){
            Class.forName(ConfigurationDetails.DRIVER_NAME);
            con=DriverManager.getConnection(ConfigurationDetails.CONNECTION_URL,ConfigurationDetails.USER_NAME,ConfigurationDetails.USER_PASSWORD);
        }
        return con;
    }
    public static void closeConnection() throws Exception{
        if(con!=null){
            con.close();
        }
        con=null;
    }
    public static PreparedStatement prepareStatement(String query) throws Exception{
        return getConnection().prepareStatement(query);
    }
}
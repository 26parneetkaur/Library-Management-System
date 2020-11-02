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
import model_to.IssuedetailsTO;
import utility.ErrorHandler;

/**
 *
 * @author HP
 */
public class IssuedetailsDAO extends DAO {

    public boolean insertRecord(IssuedetailsTO record) {
        try {
            String query = " insert into issuedetails ";
            query += " (issueid,bookid,issuedate,returndate,quantity,username,studentid,noofdays,fineamount,"
                    + "fineperday,latedays) ";
            query += " values(?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, record.getIssueid());
            stmt.setInt(2, record.getBookid());
            stmt.setDate(3, record.getIssuedate());
            stmt.setDate(4, record.getReturndate());
            stmt.setInt(5, record.getQuantity());
            stmt.setString(6, record.getUsername());
            stmt.setInt(7, record.getStudentid());
            stmt.setInt(8, record.getNoofdays());
            stmt.setFloat(9, record.getFineamount());
            stmt.setFloat(10, record.getFineperday());
            stmt.setInt(11, record.getLatedays());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return false;
        }
    }

    public boolean updateRecord(IssuedetailsTO record) {
        try {
            String query = " update issuedetails";

            query += " set returndate=?, ";
            // query +=" set quantity=? ";
            // query +=" set username=? ";
            // query +=" studentid=?, ";
            query += " noofdays=?, ";
            query += " fineamount=?, ";
            query += " fineperday=?, ";
            query += " latedays=? ";
            query += " where issueid=? ";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            //stmt.setInt(1,record.getIssueid());        
            //stmt.setDate(2,record.getIssuedate());
            stmt.setDate(1, record.getReturndate());
            //stmt.setInt(2,record.getQuantity());
            //stmt.setString(5,record.getUsername());
            // stmt.setInt(2,record.getStudentid());
            stmt.setInt(2, record.getNoofdays());
            stmt.setFloat(3, record.getFineamount());
            stmt.setFloat(4, record.getFineperday());
            stmt.setInt(5, record.getLatedays());
            stmt.setInt(6, record.getIssueid());

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return false;
        }
    }

    public boolean deleteRecord(int bookid) {
        try {
            String query = " delete from issuedetails ";

            query += " where bookid=? ";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, bookid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return false;
        }
    }

    public List<IssuedetailsTO> getRecord(int stid) {
        try {
            String query = " select issueid,bookid,issuedate,returndate,quantity,username,studentid,noofdays,fineamount, "
                    + " fineperday,latedays ";
            query += " from issuedetails ";
            query += " where studentid=? ";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, stid);
            // IssuedetailsTO result =null;
            ResultSet rs = stmt.executeQuery();
            List<IssuedetailsTO> result = null;
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    IssuedetailsTO res = new IssuedetailsTO();
                    res.setIssueid(rs.getInt("issueid"));
                    res.setBookid(rs.getInt("bookid"));
                    res.setIssuedate(rs.getDate("issuedate"));
                    res.setReturndate(rs.getDate("returndate"));
                    res.setQuantity(rs.getInt("quantity"));
                    res.setUsername(rs.getString("username"));
                    res.setStudentid(rs.getInt("studentid"));
                    res.setNoofdays(rs.getInt("noofdays"));
                    res.setFineamount(rs.getFloat("fineamount"));
                    res.setFineperday(rs.getFloat("fineperday"));
                    res.setLatedays(rs.getInt("latedays"));
                    result.add(res);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return null;
        }
    }

    public List<IssuedetailsTO> getAllRecord() {
        try {
            String query = " select  issueid,bookid,issuedate,returndate,quantity,username,studentid,noofdays,fineamount, "
                    + " fineperday,latedays ";
            query += " from issuedetails ";

            PreparedStatement stmt = DataConnection.prepareStatement(query);
            List<IssuedetailsTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    IssuedetailsTO res = new IssuedetailsTO();
                    res.setIssueid(rs.getInt("issueid"));
                    res.setBookid(rs.getInt("bookid"));
                    res.setIssuedate(rs.getDate("issuedate"));
                    res.setReturndate(rs.getDate("returndate"));
                    res.setQuantity(rs.getInt("quantity"));
                    res.setUsername(rs.getString("username"));
                    res.setStudentid(rs.getInt("studentid"));
                    res.setNoofdays(rs.getInt("noofdays"));
                    res.setFineamount(rs.getFloat("fineamount"));
                    res.setFineperday(rs.getFloat("fineperday"));
                    res.setLatedays(rs.getInt("latedays"));

                    result.add(res);
                } while (rs.next());

            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.getMessage();
            ErrorHandler.showErrorStack(ex);
            return null;
        }
    }

    public List<IssuedetailsTO> getAllRecord(int studentid) {
        try {
            String query = " select issueid,bookid,issuedate,returndate,quantity,username,studentid,noofdays,fineamount, "
                    + " fineperday,latedays ";
            query += " from issuedetails ";
            query += " where studentid=? ";
        } catch (Exception ex) {
            error_message = ex.getMessage();
            ErrorHandler.showErrorStack(ex);

        }
        return null;
    }
}

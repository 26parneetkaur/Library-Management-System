/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_to;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class IssuedetailsTO {
    private int issueid;

    public int getIssueid() {
        return issueid;
    }

    public void setIssueid(int issueid) {
        this.issueid = issueid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getNoofdays() {
        return noofdays;
    }

    public void setNoofdays(int noofdays) {
        this.noofdays = noofdays;
    }

    public float getFineamount() {
        return fineamount;
    }

    public void setFineamount(float fineamount) {
        this.fineamount = fineamount;
    }

    public float getFineperday() {
        return fineperday;
    }

    public void setFineperday(float fineperday) {
        this.fineperday = fineperday;
    }

    public int getLatedays() {
        return latedays;
    }

    public void setLatedays(int latedays) {
        this.latedays = latedays;
    }
    private int bookid;
    private Date issuedate;
    private Date returndate;
    private int quantity;
    private String username;
    private int studentid;
    private int noofdays;
    private float fineamount;
    private float fineperday;
    private int latedays;
}

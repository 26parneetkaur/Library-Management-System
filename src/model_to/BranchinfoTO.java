/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_to;

/**
 *
 * @author HP
 */
public class BranchinfoTO {
    private String branchid;
    private String branchname;
    private int maximumissue;

    public String getBranchid() {
        return branchid;
    }

    public void setBranchid(String branchid) {
        this.branchid = branchid;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public int getMaximumissue() {
        return maximumissue;
    }

    public void setMaximumissue(int maximumissue) {
        this.maximumissue = maximumissue;
    }
    
    public String toString(){
        return branchname;
    }
}

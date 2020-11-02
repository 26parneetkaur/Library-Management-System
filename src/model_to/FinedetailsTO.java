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
public class FinedetailsTO {
    private int fineid;

    public int getFineid() {
        return fineid;
    }

    public void setFineid(int fineid) {
        this.fineid = fineid;
    }

    public int getMinday() {
        return minday;
    }

    public void setMinday(int minday) {
        this.minday = minday;
    }

    public int getMaxday() {
        return maxday;
    }

    public void setMaxday(int maxday) {
        this.maxday = maxday;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    private int minday;
    private int maxday;
    private float amount;
}

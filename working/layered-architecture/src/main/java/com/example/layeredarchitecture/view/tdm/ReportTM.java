package com.example.layeredarchitecture.view.tdm;

public class ReportTM {
    private String description;
    private int qty;

    public ReportTM(String description, int qty) {
        this.description = description;
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ReportTM{" +
                "description='" + description + '\'' +
                ", qty=" + qty +
                '}';
    }
}

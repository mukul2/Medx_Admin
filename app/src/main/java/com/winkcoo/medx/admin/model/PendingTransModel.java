package com.winkcoo.medx.admin.model;

public class PendingTransModel {
    int id;
    String pid;
    String name ;
    String date;
    String amount;
    String payment_details;
    String img;

    public PendingTransModel(int id, String pid, String name, String date, String amount, String payment_details, String img) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.payment_details = payment_details;
        this.img = img;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return img;
    }

    public void setType(String type) {
        this.img = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment_details() {
        return payment_details;
    }

    public void setPayment_details(String payment_details) {
        this.payment_details = payment_details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

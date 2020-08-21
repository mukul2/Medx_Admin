package com.winkcoo.medx.admin.model;

public class PendingTransModel {
    int id;
    String pid;
    String name ;
    String did ;
    String date;
    String amount;
    String payment_details;
    String img;
    String service_details;

    public PendingTransModel(int id, String pid, String name, String did, String date, String amount, String payment_details, String img, String service_details) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.did = did;
        this.date = date;
        this.amount = amount;
        this.payment_details = payment_details;
        this.img = img;
        this.service_details = service_details;
    }

    public String getService_details() {
        return service_details;
    }

    public void setService_details(String service_details) {
        this.service_details = service_details;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
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

package com.winkcoo.medx.admin.model;

public class WidthdrawModel {
    Integer id;
    Integer amount;
    Integer status;
    String created_at;
    String bankinfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getBankinfo() {
        return bankinfo;
    }

    public void setBankinfo(String bankinfo) {
        this.bankinfo = bankinfo;
    }
}

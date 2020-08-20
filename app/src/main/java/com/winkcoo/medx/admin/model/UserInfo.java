package com.winkcoo.medx.admin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("department")
@Expose
private Integer department;
@SerializedName("user_type")
@Expose
private String userType;
@SerializedName("photo")
@Expose
private String photo;
@SerializedName("password")
@Expose
private String password;
@SerializedName("email")
@Expose
private String email;
@SerializedName("phone")
@Expose
private String phone;
@SerializedName("token")
@Expose
private String token;
@SerializedName("remember_token")
@Expose
private String rememberToken;
@SerializedName("created_at")
@Expose
private String createdAt;
@SerializedName("updated_at")
@Expose
private String updatedAt;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Integer getDepartment() {
return department;
}

public void setDepartment(Integer department) {
this.department = department;
}

public String getUserType() {
return userType;
}

public void setUserType(String userType) {
this.userType = userType;
}

public String getPhoto() {
return photo;
}

public void setPhoto(String photo) {
this.photo = photo;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getToken() {
return token;
}

public void setToken(String token) {
this.token = token;
}

public String getRememberToken() {
return rememberToken;
}

public void setRememberToken(String rememberToken) {
this.rememberToken = rememberToken;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public String getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

}
package com.winkcoo.medx.admin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicLatestQueryModel {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("message_body")
@Expose
private String messageBody;
@SerializedName("message_sender_id")
@Expose
private Integer messageSenderId;
@SerializedName("message_receiver_id")
@Expose
private Integer messageReceiverId;
@SerializedName("status")
@Expose
private Integer status;
@SerializedName("created_at")
@Expose
private String createdAt;
@SerializedName("updated_at")
@Expose
private String updatedAt;
@SerializedName("sender_profile")
@Expose
private CommonUserModel senderProfile;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getMessageBody() {
return messageBody;
}

public void setMessageBody(String messageBody) {
this.messageBody = messageBody;
}

public Integer getMessageSenderId() {
return messageSenderId;
}

public void setMessageSenderId(Integer messageSenderId) {
this.messageSenderId = messageSenderId;
}

public Integer getMessageReceiverId() {
return messageReceiverId;
}

public void setMessageReceiverId(Integer messageReceiverId) {
this.messageReceiverId = messageReceiverId;
}

public Integer getStatus() {
return status;
}

public void setStatus(Integer status) {
this.status = status;
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

public CommonUserModel getSenderProfile() {
return senderProfile;
}

public void setSenderProfile(CommonUserModel senderProfile) {
this.senderProfile = senderProfile;
}

}
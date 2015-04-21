package com.addrbook.backend.domain;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
* Created by alexandr on 21.04.15.
*/
public class TomcatUsers {

    public TomcatUsers(){}
    public TomcatUsers(String userName,String userPass,String userFio,String userLdap,String email,String groupName,String ip,String updateIp,Date regdate,Date updateRegdate,String status){
        this.userName = userName;
        this.userPass = userPass;
        this.userFio = userFio;
        this.userLdap = userLdap;
        this.email = email;
        this.groupName = groupName;
        this.ip = ip;
        this.updateIp = updateIp;
        this.regdate = regdate;
        this.updateRegdate = updateRegdate;
        this.status = status;
    }
    public TomcatUsers(TomcatUsers users){
        this.userName = users.userName;
        this.userPass = users.userPass;
        this.userFio = users.userFio;
        this.userLdap = users.userLdap;
        this.email = users.email;
        this.groupName = users.groupName;
        this.ip = users.ip;
        this.updateIp = users.updateIp;
        this.regdate = users.regdate;
        this.updateRegdate = users.updateRegdate;
        this.status = users.status;
    }

//    @NotNull(message = "Message 'userName' must not be blank!")
    private String userName;
    @NotNull(message = "Message 'userPass' must not be blank!")
    private String userPass;
    private String userFio;
//    @NotNull(message = "Message 'userLdap' must not be blank!")
    private String userLdap;
    private String email;
    private String groupName;
    private String ip;
    private String updateIp;
    private Date   regdate;
    private Date   updateRegdate;
    @NotNull(message = "Message 'status' must not be blank!")
    private String status;


    public String getUserName(){
        return userName;
    }
    public String getUserPass(){
        return userPass;
    }
    public String getUserFio(){
        return userFio;
    }
    public String getUserLdap(){
        return userLdap;
    }
    public String getEmail(){
        return email;
    }
    public String getGroupName(){
        return groupName;
    }
    public String getIp(){
        return ip;
    }
    public String getUpdateIp(){
        return updateIp;
    }
    public Date getRegdate(){
        return regdate;
    }
    public Date getUpdateRegdate(){
        return updateRegdate;
    }
    public String getStatus(){
        return status;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setUserPass(String userPass){
        this.userPass = userPass;
    }
    public void setUserFio(String userFio){
        this.userFio = userFio;
    }
    public void setUserLdap(String userLdap){
        this.userLdap = userLdap;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setGroupName(String groupName){
        this.groupName = groupName;
    }
    public void setIp(String ip){
        this.ip = ip;
    }
    public void setUpdateIp(String updateIp){
        this.updateIp = updateIp;
    }
    public void setRegdate(Date regdate){
        this.regdate = regdate;
    }
    public void setUpdateRegdate(Date updateRegdate){
        this.updateRegdate = updateRegdate;
    }
    public void setStatus(String status){
        this.status = status;
    }


    @Override
    public String toString() {
        return "TomcatUsers{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userFio='" + userFio + '\'' +
                ", userLdap='" + userLdap + '\'' +
                ", email='" + email + '\'' +
                ", groupName='" + groupName + '\'' +
                ", ip='" + ip + '\'' +
                ", updateIp='" + updateIp + '\'' +
                ", regdate=" + regdate +
                ", updateRegdate=" + updateRegdate +
                ", status='" + status + '\'' +
                '}';
    }
}

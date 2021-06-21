package com.internship.scenariosystem.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manage {
    /*   manage_number        varchar(255),
   manage_id            int not null auto_increment,
   manage_name          varchar(1024),
   manage_password      varchar(1024),
   manage_type          varchar(1024),*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer manage_id;

    @NotNull
    private String manage_number;

    @NotNull
    private String manage_name;

    @NotNull
    private String manage_password;

    private String manage_type;

    public Integer getManage_id() {
        return manage_id;
    }

    public void setManage_id(Integer manage_id) {
        this.manage_id = manage_id;
    }

    public String getManage_number() {
        return manage_number;
    }

    public void setManage_number(String manage_number) {
        this.manage_number = manage_number;
    }

    public String getManage_name() {
        return manage_name;
    }

    public void setManage_name(String manage_name) {
        this.manage_name = manage_name;
    }

    public String getManage_password() {
        return manage_password;
    }

    public void setManage_password(String manage_password) {
        this.manage_password = manage_password;
    }

    public String getManage_type() {
        return manage_type;
    }

    public void setManage_type(String manage_type) {
        this.manage_type = manage_type;
    }
}

package com.internship.scenariosystem.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_number"})
})

@Entity
public class User {
    /*   user_number          varchar(255),
   user_id              int not null auto_increment,
   user_name            varchar(1024),
   user_phone           varchar(1024),
   user_avatar          varchar(1024),
   user_consume         decimal,*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    @NotNull
    private String user_number;

    private String user_name;

    private String user_phone;

    @Column(length = 1024)
    private String user_avatar;

    private BigDecimal user_consume;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public BigDecimal getUser_consume() {
        return user_consume;
    }

    public void setUser_consume(BigDecimal user_consume) {
        this.user_consume = user_consume;
    }
}

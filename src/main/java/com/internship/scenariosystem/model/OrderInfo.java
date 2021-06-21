package com.internship.scenariosystem.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

//@Table(uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"order_number"})
//})

@Entity
public class OrderInfo {
    /*   order_number         varchar(255),
   order_id             int not null auto_increment,
   user_number          int,
   play_number          int,*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_id;

    private String user_number;

    private String play_number;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getPlay_number() {
        return play_number;
    }

    public void setPlay_number(String play_number) {
        this.play_number = play_number;
    }
}

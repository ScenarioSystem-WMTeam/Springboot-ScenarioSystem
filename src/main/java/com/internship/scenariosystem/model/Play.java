package com.internship.scenariosystem.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"play_number"})
})

@Entity
public class Play {

    /*      play_number          varchar(255),
   play_name            varchar(255),
   play_id              int not null auto_increment,
   play_photo           varchar(1024),
   play_detail          varchar(1024),
   play_price           decimal,
   play_sort            int,
   play_type            varchar(255),
   play_detail_photo    varchar(1024),
   play_people          varchar(255),*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer play_id;

    @NotNull
    private String play_number;

    private String play_name;

    private String play_photo;

    private String play_detail;

    private BigDecimal play_price;

    private Integer play_sort;

    private String play_type;

    private String play_detail_photo;

    private String play_people;

    public Integer getPlay_id() {
        return play_id;
    }

    public void setPlay_id(Integer play_id) {
        this.play_id = play_id;
    }

    public String getPlay_number() {
        return play_number;
    }

    public void setPlay_number(String play_number) {
        this.play_number = play_number;
    }

    public String getPlay_name() {
        return play_name;
    }

    public void setPlay_name(String play_name) {
        this.play_name = play_name;
    }

    public String getPlay_photo() {
        return play_photo;
    }

    public void setPlay_photo(String play_photo) {
        this.play_photo = play_photo;
    }

    public String getPlay_detail() {
        return play_detail;
    }

    public void setPlay_detail(String play_detail) {
        this.play_detail = play_detail;
    }

    public BigDecimal getPlay_price() {
        return play_price;
    }

    public void setPlay_price(BigDecimal play_price) {
        this.play_price = play_price;
    }

    public Integer getPlay_sort() {
        return play_sort;
    }

    public void setPlay_sort(Integer play_sort) {
        this.play_sort = play_sort;
    }

    public String getPlay_type() {
        return play_type;
    }

    public void setPlay_type(String play_type) {
        this.play_type = play_type;
    }

    public String getPlay_detail_photo() {
        return play_detail_photo;
    }

    public void setPlay_detail_photo(String play_detail_photo) {
        this.play_detail_photo = play_detail_photo;
    }

    public String getPlay_people() {
        return play_people;
    }

    public void setPlay_people(String play_people) {
        this.play_people = play_people;
    }
}

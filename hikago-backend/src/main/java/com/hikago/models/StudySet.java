package com.hikago.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Date;

/**
 * Created by tuannka on 10/5/15.
 */

@Entity
public class StudySet {
    @Id public Long id;
    @Index public String name;
    public Date lastUpdate;
    public String username;

    public StudySet() {
        this.lastUpdate = new Date();
    }

    public StudySet(String name, String username) {
        this.name = name;
        this.lastUpdate = new Date();
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

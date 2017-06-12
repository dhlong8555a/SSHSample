package com.adv.devops.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by hailong.dang on 6/7/2017.
 */
@Entity
@Table(name="T_Pipeline")
public class Pipeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 32)
    private String name;

    @Column(length = 1024)
    private String gitUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }
}

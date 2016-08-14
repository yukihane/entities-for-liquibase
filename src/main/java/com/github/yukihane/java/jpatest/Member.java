package com.github.yukihane.java.jpatest;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author yuki
 */
@Entity
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    private Organization organization;

    @Column(nullable = false)
    private String name;

    public void setOrganization(Organization org) {
        this.organization = org;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.crm.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * luopa 在 2017/3/1 创建.
 */
public class Customer {
    private Integer cid;
    private String custName;
    private String custLevel;
    private String custSource;
    private String custLinkman;
    private String custPhone;
    private String custMobile;
    private Set<Linkman> linkmanSet = new HashSet<Linkman>();

    public Set<Linkman> getLinkmanSet() {
        return linkmanSet;
    }

    public void setLinkmanSet(Set<Linkman> linkmanSet) {
        this.linkmanSet = linkmanSet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", custName='" + custName + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLinkman='" + custLinkman + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custMobile='" + custMobile + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLinkman() {
        return custLinkman;
    }

    public void setCustLinkman(String custLinkman) {
        this.custLinkman = custLinkman;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }
}

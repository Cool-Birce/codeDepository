package com.gec.pojo;

import java.util.Date;

/**
 * @author Brice
 * @title: CustomerOrderMapper
 * @projectName demo03
 * @description: TODO
 * @date 2020/11/219:05
 */
public class CustomerOrder extends User {
    private Integer oid;
    private String number;
    private Date createtime;
    private String note;

    public CustomerOrder() {
    }

    public CustomerOrder(Integer oid, String number, Date createtime, String note) {
        this.oid = oid;
        this.number = number;
        this.createtime = createtime;
        this.note = note;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "CustomerOrder{"
                +"username="+this.getUsername()
                +", Id="+this.getId()
                +", Birthday="+this.getBirthday()
                +", Sex="+this.getSex()
                +", Address="+this.getAddress()+
                ", oid=" + oid +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                '}';
    }
}

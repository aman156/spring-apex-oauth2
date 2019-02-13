package com.client.app.springangular.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Contact
 */
@Entity
@Table(name="contact")
@SequenceGenerator(name="seq0", initialValue=1, allocationSize=100)
public class Contact implements Serializable{

    @Transient
    private static final long serialVersionUID = -1599229606536302407L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "seq0")
    private String id;
    private String Name;
    private String Phone;
    private String Address;

    @ManyToOne(targetEntity=Account.class)
    @JoinColumn(name = "accountId")
    private Account account;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        Phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        Address = address;
    }

    


}
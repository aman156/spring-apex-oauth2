
package com.client.app.springangular.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="account")
public class Account  implements Serializable{

    @Transient
    private static final long serialVersionUID = -2444569332826248666L;

    @Id()
    /*@GeneratedValue(strategy = GenerationType.TABLE,  generator= "seq1")
    NOT-WORKED with String primary key, only supported Long,Int datatype*/
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String firstName;
    private String lastName;
    private String accountNumber;
    
    public Account(){}
    
    public Account(String firstName,String lastName,String accountNumber)
    {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.accountNumber= accountNumber;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "["+this.getFirstName()+","+this.getLastName()+","+this.getAccountNumber()+"]";
    }
   
}

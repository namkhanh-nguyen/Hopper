package com.hopper;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Deposits the ID and submitted content in the database
 */

@Entity
public class Content{

    /**
     * GenericGenerator's strategy can be changed to refer to another class, as long as that class is a sequence generator
     * GeneratedValue's GenerationType can be changed, e.g. GenerationType.SEQUENCE
     */
    @Id
    @GenericGenerator(name = "KeyGen", strategy = "com.hopper.KeyGen")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "KeyGen")

    private String id;
    private String userInput;
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

}

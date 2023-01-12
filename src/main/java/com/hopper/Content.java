package com.hopper;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Content{
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

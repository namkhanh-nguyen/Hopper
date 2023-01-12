package com.hopper;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Content implements Key{
    @Id
    @GenericGenerator(name = "KeyGen", strategy = "com.hopper.KeyGen")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "KeyGen")
    @Column(name = "Id")

    private String id;
    private String userInput;
    private String keyOffset;
    //private String hopperKey;

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

    public String keyCreate() {
        int value = (int)Math.round((Math.random() * 10000)+1);
        String stringValue = Integer.toString(value);
        String finalKey = this.keyOffset + stringValue;
        return finalKey;
    }

    /*public String getHopperKey(){
        this.hopperKey = keyCreate();
        return this.hopperKey;
    }

    public void setHopperKey(String Offset){
        this.keyOffset = Offset;
        this.hopperKey = this.keyCreate();
    }*/

    public String getKeyOffset(){
        return keyOffset;
    }
    public void setKeyOffset(String KeyOffset){
        this.keyOffset = KeyOffset;
     }
}

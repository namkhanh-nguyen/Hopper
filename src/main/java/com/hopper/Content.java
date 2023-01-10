package com.hopper;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Content implements Key{
        @Id
        //@GenericGenerator(name = "keygen", strategy = "com.hopper.Content.setHopperKey")
        @GeneratedValue//(generator = "keygen")
        //@Column(name = "keygen")
        private Long id;
        private String userInput;
    private String keyOffset;
    private String hopperKey;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String KeyCreate() {
        int value = (int)Math.round((Math.random() * 10000)+1);
        String Stringvalue = Integer.toString(value);
        String FinalKey = this.keyOffset + Stringvalue;
        return FinalKey;
    }

    public String GetHopperkey(){
        this.hopperKey = KeyCreate();
        return this.hopperKey;
    }

    public void setHopperKey(String Offset){
        this.keyOffset = Offset;
        String NewKey = this.KeyCreate();
        this.hopperKey = NewKey;
    }

    public String getKeyOffset(){
        return keyOffset;
    }
     public void setKeyOffset(String KeyOffset){
        this.keyOffset = KeyOffset;
     }
}

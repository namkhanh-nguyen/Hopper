package com.hopper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Content implements Key{
        @Id
        @GeneratedValue
        private Long id;
        private String userInput;
    private String KeyOffset;
    private String Hopperkey;

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
        String FinalKey = this.KeyOffset + Stringvalue;
        return FinalKey;
    }

    public String GetHopperkey(){
        this.Hopperkey = KeyCreate();
        return this.Hopperkey;
    }

    public void setHopperkey(String Offset){
        this.KeyOffset = Offset;
        String NewKey = this.KeyCreate();
        this.Hopperkey = NewKey;
    }

    public String getKeyOffset(){
        return KeyOffset;
    }
     public void setKeyOffset(String KeyOffset){
        this.KeyOffset = KeyOffset;
     }
}

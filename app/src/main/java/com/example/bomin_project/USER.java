package com.example.bomin_project;

import java.io.Serializable;

public class USER implements Serializable {

    private String name;
    private String email;
    private int current_product;
    private int safety_score;

    public USER(String name, String email, int current_product, int safety_score)
    {
        this.name = name;
        this.email = email;
        this.current_product = current_product;
        this.safety_score = safety_score;
    }

    public String getName()
    {
        return name;
    }

    public int getCurrent_product()
    {
        return current_product;
    }

    public String getEmail() {return email;}

    public int getSafety_score() {return safety_score;}

    public void setName(String name) {this.name = name;}

    public void setEmail(String email) {this.email = email;}

    public void setCurrent_product(int current_product) {this.current_product = current_product;}

    public void setSafety_score(int safety_score) {this.safety_score = safety_score;}
}

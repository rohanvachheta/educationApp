
package com.example.lenovo.educationapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Action {

    @SerializedName("complate")
    @Expose
    private String complate;
    @SerializedName("incomplate")
    @Expose
    private String incomplate;

    public String getComplate() {
        return complate;
    }

    public void setComplate(String complate) {
        this.complate = complate;
    }

    public String getIncomplate() {
        return incomplate;
    }

    public void setIncomplate(String incomplate) {
        this.incomplate = incomplate;
    }

}

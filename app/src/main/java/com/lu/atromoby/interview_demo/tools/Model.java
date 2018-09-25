package com.lu.atromoby.interview_demo.tools;

import com.google.gson.Gson;

public abstract class Model{
    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

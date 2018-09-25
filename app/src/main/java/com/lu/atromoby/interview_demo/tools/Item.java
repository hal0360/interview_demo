package com.lu.atromoby.interview_demo.tools;


import com.lu.atromoby.interview_demo.models.Record;

public class Item{

    public int type;
    public String des = "";
    public Record record;

    public Item(int type, Record rec){
        this.type = type;
        this.record = rec;
    }


}

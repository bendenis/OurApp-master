package com.example.bendenisshaffer.ourapp.datamodel;

import java.util.ArrayList;

/**
 * Created by aksha on 12/13/2017.
 */

public class Space {

    public String name;
    public ArrayList<String> roommateList;

    public Space() {


    }


    public Space(String n, ArrayList<String> r) {
        name = n;
        roommateList = r;
    }

}

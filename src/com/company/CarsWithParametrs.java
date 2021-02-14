package com.company;

import java.util.TreeSet;

public class CarsWithParametrs extends Cars{
    protected String parametr;
    CarsWithParametrs(String t, String n, String m, String p) {
        super(t, n, m);
        this.parametr = p;
    }


}

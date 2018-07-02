package com.miniproject.blooddonation;

/*** Created by KISHOR K R on 3/8/2017.
 */

public class dblist {
    public int Rollno;
    public String Name;
    public String Dept;
    public int Year;
    public int Pno;
    public String BG;


    public dblist(int rno,String name,String dept,int year,int pno,String bg){
        Rollno = rno;
        Name = name;
        Dept = dept;
        Year = year;
        Pno = pno;
        BG = bg;
    }
    public int getpno(){
        return Pno;

    }
}

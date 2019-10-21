
package ba.unsa.etf.rpr.tutorijal02;

import java.util.*;



public class Interval {

    private double x1,x2;

    private boolean px1, px2;

    public Interval(double x1, double x2, boolean px1, boolean px2){

        if(x1>x2)throw new IllegalArgumentException("greska");

        this.x1=x1;

        this.x2=x2;

        this.px1=px1;

        this.px2=px2;

    }

    public Interval(){

        x1=0;

        x2=0;

        px1=false;

        px2=false;

    }

    public boolean isNull(){

        if(x1==0 && x2==0 && px1==false && px2==false)return true;

        return false;

    }

    public boolean isIn(double t){

        if((t<x1 || t>x2) || (t==x1 && px1==false) || (t==x2 && px2==false))return false;

        return true;

    }

    public static Interval intersect(Interval i1, Interval i2){

        if(i1.x1 <= i2.x1 && i2.x2 <= i1.x2) return new Interval(i2.x1, i2.x2, i2.px1, i2.px2);

        if(i2.x1 <= i1.x1 && i1.x1 <= i2.x1) return new Interval(i1.x1, i1.x2, i1.px1, i1.px2);

        if(i1.x2 >= i2.x1) return new Interval(i2.x1, i1.x2, i2.px1, i1.px2);

        if(i2.x2 >= i1.x1) return new Interval(i1.x1, i2.x2, i1.px1, i2.px2);

        return new Interval();

    }



    public Interval intersect(Interval i){

        Interval presjek=intersect(this, i);

        return presjek;

    }





    public String toString(){



        if(x1==0 && x2==0 && px1==false && px2==false) return "()";

        if(px1==true && px2==true)  return "["+x1+","+x2+"]";

        if(px1==true && px2==false) return "["+x1+","+x2+")";

         if(px1==false && px2==true)  return "("+x1+","+x2+"]";

         return  "("+x1+","+x2+")";



    }

    public boolean equals(Object o){

        Interval s=(Interval) o;

        if(this.x1==s.x1 && this.x2==s.x2 && this.px1==s.px1 && this.px2==s.px2)return true;

        return false;

    }



}
package com.notes;

public class demo2 {
String name;
int id;
demo2(String name,int id){
	this.name=name;
	this.id=id;
	
	System.out.println(name+id);
}
demo2(){
	System.out.println(name+id);
}
public static void main(String[] args) {
	demo2 d1=new demo2("sanjay",101);
//	d1.name="sanjay";
//	d1.id=101;
	System.out.println(d1.name+d1.id);
	
	demo2 d2=new demo2();
	d2.name="varun";
	d2.id=102;
	System.out.println(d2.name+d2.id);
}
}

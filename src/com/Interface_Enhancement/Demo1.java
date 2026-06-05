package com.Interface_Enhancement;

interface Dcl{
	void JFS();
	void PFS();
	
	default void mern() {
		System.out.println("mern Stack");
	}
	
	static void devops() {
		System.out.println("sushman mam handles devops");
	}
	
	
}


class yelahanka implements Dcl{

	@Override
	public void JFS() {
System.out.println("jfs at yelahanka");		
	}

	@Override
	public void PFS() {
System.out.println("pfs at yelahanka");		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mern() {

		System.out.println("nagaraj sir handles mern");
//		Dcl.super.mern();
	}
	
}




class Rajajinagar implements Dcl{

	@Override
	public void JFS() {
		System.out.println("jfs at Rajaginagar");
	}

	@Override
	public void PFS() {
		// TODO Auto-generated method stub
		System.out.println("pfs at Rajaginagar");
	}
	
}


class Btm implements Dcl{

	@Override
	public void JFS() {
		// TODO Auto-generated method stub
		System.out.println("jfs at Btm");
	}

	@Override
	public void PFS() {
		// TODO Auto-generated method stub
		System.out.println("pfs at Btm");
	}
	
}




public class Demo1 {
public static void main(String[] args) {
	
	yelahanka y=new yelahanka();
	y.JFS();
	y.PFS();
	y.mern();
	
	Rajajinagar r= new Rajajinagar();
	r.PFS();
	r.JFS();
	
	
	Btm b = new Btm();
	b.PFS();
	b.JFS();
	Dcl.devops();
	
}
	
}

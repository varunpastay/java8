package com.lamdaExpression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ex5_ {
public static void main(String[] args) {
	List<Emp> empData= DataFromDB.getAllEmps();
	
	
	//1. wap to display the names of emp if the emp fname starts with s
//	Predicate<Emp> p1=(e)->e.fname.startsWith("S");
//	for(Emp e:empData) {
//		if(p1.test(e)) {
//			System.out.println(e.fname);
//		}
//	}
	
	
	
	
//	//2. wap to get emp where sal >40000.
//	Predicate<Emp> p2=(e)->e.sal>40000;
//	for(Emp e:empData) {
//		if(p2.test(e)) {
//			System.out.println(e.fname);
//		}
//	}
	
	//3.wap to display the name, dno of the emp if the emp is working in dept 113.
//	Predicate<Emp> p3=(e)->e.dno.equals(113);
//	for(Emp e:empData) {
//		if(p3.test(e)) {
//			System.out.println(e.fname+" "+e.dno);
//		}
//	}
	
	
	
	//4.wap to display the emp fname, and lname,if the emp fname length exceeds 4.
	
//	Predicate<Emp> p4=(e)->e.fname.length()>4;
//	for(Emp e:empData) {
//		if(p4.test(e)) {
//			System.out.println(e.fname+" "+e.lname);
//		}
//	}
	
	
	
	
	//consumer
	
	
//	Consumer<String> c=(a)->System.out.println(a.length());
//	c.accept("varun");
	
//	Consumer<Emp> c=(e)->System.out.println(e);
//	c.accept(new Emp(1,"Raju","patil","abc",1000.00,12));
	
//	Supplier<Emp> s=()->empData.get(0);
//	Emp Emp_first_data=s.get();
//	System.out.println(Emp_first_data);
//	
//	
//	Supplier<String> s1=()->"Virat Kholi";
//	System.out.println(s1.get());
	
	
	Function<String,Integer> f=(name)->name.length();
	Integer len=f.apply("varun");
	System.out.println(len);
	
	
}


static class Emp{
	Integer eid;
	String fname;
	String lname;
	String job;
	Double sal;
	Integer dno;
	
	public Emp(Integer eid,String fname,String lname,String job,Double sal, Integer dno) {
		this.eid=eid;
		this.fname=fname;
		this.lname=lname;
		this.job=job;
		this.sal=sal;
		this.dno=dno;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", job=" + job + ", sal=" + sal + ", dno="
				+ dno + "]";
	}
	
	
	
}

class DataFromDB{
	public static List<Emp> getAllEmps(){
		List<Emp> eList=new ArrayList<Emp>();
		Emp e=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company_1", "root","Varun@2223");
			PreparedStatement ps=con.prepareStatement("select * from emp");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				e=new Emp(rs.getInt("eid"),rs.getString("fname"),rs.getString("lname"),rs.getString("job"),rs.getDouble("sal"),rs.getInt("dno"));
				eList.add(e);
			}
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return eList;
		
		
	}
}
}

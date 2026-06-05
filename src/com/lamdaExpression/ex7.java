package com.lamdaExpression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Emp {
	Integer id;
	String fname;
	String lname;
	String job;
	Double salary;
	Integer dno;

	public Emp(Integer id, String fname, String lname, String job, Double salary, Integer dno) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.job = job;
		this.salary = salary;
		this.dno = dno;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", fname=" + fname + ", lname=" + lname + ", job=" + job + ", salary=" + salary
				+ ", dno=" + dno + "]";
	}
}

class Dept {
	Integer dno;
	String dname;
	Integer lid;

	public Dept(Integer dno, String dname, Integer lid) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.lid = lid;
	}

	@Override
	public String toString() {
		return "Dept [dno=" + dno + ", dname=" + dname + ", lid=" + lid + "]";
	}
}

class DBConnection {
	public static Connection reqCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_1", "root", "Varun@2223");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static List<Emp> getEmp() {
		List<Emp> elist = new ArrayList();
		Emp e1 = null;
		Connection con = reqCon();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e1 = new Emp(rs.getInt("EID"), rs.getString("FNAME"), rs.getString("LNAME"), rs.getString("JOB"),
						rs.getDouble("SAL"), rs.getInt("DNO"));
				elist.add(e1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elist;
	}

	public static List<Dept> getDept() {

		List<Dept> dlist = new ArrayList();
		Connection con = reqCon();
		Dept d = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_1", "root", "Varun@2223");
			PreparedStatement sp = con.prepareStatement("Select * from dept");
			ResultSet rs = sp.executeQuery();
			while (rs.next()) {
				d = new Dept(rs.getInt(1), rs.getString(2), rs.getInt(3));
				dlist.add(d);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlist;
	}
}

public class ex7 {
	public static void main(String[] args) {

//		System.out.println(args.length);
//		System.out.println(args[0]);

		List<Emp> elist = DBConnection.getEmp();
		List<Dept> dlist = DBConnection.getDept();

		// 1.wap to display the data employees who is working as salesman;
		System.out.println("--1. All Salesman--");
		elist.stream()  // create the stream
		     .filter(n -> n.job.equalsIgnoreCase("salesman"))  // filter salesman record
		     .forEach(System.out::println);  // Iterate through the list collection

		System.out.println("\n--2. 112 Dno details--");
		elist.stream()
		     .filter(e -> e.dno == 112 )
		     .forEach(System.out::println);
		
		System.out.println("\n--3. Not ceo's--");
		elist.stream()
		     .filter(e -> !e.job.equalsIgnoreCase("ceo"))
		     .forEach(System.out::println);
		
		System.out.println("\n--4. Sal > 45000--");
		elist.stream()
		     .filter(e -> e.salary > 45000)
		     .forEach(System.out::println);
		
		System.out.println("\n--5. Name starts with s--");
		elist.stream()
		     .filter(e -> e.fname.toLowerCase().startsWith("s"))
		     .forEach(System.out::println);
		
		System.out.println("\n--.6 Job role name starts with d--");
		elist.stream()
		     .filter(e -> e.job.toLowerCase().startsWith("d"))
		     .forEach(System.out::println);
		
		System.out.println("\n--.7 emp working is Salesman or Manager--");
		elist.stream()
		     .filter(e -> e.job.equalsIgnoreCase("salesman") 
		    		 || e.job.equalsIgnoreCase("manager"))
		     .forEach(System.out::println);
		
		System.out.println("\n--.8 emp  40000 < sal < 100000 --");
		elist.stream()
		     .filter(e -> e.salary > 40000 && e.salary < 100000)
		     .forEach(System.out::println);
		
		System.out.println("\n--9. name ends with I or Y--");
		elist.stream()
		     .filter(e -> e.lname.toLowerCase().endsWith("i") 
		    		 || e.lname.toLowerCase().endsWith("y"))
		     .forEach(System.out::println);
		
		System.out.println("\n--.10 emp working is Salesman or Manager in dept 110 or 111--");
		elist.stream()
		     .filter(e -> (e.job.equalsIgnoreCase("salesman") 
		    		 || e.job.equalsIgnoreCase("manager"))
	                 && (e.dno == 110 || e.dno == 111))
		     .forEach(System.out::println);
		
		System.out.println("\n--11. emp's sal > 35000");
		Stream<Emp> s1 = elist.stream();
		Consumer<Emp> c = System.out::println;
		Predicate<Emp> p = (e) -> e.salary > 35000 ;
		Stream<Emp> s2 = s1.filter(p);
		s2.forEach(c);
		
		System.out.println("\n-- Annual Salary --");
		Function<Emp, Double> f = e -> e.salary * 12;
		elist.stream()
		     .forEach(e -> System.out.println(f.apply(e)));
		
		System.out.println("\n-- Employee Full Name --");
		Function<Emp, String> f1 =
		        e -> e.fname + " " + e.lname;
		elist.stream()
		     .forEach(e -> System.out.println(f1.apply(e)));
		
		
		
//		System.out.println("--.10 emp working is Salesman or Manager in dept 110 or 111--");
//		elist.stream()
//		     .filter(e -> e.salary > 35000)
//		     .forEach(System.out::println);
		
		
		
		//11.WRITE A PROG TO DISPLAY detailes OF EMP IF THE EMP sal>35000
		
		System.out.println("-------11---------");
		elist.stream()
		.filter(e->e.salary>35000)
		.forEach(System.out::println);
		
//		12.WRITE A PROG TO DISPLAY YHE NAMES OF EMP IF THE EMP FIRST NAME STARTS WITH S
		
		System.out.println("-------12---------");
		elist.stream()
		.filter(e->e.fname.startsWith("S"))
		.forEach(e->System.out.println(e.fname));
		//or
//		elist.stream()
//		.filter(e->e.fname.startsWith("S"))
//		.map(e->e.fname.toUpperCase())
//		.forEach(System.out::println);
		
		//13.waptd the name and sal of emp if the emp is getting sal
		//more than 50000
		System.out.println("----------13-----------");
		elist.stream()
		.filter(e->e.salary>50000)
		.map(e->(e.fname+" "+e.salary))
		.forEach(System.out::println);

		
		//14.waptd the name ,job,dept no,if the emp is working
		//as developer or tester in dept 113
		
		System.out.println("-----------14---------");
		elist.stream()
			.filter(e->e.job.equalsIgnoreCase("Developer")||e.job.equalsIgnoreCase("Tester") && e.dno==113)
			.map(e->(e.fname+" "+e.job+" "+e.dno))
			.forEach(System.out::println);
		
		//15.waptd the full name of  emps
		System.out.println("--------15--------");
		elist.stream()
		.map(e->(e.fname+" "+e.lname))
		.forEach(System.out::println);
		
		//16. waptd the emp fullname int the below format
		//siddarth patil->siddarth.p
		System.out.println("--------------16---------");
		elist.stream()
		.map(e->(e.fname+"."+e.lname.charAt(0)))
		.forEach(System.out::println);
		
		
		//17.waptd the first half of fname
		System.out.println("----------17-----------");
		elist.stream()
		.map(e->e.fname.substring(0, e.fname.length()/2))
		.forEach(System.out::println);
		
		//18.waptd the fname and lname if the length of fname exceeds 5 characters
		System.out.println("-----------18----------");
		elist.stream()
		.filter(e->e.fname.length()>5)
		.map(e->(e.fname+" "+e.lname))
		.forEach(System.out::println);
		
		//19.waptd all the job roles from empdata
		System.out.println("--------------19-----------");
		elist.stream()
		.map(e->e.job)
		.distinct()
		.forEach(System.out::println);
		
		//20.waptd the different dept available in emp data
		System.out.println("-----------20----------");
		elist.stream()
		.map(e->e.dno)
		.distinct()
		.forEach(System.out::println);
		
		
		//21.waptd the fname, lname,and salary,if the emp is working
		//as salesman or manager
		System.out.println("-----------21----------");
		elist.stream()
		.filter(e->(e.job.equals("Salesman")||e.job.equals("Manager")))
		.map(e->(e.fname+" "+e.lname+" "+e.salary))
		.forEach(System.out::println);
		
		
		//22.waptd the first 5 emp data from emplist
		System.out.println("--------------22------------");
		elist.stream()
		.limit(5)
		.forEach(System.out::println);
		
		
		//23.waptd the first 4 emp fname
		System.out.println("----------------23-----------");
		elist.stream()
		.limit(4)
		.map(e->e.fname)
		.forEach(System.out::println);
		
		//24.waptd the 4th emp data
		System.out.println("--------24---------");
		elist.stream()
		.skip(3)
		.limit(1)
		.forEach(System.out::println);
		
		//25.waptd the first 10 records
		System.out.println("-----------25----------");
		elist.stream()
		.limit(10)
		.forEach(System.out::println);
		
		//26.waptd the 7th emp data
		System.out.println("---------------26----------");
		elist.stream()
		.skip(6)
		.limit(1)
		.forEach(System.out::println);
		
		//27.waptd the 8th and 9th emp data
		System.out.println("---------------27----------");
		elist.stream()
		.skip(7)
		.limit(2)
		.forEach(System.out::println);
		
		//28.waptd the first 3 emp data which has even id
		System.out.println("---------------28----------");
		elist.stream()
		.filter(e->(e.id%2==0))
		.limit(3)
		.forEach(System.out::println);
		
		//29.waptd the emp records based on salary 
		//from min to max
		
		System.out.println("------------29-------");
		elist.stream()
		.sorted(Comparator.comparing(e->e.salary))
		.forEach(System.out::println);
		
		
		//30. waptd the emp records in alphebatic order
		System.out.println("------30----------");
		elist.stream()
		.sorted(Comparator.comparing(e->e.fname))
		.map(e->(e.fname))
		.forEach(System.out::println);
		
		//31.waqtd the emp sal in descending order
		System.out.println("----31----");
		elist.stream()
			.sorted(Comparator.comparing((Emp e)->e.salary).reversed())
			.map(e->e.salary)
			.forEach(System.out::println);
		
		
		//32.waptd the last 4 records from emp list
		System.out.println("----------32------");
		elist.stream()
		.sorted(Comparator.comparing((Emp e)->e.id).reversed())
		.limit(4)
		.forEach(System.out::println);
		
		
		//33.waptd the 2nd max salary from emp list
		System.out.println("----------33------");
		elist.stream()
		.sorted(Comparator.comparing((Emp e)->e.salary).reversed())
		.distinct()
		.skip(1)
		.limit(1)
		.map(e->e.salary)
		.forEach(System.out::println);
		
		
		//34.waptd the 3rd min salary from emp list
		System.out.println("----------34------");
		elist.stream()
		.sorted(Comparator.comparing((Emp e)->e.salary))
		.map(e->e.salary)
		.distinct()
		.skip(2)
		.limit(1)
		.forEach(System.out::println);
		
		//35.waptd the no of sales man in the list
		System.out.println("---------35----------");
		long salesman_count=elist.stream()
								.filter(e->e.job.equals("Salesman"))
								.count();
		System.out.println(salesman_count);
		
		//36 . waptd the no of emp whose fname starts with s or k
		System.out.println("----------36---------");
		long fname_count=elist.stream()
				.filter(e->e.fname.charAt(0)=='E' ||e.fname.charAt(0)=='K')
				.count();
		System.out.println(fname_count);
		
		
		
		//37.waptd the no of different job roles available in emp records
		System.out.println("----------37---------");
		long jobrole_count= elist.stream()
				.map(e->e.job)
				.distinct()
				.count();
		System.out.println(jobrole_count);
		
		//38.waptd the no of dept available in dept list
		
		System.out.println("----------38---------");
		long dept_count=elist.stream()
				.map(e->e.dno)
				.distinct()
				.count();
		System.out.println(dept_count);
		
		
	}

}
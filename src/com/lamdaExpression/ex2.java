package com.lamdaExpression;

public class ex2 {
	
	interface Addition{
		int add(int a,int b);
	}
	
//	static class imp implements Addition{
//	@Override
//	public int add(int a, int b) {
//		int sum=a+b;
//		return sum;
//	}
//	}
	public static void main(String[] args) {
//		Addition res=new imp();
//		System.out.println(res.add(10,20));
//		lamda expression
	Addition sum=(a,b)->a+b;
	System.out.println(sum.add(10,20));
	}
	
}

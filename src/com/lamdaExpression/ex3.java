package com.lamdaExpression;

public class ex3 {

	interface EvenOdd {
		String check(int a);
	}

	public static void main(String[] args) {
		EvenOdd res=(a)->(a%2==0)?"even":"odd";
			
		System.out.println(res.check(10));
	}

}

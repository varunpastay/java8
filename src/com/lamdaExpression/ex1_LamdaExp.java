package com.lamdaExpression;

public class ex1_LamdaExp {

	
	//FUNCTIONAL INTERFACE
//    interface demo {
//        int findLength(String a);
//    }
//
//    static class imp implements demo {
//
//        @Override
//        public int findLength(String a) {
//            int length = a.length();
//            return length;
//        }
//    }
//
//    public static void main(String[] args) {
//
//        demo d = new imp();
//
//        System.out.println(d.findLength("varun"));
//    }
	
	
	//LAMDA EXPRESSION
	interface demo{
		int findLength(String a);
	}
	
	public static void main(String[] args) {
		demo d=(a)->a.length();
		System.out.println(d.findLength("varun"));
	}
}
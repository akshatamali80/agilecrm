package com.agilecrm.pages;

public class Testing {

	public static void main(String[] args) {

		SoftwareTesting obj = new SoftwareTesting() {

			public void addition(int a, int b) {
				System.out.println(a + b);

			}

			public void substraction(int a, int b) {
				System.out.println(a - b);

			}

			public void multiplication(int a, int b) {
				System.out.println(a * b);

			}

			public void division(int a, int b) {
				System.out.println(a / b);

			}

		};
		obj.addition(100, 100);
		obj.substraction(300, 100);
		obj.multiplication(40, 5);
		obj.division(1000, 5);

	}

}

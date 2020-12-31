package com.Controller;

import java.util.Random;

public class GeneratePassword {

	public static String generatePassword() {
		String contain = "abcdefghijklmnopqrstuvwxyz@#$%&ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuilder stringbuilder = new StringBuilder(6);
		for (int i = 0; i < 6; i++) {
			stringbuilder.append(contain.charAt(random.nextInt(contain.length())));
		}
		String password = stringbuilder.toString();
		contain = "1234567890";
		random = new Random();
		stringbuilder = new StringBuilder(2);
		for (int i = 0; i < 2; i++) {
			stringbuilder.append(contain.charAt(random.nextInt(contain.length())));
		}
		password += stringbuilder.toString();
		
		System.out.println(password);
		return password;
	}

	public static void main(String[] args) {
		System.out.println(generatePassword());
	}

}

package com.Controller;

import java.util.Random;

public class GeneratePassword {

	public static String generatePassword() {
		String contain = "abcdefghijklmnopqrstuvwxyz@#$%&1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuilder stringbuilder = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			stringbuilder.append(contain.charAt(random.nextInt(contain.length())));
		}
		String password = stringbuilder.toString();
		System.out.println(password);
		return password;
	}

	public static void main(String[] args) {
		System.out.println(generatePassword());
	}

}

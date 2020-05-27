package com.wilkom.udemycourses.restfultodowebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for (int i=1; i<=6; i++) {
			String encodedStr = encoder.encode("koffi");
			System.out.println(encodedStr);
		}

	}

}

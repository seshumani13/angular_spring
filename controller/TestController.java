package com.hcltss.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TestController {
 @Override
	public String toString() {
		System.out.println("indside controlelr");
		return "Inside controlelr to stsring method";
	}


}

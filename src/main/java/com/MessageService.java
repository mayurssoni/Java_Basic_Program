package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageService {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	@GetMapping("/user")
	public String user() {
		return "Mayur";
	}
	@GetMapping("/leap/{year}")
	public boolean isLeap(@PathVariable int year) {
	if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % 400 == 0)
                    return true;
                else
                    return false;
            }
            else
		return true;
        }
        else {
            return false;
        }	
	}
	@GetMapping("/sum/{one}/{two}")
	public int sum(@PathVariable int one, @PathVariable int two) {
	return one+two;
	}	
}

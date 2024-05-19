package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Random;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleService {
	
	@GetMapping("/sign/{number}")
	public String checkSign(@PathVariable int number) {
	if(number > 0)
        {
		return number+" is positive number";
        }
	else if(number < 0){
		return number+" is negative number";	
	}
        else {
            return number+" is neither positive nor negative";
        }	
	}
	
	@GetMapping("/random/{a}-{b}")
        public String generateRandom(@PathVariable int a, @PathVariable int b) {
	int max,min;
	if(a > b){
		max=a;
		min=b;
	}else if(b > a){
		max=b;
		min=a;
	}else{
		return "Random Number not possible";
	}

	Random rand=new Random();
	int randomNum = rand.nextInt((max - min) + 1) + min;

	return "Your Random Number is "+randomNum;
	}
	
	@GetMapping("/GCD/{p},{q}")
        public String calcGCD(@PathVariable int p,@PathVariable int q) {
	int gcd = 1;
	for(int i = 1; i <= p && i <= q; i++)
        {
            if(p%i==0 && q%i==0)
                gcd = i;
        }
	return "GCD of " + p + " and " + q + " is: " + gcd;
        }

        @GetMapping("/area/circle/r={r}")
        public String areaCircle(@PathVariable double r) {
	return "The area of circle is: " + Math.PI * (r * r);
	}

        @GetMapping("/area/square/side={l}")
        public String areaSquare(@PathVariable double l) {
	return "Area of Square is: " + l * l;
        }

	
}

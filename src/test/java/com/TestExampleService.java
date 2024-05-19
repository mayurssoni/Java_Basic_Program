package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ExampleService;

@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = Application.class)

@SpringBootTest
public class TestExampleService {
	ExampleService es = new ExampleService();
        
	@Test
        public void testSign() {
                Assertions.assertEquals(es.checkSign(22), "22 is positive number");
        }
	
	@Test
        public void testSign1() {
                Assertions.assertEquals(es.checkSign(-22), "-22 is negative number");
        }
	
	@Test
        public void testSig2() {
                Assertions.assertEquals(es.checkSign(0), "0 is neither positive nor negative");
        }

	@Test
        public void testGCD() {
                Assertions.assertEquals(es.calcGCD(5,45), "GCD of 5 and 45 is: 5");
        }

	@Test
        public void testAreaSquare() {
                Assertions.assertEquals(es.areaSquare(10), "Area of Square is: 100.0");
        }

        @Test
        public void testAreaCircle() {
                Assertions.assertEquals(es.areaCircle(4), "The area of circle is: 50.26548245743669");
        }

//	@Test
//        public void testRandom() {
//                Assertions.assertTrue("Error, random is too high", 70 >= es.generateRandom(5,70).random);
//        }
	
}

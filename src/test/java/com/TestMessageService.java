import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.MessageService;

@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = Application.class)

@SpringBootTest(classes={com.MessageService.class})
public class TestMessageService {

        @Test
        public void testMessage() {
                MessageService ms = new MessageService();
                System.out.println("hello");
                Assertions.assertEquals(ms.sayHello(), "hello");
        }
	
	@Test
	public void testUser() {
		MessageService ms = new MessageService();
                Assertions.assertEquals(ms.user(), "Mayur");
	}
	
	@Test
	public void testyear() {
		MessageService ms= new MessageService();
		Assertions.assertEquals(ms.isLeap(2016), true);
	}
	
	@Test
        public void testyear2() {
                MessageService ms= new MessageService();
                Assertions.assertEquals(ms.isLeap(2100), false);
        }
	
	@Test
	public void sumtest() {
		MessageService ms= new MessageService();
                Assertions.assertEquals(ms.sum(4,5), 9);
	}
}

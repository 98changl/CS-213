package project4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {
	
	@Test
	void addTest1() {
		Sandwich sandwich = new Chicken();
		OrderLine line = new OrderLine(1, sandwich);
		Order order = new Order(1);
		assertEquals(order.add(line), true);
	}

	@Test
	void addTest2() {
		Sandwich sandwich = new Chicken();
		Order order = new Order(1);
		assertEquals(order.add(sandwich), false);
	}
	
	@Test
	void removeTest1() {
		Sandwich sandwich = new Chicken();
		OrderLine line = new OrderLine(1, sandwich);
		Order order = new Order(1);
		order.add(line);
		assertEquals(order.remove(line), true);
	}
	
	@Test
	void removeTest2() {
		Sandwich sandwich = new Chicken();
		OrderLine line = new OrderLine(1, sandwich);
		Order order = new Order(1);
		assertEquals(order.remove(line), false);
	}
	
	@Test 
	void clearTest() {
		Sandwich sandwich = new Chicken();
		OrderLine line = new OrderLine(1, sandwich);
		Order order = new Order(1);
		order.add(line);
		order.clear();
		assertEquals(order.size(), 0);
	}
}

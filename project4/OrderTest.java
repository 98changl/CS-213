package project4;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {
	
	@Test 
	void lineNumber() {
		Order.lineNumber++;
		assertEquals(Order.lineNumber, 1);
	}
	
	@Test
	void addTest1() {
		Order order = new Order();
		assertEquals(order.add(new OrderLine(Order.lineNumber, new Chicken())), true);
	}

	@Test
	void addTest2() {
		Sandwich sandwich = new Chicken();
		Order order = new Order();
		assertEquals(order.add(sandwich), false);
	}
	
	@Test
	void removeTest1() {
		Sandwich sandwich = new Chicken();
		OrderLine line = new OrderLine(Order.lineNumber, sandwich);
		Order order = new Order();
		order.add(line);
		assertEquals(order.remove(line), true);
	}
	
	@Test
	void removeTest2() {
		Sandwich sandwich = new Chicken();
		OrderLine line = new OrderLine(Order.lineNumber, sandwich);
		Order order = new Order();
		assertEquals(order.remove(line), false);
	}
	
	@Test
	void removeTest3() {
		Order order = setupOrder();
		assertEquals(order.remove(new OrderLine(1, new Chicken())), true);
	}
	
	@Test
	void sizeTest() {
		Order order = setupOrder();
		assertEquals(order.size(), 3);
		order.remove(new OrderLine(1, new Chicken()));
	}
	
	@Test 
	void clearTest1() {
		Sandwich sandwich = new Chicken();
		OrderLine line = new OrderLine(Order.lineNumber, sandwich);
		Order order = new Order();
		order.add(line);
		order.clear();
		assertEquals(order.size(), 0);
	}
	
	@Test 
	void clearTest2() {
		Sandwich sandwich = new Chicken();
		OrderLine line = new OrderLine(Order.lineNumber, sandwich);
		Order order = new Order();
		order.add(line);
		order.clear();
		assertEquals(Order.lineNumber, 0);
	}
	
	@Test
	void getOrderLineTest() {
		Order order = setupOrder();
		
	}
	
	@Test
	void getTest() {
		
	}
	
	private Order setupOrder() {
		Order order = new Order();
		order.add(new OrderLine(Order.lineNumber, new Chicken()));
		order.add(new OrderLine(Order.lineNumber, new Beef()));
		order.add(new OrderLine(Order.lineNumber, new Fish()));
		
		return order;
	}
}

package main.java.com.github.jmaillard.mockito.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

	@Mock
	Product product1;

	@Mock
	Product product2;

	@Test
	public void should_return_the_correct_total_price() throws Exception {
		// GIVEN
		Mockito.when(product1.getPrice()).thenReturn(new BigDecimal("3.99"));
		Mockito.when(product2.getPrice()).thenReturn(new BigDecimal("5.00"));

		// WHEN
		List<Product> products = new ArrayList<Product>();
		products.add(product1);
		products.add(product2);
		Order order = new Order(products);

		// THEN
		BigDecimal actual = order.getTotalPrice();
		BigDecimal expected = new BigDecimal("8.99");
		assertEquals(expected, actual);
	}

	@Test
	public void should_format_total_price() throws Exception {
		Order order = new Order(new ArrayList<Product>());
		order.formatTotalPrice(new Locale("fr"));

		// THEN
		Mockito.verify(order).getTotalPrice();
	}
}

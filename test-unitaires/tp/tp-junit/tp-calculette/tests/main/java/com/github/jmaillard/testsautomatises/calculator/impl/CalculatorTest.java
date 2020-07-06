package main.java.com.github.jmaillard.testsautomatises.calculator.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calculator;

	@Before
	public void initialize() {
		calculator = new Calculator();
	}

	@Test()
	public void should_return_5_if_I_add_2_and_3() {
		int expected = 5;
		int actual = calculator.sum(2, 3);

		assertEquals(expected, actual);
	}

	@Test
	public void should_return_minus_1_if_I_add_2_and_minus_3() {
		int expected = -1;
		int actual = calculator.sum(2, -3);

		assertEquals(expected, actual);
	}

	@Test
	public void should_return_minus_1_if_I_substract_3_to_2() {
		int expected = -1;
		int actual = calculator.minus(2, 3);

		assertEquals(expected, actual);
	}

	@Test
	public void should_return_5_if_I_substract_minus_3_to_2() {
		int expected = 5;
		int actual = calculator.minus(2, -3);

		assertEquals(expected, actual);
	}

	@Test
	public void should_return_5_if_I_divide_10_by_5() {
		int expected = 5;
		int actual = calculator.divide(10, 2);

		assertEquals(expected, actual);
	}

	@Test(expected = ArithmeticException.class)
	public void should_return_an_error_if_I_divide_10_by_0() {
		calculator.divide(10, 0);
	}

	@Test
	public void should_return_6_if_I_multiply_2_by_3() {
		int expected = 6;
		int actual = calculator.multiply(2, 3);

		assertEquals(expected, actual);
	}

	@Test
	public void should_return_0_if_I_multiply_2_by_0() {
		int expected = 0;
		int actual = calculator.multiply(2, 0);

		assertEquals(expected, actual);
	}
}

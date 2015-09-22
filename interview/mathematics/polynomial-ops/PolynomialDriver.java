package com.interview;

import java.util.ArrayList;
import java.util.List;

public class PolynomialDriver {
	public static void main(String[] args) {
		PolynomialDriver driver = new PolynomialDriver();
		List<PolynomialNode> polynomial1 = driver.preparePolynomial(new int[] { 3, 2, 1, 0 },
				new float[] { 4, 2, 12, 5 });
		List<PolynomialNode> polynomial2 = driver.preparePolynomial(new int[] { 2, 1, 0 }, new float[] { 1, 2, 6 });
		PolynomialOperation operation = new PolynomialOperation();
		operation.printPolynomial(polynomial1);
		operation.printPolynomial(polynomial2);
		List<PolynomialNode> addPolynomials = operation.addPolynomials(polynomial1, polynomial2);
		operation.printPolynomial(addPolynomials);
		List<PolynomialNode> subtractPolynomials = operation.subtractPolynomials(polynomial1, polynomial2);
		operation.printPolynomial(subtractPolynomials);
		List<PolynomialNode> multiplyPolynomials = operation.multiplyPolynomials(polynomial1, polynomial2);
		operation.printPolynomial(multiplyPolynomials);
	}

	private List<PolynomialNode> preparePolynomial(int[] powers, float[] coefficients) {
		List<PolynomialNode> polynomial = new ArrayList<PolynomialNode>();
		PolynomialNode n = null;
		for (int i = 0; i < powers.length; i++) {
			n = new PolynomialNode(coefficients[i], powers[i]);
			polynomial.add(n);
		}

		return polynomial;
	}
}

package com.interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class PolynomialOperation {

	public List<PolynomialNode> addPolynomials(List<PolynomialNode> polynomial1, List<PolynomialNode> polynomial2) {
		List<PolynomialNode> result = addOrSubtract(polynomial1, polynomial2, true);
		return result;
	}

	public List<PolynomialNode> subtractPolynomials(List<PolynomialNode> polynomial1, List<PolynomialNode> polynomial2) {
		List<PolynomialNode> result = addOrSubtract(polynomial1, polynomial2, false);
		return result;
	}

	public List<PolynomialNode> multiplyPolynomials(List<PolynomialNode> polynomial1, List<PolynomialNode> polynomial2) {
		List<PolynomialNode> result = multiply(polynomial1, polynomial2);
		return result;
	}

	public void printPolynomial(List<PolynomialNode> p1) {
		float coefficient = 0.0f;
		int count = 0;
		for (PolynomialNode p : p1) {
			coefficient = p.coefficient;
			if (count > 0)
				System.out.print(coefficient >= 0 ? " + " : " - ");
			if (coefficient < 0)
				coefficient *= -1;
			System.out.print(coefficient + (p.power > 0 ? "x^" + p.power : ""));
			count++;
		}
		System.out.println();
	}

	private List<PolynomialNode> multiply(List<PolynomialNode> p1, List<PolynomialNode> p2) {
		if (p1 == null || p2 == null)
			return null;

		LinkedHashMap<Integer, PolynomialNode> map = new LinkedHashMap<Integer, PolynomialNode>();
		PolynomialNode n1 = null;
		PolynomialNode n2 = null;
		PolynomialNode n = null;
		int sumPower = 0;
		for (int i = 0; i < p1.size(); i++) {
			n1 = p1.get(i);
			for (int j = 0; j < p2.size(); j++) {
				n2 = p2.get(j);
				if (n1.coefficient != 0 && n2.coefficient != 0) {
					sumPower = n1.power + n2.power;
					n = map.get(sumPower);
					if (n == null) {
						n = new PolynomialNode(0, sumPower);
					}
					n.coefficient += n1.coefficient * n2.coefficient;
					map.put(sumPower, n);
				}
			}
		}

		List<PolynomialNode> resultantPolynomial = new ArrayList<PolynomialNode>();
		for (Entry<Integer, PolynomialNode> entry : map.entrySet()) {
			resultantPolynomial.add(entry.getValue());
		}

		return resultantPolynomial;
	}

	private List<PolynomialNode> addOrSubtract(List<PolynomialNode> p1, List<PolynomialNode> p2, boolean add) {
		List<PolynomialNode> resultantPolymial = null;
		if (p1 == null || p2 == null)
			return null;
		else {
			resultantPolymial = new ArrayList<PolynomialNode>();
			int i = 0, j = 0;
			PolynomialNode n = null;
			PolynomialNode pNode1 = null;
			PolynomialNode pNode2 = null;
			while (i < p1.size() && j < p2.size()) {
				pNode1 = p1.get(i);
				pNode2 = p2.get(j);
				if (p1.get(i).power == p2.get(j).power) {
					n = result(pNode1, pNode2, add);
					i++;
					j++;
				} else if (p1.get(i).power > p2.get(j).power) {
					n = result(pNode1, null, add);
					i++;
				} else {
					n = result(null, pNode2, add);
					j++;
				}
				resultantPolymial.add(n);
			}
			return resultantPolymial;
		}
	}

	private PolynomialNode result(PolynomialNode pNode1, PolynomialNode pNode2, boolean add) {
		PolynomialNode resultNode = null;
		if (pNode1 != null && pNode2 != null) {
			if (add) {
				resultNode = new PolynomialNode(pNode1.coefficient + pNode2.coefficient, pNode1.power);
			} else {
				resultNode = new PolynomialNode(pNode1.coefficient - pNode2.coefficient, pNode1.power);
			}
		} else if (pNode1 == null) {
			if (add) {
				resultNode = new PolynomialNode(pNode2.coefficient, pNode2.power);
			} else {
				resultNode = new PolynomialNode(-1 * pNode2.coefficient, pNode2.power);
			}
		} else {
			resultNode = new PolynomialNode(pNode1.coefficient, pNode1.power);
		}
		return resultNode;
	}
}

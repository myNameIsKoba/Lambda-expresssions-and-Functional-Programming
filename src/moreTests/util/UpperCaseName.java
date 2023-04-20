package moreTests.util;

import java.util.function.Function;

import application.entities.Product2;

public class UpperCaseName implements Function<Product2, String>{

	@Override
	public String apply(Product2 p) {
		return p.getName().toUpperCase();
	}

}

package moreTests.util;

import java.util.function.Predicate;

import application.entities.Product2;

/**
 * Interface functional
 * @author User
 * obs: Classes que servem apenas de exemplo
 */
public class PredicateProduct implements Predicate<Product2>{

	@Override
	public boolean test(Product2 p) {
		return p.getPrice().intValue() >= 100.0;
	}

}

package moreTests.util;

import java.math.BigDecimal;
import java.util.function.Consumer;

import application.entities.Product2;

public class PriceUpdate implements Consumer<Product2>{

	@Override
	public void accept(Product2 p) {
		
		p.setPrice(p.getPrice().multiply(new BigDecimal("1.1")));
	}	
}

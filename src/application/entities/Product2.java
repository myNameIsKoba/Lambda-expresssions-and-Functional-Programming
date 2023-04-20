package application.entities;

import java.math.BigDecimal;

public class Product2 {

	private String name;
	private BigDecimal price;
	
	public Product2() {}
	
	public Product2(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public static boolean staticPredicateProduct(Product2 p) {
		return p.getPrice().doubleValue() >= 100;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean nonStaticPredicateProduct() {
		return this.price.doubleValue() >= 100;
	}
	
	/**
	 * 
	 * @param p
	 */
	public static void staticPriceUpdate(Product2 p) {
		p.setPrice(p.getPrice().multiply(new BigDecimal("1.1")));
	}

	/**
	 * 
	 */
	public void nonStaticPriceUpdate() {
		this.price.multiply(new BigDecimal("1.1"));
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public static String staticUpperCase(Product2 p) {
		return p.getName().toUpperCase(); 
	}
	
	/**
	 * 
	 * @return
	 */
	public String nonStaticUpperCase() {
		return this.name.toUpperCase(); 
	}
}

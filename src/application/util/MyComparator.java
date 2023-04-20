package application.util;

import java.util.Comparator;

import application.entities.Product2;

/**
 * Classe usada para o comparator
 * @author User
 *
 */
public class MyComparator implements Comparator<Product2>{

	@Override
	public int compare(Product2 p1, Product2 p2) {
		// TODO Auto-generated method stub
		return p1.getName()
				.toUpperCase()
				.compareTo(p2.getName().toUpperCase());
	}

}

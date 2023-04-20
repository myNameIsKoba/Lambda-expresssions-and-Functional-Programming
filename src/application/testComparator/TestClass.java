package application.testComparator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import application.entities.Product2;

/**
 * Demosntração de expressão lambda
 * @author User
 *
 */
public class TestClass {

	public static void test1() {
		
		List<Product2> list = new ArrayList<>();
		
		list.add(new Product2("TV", new BigDecimal("444.55")));
		list.add(new Product2("Notebook", new BigDecimal("2000.33")));
		list.add(new Product2("BigPatinete", new BigDecimal("6969.69")));
		
//		Collections.sort(list); // <- ao inves disso temos isso v
//		list.sort(new MyComparator());
		
		//Conceito de Classe anônima (outra solução)
//		Comparator<Product2> comp = new Comparator<Product2>() {
//
//			@Override
//			public int compare(Product2 p1, Product2 p2) {
//				return p1.getName()
//						.toUpperCase()
//						.compareTo(p2.getName().toUpperCase());
//			}
//		};
		
		//Metodo de Expressão-Lambda ["->"] (Expressão anônima) ou arrow function
//		Comparator<Product2> comp = (p1, p2) -> {
//			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//		};
		
		//Metodo de Expressão-Lambda melhorado
//		Comparator<Product2> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());												
//
//		list.sort(comp);
		
		//Metodo de Expressão-Lambda mais resumido (e melhor)
		list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		for(Product2 p : list) {
			System.out.println(p);
		}
	}
}

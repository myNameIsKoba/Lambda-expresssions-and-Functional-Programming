package application.entities.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

import application.entities.Product2;


/**
 * Dicas de manutençao
 * @author User
 *
 */
public class ProductService {

	public BigDecimal somaFiltrada(List<Product2> list, Predicate<Product2> criterio) {
		BigDecimal soma = new BigDecimal("0.0");
		
		for (Product2 p : list) {
//			if(p.getName().charAt(0) == 'T')
//				soma = soma.add(p.getPrice());
			if(criterio.test(p))
				soma = soma.add(p.getPrice());
		}
		
		return soma;
	}
}

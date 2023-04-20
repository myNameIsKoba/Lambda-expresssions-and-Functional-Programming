package moreTests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import application.entities.Product2;
import application.entities.service.ProductService;

/**
 * Exemplo de classe que não é referencialmente transparente
 * 
 * @author User
 * obs: testes pequenos estarão disponiveis por aqui por classes externas
 */
public class OtherTests {

	protected static int globalValue = 10;

	public static void test1() {

		int[] vect = new int[] { 3, 4, 5 };
		changeOddValues(vect);
		System.out.println(Arrays.toString(vect));
	}

	protected static void changeOddValues(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 != 0) {
				numbers[i] += globalValue;
			}
		}
	}
	
	/// Exemplos de operações lambda nas classes abaixo
	public static void test2() {
		InnerClass1.test2();
	}
	
	public static void test3() {
		InnerClass2.test();
	}
	
	public static void test4() {
		InnerClass3.test();
	}
	
	public static void test5() {
		InnerClass4.test();
	}
	
	public static void test6() {
		InnerClass5.test();
	}
	
	/// Streams
	public static void test7() {
		InnerClass6.test();
	}
	
	/// Pipelines
	public static void test8() {
		InnerClass7.test();
	}
}

/**
 * Mais exeplos de programação funcional
 * @author User
 *
 */
class InnerClass1 {

	private static int compareProducts(Product2 p1, Product2 p2) {
		return p1.getPrice().compareTo(p2.getPrice());
	}

	public static void test2() {

		List<Product2> list = new ArrayList<>();

		list.add(new Product2("TV", new BigDecimal("444.55")));
		list.add(new Product2("Notebook", new BigDecimal("2000.33")));
		list.add(new Product2("BigPatinete", new BigDecimal("6969.69")));
		
		// refeferencia para a função 'compareProducts'
		list.sort(InnerClass1::compareProducts);

		// função como.. argumento de outra função..?
		list.forEach(System.out::println);
	}
	
	public static void test3() {
		
		List<Product2> list = new ArrayList<>();
		
		list.add(new Product2("TV", new BigDecimal("444.55")));
		list.add(new Product2("Notebook", new BigDecimal("2000.33")));
		list.add(new Product2("BigPatinete", new BigDecimal("6969.69")));
		
//		Integer sum=0;
//		for(Integer i : list) {
//			sum += i;
//		}
		
//		Integer soma = list.stream().reduce(0, Integer::sum);
	}
}

/**
 * Predicate<T>
 * 
 * Fazer um programa que, a partir de uma lista de produtos, remova da
	lista somente aqueles cujo preço mínimo seja 100.
 * 
 */
class InnerClass2{
	
	protected static void test() {
		List<Product2> list = new ArrayList<>();
		
		list.add(new Product2("TV", new BigDecimal("444.55")));
		list.add(new Product2("Notebook", new BigDecimal("2000.33")));
		list.add(new Product2("BigPatinete", new BigDecimal("6969.69")));
		list.add(new Product2("Sabão em pó", new BigDecimal("15.59")));
		
		// versao 1
//		list.removeIf(new PredicateProduct());
		
		// versao 2
//		list.removeIf(Product2::staticPredicateProduct);
		
		// versao 3
//		list.removeIf(Product2::nonStaticPredicateProduct);
		
		// versao 4
//		Predicate<Product2> predicate = p -> p.getPrice().doubleValue() >= 100.0;
//		
//		list.removeIf(predicate);
		
		// versao 5
		list.removeIf(p -> p.getPrice().doubleValue() >= 100.0);
		
		
		for (Product2 p : list) {
			System.out.println(p);
		}
	}
}

/**
 * Consumer<T>
 * 
 * @author User
 *
 */
class InnerClass3{
	
	protected static void test() {
		List<Product2> list = new ArrayList<>();
		
		list.add(new Product2("TV", new BigDecimal("444.55")));
		list.add(new Product2("Notebook", new BigDecimal("2000.33")));
		list.add(new Product2("BigPatinete", new BigDecimal("6969.69")));
		list.add(new Product2("Sabão em pó", new BigDecimal("15.59")));
		
		/* versao 1 */
//		list.forEach(new PriceUpdate());
		
		/* versao 2 */
//		list.forEach(Product2::staticPriceUpdate);
		
		/* versao 3 */
//		list.forEach(Product2::nonStaticPriceUpdate);
		
		/* versao 4 */
//		Consumer<Product2> cons = p -> {
//			p.setPrice(p.getPrice().multiply(new BigDecimal("1.1")));
//		};
//		list.forEach(cons);
		
		/* versao 5 */
//		Consumer<Product2> cons = p -> p.setPrice(p.getPrice().multiply(new BigDecimal("1.1")));
//		list.forEach(cons);
		
		/* versao 6 */
		list.forEach(p -> p.setPrice(p.getPrice().multiply(new BigDecimal("1.1"))));
		
		list.forEach(System.out::println);
	}
}

/**
 * Function<T, R>
 * 
 * @author User
 *
 */
class InnerClass4{
	
	protected static void test() {
		List<Product2> list = new ArrayList<>();
		
		list.add(new Product2("TV", new BigDecimal("444.55")));
		list.add(new Product2("Notebook", new BigDecimal("2000.33")));
		list.add(new Product2("BigPatinete", new BigDecimal("6969.69")));
		list.add(new Product2("Sabão em pó", new BigDecimal("15.59")));
	
		/* versao 1 */
//		List<String> nomes = list.stream()				   		// converte um tipo  lista para um tipo stream - 
																// 		stream sequencia elementos indenpendente da fonte da dos e oferece suporte a operações agregadas 	
//								 .map(new UpperCaseName()) 		// aplica a função dada a cada elemento da lista
//								 .collect(Collectors.toList()); // retorna stream para o tipo lista
		/* versao 2 */
//		List<String> nomes = list.stream()				   	
//				 				 .map(Product2::staticUpperCase) 		
//				 				 .collect(Collectors.toList());
		/* versao 3 */
//		List<String> nomes = list.stream()				   	
//				 				 .map(Product2::nonStaticUpperCase) 		
//				 				 .collect(Collectors.toList());
		/* versao 4 */
//		Function<Product2, String> funct = p -> p.getName().toUpperCase();
//		List<String> nomes = list.stream()				   	
//								 .map(funct) 		
//								 .collect(Collectors.toList());
		/* versao 5 */
		List<String> nomes = list.stream()				   	
								 .map(p -> p.getName().toUpperCase()) 		
								 .collect(Collectors.toList());
		
		nomes.forEach(System.out::println);
	}
}

/**
 * Interface customizada | função como argumento
 * @author User
 *
 */
class InnerClass5{
	
	protected static void test() {
		List<Product2> list = new ArrayList<>();
		
		list.add(new Product2("TV", new BigDecimal("444.55")));
		list.add(new Product2("Notebook", new BigDecimal("2000.33")));
		list.add(new Product2("T_BigPatinete", new BigDecimal("6969.69")));
		list.add(new Product2("Sabão em pó", new BigDecimal("15.59")));
	
		ProductService service = new ProductService();
		
		BigDecimal soma = service.somaFiltrada(list, p -> p.getPrice().doubleValue() < 1000.0 );
		
		System.out.println(" Soma = " + soma.toString());
	}
}

/**
 * - Streams -
 *  <a>https://www.oracle.com/br/technical-resources/articles/java-stream-api.html</a>
 * 
 * @author User
 *
 */
class InnerClass6{
	
	protected static void test() {
		// Operações intermediarias
		
//		• filter
//		• map
//		• flatmap
//		• peek
//		• distinct
//		• sorted
//		• skip
//		• limit (*)
//		* short-circuit - Condição satisfeita = fim da operação
		
		// Operações terminais
//		• forEach
//		• forEachOrdered
//		• toArray
//		• reduce
//		• collect
//		• min
//		• max
//		• count
//		• anyMatch (*)
//		• allMatch (*)
//		• noneMatch (*)
//		• findFirst (*)
//		• findAny (*)
		
		// exemplos
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 9, 0);
		
		Stream<Integer> st1 = list.stream()
									.map(n -> n * 10);
		System.out.println(Arrays.toString(st1.toArray()));
		
		Stream<String> st2 = Stream.of("A", "B", "C");
		System.out.println(Arrays.toString(st2.toArray()));
		
		Stream<Integer> st3 = Stream.iterate(0, n -> n + 2);
		System.out.println(Arrays.toString(st3.limit(10).toArray()));
		
		Stream<Long> st4 = Stream.iterate( new long[]{ 0L, 1L }, 
											p->new long[]{ p[1], p[0]+p[1] })
											.map(p -> p[0]);	
		System.out.println(Arrays.toString(st4.limit(20).toArray()));
	}
}

/**
 * - Pipelines -
 * 
 * @author User
 *
 */
class InnerClass7{
	
	protected static void test() {
		// exemplos
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 9, 0);
		
		Stream<Integer> st1 = list.stream()
								  .map(n -> n + n);
		
		System.out.println(Arrays.toString(st1.toArray()));
		
		Integer soma = list.stream()
							.reduce(0, (x, y) -> x + y);
		System.out.println(" Soma : " + soma);
		
		List<Integer> n1list = list.stream()
									.filter(n -> n % 2 == 0)
									.map(n -> n * 10)
									.collect(Collectors.toList());
		
		System.out.println(Arrays.toString(n1list.toArray()));
	}
}
	

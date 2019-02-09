package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Collection<Product> products = new ArrayList<Product>();

	public void addProduct(Product product) {
		products.add(product);
	}

	public void addProduct(Product product, Integer quantity) {
		
		if(quantity <= 0 ) {
			throw new IllegalArgumentException("Quantity can not be equal or lesss than 0");
		}
		for (int i = 0; i<quantity; i++) {
			products.add(product);
		}
	}

	public BigDecimal getTotalNetPrice() {
		
		BigDecimal total = BigDecimal.ZERO;
		for (Product product: products){
			total = total.add(product.getPrice());
		}
		return total;
		
	}

	public BigDecimal getTotalTax() {
		
		if(products.isEmpty()) {
			return BigDecimal.ZERO;
		}
		else {
			BigDecimal total = new BigDecimal("0");
			for (Product product: products) {
				total = total.add(product.getPrice().multiply(product.getTaxPercent()));
			}
			return total;
		}	
		
	}

	public BigDecimal getTotalGrossePrice() {
		if (products.isEmpty()) {
			return BigDecimal.ZERO;
		}
		BigDecimal total = new BigDecimal("0");
		for (Product product: products){
			total = total.add(product.getPriceWithTax());
		}
		return total;
	}
	
}

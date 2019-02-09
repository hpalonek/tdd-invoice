package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product{
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		
		if (name == null || name == "" ) {
			throw new IllegalArgumentException("Wrong name");
		}
		
		else{
			this.name = name;
		}
		
		if(price.intValue() < 0 || price == null) {
			throw new IllegalArgumentException("Wrong price");
		}
		else {
			this.price = price;
		}
		
		if(tax.intValue()< 0 || tax == null) {
			throw new IllegalArgumentException("Wrong tax");
		}
		else{
			this.taxPercent = tax;
		}
		
	}
	
	

	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return price.add(price.multiply(taxPercent));
	}
}

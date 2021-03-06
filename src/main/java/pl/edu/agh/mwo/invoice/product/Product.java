package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product{
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {
		
		if (name == null || name.equals("")) { // lepsze niż name == "" tu sa dwie raferencje, bo wszystkie wystapienia takie same stringa beda domyslenie zastapione ta sama instancją
			throw new IllegalArgumentException("Wrong name");
		}
		
		if( price == null || price.intValue() < 0) {
			throw new IllegalArgumentException("Wrong price");
		}
		
		if(tax == null || tax.intValue()< 0) {
			throw new IllegalArgumentException("Wrong tax");
		}

		this.name = name;
		this.price = price;
		this.taxPercent = tax;
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

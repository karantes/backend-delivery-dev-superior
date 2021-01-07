package br.com.arantes.delivery.dto;

import java.io.Serializable;

import br.com.arantes.delivery.entity.Product;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageUri;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final Double getPrice() {
		return price;
	}

	public final void setPrice(Double price) {
		this.price = price;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final String getImageUri() {
		return imageUri;
	}

	public final void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, Double price, String description, String imageUri) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUri = imageUri;
	}

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.imageUri = product.getImageUri();
	}

}

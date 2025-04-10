package fastcartRegistration.dto;


public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private String imageUrl;
	private Double price;
	private String category;
	private Integer stock;

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, String description, String imageUrl, Double price, String category,
			Integer stock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.category = category;
		this.stock = stock;
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public Integer getStock() {
		return stock;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}

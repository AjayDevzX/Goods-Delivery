package Model;

public class OrderInformation {
	
	private int id, productId, quantity;
	
	private String deliveryAddress, deliveryDate, dateCreated;

    public OrderInformation(int productId, int quantity, String deliveryAddress, String deliveryDate) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.deliveryAddress = deliveryAddress;
		this.deliveryDate = deliveryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "OrderInformation [id=" + id + ", productId=" + productId + ", quantity=" + quantity
				+ ", deliveryAddress=" + deliveryAddress + ", deliveryDate=" + deliveryDate + ", dateCreated="
				+ dateCreated + "]";
	}
	
	
	
	
}

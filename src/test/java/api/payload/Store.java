package api.payload;

public class Store {
	
	int id = 0;
	int petId = 0;
	int quantity = 0;
	String shipDate;
	String status;
	boolean complete;
	
	
	public int getId() {
		return id;
	}
	public int getPetId() {
		return petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getShipDate() {
		return shipDate;
	}
	public String getStatus() {
		return status;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
	
	
 	
}

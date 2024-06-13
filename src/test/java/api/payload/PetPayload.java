package api.payload;

public class PetPayload {
	
	int id;
	String name;
	String status;
	
	public int getPetId() {
		return id;
	}
	public void setPetId(int id) {
		this.id = id;
	}
	public String getPetName() {
		return name;
	}
	public void setPetName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

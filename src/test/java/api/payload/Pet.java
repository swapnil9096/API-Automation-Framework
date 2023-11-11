package api.payload;

public class Pet {
		
	
	int code = 0;
	String type;
	String message;
	
	
	public int getCode() {
		return code;
	}
	public String getType() {
		return type;
	}
	public String getMessage() {
		return message;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

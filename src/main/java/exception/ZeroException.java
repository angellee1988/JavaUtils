package exception;

public class ZeroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3227835637232062430L;
	
	private String code ;
	private String message ;
	
	public ZeroException(String code ,String message){
		super() ;
		this.code = code ;
		this.message = message ;
	}

	public ZeroException(String code,String message,Throwable t){
	    super(t);
	    this.code=code;
        this.message=message;
    }
	
	public ZeroException(String code,String message,Exception t){
        super(t);
        this.code=code;
        this.message=message;
    }
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ZeroException [code=" + code + ", message=" + message + "]";
	}
	
}

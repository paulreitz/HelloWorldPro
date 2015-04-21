package hello.model;

/**
 * Holds the basic "Hello, World" message. Can also be used to handle additional messages
 * 
 * @author Paul Reitz
 *
 */
public class HelloVO extends MessageBase
{
	private String message;
	
	{
		ariaReadOnly = true;
	}
	
	public HelloVO()
	{
		
	}
	
	public HelloVO(String value)
	{
		message = value;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}

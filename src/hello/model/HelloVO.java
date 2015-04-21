package hello.model;

/**
 * Holds the basic "Hello, World" message. Can also be used to handle additional messages
 * 
 * @author Paul Reitz
 *
 */
public class HelloVO extends MessageBase
{
	// A single message that will be displayed to the output.
	private String message;
	
	{
		ariaReadOnly = true;
		ariaLabel = "hello_world";
	}
	
	/**
	 * Constructor
	 */
	public HelloVO()
	{
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param value	Initial message
	 */
	public HelloVO(String value)
	{
		message = value;
	}

	/**
	 * The message
	 * 
	 * @return
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * Sets the message
	 * 
	 * @param message
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
}

package hello.model;

/**
 * All message value objects should extend MessageBase so that they are completely set up 
 * for Accessibility.
 * 
 * 
 * @author Paul Reitz
 *
 */
public class MessageBase
{
	protected String ariaLabel;
	protected String ariaLabelFor;
	protected String ariaOwns;
	protected boolean ariaReadOnly;
	
	{
		ariaLabel = "";
		ariaLabelFor = "";
		ariaOwns = "";
		ariaReadOnly = false;
	}
	
	public MessageBase()
	{
		
	}

	public String getAriaLabel()
	{
		return ariaLabel;
	}

	public void setAriaLabel(String ariaLabel)
	{
		this.ariaLabel = ariaLabel;
	}

	public String getAriaLabelFor()
	{
		return ariaLabelFor;
	}

	public void setAriaLabelFor(String ariaLabelFor)
	{
		this.ariaLabelFor = ariaLabelFor;
	}

	public String getAriaOwns()
	{
		return ariaOwns;
	}

	public void setAriaOwns(String ariaOwns)
	{
		this.ariaOwns = ariaOwns;
	}

	public boolean isAriaReadOnly()
	{
		return ariaReadOnly;
	}

	public void setAriaReadOnly(boolean ariaReadOnly)
	{
		this.ariaReadOnly = ariaReadOnly;
	}
}

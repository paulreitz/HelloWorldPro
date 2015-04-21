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
	// Sets a label for screen readers.
	protected String ariaLabel;
	// Used in case this item is a reference to another item the screen reader needs to read
	protected String ariaLabelFor;
	// Lets a screen reader know that there are child objects to this item.
	protected String ariaOwns;
	// Whether or not this item can be interacted with. If true, the screen reader will be able to set focus to this item
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

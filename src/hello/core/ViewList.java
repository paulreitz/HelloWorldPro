package hello.core;

import hello.views.IViewRenderer;

/**
 * Custom list class to hold IViewRenderers. Because if you're going to over complicate 
 * Hello World, go big or go home!
 * 
 * @author Paul Reitz
 *
 */
public class ViewList
{
	// the top level node of the list.
	private Node head;
	
	/**
	 * Constructor
	 */
	public ViewList()
	{
		head = new Node();
	}
	
	/**
	 * The number of view renderers in the list.
	 * @return
	 */
	public int size()
	{
		int count = 0;
		Node tail = head;
		while(tail.hasChild())
		{
			tail = tail.getChild();
			count++;
		}
		return count;
	}
	
	/**
	 * Adds an view render to the list at index 0.
	 * 
	 * @param item
	 */
	public void shift(IViewRenderer item)
	{
		Node inserted = new Node();
		inserted.setData(item);
		inserted.setChild(head.getChild());
		head.setChild(inserted);
	}
	
	/**
	 * Removes the view renderer at index 0 and returns it.
	 * 
	 * @return
	 */
	public IViewRenderer unshift()
	{
		Node unshifted = head.getChild();
		head.setChild(unshifted.getChild());
		return unshifted.getData();
	}
	
	/**
	 * Removes the view renderer at the end of the list and returns it
	 * 
	 * @return
	 */
	public IViewRenderer pop()
	{
		Node parent = head;
		Node tail = head.getChild();
		while(tail.hasChild())
		{
			parent = tail;
			tail = tail.getChild();
		}
		parent.setChild(null);
		return tail.getData();
	}
	
	/**
	 * Adds a view renderer to the end of the list.
	 * 
	 * @param item
	 */
	public void add(IViewRenderer item)
	{
		Node tail = head;
		while(tail.hasChild())
		{
			tail = tail.getChild();
		}
		Node next = new Node();
		next.setData(item);
		tail.setChild(next);
	}
	
	/**
	 * Returns the view renderer at the specified index.
	 * 
	 * @param index
	 * @return	
	 */
	public IViewRenderer get(int index)
	{
		Node tail = head;
		for (int i = 0; i <= index; i++)
		{
			if (tail.hasChild())
			{
				tail = tail.getChild();
			}
		}
		return tail.getData();
	}
	
	/**
	 * Checks to see if a view renderer is contained in the list
	 * 
	 * @param item
	 * @return	true if the specified view renderer is found in the list, false otherwise.
	 */
	public boolean contains(IViewRenderer item)
	{
		Node tail = head.getChild();
		while (tail != null)
		{
			if (tail.getData() == item)
			{
				return true;
			}
			tail = tail.getChild();
		}
		return false;
	}
	
	/**
	 * Returns the index of the first instance of the specified view renderer
	 * 
	 * @param item
	 * @return The first index of the given view renderer or -1.
	 */
	public int indexOf(IViewRenderer item)
	{
		int index = -1;
		Node tail = head.getChild();
		while(tail != null)
		{
			index++;
			if (tail.getData() == item)
			{
				return index;
			}
			tail = tail.getChild();
		}
		return -1;
	}
	
	public IViewIterator getIterator()
	{
		ViewIterator it = new ViewIterator(this);
		return it;
	}
	
	class Node
	{
		// holds a reference to a view renderer
		private IViewRenderer data;
		// A reference to the next node in the list
		private Node child;
		
		public Node()
		{
			data = null;
			child = null;
		}

		/**
		 * The view renderer referenced by this node.
		 * @return
		 */
		public IViewRenderer getData()
		{
			return data;
		}

		/**
		 * Sets the view renderer this node references
		 * 
		 * @param value
		 */
		public void setData(IViewRenderer value)
		{
			data = value;
		}

		/**
		 * The next node in the list
		 * 
		 * @return
		 */
		public Node getChild()
		{
			return child;
		}

		/**
		 * Sets the next node in the list
		 * 
		 * @param value
		 */
		public void setChild(Node value)
		{
			child = value;
		}
		
		/**
		 * Returns whether or not this node contains a reference to another node.
		 * 
		 * @return
		 */
		public boolean hasChild()
		{
			return !(child == null);
		}
	}
	
	class ViewIterator implements IViewIterator
	{
		private ViewList list;
		private int index;
		
		public ViewIterator(ViewList l)
		{
			list = l;
			index = 0;
		}
		
		public boolean hasNext()
		{
			return (index < list.size());
		}
		
		public IViewRenderer next()
		{
			if (index < list.size())
			{
				IViewRenderer next = list.get(index);
				index++;
				return next;
			}
			return null;
		}
	}
}

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
	private ViewVO head;
	
	/**
	 * Constructor
	 */
	public ViewList()
	{
		head = new ViewVO();
	}
	
	/**
	 * The number of view renderers in the list.
	 * @return
	 */
	public int size()
	{
		int count = 0;
		ViewVO tail = head;
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
		ViewVO inserted = new ViewVO();
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
		ViewVO unshifted = head.getChild();
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
		ViewVO parent = head;
		ViewVO tail = head.getChild();
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
		ViewVO tail = head;
		while(tail.hasChild())
		{
			tail = tail.getChild();
		}
		ViewVO next = new ViewVO();
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
		ViewVO tail = head;
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
		ViewVO tail = head.getChild();
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
		ViewVO tail = head.getChild();
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
	
	class ViewVO
	{
		// holds a reference to a view renderer
		private IViewRenderer data;
		// A reference to the next node in the list
		private ViewVO child;
		
		public ViewVO()
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
		 * @param data
		 */
		public void setData(IViewRenderer data)
		{
			this.data = data;
		}

		/**
		 * The next node in the list
		 * 
		 * @return
		 */
		public ViewVO getChild()
		{
			return child;
		}

		/**
		 * Sets the next node in the list
		 * 
		 * @param child
		 */
		public void setChild(ViewVO child)
		{
			this.child = child;
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

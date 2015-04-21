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
	private ViewVO head;
	
	public ViewList()
	{
		head = new ViewVO();
	}
	
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
	
	public void shift(IViewRenderer item)
	{
		ViewVO inserted = new ViewVO();
		inserted.setData(item);
		inserted.setChild(head.getChild());
		head.setChild(inserted);
	}
	
	public IViewRenderer unshift()
	{
		ViewVO unshifted = head.getChild();
		head.setChild(unshifted.getChild());
		return unshifted.getData();
	}
	
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
	
	class ViewVO
	{
		private IViewRenderer data;
		private ViewVO child;
		
		public ViewVO()
		{
			data = null;
			child = null;
		}

		public IViewRenderer getData()
		{
			return data;
		}

		public void setData(IViewRenderer data)
		{
			this.data = data;
		}

		public ViewVO getChild()
		{
			return child;
		}

		public void setChild(ViewVO child)
		{
			this.child = child;
		}
		
		public boolean hasChild()
		{
			return !(child == null);
		}
	}
}

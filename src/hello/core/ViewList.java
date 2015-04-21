package hello.core;

import hello.views.IViewRenderer;

public class ViewList
{
	private ViewVO head;
	private int count;
	
	public ViewList()
	{
		head = new ViewVO();
		count = 0;
	}
	
	public int size()
	{
		return count;
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
		count++;
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

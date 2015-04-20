package hello.controllers;

import hello.views.IViewRenderer;

import java.util.ArrayList;

public class HelloController
{
	private static HelloController _instance;
	
	private ArrayList<IViewRenderer> views;
	
	private HelloController()
	{
		views = new ArrayList<>();
	}
	
	public static HelloController getInstance()
	{
		if (_instance == null)
		{
			_instance = new HelloController();
		}
		return _instance;
	}
	
	public void addView(IViewRenderer view)
	{
		views.add(view);
	}
	
	public int viewCount()
	{
		return views.size();
	}
	
	public void renderViews()
	{
		int count = views.size();
		for (int i = 0; i < count; ++i)
		{
			views.get(i).render();
		}
	}
}

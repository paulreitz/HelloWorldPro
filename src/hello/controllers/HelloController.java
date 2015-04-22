package hello.controllers;

import hello.core.IViewIterator;
import hello.core.ViewList;
import hello.views.IViewRenderer;

/**
 * Main controller for the app. 
 * 
 * @author Paul Reitz
 *
 */
public class HelloController
{
	// static instance of the HelloController.
	private static HelloController _instance;
	
	// Contains all the views that will render text to the console.
	private ViewList views;
	
	/**
	 * Constructor
	 */
	private HelloController()
	{
		views = new ViewList();
	}
	
	/**
	 * It's a singleton....you should know what this function does.
	 * 
	 * @return A static instance of HelloController
	 */
	public static HelloController getInstance()
	{
		if (_instance == null)
		{
			_instance = new HelloController();
		}
		return _instance;
	}
	
	/**
	 * Adds a view renderer to the list
	 * 
	 * @param view
	 */
	public void addView(IViewRenderer view)
	{
		views.add(view);
	}
	
	/**
	 * The number of view renderers
	 * @return	The number of view renderers
	 */
	public int viewCount()
	{
		return views.size();
	}
	
	/**
	 * Calls render() on all view renderers in the list.
	 */
	public void renderViews()
	{
		IViewIterator iterator = views.getIterator();
		while(iterator.hasNext())
		{
			IViewRenderer renderer = iterator.next();
			renderer.render();
		}
	}
}

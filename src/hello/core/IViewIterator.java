package hello.core;

import hello.views.IViewRenderer;

public interface IViewIterator
{
	boolean hasNext();
	IViewRenderer next();
}

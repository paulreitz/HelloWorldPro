package hello;

import hello.controllers.HelloController;
import hello.core.HelloConstants;
import hello.views.HelloView;

/**
 * Launches the Hello World app.
 * 
 * @author Paul Reitz
 *
 */
public class Program
{

	public static void main(String[] args)
	{
		HelloView hello = new HelloView(HelloConstants.HELLO_MESSAGE);
		HelloController.getInstance().addView(hello);
		HelloController.getInstance().renderViews();
	}

}

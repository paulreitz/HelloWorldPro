package hello.views;

import hello.model.HelloVO;

public class HelloView implements IViewRenderer
{
	private HelloVO messageVO;
	
	public HelloView()
	{
		messageVO = new HelloVO();
	}
	
	public HelloView(String message)
	{
		messageVO = new HelloVO(message);
	}
	
	public HelloView(HelloVO mVo)
	{
		messageVO = mVo;
	}

	public HelloVO getMessageVO()
	{
		return messageVO;
	}

	public void setMessageVO(HelloVO value)
	{
		messageVO = value;
	}
	
	public String getMessage()
	{
		return messageVO.getMessage();
	}
	
	public void setMessage(String value)
	{
		messageVO.setMessage(value);
	}

	public void render()
	{
		System.out.println(messageVO.getMessage());
	}

}

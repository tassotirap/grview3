package grview3.ui;

public class Launcher
{
	public void init()
	{
		try
		{
			WorkspaceChooser workspaceChooser = new WorkspaceChooser();
			workspaceChooser.setVisible(true);
			while (workspaceChooser.isVisible())
			{
				Thread.sleep(500);
			}
			workspaceChooser.dispose();
				
			Splash.getInstance().openSplash();			
			Thread.sleep(1000);			
			Splash.getInstance().finish();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}

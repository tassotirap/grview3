package grview3.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Window;

/**
 * 
 * @author Tasso Tirapani Silva Pinto
 * 
 */
public class Splash extends Window
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String IMG_NAME = "/grview3/img/splash_screen.png";
	private Image splashImage;
	private Toolkit toolkit;
	private static Splash splash;
	
	private Splash()
	{
		super(null);
		toolkit = Toolkit.getDefaultToolkit(); 
	}	

	public static Splash getInstance()
	{
		if (splash == null)
			splash = new Splash();
		return splash;
	}

	public void openSplash()
	{
		splash.initSplash();
	}

	public void finish()
	{
		splash.setVisible(false);
		dispose();
	}

	private void initSplash()
	{
		MediaTracker media = new MediaTracker(this);
		splashImage = toolkit.getImage(getClass().getResource(IMG_NAME));

		if (splashImage != null)
		{
			media.addImage(splashImage, 0);
			try
			{
				media.waitForID(0);
			}
			catch (InterruptedException ie)
			{
			}
		}

		setSize(splashImage.getWidth(this), splashImage.getHeight(this));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = getSize();

		if (size.width > screenSize.width)
			size.width = screenSize.width;

		if (size.height > screenSize.height)
			size.height = screenSize.height;

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		g.drawImage(splashImage, 0, 0, getBackground(), this);
	}

}

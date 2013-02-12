package grview3.ui;

import grview3.ui.editor.SemanticFuncionEditor;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.CodeEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import bibliothek.extension.gui.dock.theme.EclipseTheme;
import bibliothek.gui.DockController;
import bibliothek.gui.dock.DefaultDockable;
import bibliothek.gui.dock.SplitDockStation;
import bibliothek.gui.dock.station.split.SplitDockGrid;
import bibliothek.gui.dock.station.split.SplitDockProperty;
import bibliothek.gui.dock.station.stack.tab.DefaultMenuLineLayoutFactory;
import bibliothek.gui.dock.station.stack.tab.MenuLineLayout;
import bibliothek.gui.dock.station.stack.tab.MenuLineLayoutOrder;
import bibliothek.gui.dock.station.stack.tab.MenuLineLayoutOrder.Item;
import bibliothek.gui.dock.station.stack.tab.TabPane;

public class MainWindow extends JFrame
{
	private SplitDockStation station;
	private DockController controller;
	
	public MainWindow()
	{
		setTitle("GrView 3.0");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setFonts();
		createDocking();
		
		createDockable();
		createListeners();
		setSize(400, 400);
	}

	private void setFonts()
	{
		CodeEditorPane.DEFAULT_FONT_SIZE = 12;
		CodeEditorPane.DEFAULT_TAB_SIZE = 3;		
	}

	private void createDockable()
	{
		SplitDockProperty center = new SplitDockProperty(0, 0, 1, 1);
		
		DefaultDockable dockable = new DefaultDockable();
		dockable.add(new SemanticFuncionEditor().getContainerWithLines());
		dockable.setTitleText("Semantic Editor");
		
		DefaultDockable dockable2 = new DefaultDockable();
		dockable2.add(new SemanticFuncionEditor().getContainerWithLines());
		dockable2.setTitleText("Sintatic Editor");
		
		DefaultDockable dockable3 = new DefaultDockable();
		dockable3.add(new SemanticFuncionEditor().getContainerWithLines());
		dockable3.setTitleText("Lexical Editor");
		
		station.drop(dockable, center);
		station.drop(dockable2, center);
		station.drop(dockable3, center);		
	}

	private void createListeners()
	{
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowListener()
		{
			@Override
			public void windowOpened(WindowEvent arg0)
			{
			}

			@Override
			public void windowIconified(WindowEvent arg0)
			{
			}

			@Override
			public void windowDeiconified(WindowEvent arg0)
			{
			}

			@Override
			public void windowDeactivated(WindowEvent arg0)
			{
			}

			@Override
			public void windowClosing(WindowEvent arg)
			{
				int exit_opt = JOptionPane.showConfirmDialog(null, "Close project?", "Close", JOptionPane.YES_NO_OPTION);
				if (exit_opt == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}

			@Override
			public void windowClosed(WindowEvent arg0)
			{
			}

			@Override
			public void windowActivated(WindowEvent arg0)
			{
			}
		});

	}

	private void createDocking()
	{	
		controller = new DockController();
		controller.setRootWindow(this);
		controller.setTheme(new EclipseTheme());

		station = new SplitDockStation();
		controller.add(station);
		this.add(station);		
		
		MenuLineLayout layoutManager = new MenuLineLayout();
		layoutManager.setFactory(new DefaultMenuLineLayoutFactory(){
			public MenuLineLayoutOrder createOrder(MenuLineLayout layout, TabPane pane)
			{
				MenuLineLayoutOrder order = new MenuLineLayoutOrder(Item.INFO, Item.TABS, Item.MENU);
				order.setConstraints(Item.INFO, 0f, 0f, 1f);
				order.setConstraints(Item.TABS, 1f, 0f, 0f);
				order.setConstraints(Item.MENU, 0f, 1f, 0f);
				return order;
			}
		});
		
		controller.getProperties().set(TabPane.LAYOUT_MANAGER, layoutManager);
	}
}

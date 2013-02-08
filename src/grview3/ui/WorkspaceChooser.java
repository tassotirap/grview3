package grview3.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;

/**
 * 
 * @author Tasso Tirapani Silva Pinto
 *
 */
public class WorkspaceChooser extends JFrame
{
	
	/**
	 * Versão 1.0
	 */
	private static final long serialVersionUID = 1L;
	
	private final String PROJECTS_SCREEN_PNG = "/grview3/img/projects_screen.png";
	private final int width = 430;
	private final int heigth = 230;
	
	private JLabel imgWorkspace;
	private JLabel lblWorkspace;
	private JComboBox<String> ckbWorkspace;
	private JButton btnBrowse;
	private JButton btnCancel;
	private JButton btnOk;

	
	public WorkspaceChooser()
	{
		setFrame();	
		setLocation();
		initComponents();
	}
	
	private void setFrame()
	{
		setTitle("grView 3.0");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setSize(width, heigth);
	}
	
	private void setLocation()
	{
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void initComponents()
	{
		imgWorkspace = new JLabel();
		lblWorkspace = new JLabel();
		ckbWorkspace = new JComboBox<String>();
		btnBrowse = new JButton();
		btnCancel = new JButton();
		btnOk = new javax.swing.JButton();

		imgWorkspace.setIcon(new ImageIcon(getClass().getResource(PROJECTS_SCREEN_PNG))); // NOI18N
		lblWorkspace.setText("Please inform a workspace to continue:");
		btnBrowse.setText("Browse");

		btnBrowse.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				btnBrowseActionPerformed();
			}
		});

		btnCancel.setText("OK");
		btnCancel.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				btnOkActionPerformed();
			}
		});

		btnOk.setText("Cancel");
		btnOk.addActionListener(new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				btnCancelActionPerformed();
			}
		});

		ckbWorkspace.setEditable(true);

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().
						addContainerGap().
						addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).
								addComponent(ckbWorkspace, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE).
								addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)).
								addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).
								addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).
										addComponent(btnOk, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE).
										addComponent(btnBrowse, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)).
										addContainerGap()).
										addComponent(imgWorkspace).
										addGroup(layout.createSequentialGroup().
												addContainerGap().
												addComponent(lblWorkspace)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
				addGroup(layout.createSequentialGroup().
						addComponent(imgWorkspace).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
						addComponent(lblWorkspace).
						addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).
						addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
								addComponent(ckbWorkspace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).
								addComponent(btnBrowse)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).
								addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
										addComponent(btnOk).
										addComponent(btnCancel)).
										addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);
		pack();
	}
	
	private void btnCancelActionPerformed()
	{
		System.exit(0);
	}
	
	private void btnOkActionPerformed()
	{
		setVisible(false);
	}
	
	private void btnBrowseActionPerformed()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int dialogReturn = fileChooser.showOpenDialog(this);
		if (dialogReturn == JFileChooser.APPROVE_OPTION)
		{
			ckbWorkspace.setSelectedItem(fileChooser.getSelectedFile().getAbsolutePath());
		}
		if (dialogReturn == JFileChooser.CANCEL_OPTION)
		{
			ckbWorkspace.setSelectedItem("");
		}
	}
}

package grview3.ui.editor;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.CodeEditorPane;

public class SemanticFuncionEditor extends CodeEditorPane
{
	public SemanticFuncionEditor()
	{
		setKeywordColors();
		setKeywordHelps();
	}

	private void setKeywordHelps()
	{
		HashMap<String, String> help = new HashMap<String, String>();
		help.put("stack", "Semantical stack.");
		help.put("token", "Current token.");
		this.setKeywordHelp(help);
	}

	private void setKeywordColors()
	{
		final HashMap<String, Color> syntax = new HashMap<String, Color>();
		syntax.put("public", new Color(90, 40, 90));
		syntax.put("static", new Color(90, 40, 90));
		syntax.put("void", new Color(90, 40, 90));
		syntax.put("stack", Color.RED);
		syntax.put("token", Color.RED);
		this.setKeywordColor(syntax);
	}
}

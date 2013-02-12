package grview3.project;

import grview3.exception.BusinessException;

public class Project
{
	private static Project project = null;
	
	private Project()
	{
		
	}
	
	public static Project getIntance() throws BusinessException
	{
		if(project == null)
		{
			throw new BusinessException("Project isn't loaded.");
		}
		return project;
	}
}

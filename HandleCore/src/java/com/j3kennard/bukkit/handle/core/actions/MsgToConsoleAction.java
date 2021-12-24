package com.j3kennard.bukkit.handle.core.actions;

import com.j3kennard.bukkit.handle.core.HandleCore;
import com.j3kennard.bukkit.handle.core.util.FormatUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MsgToConsoleAction extends Action
{
	private String actionString;
	
	public MsgToConsoleAction(String actionString)
	{
		this.actionString = actionString;
	}
	
	public String getString()
	{
		return this.actionString;
	}
	
	public void run()
	{
		Bukkit.getLogger().info(actionString);
	}
}
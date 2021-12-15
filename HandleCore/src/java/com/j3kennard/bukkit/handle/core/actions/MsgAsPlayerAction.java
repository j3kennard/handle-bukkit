package com.j3kennard.bukkit.handle.core.actions;

import com.j3kennard.bukkit.handle.core.util.FormatUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MsgAsPlayerAction extends Action
{
	private String actionString;
	private Player targetPlayer;
	
	public MsgAsPlayerAction(String actionString, Player targetPlayer)
	{
		this.targetPlayer = targetPlayer;
		this.actionString = actionString;
	}
	
	public String getString()
	{
		return this.actionString;
	}
	
	public void run()
	{
		new BukkitRunnable() {
			@Override
			public void run() {
				targetPlayer.chat(FormatUtility.formatMessage(actionString));
			}
		}.runTask(Bukkit.getPluginManager().getPlugin("Handle"));
	}
}
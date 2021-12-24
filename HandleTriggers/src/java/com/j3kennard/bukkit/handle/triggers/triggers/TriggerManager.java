package com.j3kennard.bukkit.handle.triggers.triggers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TriggerManager
{
	private List<Trigger> blockAttackTriggers = new ArrayList<>();
	private List<Trigger> blockInteractTriggers = new ArrayList<>();
	private List<Trigger> blockUseTriggers = new ArrayList<>();
	private List<Trigger> breakTriggers = new ArrayList<>();
	private List<Trigger> commandTriggers = new ArrayList<>();
	private List<Trigger> joinTriggers = new ArrayList<>();
	private List<Trigger> placeTriggers = new ArrayList<>();
	private List<Trigger> quitTriggers = new ArrayList<>();
	
	public TriggerManager()
	{
		// TODO
	}
	
	public void loadTriggers(ConfigurationSection... triggerSections)
	{
		Bukkit.getLogger().info("Clearing trigger map..");
		this.blockAttackTriggers.clear();
		this.blockInteractTriggers.clear();
		this.blockUseTriggers.clear();
		this.breakTriggers.clear();
		this.commandTriggers.clear();
		this.joinTriggers.clear();
		this.placeTriggers.clear();
		this.quitTriggers.clear();
		
		Bukkit.getLogger().info("Loading triggers from specified files..");
		for (ConfigurationSection ts : triggerSections)
		{
			Bukkit.getLogger().info("  Making sure file isn't empty..");
			if (!ts.getKeys(false).isEmpty())
			{
				Bukkit.getLogger().info("  Loading each trigger..");
				for (String t : ts.getKeys(false))
				{
					Bukkit.getLogger().info("    Making sure trigger '" + t + "' isn't null..");
					if (ts.getConfigurationSection(t) != null)
					{
						Trigger trigger = new Trigger(t, ts.getConfigurationSection(t));
						Bukkit.getLogger().info("    Trigger '" + t + "' is being added..");
						switch (trigger.getType().toUpperCase(Locale.ROOT).replace(" ", "_"))
						{
							case "BLOCK_ATTACK" -> this.blockAttackTriggers.add(trigger);
							case "BLOCK_INTERACT" -> this.blockInteractTriggers.add(trigger);
							case "BLOCK_USE" -> this.blockUseTriggers.add(trigger);
							case "BREAK" -> this.breakTriggers.add(trigger);
							case "COMMAND" -> this.commandTriggers.add(trigger);
							case "JOIN" -> this.joinTriggers.add(trigger);
							case "PLACE" -> this.placeTriggers.add(trigger);
							case "QUIT" -> this.quitTriggers.add(trigger);
							default -> Bukkit.getLogger().warning("    Trigger '" + t + "' has an invalid type");
						}
					}
				}
			}
		}
	}
	
	public List<Trigger> getBlockAttackTriggers()
	{
		return this.blockAttackTriggers;
	}
	
	public List<Trigger> getBlockInteractTriggers()
	{
		return this.blockInteractTriggers;
	}
	
	public List<Trigger> getBlockUseTriggers()
	{
		return this.blockUseTriggers;
	}
	
	public List<Trigger> getBreakTriggers()
	{
		return this.breakTriggers;
	}
	
	public List<Trigger> getCommandTriggers()
	{
		return this.commandTriggers;
	}
	
	public List<Trigger> getJoinTriggers()
	{
		return this.joinTriggers;
	}
	
	public List<Trigger> getPlaceTriggers()
	{
		return this.placeTriggers;
	}
	
	public List<Trigger> getQuitTriggers()
	{
		return this.quitTriggers;
	}
}

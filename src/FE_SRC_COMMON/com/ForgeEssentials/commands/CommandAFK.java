package com.ForgeEssentials.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.ForgeEssentials.commands.util.AFKdata;
import com.ForgeEssentials.commands.util.TickHandlerCommands;
import com.ForgeEssentials.core.commands.ForgeEssentialsCommandBase;

public class CommandAFK extends ForgeEssentialsCommandBase
{
	/*
	 * Config
	 */
	public static int warmup = 5; 

	@Override
	public String getCommandName()
	{
		return "afk";
	}

	@Override
	public void processCommandPlayer(EntityPlayer sender, String[] args)
	{
		TickHandlerCommands.afkListToAdd.add(new AFKdata((EntityPlayerMP) sender));
		sender.sendChatToPlayer("Stand still for " + warmup + "s.");
	}

	@Override
	public void processCommandConsole(ICommandSender sender, String[] args)
	{
	}

	@Override
	public boolean canConsoleUseCommand()
	{
		return false;
	}

	@Override
	public String getCommandPerm()
	{
		return "ForgeEssentials.BasicCommands." + getCommandName();
	}
	
	public static void abort(AFKdata afKdata)
	{
		if(!afKdata.player.capabilities.isCreativeMode)
		{
			afKdata.player.capabilities.disableDamage = false;
			afKdata.player.sendPlayerAbilities();
		}
		afKdata.player.sendChatToPlayer("AFK lifted.");
		TickHandlerCommands.afkListToRemove.add(afKdata);
	}

	public static void makeAFK(AFKdata afKdata)
	{
		afKdata.player.capabilities.disableDamage = true;
		afKdata.player.sendPlayerAbilities();
		afKdata.player.sendChatToPlayer("You are in AFK now.");
	}
}

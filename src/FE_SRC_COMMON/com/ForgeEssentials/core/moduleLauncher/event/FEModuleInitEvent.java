package com.ForgeEssentials.core.moduleLauncher.event;

import com.ForgeEssentials.core.moduleLauncher.ModuleContainer;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLStateEvent;

public class FEModuleInitEvent extends FEModuleEvent
{
	private FMLInitializationEvent event;

	public FEModuleInitEvent(ModuleContainer container,FMLInitializationEvent event)
	{
		super(container);
		this.event = event;
	}

	@Override
	public FMLStateEvent getFMLEvent()
	{
		return event;
	}
}

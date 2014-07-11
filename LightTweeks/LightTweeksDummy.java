package LightProcessing.LightTweeks;

import java.util.Arrays;

import LightProcessing.common.lib.Reference;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class LightTweeksDummy extends DummyModContainer {

	public LightTweeksDummy() {
		super(new ModMetadata());
		ModMetadata meta = getMetadata();
		meta.modId = "LightTweeks";
		meta.name = "Light Tweeks";
		meta.version = Reference.VERSION;
		//meta.credits = "";
		meta.authorList = Arrays.asList("JPisaBrony", "Rellik55");
		//meta.description = "";
		//meta.url = "";
		//meta.updateUrl = "";
		//meta.screenshots = new String[0];
		//meta.logoFile = "";
	}

	@Override
	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}

	@Subscribe
	public void modConstruction(FMLConstructionEvent evt) {}

	@Subscribe
	public void preInit(FMLPreInitializationEvent evt) {}

	@Subscribe
	public void init(FMLInitializationEvent evt) {}

	@Subscribe
	public void postInit(FMLPostInitializationEvent evt) {}

}

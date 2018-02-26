package net.dark_roleplay.drpcore.common;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.ForgeVersion.CheckResult;
import net.minecraftforge.common.ForgeVersion.Status;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class DRPCoreReferences {

	public static final String MODID = "drpcore";
	public static final String NAME = "Dark Roleplay Core";
	public static final String VERSION = "0.3.4";
	public static final String ACCEPTEDVERSIONS = "[1.12,1.13)";
	public static final String UPDATE_JSON = "http://dark-roleplay.net/version_files/DarkRoleplayCore.json";
	public static final String DEPENDECIES = "required-after:forge@[1.12.2-14.23.0.2499,)";
	public static final String URL = "http://dark-roleplay.net/";
	public static final List<String> AUTHORS = Arrays.asList("JTK222");
	public static final String CREDITS = "Lead Programmer: JTK222";
	public static final String DESCRIPTION = "Dark Roleplay Core is a mixture of a Library and a content adding mod. \nMost parts of it can't be used without another mod, \neven though there are a few things like the \"Blueprint Controller\" which are available without other mods.";
	
	public static File DARK_ROLEPLAY_CONFIGS;
	public static File DARK_ROLEPLAY_FOLDER;
	public static File DARK_ROLEPLAY_BLUEPRINTS_FOLDER;
	public static File DARK_ROLEPLAY_RECIPES_FOLDER;
	public static File DARK_ROLEPLAY_ARGH;
	public static Logger LOGGER;
	
	public static Side SIDE;
	
	public static CheckResult VERSION_STATUS;
	
	public static void init(FMLPreInitializationEvent event){
		DRPCoreReferences.LOGGER = LogManager.getLogger(DRPCoreReferences.MODID);
		
		DRPCoreReferences.SIDE = event.getSide();
		
		DARK_ROLEPLAY_CONFIGS = event.getModConfigurationDirectory();
		DRPCoreReferences.DARK_ROLEPLAY_FOLDER = new File(event.getModConfigurationDirectory().getParentFile().getPath() + "/dark roleplay/");
		DRPCoreReferences.DARK_ROLEPLAY_FOLDER.mkdirs();
		DRPCoreReferences.DARK_ROLEPLAY_BLUEPRINTS_FOLDER = new File(DRPCoreReferences.DARK_ROLEPLAY_FOLDER.getPath() + "/blueprints/");
		DRPCoreReferences.DARK_ROLEPLAY_BLUEPRINTS_FOLDER.mkdirs();
		DRPCoreReferences.DARK_ROLEPLAY_RECIPES_FOLDER = new File(DRPCoreReferences.DARK_ROLEPLAY_FOLDER.getPath() + "/recipes/");
		DRPCoreReferences.DARK_ROLEPLAY_RECIPES_FOLDER.mkdirs();
		DARK_ROLEPLAY_ARGH = new File(DRPCoreReferences.DARK_ROLEPLAY_FOLDER.getPath() + "/argh/assets/");
		DARK_ROLEPLAY_ARGH.mkdirs();
		
		ModContainer mod = Loader.instance().activeModContainer();
		if(mod.getModId().equals(DRPCoreReferences.MODID)){
			DRPCoreReferences.VERSION_STATUS = ForgeVersion.getResult(mod);
		}
		
		ModMetadata meta = event.getModMetadata();
		meta.autogenerated = false;
		meta.modId = MODID;
		meta.name = NAME;
		meta.authorList = AUTHORS;
		meta.credits = CREDITS;
		meta.description = DESCRIPTION;
		meta.version = VERSION;
		meta.url = URL;
		meta.updateJSON = UPDATE_JSON;
	}
}

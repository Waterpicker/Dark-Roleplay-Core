package net.dark_roleplay.core.common;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.gui.toasts.TutorialToast;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.ForgeVersion.CheckResult;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class References {

	public static final String MODID = "drpcore";
	public static final String NAME = "Dark Roleplay Core";
	public static final String VERSION = "0.4.0";
	public static final String ACCEPTEDVERSIONS = "[1.12,1.13)";
	public static final String UPDATE_JSON = "http://dark-roleplay.net/version_files/DarkRoleplayCore.json";
	public static final String DEPENDECIES = "required-after:forge@[1.12.2-14.23.0.2499,)";
	public static final String URL = "http://dark-roleplay.net/";
	public static final List<String> AUTHORS = Arrays.asList("JTK222");
	public static final String CREDITS = "Lead Programmer: JTK222";
	public static final String DESCRIPTION = "Dark Roleplay Core is a mixture of a Library and a content adding mod. \nMost parts of it can't be used without another mod, \neven though there are a few things like the \"Blueprint Controller\" which are available without other mods.";
	
	public static File FOLDER_CONFIGS;
	public static File FOLDER_MAIN;
	public static File FOLDER_BLUEPRINTS;
	public static File FOLDER_RECIPES;
	public static File FOLDER_ARG;
	
	@SideOnly (Side.SERVER)
	public static File FOLDER_PERMISSIONS;
	@SideOnly(Side.SERVER)
	public static File FOLDER_PERMISSIONS_USERS;
	@SideOnly(Side.SERVER) 
	public static File FOLDER_PERMISSIONS_GROUPS;
	
	public static Logger LOGGER;
	
	public static Side SIDE;
	
	public static CheckResult VERSION_STATUS;
	
	public static final TutorialToast CRAFTING_TUT = new TutorialToast(TutorialToast.Icons.RECIPE_BOOK, new TextComponentTranslation("drpcore.tutorial.craft.title"), new TextComponentTranslation("drpcore.tutorial.craft.desc", "C"), false);
	
	public static void init(FMLPreInitializationEvent event){
		References.LOGGER = LogManager.getLogger(References.MODID);
		
		References.SIDE = event.getSide();
		
		FOLDER_CONFIGS = event.getModConfigurationDirectory();
		
		FOLDER_MAIN = new File(event.getModConfigurationDirectory().getParentFile().getPath() + "/dark roleplay/");
		FOLDER_MAIN.mkdirs();
		
		FOLDER_RECIPES = new File(FOLDER_MAIN.getPath() + "/recipes/");
		FOLDER_RECIPES.mkdirs();

		FOLDER_BLUEPRINTS = new File(FOLDER_MAIN.getPath() + "/blueprints/");
		FOLDER_BLUEPRINTS.mkdirs();
		
		if(SIDE.isServer()) {
			
			FOLDER_PERMISSIONS = new File(FOLDER_MAIN.getPath() + "/permissions/");
			FOLDER_PERMISSIONS.mkdirs();
			FOLDER_PERMISSIONS_USERS = new File(FOLDER_PERMISSIONS.getPath() + "/users/");
			FOLDER_PERMISSIONS_USERS.mkdirs();
			FOLDER_PERMISSIONS_GROUPS = new File(FOLDER_PERMISSIONS.getPath() + "/groups/");
			FOLDER_PERMISSIONS_GROUPS.mkdirs();
		}
		
		FOLDER_ARG = new File(FOLDER_MAIN.getPath() + "/argh/assets/");
		FOLDER_ARG.mkdirs();
		
		ModContainer mod = Loader.instance().activeModContainer();
		if(mod.getModId().equals(References.MODID)){
			References.VERSION_STATUS = ForgeVersion.getResult(mod);
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

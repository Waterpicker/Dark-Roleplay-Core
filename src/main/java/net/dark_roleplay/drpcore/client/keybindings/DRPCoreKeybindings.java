package net.dark_roleplay.drpcore.client.keybindings;

import org.lwjgl.input.Keyboard;

import net.dark_roleplay.drpcore.common.DarkRoleplayCore;
import net.dark_roleplay.drpcore.common.handler.DRPCoreGuis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class DRPCoreKeybindings {

	public static KeyBinding openCrafting = new KeyBinding("keyBinding.openCrafting", Keyboard.KEY_C, "Dark Roleplay Core");
	public static KeyBinding openCrafting2 = new KeyBinding("keyBinding.openCrafting2", Keyboard.KEY_V, "Dark Roleplay Core");

	
	public static void preInit(FMLPreInitializationEvent event) {}

	public static void init(FMLInitializationEvent event) {
		ClientRegistry.registerKeyBinding(openCrafting);
		ClientRegistry.registerKeyBinding(openCrafting2);
		MinecraftForge.EVENT_BUS.register(new DRPCoreKeybindings());
	}

	public static void postInit(FMLPostInitializationEvent event) {}
	
	@SubscribeEvent
	public void KeyInput(KeyInputEvent event) {

		if(this.openCrafting.isKeyDown()) {
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			player.openGui(DarkRoleplayCore.instance, DRPCoreGuis.DRPCORE_GUI_CRAFTING_RECIPESELECTION, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		}else if(this.openCrafting2.isKeyDown()){
			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			player.openGui(DarkRoleplayCore.instance, DRPCoreGuis.DRPCORE_GUI_CRAFTING_RECIPECRAFTING_SIMPLE, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		}
	}
	
}

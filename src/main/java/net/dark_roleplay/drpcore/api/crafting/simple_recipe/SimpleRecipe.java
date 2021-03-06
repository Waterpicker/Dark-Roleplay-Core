package net.dark_roleplay.drpcore.api.crafting.simple_recipe;

import net.dark_roleplay.drpcore.common.crafting.CraftingRegistry;
import net.dark_roleplay.drpcore.common.handler.DRPCoreCapabilities;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class SimpleRecipe extends IRecipe.Impl{
	
	private ItemStack[] mainIngredients;
	
	private ItemStack[] mainOutput;
	
	private boolean[] ignoreMeta;
	
	private SimpleCrafter crafter;

	public SimpleRecipe(ResourceLocation registryName, Block station, String category, ItemStack[] mainOutput, ItemStack[] mainIngredients){
		this(registryName, mainOutput, mainIngredients);
		this.crafter = CraftingRegistry.SIMPLE_CRAFTER_INSTANCE;
	}
	
	public SimpleRecipe(ResourceLocation registryName, ItemStack[] mainOutput, ItemStack[] mainIngredients){
		this.registryName = registryName;
		this.mainOutput = mainOutput;
		this.mainIngredients = mainIngredients;
		this.ignoreMeta = new boolean[mainIngredients.length];
		this.crafter = new SimpleCrafter();
		this.displayItems = mainOutput;
		
		for(int i = 0; i < this.ignoreMeta.length; i++){
			this.ignoreMeta[i] = false; 
		}
	}
	
	
	
	//------------------------------------------------------------ Getter ------------------------------------------------------------

	public boolean[] getIgnoreMeta() {
		return ignoreMeta;
	}


	public ItemStack[] getMainIngredients(){
		return mainIngredients.clone();
	}

	public ItemStack[] getMainOutput(){
		return mainOutput.clone();
	}
	
	
	public SimpleCrafter getCrafter() {
		return crafter;
	}

	//------------------------------------------------------------ Setters ------------------------------------------------------------
	
	public SimpleRecipe setRequiresUnlock(boolean requiresUnlock){
		this.requiresUnlock = requiresUnlock;
		return this;
	}
	
	public void setCrafter(SimpleCrafter crafter) {
		this.crafter = crafter;
	}
}

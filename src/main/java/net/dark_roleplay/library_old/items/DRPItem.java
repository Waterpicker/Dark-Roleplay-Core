package net.dark_roleplay.library_old.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.FMLContainer;
import net.minecraftforge.fml.common.InjectedModContainer;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author JTK222
 */
public class DRPItem extends Item{

	protected String[] subNames;
	protected String itemFolder;

	/**
	 * A Variant for Item that Automaticly registers it's Model	and has also easy to use support for sub Items
	 * ({@link net.dark_roleplay.library_old.items.ItemUtil#addItem(DRPItem) ItemUtil.addItem(DRPItem)} should be called by each Mod during the Model Registry Event)
	 * @param stackSize
	 * @param subNames
	 */
	public DRPItem(String name, int stackSize, String... subNames){
		this(name, null, stackSize, subNames);
	}

	public DRPItem(String name, String itemFolder, int stackSize, String... subNames){
		ModContainer mc = Loader.instance().activeModContainer();
        String modid = (mc == null) || ((mc instanceof InjectedModContainer) && (((InjectedModContainer)mc).wrappedContainer instanceof FMLContainer)) ? "minecraft" : mc.getModId().toLowerCase();

        this.setTranslationKey(name);
		this.setRegistryName(modid + ":" + name);

		this.setMaxStackSize(stackSize);
		if(subNames != null && subNames.length > 0){
	        this.setHasSubtypes(true);
		}
		this.subNames = subNames != null && subNames.length > 0 ? subNames : null;
		this.itemFolder = itemFolder;

		ItemUtil.addItem(this);
	}

	/**
	 * Returns the Folder/Folder Path for the Model files
	 * @return
	 */
	public String getItemFolder() {
		return this.itemFolder;
	}

	/**
	 * Returns an Array of Sub Names for this Item,
	 * this is also used to register the model files.
	 * @return
	 */
	public String[] getSubNames(){
		return this.subNames;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list){
		if(this.isInCreativeTab(tab)){
			if(this.getSubNames()!=null){
				for(int i=0;i<this.getSubNames().length;i++){
					list.add(new ItemStack(this,1,i));
				}
			}else{
				list.add(new ItemStack(this));
			}
		}
	}

	@Override
	public String getTranslationKey(ItemStack stack){
		if(this.getSubNames()!=null){
			String subName = stack.getItemDamage() < this.getSubNames().length ? "." + this.getSubNames()[stack.getItemDamage()] : "";
			return this.getTranslationKey() + subName;
		}
		return this.getTranslationKey();
	}
}
package net.drpcore.common.network.packets.guis;

import net.drpcore.common.DarkRoleplayCore;
import net.drpcore.common.gui.GuiHandler;
import net.drpcore.common.network.PacketBase;
import net.drpcore.common.util.schematic.Schematic;
import net.minecraft.entity.player.EntityPlayer;
import io.netty.buffer.ByteBuf;


public class PacketOpenInventory extends PacketBase<PacketOpenInventory> {

	@Override
	public void fromBytes(ByteBuf buf) {}

	@Override
	public void toBytes(ByteBuf buf) {}

	@Override
	public void handleClientSide(PacketOpenInventory message, EntityPlayer player) {}

	@Override
	public void handleServerSide(PacketOpenInventory message, EntityPlayer player) {

		player.openGui(DarkRoleplayCore.instance, GuiHandler.GUI_INVENTORY, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
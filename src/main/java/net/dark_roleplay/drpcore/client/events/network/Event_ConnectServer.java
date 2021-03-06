package net.dark_roleplay.drpcore.client.events.network;

import net.dark_roleplay.drpcore.common.DRPCoreInfo;
import net.dark_roleplay.drpcore.common.config.SyncedConfigRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class Event_ConnectServer {

	@SubscribeEvent
	public void connectServer(FMLNetworkEvent.ClientConnectedToServerEvent event) {
		if(!event.isLocal())
			SyncedConfigRegistry.establishServerConnection();
	}
	

	@SubscribeEvent
	public void disconnectServer(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
			SyncedConfigRegistry.disconnectFromServer();
	}
}

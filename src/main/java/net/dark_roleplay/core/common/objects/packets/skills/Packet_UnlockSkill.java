package net.dark_roleplay.core.common.objects.packets.skills;

import io.netty.buffer.ByteBuf;
import net.dark_roleplay.library.networking.PacketBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class Packet_UnlockSkill extends PacketBase.Server<Packet_UnlockSkill>{
	
	private String skill;

	public Packet_UnlockSkill(){
		this.skill = null;
	}
	
	public Packet_UnlockSkill(String skillPoint){
		this.skill = skillPoint;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.skill = ByteBufUtils.readUTF8String(buf);		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.skill);
	}

	@Override
	public void handleServerSide(Packet_UnlockSkill message, EntityPlayer player) {
//		player.getServer().addScheduledTask(
//			new Runnable(){
//				public void run() {
//					ISkillController controller = (ISkillController) player.getCapability(DRPCoreCapabilities.DRPCORE_SKILL_CONTROLLER, null);
//					Skill skill = SkillRegistry.getSkillByName(message.skill);
//	
//					if(skill != null && !controller.hasSkill(skill)){
//	
//						SkillRequirements req = skill.getRequirements();
//						for(SkillPoint point : req.getRequiredPoints()){
//	
//							SkillPointData data = controller.getSkillPointData(point);
//							if(data == null || data.getAmount() < req.getRequiredAmount(point)){
//								return;
//							}
//						}
//						for(Skill parent : skill.getParents()){
//							if(!controller.hasSkill(parent)){
//								return;
//							}
//						}
//						for(SkillPoint point : req.getRequiredPoints()){
//							controller.consumeSkillPoint(point, req.getRequiredAmount(point));
//						}
//						controller.unlockSkill(skill);
//						skill.unlock(player);
//					}
//				}
//			}
//		);
	}
}
package com.tayjay.getpwned.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by tayjay on 2017-12-02.
 */
public class PacketOpenOtherPlayerInventory extends PacketRunnable<PacketOpenOtherPlayerInventory>
{
    private int target;

    public PacketOpenOtherPlayerInventory(){}

    public PacketOpenOtherPlayerInventory(EntityPlayer openingPlayer)
    {

        this.target = openingPlayer.getEntityId();
    }
    @Override
    public void handleServer(PacketOpenOtherPlayerInventory message, MessageContext ctx)
    {
        EntityPlayerMP player = ctx.getServerHandler().playerEntity;

        EntityPlayerMP other = (EntityPlayerMP) player.worldObj.getEntityByID(this.target);
        player.addChatComponentMessage(new TextComponentString("Target is: "+other));
        player.displayGUIChest(other.inventory);
    }

    @Override
    public void handleClient(PacketOpenOtherPlayerInventory message, MessageContext ctx)
    {

    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.target = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.target);

    }
}

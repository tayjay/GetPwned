package com.tayjay.getpwned.network;

import com.tayjay.getpwned.GetPwned;
import com.tayjay.getpwned.network.packets.PacketOpenOtherPlayerInventory;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by tayjay on 2017-12-02.
 */
public class NetworkManager
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(GetPwned.MODID);

    /**
     * Register packets on load
     */
    static
    {
        int desc = 0;//Discriminator
        INSTANCE.registerMessage(PacketOpenOtherPlayerInventory.class,PacketOpenOtherPlayerInventory.class,desc++, Side.SERVER);
    }

    public static void sendToAll(IMessage msg)
    {
        INSTANCE.sendToAll(msg);
    }

    public static void sendTo(IMessage msg, EntityPlayerMP player)
    {
        INSTANCE.sendTo(msg,player);
    }

    public static void sendToAllAround(IMessage msg, EntityPlayerMP player, double range)
    {
        sendToAllAround(msg, player.dimension, player.posX, player.posY, player.posZ, range);
    }

    public static void sendToAllAround(IMessage msg, int dim, double x, double y, double z, double range)
    {
        INSTANCE.sendToAllAround(msg, new NetworkRegistry.TargetPoint(dim, x, y, z, range));
    }

    public static void sendToServer(IMessage msg)
    {
        INSTANCE.sendToServer(msg);
    }

}

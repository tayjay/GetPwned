package com.tayjay.getpwned.event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

/**
 * Created by tayjay on 2017-12-02.
 */
public class EventHandler
{
    /**
     * Handles silencing of a player
     * @param event
     */
    @SubscribeEvent
    public void serverChatEvent(ServerChatEvent event)
    {

    }

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent event)
    {
        if (event.getEntityPlayer().worldObj.isRemote)
        {
            RayTraceResult result = Minecraft.getMinecraft().objectMouseOver;
            if (result.entityHit != null)
            {
                //event.getEntityPlayer().addChatComponentMessage(new TextComponentString(result.entityHit.toString()));

            }
        }
        /*if (event.getItemStack() == null)
        {
            RayTraceResult result = event.getEntityPlayer().rayTrace(5, 0);
            if (result.entityHit != null)
            {
                event.getEntityPlayer().addChatComponentMessage(new TextComponentString(result.entityHit.toString()));
            }
        }*/
    }
}

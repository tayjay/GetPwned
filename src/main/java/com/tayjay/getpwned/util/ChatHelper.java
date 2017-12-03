package com.tayjay.getpwned.util;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by tayjay on 2017-12-02.
 */
public class ChatHelper
{
    /**
     * Sends a chat message as another player.
     * Note that this impl only works from a server side.
     * @param other
     * @param msg
     */
    public static void sendChatAs(String other, String msg)
    {
        ITextComponent itextcomponent = new TextComponentTranslation("chat.type.text", other, net.minecraftforge.common.ForgeHooks.newChatWithLinks(msg));
        FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().sendChatMsg(itextcomponent);
    }
}

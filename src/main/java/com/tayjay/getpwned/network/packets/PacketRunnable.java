package com.tayjay.getpwned.network.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by tayjay on 2017-12-02.
 */
public abstract class PacketRunnable<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, IMessage>
{
    public PacketRunnable(){}

    @Override
    public REQ onMessage(REQ message, MessageContext ctx)
    {
        if(ctx.side == Side.CLIENT)
            Minecraft.getMinecraft().addScheduledTask(getClientRunnable(message,ctx));
        else
            ctx.getServerHandler().playerEntity.getServerWorld().addScheduledTask(getServerRunnable(message,ctx));
        return null;
    }

    /**
     * Make the runnable to be used in the server ScheduledTask list.
     * Passes all code to another method to make writing children easier.
     * @param message
     * @param ctx
     * @return
     */
    private Runnable getServerRunnable(final REQ message,final MessageContext ctx)
    {
        return new Runnable()
        {
            @Override
            public void run()
            {
                handleServer(message,ctx);
            }
        };
    }

    /**
     * This method will be passed to the ServerWorld ScheduledTask list for server execution.
     * Makes it easier than manually detecting side and creating a runnable in every packet.
     * Should be safe to run this because it isn't executed until it is in the main thread.
     * @param message   Message being handled
     * @param ctx       Server context
     */
    public abstract void handleServer(final REQ message,final MessageContext ctx);

    /**
     * Make the runnable to be used in the client ScheduledTask list.
     * Passes all code to another method to make writing children easier.
     * @param message
     * @param ctx
     * @return
     */
    private Runnable getClientRunnable(final REQ message, final MessageContext ctx)
    {
        return new Runnable()
        {
            @Override
            public void run()
            {
                handleClient(message,ctx);
            }
        };
    }

    /**
     * This method will be passed to the client ScheduledTask list for client execution.
     * Easier than detecting client side and creating runnable manually in each packet.
     * Should be safe to run this because it isn't executed until it is in the main thread.
     * @param message   Message being handled
     * @param ctx       Client context
     */
    public abstract void handleClient(REQ message,MessageContext ctx);
}
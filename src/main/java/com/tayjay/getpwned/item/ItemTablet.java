package com.tayjay.getpwned.item;

import com.tayjay.getpwned.network.NetworkManager;
import com.tayjay.getpwned.network.packets.PacketOpenOtherPlayerInventory;
import com.tayjay.getpwned.util.ChatHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by tayjay on 2017-12-02.
 */
public class ItemTablet extends ItemBase
{
    public ItemTablet(String name)
    {
        super(name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        //ChatHelper.sendChatAs("Notch","...");

        if (Minecraft.getMinecraft()!=null)
        {
            RayTraceResult result = Minecraft.getMinecraft().objectMouseOver;
            if(result.entityHit!=null && result.entityHit instanceof EntityPlayer)
            {
                NetworkManager.sendToServer(new PacketOpenOtherPlayerInventory((EntityPlayer) result.entityHit));
            }

        }
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}

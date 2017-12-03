package com.tayjay.getpwned.item;

import com.tayjay.getpwned.GetPwned;
import com.tayjay.getpwned.init.IItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by tayjay on 2017-12-02.
 */
public class ItemBase extends Item implements IItemModelProvider
{
    protected String name;

    public ItemBase(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", GetPwned.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", GetPwned.MODID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    public String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public void registerItemModel(Item item)
    {
        GetPwned.proxy.registerItemRenderer(this,0,this.name);
    }
}

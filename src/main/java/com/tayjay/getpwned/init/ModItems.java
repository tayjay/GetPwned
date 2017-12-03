package com.tayjay.getpwned.init;

import com.tayjay.getpwned.item.ItemBase;
import com.tayjay.getpwned.item.ItemTablet;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by tayjay on 2017-12-02.
 */
public class ModItems
{
    public static ItemBase tablet;

    public static void init()
    {
        //Initialize Items
        tablet = register(new ItemTablet("tablet"));
    }

    private static <T extends Item> T register(T item)
    {
        GameRegistry.register(item);

        if (item instanceof IItemModelProvider)
        {
            ((IItemModelProvider) item).registerItemModel(item);
        }
        return item;
    }
}

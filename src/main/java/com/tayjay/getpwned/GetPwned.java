package com.tayjay.getpwned;

import com.tayjay.getpwned.event.EventHandler;
import com.tayjay.getpwned.init.ModItems;
import com.tayjay.getpwned.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by tayjay on 2017-12-02.
 */
@Mod(modid = GetPwned.MODID, name = GetPwned.NAME, version = GetPwned.VERSION)
public class GetPwned
{
    @Mod.Instance
    public static GetPwned instane;

    @SidedProxy(serverSide = "com.tayjay.getpwned.proxy.CommonProxy",clientSide = "com.tayjay.getpwned.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static final String MODID = "getpwned";
    public static final String NAME = "Get Pwned";
    public static final String VERSION = "0.0.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init();

        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        proxy.init();
    }



}

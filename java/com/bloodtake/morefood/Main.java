package com.bloodtake.morefood;

import com.bloodtake.morefood.item.MoreCrops;
import com.bloodtake.morefood.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Resources.MODID,name = Resources.NAME,version = Resources.VERSION)
public class Main {
	
	@SidedProxy(clientSide= Resources.ClientProxy, serverSide= Resources.CommonProxy)
	public static CommonProxy proxy;
	
	@Instance   
	public static Main instance = new Main();
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) 
    {
    	proxy.preInit(event); 
    	MoreCrops.setGrassLootDrops();
    }
    @EventHandler
    public void init(FMLInitializationEvent event) 
    {
    	proxy.init(event);
    }
        
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
        proxy.postInit(event);
    }
	
}

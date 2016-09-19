package com.bloodtake.morefood.proxy;

import com.bloodtake.morefood.item.MoreCrops;
import com.bloodtake.morefood.item.MoreFoods;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        MoreCrops.init();
        MoreFoods.init();
        
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event); 
        MoreCrops.registerRenders();
        MoreFoods.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
	
}

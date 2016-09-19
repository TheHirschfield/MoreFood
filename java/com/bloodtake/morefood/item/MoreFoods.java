package com.bloodtake.morefood.item;

import com.bloodtake.morefood.Resources;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MoreFoods {
	
	//Foods
	public static Item CORN;
	
	
	//Seeds
	public static Item CORN_SEED;
	
	
	public static void init(){
		
		//Foods
		CORN = registerItemFood("corn", 1, 3.0f, false);
		
		
		//Seeds
		CORN_SEED = registerItemSeed("corn_seed", MoreCrops.CORN_PLANT);
	}
	
	
	public static void registerRenders(){
		
		//Foods
		registerRender(CORN);
		
		//Seeds
		registerRender(CORN_SEED);
	}
	


	//Custom Methods
	
	private static Item registerItemFood(String registryName, int amount, float sat, boolean isWolfFood) {
		Item item = new ItemFood(amount, sat, isWolfFood);
		item.setCreativeTab(CreativeTabs.FOOD);
		item.setRegistryName(registryName);
		item.setUnlocalizedName(registryName);

        return GameRegistry.register(item);
    }
	
	private static Item registerItemSeed(String registryName, Block crop){
		Item item = new ItemSeeds(crop, Blocks.FARMLAND);
		item.setCreativeTab(CreativeTabs.FOOD);
		item.setRegistryName(registryName);
		item.setUnlocalizedName(registryName);
		
		return GameRegistry.register(item);
	}
	
	
	private static void registerRender(Item item) {
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Resources.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
	}
	
	
	
	
}

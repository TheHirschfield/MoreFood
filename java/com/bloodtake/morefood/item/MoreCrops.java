package com.bloodtake.morefood.item;

import com.bloodtake.morefood.Resources;
import com.bloodtake.morefood.block.crops.CornPlant;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class MoreCrops {
	
	public static Block CORN_PLANT;
	
	
	public static void init(){
		
		CORN_PLANT = new CornPlant();
	}
	
	public static void registerRenders(){
		registerRender(CORN_PLANT);
	}
	
	
	public static void setGrassLootDrops(){
		
		MinecraftForge.addGrassSeed(new ItemStack(MoreFoods.CORN_SEED,1,0),5);
	}
	
	
	private static void registerRender(Block block) {
		
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Resources.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
	
	}
	
}

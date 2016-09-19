package com.bloodtake.morefood.block.crops;

import java.util.List;
import java.util.Random;

import com.bloodtake.morefood.item.MoreFoods;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CornPlant extends BlockCrops{
	
	
	public CornPlant(){
		
		setRegistryName("corn_plant");
		setUnlocalizedName("corn_plant");
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this), getRegistryName());
		
	}
	
	@Override
	protected Item getSeed(){
		return MoreFoods.CORN_SEED;
	}
	
	@Override
	protected Item getCrop(){
		return MoreFoods.CORN;
	}
	
	
	
	@Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        this.checkAndDropBlock(worldIn, pos, state);

        if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
            int i = this.getMetaFromState(state);

            if (i < 3) {
                float f = getGrowthChance(this, worldIn, pos);

                if (rand.nextInt((int) (25.0F / f) + 1) == 0) {
                    worldIn.setBlockState(pos, this.getStateFromMeta(i + 1), 2);
                }
            }
        }
    }
	
    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        grow(worldIn, pos, state);
    }
    
    
	
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {

        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();

        Random rand = world instanceof World ? ((World) world).rand : new Random();

        int age = getMetaFromState(state);

        int count = quantityDropped(state, fortune, rand);
        for (int i = 0; i < count; i++) {
            Item item = this.getItemDropped(state, rand, fortune);
            if (item != null) {
                ret.add(new ItemStack(item, 1, this.damageDropped(state)));
            }
        }

        if (age >= 3) {
            for (int i = 0; i < 3 + fortune; ++i) {
                if (rand.nextInt(2 * 3) <= age) {
                    ret.add(new ItemStack(this.getSeed(), 1, 0));
                }
            }
        }

        return ret;
    }
}

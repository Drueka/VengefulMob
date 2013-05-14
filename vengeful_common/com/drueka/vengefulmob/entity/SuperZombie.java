package com.drueka.vengefulmob.entity;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class SuperZombie extends EntityMob{

            public SuperZombie(World par1World) {
            super(par1World);
            
          
    this.texture = "/mob/superzombie.png";
    
    this.moveSpeed = 0.5F;
    this.getNavigator().setBreakDoors(true);
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(1, new EntityAIBreakDoor(this));
    this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
    this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.moveSpeed, true));
    this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
    this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
    this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
    this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
    this.tasks.addTask(7, new EntityAILookIdle(this));
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
    this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
        }

        @Override
        public int getMaxHealth() {
            return 20;
        }
    public int getAttackStrength(){
            return 100;
        }
    
    @SuppressWarnings("unused")
    private static final float[] armorProbability = new float[] {0.0F, 0.0F, 0.05F, 1.0F};
        
    
    public int getTotalArmorValue()
        {
            return 5;
        }

     public EnumCreatureAttribute getCreatureAttribute(){
            return EnumCreatureAttribute.UNDEAD;
        }
    
     protected String getDeathSound(){
         return "mob.zombie.death";
     }
     
     protected String getLivingSound(){
         return "mob.endermen.scream3";
     }
     
     protected String getHurtSound(){
         return "mob.skeletonhurt3";
     }
     
     protected void playStepSound(int par1, int par2, int par3, int par4)
     {
         this.playSound("mob.zombie.step", 0.15F, 1.0F);
     }
     
     
     
             
     
     public void onLivingUpdate()
     {
         if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
         {
             float var1 = this.getBrightness(1.0F);

             if (var1 > 0.5F && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
             {
                 boolean var2 = true;
                 ItemStack var3 = this.getCurrentItemOrArmor(4);

                 if (var3 != null)
                 {
                     if (var3.isItemStackDamageable())
                     {
                         var3.setItemDamage(var3.getItemDamageForDisplay() + this.rand.nextInt(2));

                         if (var3.getItemDamageForDisplay() >= var3.getMaxDamage())
                         {
                             this.renderBrokenItemStack(var3);
                             this.setCurrentItemOrArmor(4, (ItemStack)null);
                             
                         }
                     }

                     var2 = false;
                 }

                 if (var2)
                 {
                     this.setFire(8);
                 }
             }
         }

         super.onLivingUpdate();
     }
}   

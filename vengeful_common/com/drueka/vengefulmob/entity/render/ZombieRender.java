package com.drueka.vengefulmob.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import com.drueka.vengefulmob.entity.SuperZombie;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ZombieRender extends RenderLiving
{
    
   
    public ZombieRender(SuperZombieMob par1ModelBase, float par2) {
        super(par1ModelBase, par2);
        
    }

    public void renderSuperZombie(SuperZombie par1EntitySuperZombie, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(par1EntitySuperZombie, par2, par4, par6, par8, par9);
    }
 
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSuperZombie((SuperZombie)par1EntityLiving, par2, par4, par6, par8, par9);
        
               
        
    }

    
            
            
    
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSuperZombie((SuperZombie)par1Entity, par2, par4, par6, par8, par9);
    }
}
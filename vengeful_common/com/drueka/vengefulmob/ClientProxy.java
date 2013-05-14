package com.drueka.vengefulmob;


import net.minecraftforge.client.MinecraftForgeClient;

import com.drueka.vengefulmob.entity.SuperZombie;
import com.drueka.vengefulmob.entity.render.SuperZombieMob;
import com.drueka.vengefulmob.entity.render.ZombieRender;

import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends ServerProxy{
    
    public void registerRenderThings()
    {
                                                                                                   // added null here to test for ffs
    RenderingRegistry.registerEntityRenderingHandler(SuperZombie.class, new ZombieRender(new SuperZombieMob(), 0.5F));
    MinecraftForgeClient.preloadTexture("/mob/superzombie.png");
    }

   
}



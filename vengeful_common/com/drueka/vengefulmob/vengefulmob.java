package com.drueka.vengefulmob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.drueka.vengefulmob.entity.Megacreeper;
import com.drueka.vengefulmob.lib.reference;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.EntityRegistry.EntityRegistration;

@Mod( 
        modid = reference.MOD_ID, 
        name = reference.MOD_NAME, 
        version = reference.VERSION)



public class vengefulmob {
    // PreInit is before mod init
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    // block and items registration     
    
        
    }
  //  (Megacreeper.class, "Mega Creeper", 50, this, 80, 3, true);
    static int startEntityId = 300;
    
    // Init is ran as forge loads mod
    
    @Init
    public void init(FMLInitializationEvent event) {
    
        EntityRegistry.registerModEntity(Megacreeper.class, "BlackCreeper", 50, this, 80, 3, true);
        
        EntityRegistry.addSpawn(Megacreeper.class, 5, 2, 5, EnumCreatureType.monster, BiomeGenBase.desert);
        
        LanguageRegistry.instance().addStringLocalization("entity.VM1.BlackCreeper.name", "Black Creeper");
        
        registerEntityEgg(Megacreeper.class, 0x000000, 0x00FF00);
    }
    // PostInit is after all mods are loaded
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
    
    public static int getUniqueEntityId()
    {
        do
        {
            startEntityId++;
        }
        while(EntityList.getStringFromID(startEntityId) != null);
        
        return startEntityId;
        }
    

    
    @SuppressWarnings("unchecked")
    public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
    {
        
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }
}
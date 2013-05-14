package com.drueka.vengefulmob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.drueka.vengefulmob.entity.SuperZombie;
import com.drueka.vengefulmob.lib.reference;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod( 
        modid = reference.MOD_ID, 
        name = reference.MOD_NAME, 
        version = reference.VERSION)

@NetworkMod(clientSideRequired = true, serverSideRequired = true)


    

public class vengefulmob {
    
    @SidedProxy(clientSide = "com.drueka.vengefulmob.ClientProxy", serverSide ="com.drueka.vengefulmob.ServerProxy")
    public static ServerProxy proxy;
    
    
    // PreInit is before mod init
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
    // block and items registration     
    
    }
  
   
    static int startEntityId = 300;
    
    // Init is ran as forge loads mod
    
  
    @Init
    public void init(FMLInitializationEvent event) {
    proxy.registerRenderThings();    
    
    EntityRegistry.registerModEntity(SuperZombie.class, "superzombie", 1, this, 80, 3, true);
   
    EntityRegistry.addSpawn(SuperZombie.class, 10, 2, 6, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.forest, 
            BiomeGenBase.jungle, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
    
    LanguageRegistry.instance().addStringLocalization("entity.VM1.superzombie.name", "Super Zombie"); 
    
    EntityEgg(SuperZombie.class, 0x000000, 0x2FE01B);    
      // 0x000000, 0x00FF00);
    
    
    }
   
    
    // PostInit is after all mods are loaded
   
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
    
    @SuppressWarnings("unchecked")
    public static void EntityEgg(Class<? extends Entity > entity, int primaryColor, int secondaryColor){
        int id = getUniqueID();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }
   
    
    

    public static int getUniqueID(){
        int EntityId = 300;
        do{
            EntityId++;
        } while(EntityList.getStringFromID(EntityId) != null);
        return EntityId;
    }
    
   
}
  

    
   
   

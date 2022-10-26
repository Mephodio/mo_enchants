package net.ldm.mo_enchants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import static net.ldm.mo_enchants.MoEnchantsMod.MODID;

public class Datagen {

    @SubscribeEvent
    public static void gatherData( GatherDataEvent event)
    {
        Gson GSON = new GsonBuilder()
                .registerTypeAdapter(Variant.class, new Variant.Deserializer())
                .registerTypeAdapter(ItemCameraTransforms.class, new ItemCameraTransforms.Deserializer())
                .registerTypeAdapter(ItemTransformVec3f.class, new ItemTransformVec3f.Deserializer())
                .create();

        DataGenerator gen = event.getGenerator();

        /* None of these are required as of right now.
        if (event.includeClient())
        {
            gen.addProvider(new Lang(gen));
            // Let blockstate provider see generated item models by passing its existing file helper
            ItemModelProvider itemModels = new ItemModels(gen, event.getExistingFileHelper());
            gen.addProvider(itemModels);
            gen.addProvider(new BlockStates(gen, itemModels.existingFileHelper));
            gen.addProvider(new SoundDefinitions(gen, event.getExistingFileHelper()));
        }*/
        if (event.includeServer())
        {
            //gen.addProvider(new Recipes(gen));
            gen.addProvider(new Tags(gen, event.getExistingFileHelper()));
            //gen.addProvider(new Advancements(gen, event.getExistingFileHelper()));
        }
    }

    public static class Tags extends BlockTagsProvider {
        public Tags( DataGenerator gen, ExistingFileHelper existingFileHelper ) {
            super(gen, MODID, existingFileHelper);
        }

        @Override
        protected void addTags() {
            tag(BiomeTags.bind(new ResourceLocation(MODID, "is_frozen").toString()))
                    .add(Biomes.ICE_SPIKES);
        }
    }
}
package itv1.sbw.cp.client;

import itv1.sbw.cp.CivilianPackMod;
import itv1.sbw.cp.client.renderer.entity.Vaz2107Renderer;
import itv1.sbw.cp.init.ModEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = CivilianPackMod.MODID, value = Dist.CLIENT)
public class ModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.VAZ_2107.get(), Vaz2107Renderer::new);
    }
}

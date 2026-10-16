package itv1.sbw.cp.init;

import itv1.sbw.cp.CivilianPackMod;
import itv1.sbw.cp.entity.vehicle.Vaz2107Entity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY =
            DeferredRegister.create(Registries.ENTITY_TYPE, CivilianPackMod.MODID);

    private static <T extends Entity> EntityType.Builder<T> vehicle(EntityType.EntityFactory<T> factory, float w, float h) {
        return EntityType.Builder.of(factory, MobCategory.MISC)
                .setTrackingRange(1028)
                .setUpdateInterval(1)
                .fireImmune()
                .sized(w, h);
    }

    public static final DeferredHolder<EntityType<?>, EntityType<Vaz2107Entity>> VAZ_2107 =
            REGISTRY.register("vaz_2107", () -> vehicle(Vaz2107Entity::new, 2.4f, 2.0f).build("vaz_2107"));
}

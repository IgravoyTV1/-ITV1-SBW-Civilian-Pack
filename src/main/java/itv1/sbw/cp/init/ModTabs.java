package itv1.sbw.cp.init;

import com.atsuishio.superbwarfare.item.container.ContainerBlockItem;
import itv1.sbw.cp.CivilianPackMod;
import net.minecraft.core.registries.Registries;import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CivilianPackMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CIVILIAN_TAB = TABS.register("civilian",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.itv1_sbw_civilian_pack.civilian"))
                    .icon(() -> new ItemStack(ModItems.VAZ_2107_ICON.get()))
                    .displayItems((param, output) -> {
                        output.accept(ContainerBlockItem.createInstance(ModEntities.VAZ_2107.get()));
                    })
                    .build());
}

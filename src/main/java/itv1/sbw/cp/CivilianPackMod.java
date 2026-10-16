package itv1.sbw.cp;

import com.mojang.logging.LogUtils;
import itv1.sbw.cp.init.ModEntities;
import itv1.sbw.cp.init.ModItems;
import itv1.sbw.cp.init.ModTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(CivilianPackMod.MODID)
public class CivilianPackMod {
    public static final String MODID = "itv1_sbw_civilian_pack";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CivilianPackMod(IEventBus modEventBus) {
        ModEntities.REGISTRY.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModTabs.TABS.register(modEventBus);
        LOGGER.info("[ITV1] SBW Civilian Pack loaded");
    }
}

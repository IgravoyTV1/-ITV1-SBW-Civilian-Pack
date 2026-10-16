package itv1.sbw.cp.init;

import itv1.sbw.cp.CivilianPackMod;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CivilianPackMod.MODID);

    public static final DeferredItem<Item> VAZ_2107_ICON =
            ITEMS.registerSimpleItem("vaz_2107_icon", new Item.Properties());
}

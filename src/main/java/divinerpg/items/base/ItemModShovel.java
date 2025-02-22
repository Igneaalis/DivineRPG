package divinerpg.items.base;

import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemModShovel extends ShovelItem {
    public ItemModShovel(Tier tier, Rarity rarity, CreativeModeTab group) {
        super(tier, 0, -1.2F, new Item.Properties().tab(group).rarity(rarity));
    }

    public ItemModShovel(Tier tier, CreativeModeTab group) {
        super(tier, 0, -1.2F, new Item.Properties().tab(group));
    }
    public ItemModShovel(Tier tier, Properties properties) {
        super(tier, 0, -1.2F, properties);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (getMaxDamage() == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        }
    }
}

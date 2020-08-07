package divinerpg.objects.entities.entity.npc;

import divinerpg.objects.entities.entity.EntityDivineVillager;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.*;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class EntityTheHunger extends EntityDivineVillager {
    public EntityTheHunger(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 2f);
    }

    protected int getGuiId() {
        return GUIHandler.THE_HUNGER_GUI_ID;
    }

    protected String[] getChatMessages() {
        return new String[] {
                "message.hunger.closer",
                "message.hunger.dinner",
                "message.hunger.fatten",
                "message.hunger.hungry"
        };
    }

    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 1, 0), new ItemStack(ItemRegistry.dreamCarrot, 2, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 3, 0), new ItemStack(ItemRegistry.dreamMelon, 4, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 5, 0), new ItemStack(ItemRegistry.dreamPie, 5, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 10, 0), new ItemStack(ItemRegistry.dreamCake, 8, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 10, 0), new ItemStack(ToolRegistry.dreamShovel, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 10, 0), new ItemStack(ToolRegistry.dreamPickaxe, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 10, 0), new ItemStack(ToolRegistry.dreamAxe, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 5, 0), new ItemStack(ItemRegistry.barredDoor, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 3, 0), new ItemStack(ItemRegistry.diskTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 3, 0), new ItemStack(ItemRegistry.cannonTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 3, 0), new ItemStack(ItemRegistry.backswordTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 3, 0), new ItemStack(ItemRegistry.hammerTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 3, 0), new ItemStack(ItemRegistry.bowTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 3, 0), new ItemStack(ItemRegistry.staffTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 3, 0), new ItemStack(ItemRegistry.clawTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 5, 0), new ItemStack(ItemRegistry.degradedTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 1, 0), new ItemStack(BlockRegistry.lightDreamBricks, 16, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 1, 0), new ItemStack(BlockRegistry.darkDreamBricks, 16, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 1, 0), new ItemStack(BlockRegistry.redDreamBricks, 16, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 2, 0), new ItemStack(BlockRegistry.dreamDirt, 64, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 1, 0), new ItemStack(BlockRegistry.smoothGlass, 16, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 4, 0), new ItemStack(BlockRegistry.firelight, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 4, 0), new ItemStack(Blocks.CHEST, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.dirtyPearls, 2, 0), new ItemStack(ItemRegistry.teakerArrow, 32, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.cleanPearls, 1, 0), new ItemStack(ItemRegistry.dreamSweets, 4, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.cleanPearls, 5, 0), new ItemStack(ItemRegistry.finishedTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.cleanPearls, 2, 0), new ItemStack(ItemRegistry.darvenArrow, 32, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.cleanPearls, 4, 0), new ItemStack(ItemRegistry.pardimalArrow, 32, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.cleanPearls, 6, 0), new ItemStack(ItemRegistry.karosArrow, 32, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.cleanPearls, 15, 0), new ItemStack(ItemRegistry.minersAmulet, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.polishedPearls, 20, 0), new ItemStack(ItemRegistry.dreamFlint, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.polishedPearls, 5, 0), new ItemStack(ItemRegistry.glisteningTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.polishedPearls, 5, 0), new ItemStack(ItemRegistry.demonizedTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.shinyPearls, 40, 0), new ItemStack(ItemRegistry.moonClock, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.shinyPearls, 25, 0), new ItemStack(ItemRegistry.bandOfHeivaHunting, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.shinyPearls, 1, 0), new ItemStack(ItemRegistry.dreamSours, 4, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.shinyPearls, 4, 0), new ItemStack(ItemRegistry.everArrow, 32, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.shinyPearls, 5, 0), new ItemStack(ItemRegistry.tormentedTemplate, 1, 0)));
        list.add(new MerchantRecipe(new ItemStack(ItemRegistry.rockChunks, 25, 0), new ItemStack(WeaponRegistry.karosRockmaul, 1, 0)));
        return list;
    }
}

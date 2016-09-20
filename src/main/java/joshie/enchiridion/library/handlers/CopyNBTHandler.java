package joshie.enchiridion.library.handlers;

import joshie.enchiridion.library.LibraryHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class CopyNBTHandler extends TemporarySwitchHandler {
    @Override
    public String getName() {
        return "copynbt";
    }

    @Override
    public void handle(ItemStack stack, EntityPlayer player, EnumHand hand, int slotID, boolean isShiftPressed) {
        ItemStack library = player.getHeldItem(hand);
        if (library.hasTagCompound()) { //Copy the current configs for the library item to the item itself, to be saved
            stack.setTagCompound(library.getTagCompound());
            LibraryHelper.markDirty();
        }

        super.handle(stack, player, hand, slotID, isShiftPressed);
    }
}

package joshie.enchiridion.api.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class FeatureVisibleEvent extends PlayerEvent {
    public final String bookid;
    public final int page;
    public final int layer;
    public boolean isVisible;

    public FeatureVisibleEvent(EntityPlayer player, boolean isVisible, String bookid, int page, int layer) {
        super(player);
        this.isVisible = isVisible;
        this.bookid = bookid;
        this.page = page;
        this.layer = layer;
    }
}

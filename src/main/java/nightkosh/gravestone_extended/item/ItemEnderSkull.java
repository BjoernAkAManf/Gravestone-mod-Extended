package nightkosh.gravestone_extended.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.helper.VanillaStructuresPosition;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemEnderSkull extends ItemImpSkull {

    public ItemEnderSkull() {
        this.setUnlocalizedName("gravestone.ender_skull");
    }

    @Override
    protected String getItemRegistryName() {
        return "gs_ender_skull";
    }

    @Override
    protected boolean isCorrectDimension(World world) {
        return world.provider.isSurfaceWorld();
    }

    @Override
    protected BlockPos getPos(EntityPlayer player) {
        return VanillaStructuresPosition.getStrongHold(player);
    }
}

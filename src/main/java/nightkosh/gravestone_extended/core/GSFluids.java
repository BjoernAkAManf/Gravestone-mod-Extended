package nightkosh.gravestone_extended.core;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSFluids {

    public static final Fluid TOXIC_WATER = new Fluid("gs_toxic_water", Resources.TOXIC_WATER_STILL, Resources.TOXIC_WATER_FLOW);

    static {
        FluidRegistry.registerFluid(TOXIC_WATER);
        FluidRegistry.addBucketForFluid(TOXIC_WATER);
    }
}

package nightkosh.gravestone_extended.core;

import nightkosh.gravestone_extended.ModGravestoneExtended;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSTileEntity extends nightkosh.gravestone.core.GSTileEntity {

    public static void registration() {
        ModGravestoneExtended.proxy.registerTERenderers();
    }
}

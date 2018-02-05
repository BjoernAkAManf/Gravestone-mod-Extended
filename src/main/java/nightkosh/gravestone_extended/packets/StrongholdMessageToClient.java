package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import nightkosh.gravestone_extended.helper.VanillaStructuresPosition;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class StrongholdMessageToClient implements IMessage, IMessageHandler<StrongholdMessageToClient, IMessage> {
    private int x;
    private int y;
    private int z;

    public StrongholdMessageToClient() {

    }

    public StrongholdMessageToClient(BlockPos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
    }

    @Override
    public IMessage onMessage(StrongholdMessageToClient message, MessageContext ctx) {
        if (ctx.side.isClient()) {
            VanillaStructuresPosition.setStronghold(new BlockPos(message.x, message.y, message.z));
        }
        return null;
    }
}

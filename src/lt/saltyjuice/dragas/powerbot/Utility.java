package lt.saltyjuice.dragas.powerbot;

import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class Utility
{

    public static boolean isAtFloor(ClientContext ctx, int floor)
    {
        Tile location = getCurrentTile(ctx);
        return location.floor() == floor;
    }

    public static boolean isAtLocation(ClientContext ctx, int x, int y)
    {
        Tile location = getCurrentTile(ctx);
        return location.x() == x && location.y() == y;
    }

    public static boolean isAtLocation(ClientContext ctx, int x, int y, int floor)
    {
        return isAtFloor(ctx, floor) && isAtLocation(ctx, x, y);
    }

    /**
     * Checks whether or not the character is currently moving.
     * @param ctx
     * @return
     */
    public static boolean isMoving(ClientContext ctx)
    {
        return !ctx.movement.destination().equals(Tile.NIL);
    }

    public static boolean isNotMoving(ClientContext ctx)
    {
        return !isMoving(ctx);
    }

    private static Tile getCurrentTile(ClientContext ctx)
    {
        return ctx.players.local().tile();
    }
}

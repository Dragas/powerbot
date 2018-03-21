package lt.saltyjuice.dragas.powerbot.actions.walking.lumbridge;

import lt.saltyjuice.dragas.powerbot.Utility;
import lt.saltyjuice.dragas.powerbot.actions.walking.WalkingAction;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class GotoSouthStairsAction extends WalkingAction
{
    private int targetX = 3206;
    private int targetY = 3210;
    private int originalX = 3206;
    private int originalY = 3216;

    @Override
    protected int getTargetX()
    {
        return targetX;
    }

    @Override
    protected int getTargetY()
    {
        return targetY;
    }

    @Override
    protected int getOriginalX()
    {
        return originalX;
    }

    @Override
    protected int getOriginalY()
    {
        return originalY;
    }
}

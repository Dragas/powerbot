package lt.saltyjuice.dragas.powerbot.actions.walking.lumbridge;

import lt.saltyjuice.dragas.powerbot.actions.walking.WalkingAction;

public class GotoBankAction extends WalkingAction
{
    private int targetX = 3208;
    private int targetY = 3218;
    private int originalX = 3206;
    private int originalY = 3210;

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

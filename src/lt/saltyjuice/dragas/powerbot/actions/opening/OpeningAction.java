package lt.saltyjuice.dragas.powerbot.actions.opening;

import lt.saltyjuice.dragas.powerbot.Constant;
import lt.saltyjuice.dragas.powerbot.actions.interacting.InteractingAction;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import java.util.Arrays;

public abstract class OpeningAction extends InteractingAction
{
    @Override
    protected int getObjectID()
    {
        return getDoorId();
    }

    @Override
    protected int getSearchRadius()
    {
        return 11;
    }

    @Override
    public boolean isUsable(ClientContext ctx)
    {
        return super.isUsable(ctx) && Arrays.asList(getObject(ctx).actions()).contains("Open");
    }

    @Override
    protected void interact(GameObject obj)
    {
        obj.interact("Open");
    }

    @Override
    public boolean isFinished(ClientContext ctx)
    {
        return Arrays.asList(getObject(ctx).actions()).contains("Close");
    }

    @Override
    public void undo(ClientContext ctx)
    {

    }

    protected abstract int getDoorId();
}

package lt.saltyjuice.dragas.powerbot.actions.interacting;

import lt.saltyjuice.dragas.powerbot.actions.Action;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public abstract class InteractingAction implements Action
{
    protected abstract int getObjectID();

    protected abstract int getSearchRadius();

    protected abstract void interact(GameObject obj);

    protected GameObject getObject(ClientContext ctx)
    {
        return ctx.objects.select(getSearchRadius()).id(getObjectID()).poll();
    }

    @Override
    public boolean isUsable(ClientContext ctx)
    {
        return getObject(ctx).valid();
    }

    @Override
    public void execute(ClientContext ctx)
    {
        GameObject obj = getObject(ctx);
        interact(obj);
    }

    @Override
    public void undo(ClientContext ctx)
    {

    }
}

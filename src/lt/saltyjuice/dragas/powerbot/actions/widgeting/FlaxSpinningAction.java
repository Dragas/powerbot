package lt.saltyjuice.dragas.powerbot.actions.widgeting;

import lt.saltyjuice.dragas.powerbot.Constant;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Widget;

public class FlaxSpinningAction extends SpinInteractingAction
{
    @Override
    protected int getComponentIndex()
    {
        return Constant.Widget.CHOICE.THIRD;
    }

    @Override
    public boolean isFinished(ClientContext ctx)
    {
        return ctx.inventory.select().id(Constant.Item.FLAX).count() == 0;
    }

    @Override
    protected void interact(Widget w, Component c)
    {
        super.interact(w, c);
        long now = System.currentTimeMillis();
        Condition.wait(() -> w.ctx.widgets.select().id(Constant.Widget.LEVEL_UP).poll().valid() ||
        now + 20000 < System.currentTimeMillis() || isFinished(w.ctx), 1000, 21);
        //Condition.sleep(5000);
    }
}

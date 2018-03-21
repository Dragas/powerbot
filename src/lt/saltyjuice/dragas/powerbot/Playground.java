package lt.saltyjuice.dragas.powerbot;


import lt.saltyjuice.dragas.powerbot.actions.Action;
import lt.saltyjuice.dragas.powerbot.actions.banking.BankClosingAction;
import lt.saltyjuice.dragas.powerbot.actions.banking.BankOpeningAction;
import lt.saltyjuice.dragas.powerbot.actions.banking.depositing.BowStringDepositingAction;
import lt.saltyjuice.dragas.powerbot.actions.banking.withdrawing.FlaxWithdrawingAction;
import lt.saltyjuice.dragas.powerbot.actions.climbing.lumbridge.ClimbDownAtSouthAction;
import lt.saltyjuice.dragas.powerbot.actions.climbing.lumbridge.ClimbUpAtSouthAction;
import lt.saltyjuice.dragas.powerbot.actions.interacting.SpinnerInteractingAction;
import lt.saltyjuice.dragas.powerbot.actions.opening.LumbridgeSpinnerRoomDoorOpeningAction;
import lt.saltyjuice.dragas.powerbot.actions.walking.lumbridge.GotoBankAction;
import lt.saltyjuice.dragas.powerbot.actions.walking.lumbridge.GotoSouthStairsAction;
import lt.saltyjuice.dragas.powerbot.actions.walking.lumbridge.GotoSpinnerRoomAction;
import lt.saltyjuice.dragas.powerbot.actions.widgeting.FlaxSpinningAction;
import org.powerbot.script.Condition;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Widget;

import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Level;

@Script.Manifest(
        name = "Playground",
        description = "It's going to do things"
)
public class Playground extends AbstractPollingScript
{
    Deque<Action> queue;
    //Thread pollingThread;
    @Override
    public void onPoll()
    {
        final Action action = queue.peek();
        log.fine("Got action" + action.toString());
        if(action.isFinished(ctx))
        {
            queue.removeFirst();
            queue.addLast(action);
        }
        else if(action.isUsable(ctx))
        {
            action.execute(ctx);
            Condition.wait(() -> !action.isUsable(ctx), 200, 10);
        }
        else
        {
            Action lastAction = queue.removeLast();
            action.undo(ctx);
            queue.addFirst(lastAction);
        }
        /*
        Widget a = ctx.widgets.select().id(Constant.Widget.CHOICES).poll();
        Condition.wait(a::valid);
        Component b = a.component(Constant.Widget.CHOICE.THIRD);
        b.interact("Spin");
        Condition.wait(() -> ctx.inventory.select(it -> it.id() == Constant.Item.FLAX).count() == 0, 1000, 10);*/
    }

    @Override
    public void start()
    {
        //factory = new ActionFactory();
        queue = new LinkedList<>();
        queue.addLast(new BankOpeningAction());
        queue.addLast(new BowStringDepositingAction());
        queue.addLast(new FlaxWithdrawingAction());
        queue.addLast(new BankClosingAction());
        queue.addLast(new GotoSouthStairsAction());
        queue.addLast(new ClimbDownAtSouthAction());
        queue.addLast(new GotoSpinnerRoomAction());
        queue.addLast(new LumbridgeSpinnerRoomDoorOpeningAction());
        queue.addLast(new SpinnerInteractingAction());
        queue.addLast(new FlaxSpinningAction());
        queue.addLast(new GotoSouthStairsAction());
        queue.addLast(new ClimbUpAtSouthAction());
        queue.addLast(new GotoBankAction());
        log.setLevel(Level.ALL);
        log.fine("Starting script");
    }

    @Override
    public void stop()
    {
        log.fine("Stopping script");
    }

    @Override
    public void suspend()
    {
        log.fine("Suspended");
    }

    @Override
    public void resume()
    {
        log.fine("Resumed");
    }
}

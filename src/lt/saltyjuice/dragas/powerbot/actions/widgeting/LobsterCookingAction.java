package lt.saltyjuice.dragas.powerbot.actions.widgeting;

import lt.saltyjuice.dragas.powerbot.Constant;
import lt.saltyjuice.dragas.powerbot.Utility;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Widget;

public class LobsterCookingAction extends ChoiceInteractingAction {
	@Override
	protected int getComponentIndex() {
		return Constant.Widget.CHOICE.FIRST;
	}

	@Override
	protected void interact(Widget w, Component c) {
		c.interact("Cook");
		Condition.wait(() -> Utility.hasLeveledUp(w.ctx) || isFinished(w.ctx), 500, 3600);
	}

	@Override
	public boolean isFinished(ClientContext ctx) {
		return ctx.inventory.select().id(Constant.Item.RAW_LOBSTER).count() == 0;
	}
}

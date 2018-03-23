package lt.saltyjuice.dragas.powerbot.actions.interacting;

import lt.saltyjuice.dragas.powerbot.Constant;
import lt.saltyjuice.dragas.powerbot.Utility;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class HosidiusBankInteractingAction extends InteractingAction {

	@Override
	public boolean isUsable(ClientContext ctx) {
		return super.isUsable(ctx) && !Utility.inventoryContains(ctx, Constant.Item.RAW_LOBSTER);
	}

	@Override
	protected int getObjectID() {
		return Constant.Objects.Bank.HOSIDIUS_COOKER_BANK;
	}

	@Override
	protected int getSearchRadius() {
		return 10;
	}

	@Override
	protected void interact(GameObject obj) {
		obj.ctx.camera.turnTo(obj);
		obj.interact("Use", "Bank Chest");
		Condition.wait(() -> isFinished(obj.ctx), 500, 20);
	}

	@Override
	public boolean isFinished(ClientContext ctx) {
		return ctx.bank.opened();
	}
}

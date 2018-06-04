package lt.saltyjuice.dragas.powerbot.actions.banking.depositing;

import lt.saltyjuice.dragas.powerbot.actions.banking.withdrawing.ParticularWithdrawingAction;

public class ParticularDepositingAction extends DepositingAction
{
    private final int count;
    private final int id;

    public ParticularDepositingAction(int id, int count)
    {
        this.id = id;
        this.count = count;
    }
    @Override
    protected int getItemId()
    {
        return id;
    }

    @Override
    protected int getItemCount()
    {
        return count;
    }
}

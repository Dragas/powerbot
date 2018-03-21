package lt.saltyjuice.dragas.powerbot.actions.widgeting;

import lt.saltyjuice.dragas.powerbot.Constant;

public abstract class ChoiceInteractingAction extends WidgetInteractingAction
{
    @Override
    protected int getWidgetIndex()
    {
        return Constant.Widget.CHOICES;
    }
}

package lt.saltyjuice.dragas.powerbot;

public class Constant
{
    public static class Objects
    {
        public static class Stairs
        {
            public static final int LUMBRIDGE_SECOND_FLOOR_SOUTH = 16672;
            public static final int LUMBRIDGE_THIRD_FLOOR_SOUTH = 16673;
        }

        public static class Spinner
        {
            public static final int LUMBRIDGE_SECOND_FLOOR = 14889;
        }

        public static class Door
        {
            public static final int LUMBERIDGE_SPINNER_ROOM_DOOR = 1544;
        }

        public static class Bank
        {
            public static final int HOSIDIUS_COOKER_BANK = 21301;
        }

        public static class Stove
        {
            public static final int HOSIDIUS_CLAY_COOKER = 21302;
        }
    }

    public static class Item
    {
        public static final int FLAX = 1779;
        public static final int BOW_STRING = 1777;
        public static final int RAW_LOBSTER = 377;
        public static final int COOKED_LOBSTER = 379;
        public static final int BURNT_LOBSTER = 381;
    }

    /**
     * Constants for widget API.
     */
    public static class Widget
    {
        public static final int CHOICES = 270;
        public static final int LEVEL_UP = 233;

        /**
         * Constants for choices in Widget API (see Constant.Widget.CHOICES). Used in component(index).
         */
        public static class CHOICE
        {
            public static final int ONE_ITEM = 7;
            public static final int FIVE_ITEMS = 8;
            public static final int TEN_ITEMS = 9;
            public static final int X_ITEMS = 11;
            public static final int ALL_ITEMS = 12;
            public static final int FIRST = 14;
            public static final int SECOND = 15;
            public static final int THIRD = 16;
            public static final int FOURTH = 17;
            public static final int FIFTH = 18;
            public static final int CONTINUE = 2;
        }
    }
}

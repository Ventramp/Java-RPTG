package players;

public enum Stats {

    STRENGTH("STR"),
    DEFENSE("DEF"),
    DEXTERITY("DEX"),
    PCRITICAL ("P.CRIT");

    private final String name;

    Stats(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public static Stats getStat(String name) {

        for (Stats stat : Stats.values()) {
            if (stat.getName().equals(name)) {
                return stat;
            }
        }
        throw new IllegalArgumentException("Invalid stat: " + name);
    }
}

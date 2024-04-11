package items.armors;
import java.io.Serializable;

public enum ArmorType implements Serializable {

    HEAD, CHEST, LEGS, HANDS;

    public static String getArmorType(ArmorType type) {

        return switch (type) {
            case HEAD -> "CABEZA";
            case CHEST -> "PECHO";
            case LEGS -> "PIERNAS";
            case HANDS -> "MANOS";
        };
    }
}
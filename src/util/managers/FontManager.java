package util.managers;
import util.cache.FontCache;

public class FontManager {
private static FontManager instance;
private final FontCache fontCache;

    public FontManager() {
        fontCache =FontCache.getInstance();
    }
}

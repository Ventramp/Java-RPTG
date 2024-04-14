package util.managers;

import util.cache.FontCache;
import java.awt.*;
import java.io.File;

public class FontManager {

    private static FontManager instance;
    private final FontCache fontCache;

    private FontManager() {
        fontCache = FontCache.getInstance();
        initFonts();
    }

    private void initFonts() {
        fontCache.addFont("Game Title", new File("fonts\\fortune.otf"), 24f, false);
        fontCache.addFont("Game File", new File("fonts\\player.ttf"), 20f, true);
        fontCache.addFont("Player Status", new File("fonts\\player.ttf"), 16f, false);
        fontCache.addFont("Player", new File("fonts\\player.ttf"), 16f, false);
        fontCache.addFont("statusfont", new File("fonts\\Inkfree.ttf"), 40, true);
        fontCache.addFont("consoleFont", new File("fonts\\Inkfree.ttf"), 25, true);
    }

    public static FontManager getInstance() {
        if (instance == null) {
            instance = new FontManager();
        }
        return instance;
    }

    public Font getFont(String fontName) {
        return fontCache.getFont(fontName);
    }
}

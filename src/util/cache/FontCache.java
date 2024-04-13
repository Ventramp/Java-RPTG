package util.cache;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FontCache {

    private static FontCache instance;
    private final Map<String, Font> fontCache;

    private FontCache() {
        fontCache = new HashMap<>();
    }

    public static FontCache getInstance() {
        if (instance == null) {
            instance = new FontCache();
        }
        return instance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for singleton class.");
    }

    public void addFont(String fontName, File file, float size, boolean bold) {
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(size);
            if (bold) {
                font = font.deriveFont(Font.BOLD);
            }
            fontCache.put(fontName, font);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading font: " + fontName,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Font getFont(String fontName) {
        return fontCache.get(fontName);
    }

    public void removeFont(String fontName) {
        fontCache.remove(fontName);
    }

    public void clearCache() {
        fontCache.clear();
    }

    public boolean containsFont(String fontName) {
        return fontCache.containsKey(fontName);
    }

    public void printCache() {
        for (Map.Entry<String, Font> entry : fontCache.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public boolean isCacheEmpty() {
        return fontCache.isEmpty();
    }
}

package util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * The FontLoader class loads custom fonts for use in the application.
 */
public class FontLoader {

    /** The loaded pixel font. */
    private Font pixelFont;

    /**
     * Constructs a FontLoader object and loads the custom font.
     */
    public FontLoader() {
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/pixel.ttf");
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pixelFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the loaded pixel font.
     *
     * @return The loaded pixel font.
     */
    public Font getPixelFont() {
        return pixelFont;
    }
}

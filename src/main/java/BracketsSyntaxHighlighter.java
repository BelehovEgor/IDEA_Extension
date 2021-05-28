import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class BracketsSyntaxHighlighter extends SyntaxHighlighterBase {

    public static TextAttributesKey getAttribute(Color color) {
        return createTextAttributesKey("BRACKET",
                new TextAttributes(
                        color,
                        null,
                        null,
                        null,
                        Font.PLAIN
                ));
    }

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return null;
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return new TextAttributesKey[0];
    }
}

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaToken;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BracketsAnnotator implements Annotator {

    private static final BracketsColors colors = new BracketsColors();

    private static final Map<String, Integer> numbers = new HashMap<>();

    public static final String L_PARENTH = "{";
    public static final String R_PARENTH = "}";
    public static final String L_BRACE = "[";
    public static final String R_BRACE = "]";
    public static final String L_BRACKET = "(";
    public static final String R_BRACKET = ")";

    private static final List<String> openBrackets = Arrays.asList(
            L_PARENTH,
            L_BRACE,
            L_BRACKET
    );

    private static final List<String> closeBrackets = Arrays.asList(
            R_PARENTH,
            R_BRACE,
            R_BRACKET
    );

    private static final int LENGTH = 1;

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {

        if (!(element instanceof PsiJavaToken)) {
            return;
        }

        PsiJavaToken pjt = (PsiJavaToken) element;
        String type = pjt.getTokenType().toString().substring(1);
        numbers.putIfAbsent(type, 0);
        String value = pjt.getText();

        if ((value == null) || (!openBrackets.contains(value) && !closeBrackets.contains(value))) {
            return;
        }

        Color color;
        int number = numbers.get(type);

        if (openBrackets.contains(value)) {
            number++;
            color = colors.getColor(number % colors.getLength());
        } else {
            color = colors.getColor(number % colors.getLength());
            number--;
        }
        numbers.put(type, number);

        TextRange prefixRange = TextRange.from(element.getTextRange().getStartOffset(), LENGTH);

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                .range(prefixRange).textAttributes(BracketsSyntaxHighlighter.getAttribute(color)).create();

    }
}

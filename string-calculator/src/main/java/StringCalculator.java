import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by david on 13/5/15.
 */
public class StringCalculator {


    public static int add(String items) {
        if (items.isEmpty()) {
            return 0;
        }
        List<String> elementsToSum = Arrays.asList(replaceSeparatorWithCommas(items).split(","));
        List<String> negativesNumbers = elementsToSum.stream()
                .filter(x -> Integer.parseInt(x) < 0).collect(toList());

        if (!negativesNumbers.isEmpty()) {
            throw new IllegalArgumentException(String.format("Items shouldn't contain any negative numbers: %s",
                    String.join(",", negativesNumbers)));
        }
        
        return elementsToSum.stream().mapToInt(x -> Integer.parseInt(x)).sum();
    }

    private static String replaceSeparatorWithCommas(String items) {
        String sanitizedItems = items;
        if (needToExtractSeparator(items)) {

            int endLineIndex = getEndOfFirstLineIndex(items);
            String separator = getSeparator(items, endLineIndex);
            String itemsWithoutSeparatorLine = getItemsWithoutSeparatorLine(items, endLineIndex);
            sanitizedItems = itemsWithoutSeparatorLine.replaceAll(separator, ",");
        }
        return sanitizedItems.replaceAll("\\n", ",");
    }

    private static String getItemsWithoutSeparatorLine(String items, int endOfLineIndex) {
        return items.substring(endOfLineIndex + 1);
    }

    private static boolean needToExtractSeparator(String items) {
        return items.startsWith("//");
    }

    private static String getSeparator(String items, int endLineIndex) {
        return items.substring(2, endLineIndex);
    }

    private static int getEndOfFirstLineIndex(String items) {
        return items.indexOf("\n");
    }
}

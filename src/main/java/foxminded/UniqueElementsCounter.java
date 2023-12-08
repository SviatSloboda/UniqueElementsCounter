package foxminded;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueElementsCounter {
    public static void main(String[] args) {
        UniqueElementsCounter uniqueElementsCounter = new UniqueElementsCounter();
        System.out.println(uniqueElementsCounter.countUniqueElements("hello world!"));
    }
    private final Map<Character, Integer> elementsMap;

    public UniqueElementsCounter() {
        elementsMap = new LinkedHashMap<>();
    }

    public String countUniqueElements(String value){
        if(value == null) throw new IllegalArgumentException("null is not allowed!");

        for (char character : value.toCharArray()) {
            if (!elementsMap.containsKey(character)) {
                elementsMap.put(character, 1);
                continue;
            }
            elementsMap.put(character, elementsMap.get(character) + 1);
        }

        return printUniqueElements(elementsMap);
    }

    private String printUniqueElements(Map<Character, Integer> elementsMap){
        StringBuilder result  = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : elementsMap.entrySet()) {
            result .append("'")
                    .append(entry.getKey())
                    .append("' - ")
                    .append(entry.getValue())
                    .append("\n");
        }

        return result.toString();
    }
}

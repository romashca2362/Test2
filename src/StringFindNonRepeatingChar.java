import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringFindNonRepeatingChar<T> implements searching<T> {
	@Override
	public T findNonRepeatingChar(T value) {

		String splitString = String.valueOf(value);
		List<Character> convertInputStringToArray = new ArrayList<>();
		Map<Character, Integer> countingRepeatedCharacters = new LinkedHashMap<>();
		StringBuilder foundFirstNonRepeatingChar = new StringBuilder();

		for (int i = 0; i < splitString.length(); i++) {
			convertInputStringToArray.add(splitString.charAt(i));
		}

		convertInputStringToArray.forEach(character -> countingRepeatedCharacters.merge(character, 1, (prev, one) -> prev + one));

		List<Map.Entry<Character, Integer>> filterRepeatedCharacters = countingRepeatedCharacters.entrySet()
				.stream()
				.filter(character -> character.getValue() == 1)
				.collect(Collectors.toList());

		if (filterRepeatedCharacters.size() != 0) {
			foundFirstNonRepeatingChar.append(filterRepeatedCharacters.get(0).getKey());
		}

		return (T) foundFirstNonRepeatingChar;
	}
}

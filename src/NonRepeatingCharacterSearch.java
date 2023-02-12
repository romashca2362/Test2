import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatingCharacterSearch<T> implements Searching<T> {
	private Map<Character, Integer> characterRepeatCounter = new LinkedHashMap<>();
	private StringBuilder firstUniqueCharacter;

	@Override
	public T searchNonRepeatingChar(T value) {

		firstUniqueCharacter = new StringBuilder();

		writeToMapCharactersAndNumberOfRepitions(value);

		List<Map.Entry<Character, Integer>> uniqueCharactersFilter = characterRepeatCounter.entrySet()
				.stream()
				.filter(character -> character.getValue() == 1)
				.collect(Collectors.toList());

		if (uniqueCharactersFilter.size() != 0) {
			firstUniqueCharacter.append(uniqueCharactersFilter.get(0).getKey());
		}

		return (T) firstUniqueCharacter;
	}

	private void writeToMapCharactersAndNumberOfRepitions(T value) {

		String incomingData = String.valueOf(value);

		List<Character> listCharactersIncomingData = new ArrayList<>();

		for (int i = 0; i < incomingData.length(); i++) {
			listCharactersIncomingData.add(incomingData.charAt(i));
		}

		characterRepeatCounter.clear();
		listCharactersIncomingData.forEach(character -> characterRepeatCounter.merge(character, 1, (prev, one) -> prev + one));
	}

}

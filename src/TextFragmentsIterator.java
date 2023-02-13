import java.util.Arrays;
import java.util.function.Consumer;

public class TextFragmentsIterator<T> {
	private String[] splitString;

	private StringBuilder foundCharacters = new StringBuilder();

	private Searching<String> nonRepeatingCharacterSearch = new NonRepeatingCharacterSearch<>();

	public TextFragmentsIterator(String splitString) {
		this.splitString = splitString.split("\\W+");
	}

	private void findAllUniqueCharacters() {
		for (String s : splitString) {
			foundCharacters.append(nonRepeatingCharacterSearch.searchNonRepeatingChar(s));
		}
	}

	public void printFirstUniqueCharacter() {
		findAllUniqueCharacters();

		if (!foundCharacters.isEmpty()) {
			System.out.println(nonRepeatingCharacterSearch.searchNonRepeatingChar(foundCharacters.toString()));
		} else {
			System.out.println("В тексте нет одиночного символа");
		}
	}
}

public class Main {

	public static void main(String[] args) {
		String originalString = """
				The Tao gave birth to machine language.  Machine language gave birth to the assembler.
				The assembler gave birth to the compiler.  Now there are ten thousand languages.
				Each language has its purpose, however humble.  Each language expresses the Yin and Yang of software.  Each language has its place within the Tao.
				But do not program in COBOL if you can avoid it.
				        -- Geoffrey James, "The Tao of Programming""";

		Searching nonRepeatingCharacterSearch = new NonRepeatingCharacterSearch();

		String[] splitString = originalString.split("\\W+");

		StringBuilder searchCharacter = new StringBuilder();

		//первый проход по фрагментам текста
		for (String s : splitString) {
			searchCharacter.append(nonRepeatingCharacterSearch.searchNonRepeatingChar(s));
		}

		//выводим искомый символ
		if (!searchCharacter.isEmpty()) {
			System.out.println(nonRepeatingCharacterSearch.searchNonRepeatingChar(searchCharacter.toString()));
		} else {
			System.out.println("В тексте нет одиночного символа");
		}
	}
}
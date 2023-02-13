public class Main {

	public static void main(String[] args) {
		String originalString = """
				C makes it easy for you to shoot yourself in the foot. C++ makes that harder, but when you do, it blows away your whole leg. (c) Bjarne Stroustrup""";

		TextFragmentsIterator<String> textFragmentsIterator = new TextFragmentsIterator<>(originalString);

		textFragmentsIterator.printFirstUniqueCharacter();

	}
}
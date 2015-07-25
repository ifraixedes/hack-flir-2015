package hack.mrowlsafari.animals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class AnimalsContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<AnimalItem> ITEMS = new ArrayList<AnimalItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, AnimalItem> ITEM_MAP = new HashMap<String, AnimalItem>();

	static {
		// Add 3 sample items.
		addItem(new AnimalItem("1", "Rabbit"));
		addItem(new AnimalItem("2", "Owl"));
		addItem(new AnimalItem("3", "Turtle"));
		addItem(new AnimalItem("4", "Fox"));
		addItem(new AnimalItem("5", "Bear"));
		addItem(new AnimalItem("6", "Elephant"));
		addItem(new AnimalItem("7", "Giraffe"));
		addItem(new AnimalItem("8", "Mouse"));
		addItem(new AnimalItem("9", "Lion"));
		addItem(new AnimalItem("10", "Cat"));
		addItem(new AnimalItem("11", "Tiger"));


	}

	private static void addItem(AnimalItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class AnimalItem {
		public String id;
		public String content;

		public AnimalItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}

package hack.nightowlsafari.routes;

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
public class RoutesContent {

	/**
	 * An array of sample (dummy) items.
	 */
	public static List<RouteItem> ITEMS = new ArrayList<RouteItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, RouteItem> ITEM_MAP = new HashMap<String, RouteItem>();

	static {
		// Add 3 sample items.
		addItem(new RouteItem("1", "Item 1"));
		addItem(new RouteItem("2", "Item 2"));
		addItem(new RouteItem("3", "Item 3"));
	}

	private static void addItem(RouteItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class RouteItem {
		public String id;
		public String content;

		public RouteItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}

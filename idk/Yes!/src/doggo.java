import java.util.HashSet;

public class doggo {

	public HashSet<String> names (HashSet<String> cards, HashSet<String> topNames){
		HashSet<String> newCards = new HashSet<String>();
		for (String card:cards) {
			if (topNames.contains(card)) {
				newCards.add(card);
				}
		}
		return newCards;
	}
}

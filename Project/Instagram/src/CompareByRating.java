import java.util.Comparator;

public class CompareByRating implements Comparator<Photograph> {

	@Override
	public int compare(Photograph photo1, Photograph photo2) {
		
		//if the ratings of the photos are equal, then it compares by caption
		if (photo1.getRating() == photo2.getRating()) {
			
			//if the captions are equals, then it returns 0
			if (photo1.getCaption().equals(photo2.getCaption())){
				return 0;
				
			//if they aren't equal, then we will return the product of the strings compareTo method
			}else {
				return photo1.getCaption().compareTo(photo2.getCaption());
			}
		
		//if photo1's rating is greater than photo2's rating, then it will come before photo2
		}else if (photo1.getRating() > photo2.getRating()) {
			return -1;
			
		//if photo1's rating is less than photo2's rating, then it will come after photo2
		}else {
			return 1;
		}

	}

}

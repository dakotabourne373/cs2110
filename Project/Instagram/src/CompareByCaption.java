import java.util.Comparator;

public class CompareByCaption implements Comparator<Photograph> {

	@Override
	public int compare(Photograph photo1, Photograph photo2) {
		
		//if the captions are equals, then run through
		if (photo1.getCaption().equals(photo2.getCaption())) {
			
			// if the rating of photo1 is greater than photo2's, return -1
			if (photo1.getRating() > photo2.getRating()) {
				return -1;
			
			//if the rating of photo1 is equal than photo2's, return 0
			}else if (photo1.getRating() == photo2.getRating()) {
				return 0;
				
			//if the rating of photo1 is less than photo2's, return 1	
			}else {
				return 1;
			}
		}
		
		
		return photo1.getCaption().compareTo(photo2.getCaption());
	}

}
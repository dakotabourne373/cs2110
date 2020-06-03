import java.io.File;

public class Photograph implements Comparable<Photograph> {
	private String caption;
	private String filename;
	private String dateTaken;
	private int rating;
	private File imageFile;
	

	/**
	 * constructor for Photograph class, taking only caption of the photograph and its filename and creating the object
	 * @param caption
	 * @param filename
	 */
	public Photograph(String caption, String filename) {
		this.caption = caption;
		this.filename = filename;
		this.dateTaken = "0000-00-00";
		this.rating = 0;
		this.imageFile = new File(filename);
	}

	/**
	 * constructor for Photograph class, taking the caption of the photograph, the filename, the date taken, as well as its rating and creating the object
	 * @param filename
	 * @param caption
	 * @param dateTaken
	 * @param rating
	 */
	public Photograph(String filename, String caption, String dateTaken, int rating) {
		if (dateTaken.length() != 10) {
			//if the date taken is a length not equal to 10, it will be set to null
			this.dateTaken = null;
		}
		if(rating > 5 || rating < 0) {
			//if the rating is out of boundaries it will be set to 0 and pull out of the constructor
			this.rating = 0;
			return;
		}
		this.caption = caption;
		this.filename = filename;
		this.dateTaken = dateTaken;
		this.rating = rating;
		this.imageFile = new File(filename);
	}


	public File getImageFile() {
		return this.imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	/**
	 * getDateTaken returns the dateTaken of the Photograph
	 * @return
	 */
	public String getDateTaken() {
		return this.dateTaken;
	}

	/**
	 * setDateTaken sets the date that the photograph was taken
	 * @param dateTaken
	 */
	public void setDateTaken(String dateTaken) {
		this.dateTaken = dateTaken;
	}

	/**
	 * getRating returns the rating of the photograph
	 * @return
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * setRating sets the rating of the photograph
	 * @param rating
	 */
	public void setRating(int rating) {
		if(rating > 5 || rating < 0) {
			//if the rating is out of bounds then it will be set to 0 and pull out of the setter
			return;
		} 
		this.rating = rating;
	}

	/**
	 * getCaption returns the caption of the Photograph
	 * @return
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * getFilename returns the filename of the photograph
	 * @return
	 */
	public String getFilename() {
		return this.filename;
	}

	/**
	 * compareTo compares a Photograph to another photograph, using the String compareTo method
	 * @param p
	 * @return either 0, if their dates are equals, or the difference their dates.
	 */
	public int compareTo(Photograph p) {
		if (this.dateTaken.equals(p.dateTaken)) {
			return this.getCaption().compareTo(p.getCaption());
		}else {
		return this.dateTaken.compareTo(p.dateTaken);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Photograph) || o == null) {
			return false;
		}

		Photograph otherPhotograph = (Photograph) o;

		return this.caption.equals(otherPhotograph.caption) && this.filename.equals(otherPhotograph.filename);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Photograph [caption=" + caption + ", filename=" + filename + "]";
	}



}

import java.util.ArrayList;

public abstract class PhotographContainer {
	protected String name;
	protected ArrayList<Photograph> photos;

	//PhotographContainer default no-argument constructor
	public PhotographContainer() {
		this.name = "<No Name>";
		this.photos = new ArrayList<Photograph>();
	}

	//PhotographContainer constructor, giving the user the ability to give a name to their container
	public PhotographContainer(String name) {
		this.name = name;
		this.photos = new ArrayList<Photograph>();
	}

	/**
	 * getName returns the name of the album object
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * setName sets the name of the album object
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getPhotos returns the list of photos related to the Album class object
	 * @return
	 */
	public ArrayList<Photograph> getPhotos() {
		return photos;
	}

	/**
	 * getPhotos will taking a rating and gather all of the photos equal to and above that rating in the photos list
	 * @param rating
	 * @return ArrayList of photos above given rating
	 */
	public ArrayList<Photograph> getPhotos(int rating){
		if (rating > 5 || rating < 0) {
			// if the rating is out of boundaries, null will be returned
			return null;
		}
		ArrayList<Photograph> newPhotos = new ArrayList<Photograph>();
		for (Photograph photo:photos) {
			// for-loop iterates through each of the Photographs in the photos ArrayList
			if (photo.getRating() >= 0 && photo.getRating() <= 5 && photo.getRating() >= rating) {
				// the current photo in the loop will be added to a new ArrayList if it's rating is above the given rating
				newPhotos.add(photo);
			}
		}
		return newPhotos;
	}

	/**
	 * getPhotosInYear will take a year and return all of the photos in the given year
	 * @param year
	 * @return ArrayList of photos taken in the given year
	 */
	public ArrayList<Photograph> getPhotosInYear(int year){
		ArrayList<Photograph> newPhotos = new ArrayList<Photograph>();
		if (year < 0) {
			// if given year is out of boundaries, return null
			return null;
		}
		try {
			for (Photograph photo:photos) {
				//for-loop iterating through all of the Photographs in the ArrayList photos
				int resultYear = Integer.parseInt(photo.getDateTaken().substring(0,4));
				if (resultYear < 0) {
					// if the year in the current photo is out of boundaries, return null
					return null;
				}
				if (resultYear == year && (year > 0) && (resultYear > 0)) {
					//if the year in the current photo is in the given year, add the photo to the ArrayList of photos
					newPhotos.add(photo);
				}
			}
		}catch(Exception e) {
			return null;
		}
		return newPhotos;
	}
	/**
	 * getPhotosInMonth takes a month and a year and returns an ArrayList of photos within that same year and month
	 * @param month
	 * @param year
	 * @return
	 */
	public ArrayList<Photograph> getPhotosInMonth(int month, int year){
		ArrayList<Photograph> newPhotos = new ArrayList<Photograph>();
		for (Photograph photo:photos) {
			// for-loop iterates through the all of the Photographs in the ArrayList of photos
			try {
				int resultYear = Integer.parseInt(photo.getDateTaken().substring(0, 4));
				int resultMonth = Integer.parseInt(photo.getDateTaken().substring(5, 7));
				if(resultYear < 0 || resultMonth <= 0 || resultMonth > 12 || month <= 0 || month > 12 || year <= 0) {
					// if the year and month of both the current photo as well as the given variables are out of boundaries, return null
					return null;
				}
				if (resultYear == year && resultMonth == month) {
					// if the year and month of the current photo is equal to the given year and month, then adds it to the ArrayList of photos 
					newPhotos.add(photo);
				}
			} catch(Exception e) {
				return null;
			}
		}
		return newPhotos;
	}
	/**
	 * getPhotosBetween takes a start date and an end date and finds all of the photos between the given dates and returns an ArrayList of these photos 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate){
		ArrayList<Photograph> newPhotos = new ArrayList<Photograph>();
		try {
			// initializes the variables after pull out each individual year, month, and day of the given dates
			int beginDateYear = Integer.parseInt(beginDate.substring(0, 4));
			int beginDateMonth = Integer.parseInt(beginDate.substring(5, 7));
			int beginDateDay = Integer.parseInt(beginDate.substring(8, 10));
			int endDateYear = Integer.parseInt(endDate.substring(0, 4));
			int endDateMonth = Integer.parseInt(endDate.substring(5, 7));
			int endDateDay = Integer.parseInt(endDate.substring(8,10));
			// initializes the variables of the total days of each given date
			int beginDays = beginDateYear*365 + beginDateMonth * 28 + beginDateDay;
			int endDays = endDateYear*365 + endDateMonth*28 + endDateDay;
			if (endDateYear < beginDateYear || beginDateYear < 0 || endDateYear < 0 || beginDateMonth <= 0 || beginDateMonth > 12
					|| endDateMonth <= 0 || endDateMonth > 12 || beginDateDay <= 0 || beginDateDay > 31 || endDateDay <= 0 || endDateDay > 31) {
				// if any of the given years, months, or days are out of order or out of boundaries, returns null
				return null;
			}
			if (endDateYear == beginDateYear) {
				if(endDateMonth < beginDateMonth || endDateMonth > 12 || endDateMonth <= 0 || beginDateMonth > 12 || beginDateMonth <= 0) {
					// if any of the given months or days are out of order or our of boundaries, returns null
					return null;
				}
				if(endDateMonth == beginDateMonth && (endDateDay < beginDateDay || endDateDay > 31 || endDateDay <= 0 || beginDateDay > 31 || beginDateDay <= 0)) {
					// if the given days are out of order or out of boundaries, returns null
					return null;
				}
			}
			for(Photograph photo:photos) {
				// for-loop iterates through the ArrayList of photos
				int photoDateYear = Integer.parseInt(photo.getDateTaken().substring(0, 4));
				int photoDateMonth = Integer.parseInt(photo.getDateTaken().substring(5, 7));
				int photoDateDay = Integer.parseInt(photo.getDateTaken().substring(8,10));
				int photoDays = photoDateYear*365 + photoDateMonth*28 + photoDateDay;
				if (photoDays >= beginDays && photoDays <= endDays) {
					// if the current photo is between the two given dates, it will be added to an ArrayList to be returned
					newPhotos.add(photo);
				}
			}

		} catch(Exception e) {
			return null;
		}
		return newPhotos;
	}

	/**
	 * addPhoto takes a Photograph p and adds it to the Album class object's list of photos
	 * @param p
	 * @return
	 */
	public boolean addPhoto(Photograph p) {
		if (p == null) {
			//in the case that p is null, then it will return false
			return false;
		}
		if(p.getRating() < 0 || p.getRating() > 5) {
			// if the rating of p is out of boundaries it will return false
			return false;
		}
		if (photos.contains(p)) {
			//if the list of photos already contains p, then it will return false
			return false;
		}else {
			//else it will be added to the Album objects list of photos
			photos.add(p);
			return true;
		}
	}

	/**
	 * hasPhoto takes a Photograph p and returns true or false based on whether the list of photos contains the given photograph
	 * @param p
	 * @return
	 */
	public boolean hasPhoto(Photograph p) {
		return photos.contains(p);
	}

	/**
	 * removePhoto takes a Photograph p and tries to remove it from the list of photos, whether or not it contains it
	 * @param p
	 * @return
	 */
	public boolean removePhoto(Photograph p) {
		if (photos.contains(p)) {
			//if the list of photos has p then it will be removed and returns true
			photos.remove(p);
			return true;
		}else {
			//else it will return false
			return false;
		}
	}

	/**
	 * numPhotographs will return the size of the list of photos
	 * @return
	 */
	public int numPhotographs() {
		return photos.size();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Album) || o == null) {
			return false;
		}

		Album otherAlbum = (Album) o;

		return this.name.equals(otherAlbum.name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		ArrayList<String> filenames = new ArrayList<String>();
		for (Photograph photo:photos) {
			// for-loop iterates through the list of photos and for each photo will add the filename of the photo to an ArrayList
			filenames.add(photo.getFilename());
		}
		//returns the Album's name as well as the list of photo's filenames
		return "Album [name=" + name + "\n"
		+ "photos=" + filenames;
	}
}

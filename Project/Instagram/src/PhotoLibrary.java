import java.util.*;
/**
 * Homework 3 
 * @author Dakota Bourne (db2nb)
 *
 */

public class PhotoLibrary extends PhotographContainer {
	private HashSet<Album> albums = new HashSet<Album>();

	//The identification number attached to the person's page
	private int id;

	//Constructor for the PhotoLibrary class
	public PhotoLibrary() {
		// The start constructor for the PhotoLibrary class
		this.name = "<No Name>";
		this.id = 0;
	}
	/**
	 * PhotoLibrary constructor that takes two parameters and adds them to the object.
	 * @param name
	 * @param id
	 */
	public PhotoLibrary(String name, int id) {
		// The Constructor attaching the name related to the person, and the ID for that persons page
		this.name = name;
		this.id = id;
	}

	/**
	 * getAlbums returns the full Hashset Album for the individual PhotoLibrary object
	 * @return
	 */
	public HashSet<Album> getAlbums() {
		return albums;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		//Setter for the name of a person object
		this.name = name;
	}
	/**
	 * @return the PhotoLibrary's ID
	 */
	public int getId() {
		//Getter for the ID of a person object
		return this.id;
	}

	public boolean removePhoto(Photograph p) {
		/**
		 * Method erasePhoto, takes a Photograph class object and checks to see if the photo is in the PhotoLibrary's list of photos, and if it is, it will delete the photo from the photos ArrayList
		 * @param p is a Photograph object
		 * @return true if the Photograph p is successfully removed from the PhotoLibrary's list of photos
		 * @return false if p was not able to be removed from the ArrayList photos > because it was not in the list to begin with
		 */
		for(Album album:albums) {
			// for-loop iterates each element of object type Album in the Hashset list of Albums
			if(album.getPhotos().contains(p)) {
				// if the element album's photos contain the Photograph p, then it will be removed from its list of photos
				album.removePhoto(p);
			}
		}
		if (photos.contains(p)) {
			// if the list of photos contains Photograph p, then it will be removed and returns true
			photos.remove(p);
			return true;
		}else{
			// if not, then it will return false
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PhotoLibrary) || o == null) {
			return false;
		}

		PhotoLibrary otherPerson = (PhotoLibrary) o;

		return this.id == otherPerson.id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		ArrayList<String> albumNames = new ArrayList<String>();
		for (Album album:albums) {
			albumNames.add(album.getName());
		}
		return "PhotoLibrary [name=" + name + ", id=" + id + ", photos=" + photos + "Album Names=" + albumNames + "]";
	}
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b){	
		/**
		 * Method commonPhotos, takes two Person class object and checks how many of the same photos each of the two people have, and if they have any same photos it will add it to a new ArrayList, 
		 * and return the ArrayList (samePhotos) after sorting through all of their photos
		 * @param a is a PhotoLibrary class object
		 * @param b is a PhotoLibrary class object
		 * @return the ArrayList, samePhotos
		 */
		ArrayList<Photograph> samePhotos = new ArrayList<Photograph>();
		for (int i=0; i < a.photos.size(); i++) {
			// for-loop iterates through each of PhotoLibrary a's list of photos
			for(int j=0; j< b.photos.size(); j++) {
				// for-loop iterates through each of PhotoLibrary b's list of photos
				if (a.photos.get(i).equals(b.photos.get(j))) {
					// if  the current photo in the loop of a's list of photos equals b's current photo in its loop, then a's photo will be added to the ArrayList samePhotos
					samePhotos.add(a.photos.get(i));
				}
			}
		}
		return samePhotos;
	}
	public static double similarity(PhotoLibrary a, PhotoLibrary b) {
		/**
		 * Method similarity, takes two Person class object and determines which person has the least amount of photos,
		 * @param a is a Person class object
		 * @param b is a Person class object
		 * @return a double relating a and b's commonphotos average
		 */
		if(a.photos.size() == 0 || b.photos.size() == 0) {
			// if either of a or b's list of photos sizes are equal to 0, then it will automatically return 0.0 
			return 0.0;
		}
		// recasts the sizes of both a and b's photos to a double
		double aSize = (int) a.photos.size();
		double bSize = (int) b.photos.size();
		if (aSize < bSize) {
			// if aSize is less than bSize, then common photos will divide by aSize
			return commonPhotos(a,b).size() / aSize;
		}else {
			// if bSize is less than aSize, then it will return their common photos divided by bSize
			return commonPhotos(a,b).size() / bSize;
		}
	}

	/**
	 * createAlbum takes an album name and creates a new album type 
	 * @param albumName
	 * @return
	 */
	public boolean createAlbum(String albumName) {
		Album newAlbum = new Album(albumName);
		Album yes = getAlbumByName(albumName);
		if (!newAlbum.equals(yes)) {
			// if a new album of the given name does not equal a current album of the given name, then the new album will be added to the list of albums and returns true
			albums.add(newAlbum);
			return true;
		}else {
			return false;
		}
	}

	/**
	 * removeAlbum takes an album name and finds out if there is an album with the current name, and if so removes it from the list of albums
	 * @param albumName
	 * @return
	 */
	public boolean removeAlbum(String albumName) {
		for (Album album:albums) {
			//for-loop iterates through the list of albums
			if (album.getName().equals(albumName)) {
				//if the current album in the loop has a name equal to the given name, then it will be removed from the list of albums and returns true
				albums.remove(album);
				return true;
			}
		}
		return false;
	}

	/**
	 * addPhotoToAlbum takes a Photograph p and an album name and if an identical photo isnt already in the album, it will be added to the album
	 * @param p
	 * @param albumName
	 * @return
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		if(p.getRating()<0 || p.getRating()>5) {
			return false;
		}
		if (photos.contains(p)) {
			// if the photograph is in the list of photos
			for (Album album:albums) {
				//for-loop iterates through the list of albums
				if (album.getName().equals(albumName) && !(album.getPhotos().contains(p))) {
					// if the current album in the loop equals the name given as well as if the album doesnt already contain p, then it will be added to that album, returning true
					album.addPhoto(p);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * removePhotoFromAlbum takes a Photograph p and an album name and tries to remove the given photograph from the given album
	 * @param p
	 * @param albumName
	 * @return
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		Album yes = getAlbumByName(albumName);
		for (Album album:albums) {
			//for-loop iterates through the list of albums
			if (album.getName().equals(albumName) && album.getPhotos().contains(p)) {
				//if the current album is equal to the name given and contains p, then p will be removed from the current album
				yes.removePhoto(p);
				return true;
			}
		}
		return false;
	}

	/**
	 * getAlbumByName takes an album name and returns the album with the same name
	 * @param albumName
	 * @return
	 */
	private Album getAlbumByName(String albumName) {
		for (Album album:albums) {
			//for-loop iterates through the list of albums
			if (album.getName().equals(albumName)) {
				// if the current album in the loop has a name equal to the given name, then the album will be returned
				return album;
			}
		}
		return null;
	}

}

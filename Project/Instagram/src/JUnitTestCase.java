import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;


public class JUnitTestCase {

	@Test
	public void testAddAlbumSuccess() {
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Album yes = new Album("newT");
		assertTrue(yes.addPhoto(photo1));
	}

	@Test
	public void testCreateAlbumSuccess() {
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Album yes = new Album("newT");
		assertFalse(yes.hasPhoto(photo1));
	}

	@Test
	public void testgetPhotosSuccess() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "2019-02-12", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "2018-05-29", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo2);
		Travis.addPhoto(photo3);
		ArrayList<Photograph> getPhotos1 = new ArrayList<Photograph>();
		getPhotos1.add(photo3);
		assertEquals(Travis.getPhotos(4), getPhotos1);
	}

	@Test
	public void testgetPhotosNull() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "2019-02-12", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "2018-05-29", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo2);
		Travis.addPhoto(photo3);
		assertNull(Travis.getPhotos(6));
	}

	@Test
	public void testgetPhotosInMonthSuccess() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "2019-02-12", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "2018-05-29", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo2);
		Travis.addPhoto(photo3);
		ArrayList<Photograph> getPhotos2 = new ArrayList<Photograph>();
		getPhotos2.add(photo1);
		getPhotos2.add(photo2);
		assertEquals(Travis.getPhotosInMonth(02, 2019), getPhotos2);
	}

	@Test
	public void testgetPhotosInMonthNull() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "14-2019-02", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "dsjk", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "05-29-2018", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo2);
		Travis.addPhoto(photo3);
		assertNull(Travis.getPhotosInMonth(02, 2019));	
	}

	@Test
	public void testgetPhotosBetweenSuccess() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "2019-02-12", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "2018-05-29", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo2);
		Travis.addPhoto(photo3);
		ArrayList<Photograph> getPhotos2 = new ArrayList<Photograph>();
		getPhotos2.add(photo1);
		getPhotos2.add(photo2);
		getPhotos2.add(photo3);
		assertEquals(Travis.getPhotosBetween("2018-04-15", "2019-03-16"), getPhotos2);
	}

	@Test
	public void testgetPhotosBetweenNull() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "14-2019-02", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "dsjk", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "05-29-2018", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo2);
		Travis.addPhoto(photo3);
		assertNull(Travis.getPhotosBetween("2018-04-15", "2019-03-16"));
	}

	@Test
	public void testerasePhotoSuccess() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "2019-02-12", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "2018-05-29", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo2);
		Travis.addPhoto(photo3);

		Travis.createAlbum("yaes");
		Travis.addPhotoToAlbum(photo2, "yaes");

		assertTrue(Travis.removePhoto(photo2));
	}

	@Test
	public void testerasePhoto() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "2019-02-12", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "2018-05-29", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo3);

		assertFalse(Travis.removePhoto(photo2));
	}

	@Test 
	public void testsimilaritySuccess() {
		PhotoLibrary Travis = new PhotoLibrary("Travis", 48732648);
		Photograph photo1 = new Photograph("Look at the sunrise!", "img123.jpg", "2019-02-14", 3);
		Photograph photo2 = new Photograph("The water :)", "img126.jpg", "2019-02-12", 2);
		Photograph photo3 = new Photograph("With the baeee :D", "img172.jpg", "2018-05-29", 5);
		PhotoLibrary Nick = new PhotoLibrary("Nick", 969696);
		Photograph photo4 = new Photograph("Philosophy", "Ithinktherefore.jpg", "2018-07-28", 4);
		Photograph photo5 = new Photograph("The ocean!", "img73.jpg", "2012-08-24", 2);
		Photograph photo6 = new Photograph("yayyy", "img1212.jpg", "2017-12-31", 3);
		Photograph photo7 = new Photograph("Lookieeee", "img123.png", "2000-11-28", 1);
		Photograph photo8 = new Photograph("epic", "img13278.jpg", "2019-10-27", 5);

		Travis.addPhoto(photo1);
		Travis.addPhoto(photo2);
		Travis.addPhoto(photo3); 
		Travis.addPhoto(photo7);
		Nick.addPhoto(photo4);
		Nick.addPhoto(photo5);
		Nick.addPhoto(photo6);
		Nick.addPhoto(photo7);
		Nick.addPhoto(photo8);
		Nick.addPhoto(photo2);

		assertEquals(PhotoLibrary.similarity(Travis, Nick),0.5, 0.01);
	}

	@Test
	public void testSimilarityfor0Return() {
		PhotoLibrary Nick = new PhotoLibrary("Nick", 969696);
		Photograph photo4 = new Photograph("Philosophy", "Ithinktherefore.jpg", "2018-07-28", 4);
		Photograph photo5 = new Photograph("The ocean!", "img73.jpg", "2012-08-24", 2);
		Photograph photo6 = new Photograph("yayyy", "img1212.jpg", "2017-12-31", 3);
		Photograph photo7 = new Photograph("Lookieeee", "img123.png", "2000-11-28", 1);
		Photograph photo8 = new Photograph("epic", "img13278.jpg", "2019-10-27", 5);
		PhotoLibrary Yes = new PhotoLibrary("Yes", 726872);

		Nick.addPhoto(photo4);
		Nick.addPhoto(photo5);
		Nick.addPhoto(photo6);
		Nick.addPhoto(photo7);
		Nick.addPhoto(photo8);

		System.out.println(PhotoLibrary.similarity(Yes, Nick));

		assertEquals(PhotoLibrary.similarity(Yes, Nick),0.0, 0.01);
	}

	@Test
	public void testCompareToBefore() {
		Photograph photo4 = new Photograph("Philosophy", "Ithinktherefore.jpg", "2018-07-28", 4);
		Photograph photo5 = new Photograph("The ocean!", "img73.jpg", "2012-08-24", 2);

		assertEquals(photo5.compareTo(photo4), -6);
	}

	@Test
	public void testCompareToAfter() {
		Photograph photo4 = new Photograph("Philosophy", "Ithinktherefore.jpg", "2018-07-28", 4);
		Photograph photo5 = new Photograph("The ocean!", "img73.jpg", "2012-08-24", 2);

		assertEquals(photo4.compareTo(photo5), 6);	
	}

	@Test
	public void testCompareByCaptionBefore() {
		Photograph photo4 = new Photograph("Philosophy", "Ithinktherefore.jpg", "2018-07-28", 4);
		Photograph photo5 = new Photograph("The ocean!", "img73.jpg", "2012-08-24", 2);
		CompareByCaption hiya = new CompareByCaption();
		assertEquals(hiya.compare(photo4, photo5), -32);
	}

	@Test
	public void testCompareByCaptionAfter() {
		Photograph photo4 = new Photograph("Philosophy", "Ithinktherefore.jpg", "2018-07-28", 4);
		Photograph photo5 = new Photograph("The ocean!", "img73.jpg", "2012-08-24", 2);
		CompareByCaption hiya = new CompareByCaption();
		assertEquals(hiya.compare(photo5, photo4), 32);
	}

	@Test
	public void testCompareByRatingAfter() {
		Photograph photo4 = new Photograph("Philosophy", "Ithinktherefore.jpg", "2018-07-28", 4);
		Photograph photo5 = new Photograph("The ocean!", "img73.jpg", "2012-08-24", 2);
		CompareByRating hiya = new CompareByRating();
		assertEquals(hiya.compare(photo5, photo4), 1);
	}

	@Test
	public void testCompareByRatingBefore() {
		Photograph photo4 = new Photograph("Philosophy", "Ithinktherefore.jpg", "2018-07-28", 4);
		Photograph photo5 = new Photograph("The ocean!", "img73.jpg", "2012-08-24", 2);
		CompareByRating hiya = new CompareByRating();
		assertEquals(hiya.compare(photo4, photo5), -1);
	}
	
	@Test(timeout=100)
    public void testPLConstructor() {
        PhotoLibrary b = new PhotoLibrary("MyLibrary", 14);
        assertEquals("PhotoLibrary's constructor failed to initialize name (getter did not return expected value)", "MyLibrary", b.getName());
        assertEquals("PhotoLibrary's constructor failed to initialize id (getter did not return expected value)", 14, b.getId());
        assertEquals("PhotoLibrary's constructor failed to initialize photos (getter did not return expected value)", new ArrayList<Photograph>(), b.getPhotos());
        assertEquals("PhotoLibrary's constructor failed to initialize albums (getter did not return expected value)", new HashSet<Album>(), b.getAlbums());
    }

    @Test(timeout=100)
    public void testSetName() {
        PhotoLibrary b = new PhotoLibrary("Arphaxad", 14);
        b.setName("Peleg");
        assertEquals("PhotoLibrary.setName() failed (getter did not return expected value)", "Peleg", b.getName());
    }


    @Test(timeout=100)
    public void testEraseEmpty() {
        PhotoLibrary b = new PhotoLibrary("Peleg", 17);
        assertFalse("PhotoLibrary.erasePhoto() failed (edge case)", b.removePhoto(new Photograph("Caption","Filename")));
    }
    

    @Test(timeout=100)
    public void testEraseThere() {
        PhotoLibrary b = new PhotoLibrary("Peleg", 17);
        b.getPhotos().add(new Photograph("C1", "F1"));
        b.getPhotos().add(new Photograph("C2", "F2"));
        b.getPhotos().add(new Photograph("C3", "F3"));
        assertTrue("PhotoLibrary createAlbum did not create the specified album.", b.createAlbum("Vacation"));
        assertTrue("PhotoLibrary addPhotoToAlbum did not add a photo to an empty album", b.addPhotoToAlbum(new Photograph("C2", "F2"), "Vacation"));
        assertTrue("PhotoLibrary createAlbum did not create the specified album.", b.createAlbum("Vacation2"));
        assertTrue("PhotoLibrary addPhotoToAlbum did not add a photo to an empty album", b.addPhotoToAlbum(new Photograph("C1", "F1"), "Vacation2"));
        assertTrue("PhotoLibrary addPhotoToAlbum did not add a photo to an empty album", b.addPhotoToAlbum(new Photograph("C2", "F2"), "Vacation2"));
        assertTrue("PhotoLibrary addPhotoToAlbum did not add a photo to an empty album", b.addPhotoToAlbum(new Photograph("C3", "F3"), "Vacation2"));

        assertTrue(b.removePhoto(new Photograph("C2","F2")));
        assertFalse("PhotoLibrary.erasePhoto() failed (something wasn't removed) (also check getPhotos())", b.getPhotos().contains(new Photograph("C2","F2")));
        Album a = null;
        for (Album c: b.getAlbums()) {
            if (c.getName().equals("Vacation"))
                a = c;
        }
        assertEquals("PhotoLibrary.erasePhoto() failed (photo wasn't removed from the albums) (also check getAlbums())", new ArrayList<Photograph>(), a.getPhotos());
        a = null;
        for (Album c: b.getAlbums()) {
            if (c.getName().equals("Vacation2"))
                a = c;
        }
        assertFalse("PhotoLibrary.erasePhoto() failed (something wasn't removed from an album) (also check getPhotos())", a.getPhotos().contains(new Photograph("C2","F2")));
        assertTrue("PhotoLibrary.erasePhoto() failed (removed too much from albums) (also check getPhotos())", a.getPhotos().contains(new Photograph("C1","F1")));
        assertTrue("PhotoLibrary.erasePhoto() failed (removed too much from albums) (also check getPhotos())", a.getPhotos().contains(new Photograph("C3","F3")));
        assertEquals("PhotoLibrary erasePhoto removed too much from albums", 2, a.getPhotos().size());
        assertTrue("PhotoLibrary.erasePhoto() failed (removed too much) (also check getPhotos())", b.getPhotos().contains(new Photograph("C1","F1")));
        assertTrue("PhotoLibrary.erasePhoto() failed (removed too much) (also check getPhotos())", b.getPhotos().contains(new Photograph("C3","F3")));
        assertEquals("PhotoLibrary erasePhoto removed too much", 2, b.getPhotos().size());
    }
    
    @Test(timeout=100)
    public void testGetPhotosYear() {
        PhotoLibrary a = new PhotoLibrary("MyLibrary", 1);
        Photograph b = new Photograph("mypic45.jpg", "Grand Canyon", "2014-01-11", 2);
        Photograph c = new Photograph("water.jpg", "Rafting", "2016-05-11", 5);
        Photograph d = new Photograph("water2.jpg", "Rafting 2", "2016-09-30", 1);

        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(b));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(c));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(d));
        assertEquals("PhotoLibrary getPhotosInYear(year) did not return photos in year", 2, a.getPhotosInYear(2016).size());
        assertTrue("PhotoLibrary getPhotosInYear(year) did not return correct photos in year", a.getPhotosInYear(2016).contains(d));
        assertTrue("PhotoLibrary getPhotosInYear(year) did not return correct photos in year", a.getPhotosInYear(2016).contains(c));
    }


    @Test(timeout=100)
    public void testGetPhotosYear2() {
        PhotoLibrary a = new PhotoLibrary("MyLibrary", 1);
        Photograph b = new Photograph("mypic45.jpg", "Grand Canyon", "2014-01-11", 2);
        Photograph c = new Photograph("water.jpg", "Rafting", "2016-05-11", 5);
        Photograph d = new Photograph("water2.jpg", "Rafting 2", "2016-09-30", 1);

        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(b));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(c));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(d));
        assertEquals("PhotoLibrary getPhotosInYear() returned photos year is negative", null, a.getPhotosInYear(-2229));
    }
    
    @Test(timeout=100)
    public void testGetPhotosBetween() {
        PhotoLibrary a = new PhotoLibrary("MyLibrary", 1);
        Photograph b = new Photograph("mypic45.jpg", "Grand Canyon", "2016-09-11", 2);
        Photograph c = new Photograph("water.jpg", "Rafting", "2016-05-11", 5);
        Photograph d = new Photograph("water2.jpg", "Rafting 2", "2016-09-30", 1);

        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(b));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(c));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(d));
        assertEquals("PhotoLibrary getPhotosBetween() did not return photos in Between", 2, a.getPhotosBetween("2016-05-12", "2017-01-01").size());
        assertTrue("PhotoLibrary getPhotosBetween() did not return correct photos between good dates", a.getPhotosBetween("2016-05-12", "2017-01-01").contains(d));
        assertTrue("PhotoLibrary getPhotosBetween() did not return correct photos between good dates", a.getPhotosBetween("2016-05-12", "2017-01-01").contains(b));
        assertFalse("PhotoLibrary getPhotosBetween() did not return correct photos between good dates", a.getPhotosBetween("2016-05-12", "2017-01-01").contains(c));
    }


    @Test(timeout=100)
    public void testGetPhotosBetween2() {
        PhotoLibrary a = new PhotoLibrary("MyLibrary", 1);
        Photograph b = new Photograph("mypic45.jpg", "Grand Canyon", "2014-01-11", 2);
        Photograph c = new Photograph("water.jpg", "Rafting", "2016-05-11", 5);
        Photograph d = new Photograph("water2.jpg", "Rafting 2", "2016-09-30", 1);

        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(b));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(c));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(d));
        assertEquals("PhotoLibrary getPhotosInBetween() returned photos when dates not formatted correctly", null, a.getPhotosBetween("2016", "2017"));
        assertEquals("PhotoLibrary getPhotosInBetween() returned photos when dates not formatted correctly", null, a.getPhotosBetween("2016-15-11", "2017-01-02"));;
        assertEquals("PhotoLibrary getPhotosInBetween() returned photos when dates not formatted correctly", null, a.getPhotosBetween("2016-10-11", "2017-04-34"));
    }


    @Test(timeout=100)
    public void testGetPhotosBetween3() {
        PhotoLibrary a = new PhotoLibrary("MyLibrary", 1);
        Photograph b = new Photograph("mypic45.jpg", "Grand Canyon", "2014-01-11", 2);
        Photograph c = new Photograph("water.jpg", "Rafting", "2016-05-11", 3);
        Photograph d = new Photograph("water2.jpg", "Rafting 2", "2016-09-30", 1);

        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(b));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(c));
        assertTrue("PhotoLibrary takePhoto did not add a photo", a.addPhoto(d));
        assertEquals("PhotoLibrary getPhotosInBetween() returned photos when it shouldn't have", 0, a.getPhotosBetween("2019-01-01", "2019-02-11").size());
        assertEquals("PhotoLibrary getPhotosInBetween() returned photos when it shouldn't have", 0, a.getPhotosBetween("2016-05-12", "2016-09-29").size());
    }
    

    @Test(timeout=100)
    public void testRemoveAlbumNotThere() {
        PhotoLibrary a = new PhotoLibrary("MyLibrary", 1);

        assertTrue("PhotoLibrary createAlbum() did not create an album", a.createAlbum("My Album"));
        assertTrue("PhotoLibrary createAlbum() did not create an album", a.createAlbum("Vacation Photos"));
        assertTrue("PhotoLibrary createAlbum() did not create an album", a.createAlbum("Vacation Photos 2"));

        assertFalse("PhotoLibrary removeAlbum() allowed removal of an album that was not there", a.removeAlbum("Vacation Photos 3"));
        boolean contains = false;
        Album c = new Album("Vacation Photos 3");
        for (Album b : a.getAlbums()) {
            if (c.equals(b))
                contains = true;
        }
        assertFalse("PhotoLibrary removeAlbum() accidentally added an album instead of removing", contains);
    }
    

    @Test(timeout=100)
    public void testAddPhotoToAlbumEdge() {
        PhotoLibrary a = new PhotoLibrary("MyLibrary", 1);
        Photograph p = new Photograph("Caption", "My Filename");
        a.addPhoto(p);

        assertFalse("PhotoLibrary addPhotoToAlbum() allowed adding photo to non-existant album", a.addPhotoToAlbum(p, "My Album"));      
    }
    
    @Test(timeout=100)
    public void testEqualsType() throws Exception {
        try {
            PhotoLibrary.class.getDeclaredMethod("equals", Object.class);
        } catch (NoSuchMethodException e) {
            fail("PhotoLibrary equals method not specified correctly.");
        } catch (Exception e) {
            throw e;
        }
    }

    @Test(timeout=100)
    public void testEqualsSame() {
        PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
        assertTrue("PhotoLibrary.equals() failed: Symmetric", b.equals(b));
    }

    @Test(timeout=100)
    public void testEqualsSimilar() {
        PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
        PhotoLibrary c = new PhotoLibrary("Le Petit Prince", 42);
        assertTrue("PhotoLibrary.equals() failed: Same id and name", b.equals(c));
    }
    
    @Test(timeout=100)
    public void testEqualsDifferentTypes() throws Exception {
        try {
            PhotoLibrary b = new PhotoLibrary("Le Petit Prince", 42);
            assertFalse("PhotoLibrary.equals() failed: Compare PhotoLibrary to Integer", b.equals(42));
        } catch (ClassCastException e) {
            fail("PhotoLibrary.equals() failed: Casting a non-PhotoLibrary to a PhotoLibrary");
        } catch (Exception e) {
            throw e;
        }
    }
	
}


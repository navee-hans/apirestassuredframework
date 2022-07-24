package resources;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace addPlacePayLoad() {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
	    AddPlace addPlace = new AddPlace();
	    addPlace.setAccuracy(50);
	    addPlace.setAddress("Test 1234 Chandigarh");
	    addPlace.setLanguage("English");
	    addPlace.setPhone_number("(+91) 8968508444");
	    addPlace.setWebsite("https://rahulshettyacademy.com");
	    addPlace.setName("Forntline Houst");
	    List<String> myList = new ArrayList<String>();
	    myList.add("shoe park");
	    myList.add("shop");
	    addPlace.setTypes(myList);
	    Location loc = new Location();
	    loc.setLat(-38.383410);
	    loc.setLng(33.427362);
	    addPlace.setLocation(loc);
	    return addPlace;
	}
}

package tv.cadent.linear.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	ResourceLoader resourceLoader;

	private static Map<String, Float[]> geoLatLongs = new HashMap<String, Float[]>();

	@PostConstruct
	public void loadLatLongs() {
		Resource resource = resourceLoader.getResource("classpath:geodata/geodata.csv");
		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(resource.getURI()))) {
			stream.forEach(line -> {
				String[] zeoLatLong = line.split(",");
				try {
					geoLatLongs.put(zeoLatLong[0],
							new Float[] { Float.valueOf(zeoLatLong[1]), Float.valueOf(zeoLatLong[2]) });
				} catch (NumberFormatException nfe) {
					// Ignore
				}
			});
		} catch (IOException e) {
			// Ignore
		}
	}

	@RequestMapping("/")
	public String viewHome(Model model) {
		Object[][] latlongMappings = new Object[8][];
		latlongMappings[0] = new Object[] { "Latitude", "Longitude", "Zip Code", };
		latlongMappings[1] = new Object[] { geoLatLongs.get("95014")[0], geoLatLongs.get("95014")[1], "95014" };
		latlongMappings[2] = new Object[] { geoLatLongs.get("95017")[0], geoLatLongs.get("95017")[1], "95017" };
		latlongMappings[3] = new Object[] { geoLatLongs.get("95018")[0], geoLatLongs.get("95018")[1], "95018" };
		latlongMappings[4] = new Object[] { geoLatLongs.get("95019")[0], geoLatLongs.get("95019")[1], "95019" };
		latlongMappings[5] = new Object[] { geoLatLongs.get("95020")[0], geoLatLongs.get("95020")[1], "95020" };
		latlongMappings[6] = new Object[] { geoLatLongs.get("10001")[0], geoLatLongs.get("10001")[1], "10001" };
		latlongMappings[7] = new Object[] { geoLatLongs.get("10005")[0], geoLatLongs.get("10005")[1], "10005" };
		model.addAttribute("latlongMappings", latlongMappings);
		model.addAttribute("restrictedDevices", new String[] { "pc", "tablet" });
		getFeedData(model);
		return "index";
	}
	
	private void getFeedData(Model model) {
		try {
			Resource resource = resourceLoader.getResource("classpath:feeddata/feedData.json");
			JSONArray feedDataRowArray = (JSONArray)new JSONParser().parse(Files.readString(Paths.get(resource.getURI())));
			if(feedDataRowArray!=null) {
				for(int i=0; i < feedDataRowArray.size(); i++) {
					JSONObject feedDataRow = (JSONObject)feedDataRowArray.get(i);
					if(feedDataRow.containsKey("feedData")) {
						JSONObject feedData = (JSONObject)feedDataRow.get("feedData");
						if(feedData!= null && feedData.containsKey("altConData")) {
							JSONArray altConDataArray = (JSONArray) feedData.get("altConData");
							if(altConDataArray!=null) {
								for(int j=0;j<altConDataArray.size();j++) {
									JSONObject altConData = (JSONObject) altConDataArray.get(j);
									if(altConData !=null && altConData.containsKey("restrictedZips")) {
										JSONArray restrictedZipsArray = (JSONArray) altConData.get("restrictedZips");
										if(restrictedZipsArray!=null) {
											for(int k=0;k<restrictedZipsArray.size();k++) {
												JSONObject restrictedZip = (JSONObject) restrictedZipsArray.get(k);
												Float[] latLong = geoLatLongs.get(restrictedZip.get("zipCode"));
												if(latLong!=null) {
													restrictedZip.put("zipLatitude", latLong[0]);
													restrictedZip.put("zipLongitude", latLong[1]);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			model.addAttribute("feedJsonArray", feedDataRowArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
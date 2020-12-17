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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static Map<String, Float[]> geoLatLongs = new HashMap<String, Float[]>();

	@PostConstruct
	public void loadLatLongs() {
		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(ResourceUtils.getFile("classpath:geodata/geodata.csv").toURI()))) {
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
		getFeedData(model);
		return "index";
	}
	
	private void getFeedData(Model model) {
		try {
			JSONArray feedDataRowArray = (JSONArray)new JSONParser().parse(
					new String(Files.readAllBytes(Paths.get(ResourceUtils.getFile("classpath:feeddata/feedData.json").toURI()))));
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
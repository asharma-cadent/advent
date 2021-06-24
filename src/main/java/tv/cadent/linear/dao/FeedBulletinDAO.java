package tv.cadent.linear.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import tv.cadent.linear.model.FeedBulletinData;

public class FeedBulletinDAO {
	
	protected static final Gson JSON_SERIALIZER_AND_DESERIALIZER = new Gson();
	
	public static List<FeedBulletinData> getFeedBulletinData(int numberOfFeeds, int numberOfDays, 
			int altConsPerFeed,	int streamsPerFeed, int numberOfBreakWindows, int numberOfBreaksPerWindow) {
		return  populateFeedBulletinData(numberOfFeeds, numberOfDays, altConsPerFeed, streamsPerFeed, 
				numberOfBreakWindows, numberOfBreaksPerWindow);
	}

	private static List<FeedBulletinData> populateFeedBulletinData(int numberOfFeeds, int numberOfDays, int altConsPerFeed, 
			int streamsPerFeed,	int numberOfBreakWindows, int numberOfBreaksPerWindow) {
		List<FeedBulletinData> feedBulletinDataList = new ArrayList<FeedBulletinData>();
		for(int i=0; i < numberOfDays; i++) {
			feedBulletinDataList.add(getFeedBulletinData(i, numberOfFeeds, numberOfDays, altConsPerFeed, 
					streamsPerFeed, numberOfBreakWindows, numberOfBreaksPerWindow));
		}
		return feedBulletinDataList;
	}

	private static FeedBulletinData getFeedBulletinData(int daysFromNow, int numberOfFeeds, int numberOfDays, int altConsPerFeed,
			int streamsPerFeed, int numberOfBreakWindows, int numberOfBreaksPerWindow) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

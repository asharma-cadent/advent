package tv.cadent.linear.model;

import java.util.Collections;
import java.util.List;

public class FeedBulletinData {
	String date;
	List<FeedData> feedData = Collections.emptyList();
	public FeedBulletinData(String date, List<FeedData> feedData) {
		this();
		this.date = date;
		this.feedData = feedData;
	}
	
	public FeedBulletinData() {
		super();
	}

	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<FeedData> getFeedData() {
		return this.feedData;
	}
	public void setFeedData(List<FeedData>feedData) {
		this.feedData = feedData;
	}
}

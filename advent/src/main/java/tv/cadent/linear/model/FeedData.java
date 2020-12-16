package tv.cadent.linear.model;

import java.util.Collections;
import java.util.List;

public class FeedData {
	List<ZonedBreakData> zonedBreakData = Collections.emptyList();
	List<AltConData> altConData = Collections.emptyList();
	public FeedData(List<ZonedBreakData>  zonedBreakData, List<AltConData> altConData) {
		super();
		this.zonedBreakData = zonedBreakData;
		this.altConData = altConData;
	}
	public List<ZonedBreakData> getZonedBreakData() {
		return zonedBreakData;
	}
	public void setZonedBreakData(List<ZonedBreakData>  zonedBreakData) {
		this.zonedBreakData = zonedBreakData;
	}
	public List<AltConData> getAltConData() {
		return altConData;
	}
	public void setAltConData(List<AltConData> altConData) {
		this.altConData = altConData;
	}
}

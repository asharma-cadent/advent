package tv.cadent.linear.model;

import java.util.Collections;
import java.util.List;

public class ZonedBreakData {
	String zoneId;
	List<BreakData> breakData = Collections.emptyList();
	public ZonedBreakData(String zoneId, List<BreakData> breakData) {
		super();
		this.zoneId = zoneId;
		this.breakData = breakData;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public List<BreakData> getBreakData() {
		return breakData;
	}
	public void setBreakData(List<BreakData> breakData) {
		this.breakData = breakData;
	}
}

package tv.cadent.linear.model;

public class BreakData {
	String scheduleDate;//MMDD
	String scheduleTime;//HHMMSS
	String windowStartTime;//HHMM
	String windowDuration;//HHMM
	String windowEndTime;//HHMM
	String breakNumberWithinWindow; //01,02,03 etc.
	String positionNumberWithinBreak;//001,002,003 etc.
	String spotId;  //00000039108
	String creative;//Nike
	String breakConfirmationTime;//The break confirmation time if it was confirmed.
	String breakStatus;//Pending, Confirmed, Expired, Deleted
	public BreakData(String scheduleDate, String scheduleTime, String windowStartTime, String windowDuration,
			String windowEndTime, String breakNumberWithinWindow, String positionNumberWithinBreak, String spotId,
			String creative, String breakConfirmationTime, String breakStatus) {
		super();
		this.scheduleDate = scheduleDate;
		this.scheduleTime = scheduleTime;
		this.windowStartTime = windowStartTime;
		this.windowDuration = windowDuration;
		this.windowEndTime = windowEndTime;
		this.breakNumberWithinWindow = breakNumberWithinWindow;
		this.positionNumberWithinBreak = positionNumberWithinBreak;
		this.spotId = spotId;
		this.creative = creative;
		this.breakConfirmationTime = breakConfirmationTime;
		this.breakStatus = breakStatus;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getWindowStartTime() {
		return windowStartTime;
	}
	public void setWindowStartTime(String windowStartTime) {
		this.windowStartTime = windowStartTime;
	}
	public String getWindowDuration() {
		return windowDuration;
	}
	public void setWindowDuration(String windowDuration) {
		this.windowDuration = windowDuration;
	}
	public String getWindowEndTime() {
		return windowEndTime;
	}
	public void setWindowEndTime(String windowEndTime) {
		this.windowEndTime = windowEndTime;
	}
	public String getBreakNumberWithinWindow() {
		return breakNumberWithinWindow;
	}
	public void setBreakNumberWithinWindow(String breakNumberWithinWindow) {
		this.breakNumberWithinWindow = breakNumberWithinWindow;
	}
	public String getPositionNumberWithinBreak() {
		return positionNumberWithinBreak;
	}
	public void setPositionNumberWithinBreak(String positionNumberWithinBreak) {
		this.positionNumberWithinBreak = positionNumberWithinBreak;
	}
	public String getSpotId() {
		return spotId;
	}
	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}
	public String getCreative() {
		return creative;
	}
	public void setCreative(String creative) {
		this.creative = creative;
	}
	public String getBreakConfirmationTime() {
		return breakConfirmationTime;
	}
	public void setBreakConfirmationTime(String breakConfirmationTime) {
		this.breakConfirmationTime = breakConfirmationTime;
	}
	public String getBreakStatus() {
		return breakStatus;
	}
	public void setBreakStatus(String breakStatus) {
		this.breakStatus = breakStatus;
	}
}

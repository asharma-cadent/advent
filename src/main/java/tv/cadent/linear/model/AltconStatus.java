package tv.cadent.linear.model;

public class AltconStatus {
	String streamId;
	String eventStartSignalTime;
	String eventEndSignalTime;
	String status;
	String executionType;
	public AltconStatus(String streamId, String eventStartSignalTime, String eventEndSignalTime, String status,
			String executionType) {
		super();
		this.streamId = streamId;
		this.eventStartSignalTime = eventStartSignalTime;
		this.eventEndSignalTime = eventEndSignalTime;
		this.status = status;
		this.executionType = executionType;
	}
	public String getStreamId() {
		return streamId;
	}
	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}
	public String getEventStartSignalTime() {
		return eventStartSignalTime;
	}
	public void setEventStartSignalTime(String eventStartSignalTime) {
		this.eventStartSignalTime = eventStartSignalTime;
	}
	public String getEventEndSignalTime() {
		return eventEndSignalTime;
	}
	public void setEventEndSignalTime(String eventEndSignalTime) {
		this.eventEndSignalTime = eventEndSignalTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExecutionType() {
		return executionType;
	}
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}
}

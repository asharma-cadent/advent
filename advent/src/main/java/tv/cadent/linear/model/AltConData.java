package tv.cadent.linear.model;

import java.util.Collections;
import java.util.List;

public class AltConData {
	String programName;
	List<ZipData> restrictedZips = Collections.emptyList();
	List<String> restrictedDevices = Collections.emptyList();
	List<AltconStatus> streamConditioningStatus = Collections.emptyList();
	public AltConData(String programName, List<ZipData> restrictedZips, List<String> restrictedDevices,
			List<AltconStatus> streamConditioningStatus) {
		super();
		this.programName = programName;
		this.restrictedZips = restrictedZips;
		this.restrictedDevices = restrictedDevices;
		this.streamConditioningStatus = streamConditioningStatus;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public List<ZipData> getRestrictedZips() {
		return restrictedZips;
	}
	public void setRestrictedZips(List<ZipData> restrictedZips) {
		this.restrictedZips = restrictedZips;
	}
	public List<String> getRestrictedDevices() {
		return restrictedDevices;
	}
	public void setRestrictedDevices(List<String> restrictedDevices) {
		this.restrictedDevices = restrictedDevices;
	}
	public List<AltconStatus> getStreamConditioningStatus() {
		return streamConditioningStatus;
	}
	public void setStreamConditioningStatus(List<AltconStatus> streamConditioningStatus) {
		this.streamConditioningStatus = streamConditioningStatus;
	}
}

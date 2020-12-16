package tv.cadent.linear.model;

public class ZipData {
	String zipCode;
	Integer zipLatitude;
	Integer zipLongitude;
	public ZipData(String zipCode, Integer zipLatitude, Integer zipLongitude) {
		super();
		this.zipCode = zipCode;
		this.zipLatitude = zipLatitude;
		this.zipLongitude = zipLongitude;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getZipLatitude() {
		return zipLatitude;
	}
	public void setZipLatitude(Integer zipLatitude) {
		this.zipLatitude = zipLatitude;
	}
	public Integer getZipLongitude() {
		return zipLongitude;
	}
	public void setZipLongitude(Integer zipLongitude) {
		this.zipLongitude = zipLongitude;
	}
}

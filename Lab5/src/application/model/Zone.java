package application.model;

public class Zone {
	
	private String zoneName, zoneCode, threatLevel;
	
	public Zone(String zoneName, String zoneCode, String threatLevel) {
		this.zoneName = zoneName;
		this.zoneCode = zoneCode;
		this.threatLevel = threatLevel;
	}
	
	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getThreatLevel() {
		return threatLevel;
	}

	public void setThreatLevel(String threatLevel) {
		this.threatLevel = threatLevel;
	}

	public String toString() {
		return zoneName + " " + zoneCode + " " + threatLevel;
	}

}

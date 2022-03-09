package tn.esprit.spring.entity;

public class Critere {
	private String dest;
	private int duration;
	private String startDate;
	private MissionType mission;
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	
	public Critere(String dest, int duration, String startDate, MissionType mission) {
		super();
		this.dest = dest;
		this.duration = duration;
		this.startDate = startDate;
		this.mission = mission;
	}
	public MissionType getMission() {
		return mission;
	}
	public void setMission(MissionType mission) {
		this.mission = mission;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return dest+ "   " + duration+ "   " + startDate;

	
	
	}
}

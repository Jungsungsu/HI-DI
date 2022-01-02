package Model;

public class StatisticsVO {
	private int sta_seq;
	private String sta_age;
	private String dis_name;
	private int sta_count;
	private String year;
	private String mb_id;
	public StatisticsVO(int sta_seq, String sta_age, String dis_name, int sta_count, String year, String mb_id) {
		super();
		this.sta_seq = sta_seq;
		this.sta_age = sta_age;
		this.dis_name = dis_name;
		this.sta_count = sta_count;
		this.year = year;
		this.mb_id = mb_id;
	}
	public int getSta_seq() {
		return sta_seq;
	}
	public void setSta_seq(int sta_seq) {
		this.sta_seq = sta_seq;
	}
	public String getSta_age() {
		return sta_age;
	}
	public void setSta_age(String sta_age) {
		this.sta_age = sta_age;
	}
	public String getDis_name() {
		return dis_name;
	}
	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}
	public int getSta_count() {
		return sta_count;
	}
	public void setSta_count(int sta_count) {
		this.sta_count = sta_count;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	
	
}

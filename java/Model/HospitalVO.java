package Model;



public class HospitalVO {
	private int hos_seq;
	private String hos_name;
	private String hos_addr;
	private String hos_phone;
	private double hos_latitude;
	private double hos_longitude;
	private String hos_facilities;
	private String hos_dpt;
	private int hos_time1;
	private int hos_time2;
	private int hos_time3;
	private int hos_time4;
	private int hos_time5;
	private String mb_id;
	
	public HospitalVO(int hos_seq, String hos_name, String hos_addr, String hos_phone, double hos_latitude2,
			double hos_longitude2, String hos_facilities, String hos_dpt, int hos_time1, int hos_time2, int hos_time3,
			int hos_time4, int hos_time5, String mb_id) {
		super();
		this.hos_seq = hos_seq;
		this.hos_name = hos_name;
		this.hos_addr = hos_addr;
		this.hos_phone = hos_phone;
		this.hos_latitude = hos_latitude2;
		this.hos_longitude = hos_longitude2;
		this.hos_facilities = hos_facilities;
		this.hos_dpt = hos_dpt;
		this.hos_time1 = hos_time1;
		this.hos_time2 = hos_time2;
		this.hos_time3 = hos_time3;
		this.hos_time4 = hos_time4;
		this.hos_time5 = hos_time5;
		this.mb_id = mb_id;
	}


	public int getHos_seq() {
		return hos_seq;
	}
	public void setHos_seq(int hos_seq) {
		this.hos_seq = hos_seq;
	}
	public String getHos_name() {
		return hos_name;
	}
	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}
	public String getHos_addr() {
		return hos_addr;
	}
	public void setHos_addr(String hos_addr) {
		this.hos_addr = hos_addr;
	}
	public String getHos_phone() {
		return hos_phone;
	}
	public void setHos_phone(String hos_phone) {
		this.hos_phone = hos_phone;
	}
	public double getHos_latitude() {
		return hos_latitude;
	}
	public void setHos_latitude(double hos_latitude) {
		this.hos_latitude = hos_latitude;
	}
	public double getHos_longitude() {
		return hos_longitude;
	}
	public void setHos_longitude(double hos_longitude) {
		this.hos_longitude = hos_longitude;
	}
	public String getHos_facilities() {
		return hos_facilities;
	}
	public void setHos_facilities(String hos_facilities) {
		this.hos_facilities = hos_facilities;
	}
	public String getHos_dpt() {
		return hos_dpt;
	}
	public void setHos_dpt(String hos_dpt) {
		this.hos_dpt = hos_dpt;
	}
	public int getHos_time1() {
		return hos_time1;
	}
	public void setHos_time1(int hos_time1) {
		this.hos_time1 = hos_time1;
	}
	public int getHos_time2() {
		return hos_time2;
	}
	public void setHos_time2(int hos_time2) {
		this.hos_time2 = hos_time2;
	}
	public int getHos_time3() {
		return hos_time3;
	}
	public void setHos_time3(int hos_time3) {
		this.hos_time3 = hos_time3;
	}
	public int getHos_time4() {
		return hos_time4;
	}
	public void setHos_time4(int hos_time4) {
		this.hos_time4 = hos_time4;
	}
	public int getHos_time5() {
		return hos_time5;
	}
	public void setHos_time5(int hos_time5) {
		this.hos_time5 = hos_time5;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	
	
	
}

package Model;

public class MemberVO {
	
	private String mb_id;
	private String mb_pw;
	private String mb_email;
	private String mb_name;
	private String mb_gender;
	private String mb_phone;
	private String mb_birthdate;
	private String mb_addr;
	private String mb_joindate;
	private String admin_yn;
	private int mb_point;
	
	//생성자
	public MemberVO(String mb_id, String mb_pw, String mb_email, String mb_name, String mb_gender, String mb_phone,
			String mb_birthdate, String mb_addr, String mb_joindate, String admin_yn, int mb_point) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_email = mb_email;
		this.mb_name = mb_name;
		this.mb_gender = mb_gender;
		this.mb_phone = mb_phone;
		this.mb_birthdate = mb_birthdate;
		this.mb_addr = mb_addr;
		this.mb_joindate = mb_joindate;
		this.admin_yn = admin_yn;
		this.mb_point = mb_point;
	}
	
	//가입일, 관리자, 포인트는 디폴트 값으로 정해졌으니 빼고 데이터 넣기 위해서 생성자 재지정(진기현)
	public MemberVO(String mb_id, String mb_pw, String mb_email, String mb_name, String mb_gender, String mb_phone,
			String mb_birthdate, String mb_addr) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_email = mb_email;
		this.mb_name = mb_name;
		this.mb_gender = mb_gender;
		this.mb_phone = mb_phone;
		this.mb_birthdate = mb_birthdate;
		this.mb_addr = mb_addr;
	}


	//getter&setter
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public String getMb_email() {
		return mb_email;
	}
	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
	public String getMb_gender() {
		return mb_gender;
	}
	public void setMb_gender(String mb_gender) {
		this.mb_gender = mb_gender;
	}
	public String getMb_phone() {
		return mb_phone;
	}
	public void setMb_phone(String mb_phone) {
		this.mb_phone = mb_phone;
	}
	public String getMb_birthdate() {
		return mb_birthdate;
	}
	public void setMb_birthdate(String mb_birthdate) {
		this.mb_birthdate = mb_birthdate;
	}
	public String getMb_addr() {
		return mb_addr;
	}
	public void setMb_addr(String mb_addr) {
		this.mb_addr = mb_addr;
	}
	public String getMb_joindate() {
		return mb_joindate;
	}
	public void setMb_joindate(String mb_joindate) {
		this.mb_joindate = mb_joindate;
	}
	public String getAdmin_yn() {
		return admin_yn;
	}
	public void setAdmin_yn(String admin_yn) {
		this.admin_yn = admin_yn;
	}
	public int getMb_point() {
		return mb_point;
	}
	public void setMb_point(int mb_point) {
		this.mb_point = mb_point;
	}
	
}

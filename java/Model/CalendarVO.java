package Model;

public class CalendarVO {
	
	private int user_check_seq;
	private int check_seq;
	private String user_check_result;
	private String reg_date;
	private String mb_id;
	
	public CalendarVO(int user_check_seq, int check_seq, String user_check_result, String reg_date, String mb_id) {
		super();
		this.user_check_seq = user_check_seq;
		this.check_seq = check_seq;
		this.user_check_result = user_check_result;
		this.reg_date = reg_date;
		this.mb_id = mb_id;
	}

	public int getUser_check_seq() {
		return user_check_seq;
	}

	public void setUser_check_seq(int user_check_seq) {
		this.user_check_seq = user_check_seq;
	}

	public int getCheck_seq() {
		return check_seq;
	}

	public void setCheck_seq(int check_seq) {
		this.check_seq = check_seq;
	}

	public String getUser_check_result() {
		return user_check_result;
	}

	public void setUser_check_result(String user_check_result) {
		this.user_check_result = user_check_result;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	
	
}
	
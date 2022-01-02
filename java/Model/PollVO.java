package Model;

public class PollVO {

	// 설문 VO
	private int poll_seq; // 설문 아이템 순번
	private String poll_title; // 설문 제목
	private String poll_content; // 설문 설명
	private String mb_id;  // 등록자 아이디
	private String reg_date; // 등록 일자
	
	// 설문 생성자 생성
	public PollVO(int poll_seq, String poll_title, String poll_content, String mb_id, String reg_date) {
		super();
		this.poll_seq = poll_seq;
		this.poll_title = poll_title;
		this.poll_content = poll_content;
		this.mb_id = mb_id;
		this.reg_date = reg_date;
	}

	// 설문 getter & setter
	public int getPoll_seq() {
		return poll_seq;
	}


	public void setPoll_seq(int poll_seq) {
		this.poll_seq = poll_seq;
	}


	public String getPoll_title() {
		return poll_title;
	}


	public void setPoll_title(String poll_title) {
		this.poll_title = poll_title;
	}


	public String getPoll_content() {
		return poll_content;
	}


	public void setPoll_content(String poll_content) {
		this.poll_content = poll_content;
	}


	public String getMb_id() {
		return mb_id;
	}


	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}


	public String getReg_date() {
		return reg_date;
	}


	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	
	
	
	
}

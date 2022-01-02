package Model;

public class PollitemsVO {

	// 설문 아이템 VO
	private int item_seq; // 설문 아이템 순번
	private int poll_seq; // 설문 순번
	private String item_name; // 아이템 항목
	private String item_content; // 아이템 보충설명
	
	// 설문 아이템 생성자 생성
	public PollitemsVO(int item_seq, int poll_seq, String item_name, String item_content) {
		super();
		this.item_seq = item_seq;
		this.poll_seq = poll_seq;
		this.item_name = item_name;
		this.item_content = item_content;
	}

	// 설문 아이템 getter & setter
	public int getItem_seq() {
		return item_seq;
	}


	public void setItem_seq(int item_seq) {
		this.item_seq = item_seq;
	}


	public int getPoll_seq() {
		return poll_seq;
	}


	public void setPoll_seq(int poll_seq) {
		this.poll_seq = poll_seq;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public String getItem_content() {
		return item_content;
	}


	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}
	
	
	
	
	
	
}

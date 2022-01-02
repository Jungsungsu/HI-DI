package Model;

public class DiseaseVO {

	private int dis_seq;	//질병 순번
	private String dis_code;	//질병코드
	private String dis_name;	//질병명
	private String dis_content;	//질병 설명
	private String dis_symptom;	//질병 증상
	private String dis_dpt; 	//질병 진료과
	private String dis_tag;	//질병 태그
	private String MB_ID;  // 관리자
	private String dis_pic1; // 질병사진
	
	
	// 생성자4
	public DiseaseVO(int dis_seq, String dis_code, String dis_name, String dis_content, String dis_symptom,
			String dis_dpt, String dis_tag, String mB_ID, String dis_pic1) {
		super();
		this.dis_seq = dis_seq;
		this.dis_code = dis_code;
		this.dis_name = dis_name;
		this.dis_content = dis_content;
		this.dis_symptom = dis_symptom;
		this.dis_dpt = dis_dpt;
		this.dis_tag = dis_tag;
		MB_ID = mB_ID;
		this.dis_pic1 = dis_pic1;
	}


	// getter&setter
	public int getDis_seq() {
		return dis_seq;
	}


	public void setDis_seq(int dis_seq) {
		this.dis_seq = dis_seq;
	}


	public String getDis_code() {
		return dis_code;
	}


	public void setDis_code(String dis_code) {
		this.dis_code = dis_code;
	}


	public String getDis_name() {
		return dis_name;
	}


	public void setDis_name(String dis_name) {
		this.dis_name = dis_name;
	}


	public String getDis_content() {
		return dis_content;
	}


	public void setDis_content(String dis_content) {
		this.dis_content = dis_content;
	}


	public String getDis_symptom() {
		return dis_symptom;
	}


	public void setDis_symptom(String dis_symptom) {
		this.dis_symptom = dis_symptom;
	}


	public String getDis_dpt() {
		return dis_dpt;
	}


	public void setDis_dpt(String dis_dpt) {
		this.dis_dpt = dis_dpt;
	}


	public String getDis_tag() {
		return dis_tag;
	}


	public void setDis_tag(String dis_tag) {
		this.dis_tag = dis_tag;
	}


	public String getMB_ID() {
		return MB_ID;
	}


	public void setMB_ID(String mB_ID) {
		MB_ID = mB_ID;
	}


	public String getDis_pic1() {
		return dis_pic1;
	}


	public void setDis_pic1(String dis_pic1) {
		this.dis_pic1 = dis_pic1;
	}
	

	
	
	
}


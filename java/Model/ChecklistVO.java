package Model;

public class ChecklistVO {
	private int check_seq;	//üũ����Ʈ ����
	private String check_age;	//���ɴ�
	private String check_name;	//üũ����Ʈ ������
	private String dis_code;	//���� �ڵ�
	private String check_item;	//üũ����Ʈ �׸�
	private int check_std; 	//üũ����Ʈ ����
	private String reg_date;	//��� ��¥
	
	//������
	public ChecklistVO(int check_seq, String check_age, String check_name, String dis_code, String check_item,
			int check_std, String reg_date) {
		super();
		this.check_seq = check_seq;
		this.check_age = check_age;
		this.check_name = check_name;
		this.dis_code = dis_code;
		this.check_item = check_item;
		this.check_std = check_std;
		this.reg_date = reg_date;
	}


	//getter&setter
	public int getCheck_seq() {
		return check_seq;
	}

	public void setCheck_seq(int check_seq) {
		this.check_seq = check_seq;
	}

	public String getCheck_age() {
		return check_age;
	}

	public void setCheck_age(String check_age) {
		this.check_age = check_age;
	}

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getDis_code() {
		return dis_code;
	}

	public void setDis_code(String dis_code) {
		this.dis_code = dis_code;
	}

	public String getCheck_item() {
		return check_item;
	}

	public void setCheck_item(String check_item) {
		this.check_item = check_item;
	}

	public int getCheck_std() {
		return check_std;
	}

	public void setCheck_std(int check_std) {
		this.check_std = check_std;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	

	
}

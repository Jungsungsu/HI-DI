package Model;

public class RawVO {
	private int raw_seq;
	private String raw_company;
	private String raw_name;
	private String raw_func;
	private String dis_tag;
	
	public RawVO(int raw_seq, String raw_company, String raw_name, String raw_func, String dis_tag) {
		super();
		this.raw_seq = raw_seq;
		this.raw_company = raw_company;
		this.raw_name = raw_name;
		this.raw_func = raw_func;
		this.dis_tag = dis_tag;
	}
	
	public int getRaw_seq() {
		return raw_seq;
	}
	public void setRaw_seq(int raw_seq) {
		this.raw_seq = raw_seq;
	}
	public String getRaw_company() {
		return raw_company;
	}
	public void setRaw_company(String raw_company) {
		this.raw_company = raw_company;
	}
	public String getRaw_name() {
		return raw_name;
	}
	public void setRaw_name(String raw_name) {
		this.raw_name = raw_name;
	}
	public String getRaw_func() {
		return raw_func;
	}
	public void setRaw_func(String raw_func) {
		this.raw_func = raw_func;
	}
	public String getDis_tag() {
		return dis_tag;
	}
	public void setDis_tag(String dis_tag) {
		this.dis_tag = dis_tag;
	}
	
	
	
}

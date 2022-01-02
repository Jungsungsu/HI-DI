package Model;

public class PointVO {
	private int point_seq;
	private int point;
	private String point_memo;
	private String reg_date;
	private String mb_id;
	private String point_kind;
	public PointVO(int point_seq, int point, String point_memo, String reg_date, String mb_id, String point_kind) {
		super();
		this.point_seq = point_seq;
		this.point = point;
		this.point_memo = point_memo;
		this.reg_date = reg_date;
		this.mb_id = mb_id;
		this.point_kind = point_kind;
	}
	public int getPoint_seq() {
		return point_seq;
	}
	public void setPoint_seq(int point_seq) {
		this.point_seq = point_seq;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getPoint_memo() {
		return point_memo;
	}
	public void setPoint_memo(String point_memo) {
		this.point_memo = point_memo;
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
	public String getPoint_kind() {
		return point_kind;
	}
	public void setPoint_kind(String point_kind) {
		this.point_kind = point_kind;
	}
	
	
}

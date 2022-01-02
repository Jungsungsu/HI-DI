package Model;

public class RecommendVO {
	
	private int reco_seq;
	private String reco_age;
	private String reco_dise;
	private String reco_food;
	private String mb_id;
	private String reco_pic;
	
	public RecommendVO(int reco_seq, String reco_age, String reco_dise, String reco_food, String mb_id,
			String reco_pic) {
		this.reco_seq = reco_seq;
		this.reco_age = reco_age;
		this.reco_dise = reco_dise;
		this.reco_food = reco_food;
		this.mb_id = mb_id;
		this.reco_pic = reco_pic;
	}

	public int getReco_seq() {
		return reco_seq;
	}

	public void setReco_seq(int reco_seq) {
		this.reco_seq = reco_seq;
	}

	public String getReco_age() {
		return reco_age;
	}

	public void setReco_age(String reco_age) {
		this.reco_age = reco_age;
	}

	public String getReco_dise() {
		return reco_dise;
	}

	public void setReco_dise(String reco_dise) {
		this.reco_dise = reco_dise;
	}

	public String getReco_food() {
		return reco_food;
	}

	public void setReco_food(String reco_food) {
		this.reco_food = reco_food;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getReco_pic() {
		return reco_pic;
	}

	public void setReco_pic(String reco_pic) {
		this.reco_pic = reco_pic;
	}
	
	
}

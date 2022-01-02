package Model;

public class FoodVO {

	private int food_seq;				// 번호
	private String food_name;			// 식품 명
	private int food_year;				// 조사년도
	private String food_source;			// 자료출처
	private float food_calory;			// 열량
	private float food_carvohydrate;	// 탄수화물
	private float food_protein;			// 단백질
	private float food_fat;				// 지방
	private float food_sugars;			// 당류
	private float food_sodium;			// 나트륨
	private float food_cholesterol;		// 콜레스테롤
	private float food_saturated_fatty; // 포화지방산
	private float food_transfat;		// 트랜스지방
	private String reg_date; 			// 날짜?
	private String food_pic2;			// 식품사진
	public FoodVO(int food_seq, String food_name, int food_year, String food_source, float food_calory,
			float food_carvohydrate, float food_protein, float food_fat, float food_sugars, float food_sodium,
			float food_cholesterol, float food_saturated_fatty, float food_transfat, String reg_date,
			String food_pic2) {
		super();
		this.food_seq = food_seq;
		this.food_name = food_name;
		this.food_year = food_year;
		this.food_source = food_source;
		this.food_calory = food_calory;
		this.food_carvohydrate = food_carvohydrate;
		this.food_protein = food_protein;
		this.food_fat = food_fat;
		this.food_sugars = food_sugars;
		this.food_sodium = food_sodium;
		this.food_cholesterol = food_cholesterol;
		this.food_saturated_fatty = food_saturated_fatty;
		this.food_transfat = food_transfat;
		this.reg_date = reg_date;
		this.food_pic2 = food_pic2;
	}
	public int getFood_seq() {
		return food_seq;
	}
	public void setFood_seq(int food_seq) {
		this.food_seq = food_seq;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public int getFood_year() {
		return food_year;
	}
	public void setFood_year(int food_year) {
		this.food_year = food_year;
	}
	public String getFood_source() {
		return food_source;
	}
	public void setFood_source(String food_source) {
		this.food_source = food_source;
	}
	public float getFood_calory() {
		return food_calory;
	}
	public void setFood_calory(float food_calory) {
		this.food_calory = food_calory;
	}
	public float getFood_carvohydrate() {
		return food_carvohydrate;
	}
	public void setFood_carvohydrate(float food_carvohydrate) {
		this.food_carvohydrate = food_carvohydrate;
	}
	public float getFood_protein() {
		return food_protein;
	}
	public void setFood_protein(float food_protein) {
		this.food_protein = food_protein;
	}
	public float getFood_fat() {
		return food_fat;
	}
	public void setFood_fat(float food_fat) {
		this.food_fat = food_fat;
	}
	public float getFood_sugars() {
		return food_sugars;
	}
	public void setFood_sugars(float food_sugars) {
		this.food_sugars = food_sugars;
	}
	public float getFood_sodium() {
		return food_sodium;
	}
	public void setFood_sodium(float food_sodium) {
		this.food_sodium = food_sodium;
	}
	public float getFood_cholesterol() {
		return food_cholesterol;
	}
	public void setFood_cholesterol(float food_cholesterol) {
		this.food_cholesterol = food_cholesterol;
	}
	public float getFood_saturated_fatty() {
		return food_saturated_fatty;
	}
	public void setFood_saturated_fatty(float food_saturated_fatty) {
		this.food_saturated_fatty = food_saturated_fatty;
	}
	public float getFood_transfat() {
		return food_transfat;
	}
	public void setFood_transfat(float food_transfat) {
		this.food_transfat = food_transfat;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getFood_pic2() {
		return food_pic2;
	}
	public void setFood_pic2(String food_pic2) {
		this.food_pic2 = food_pic2;
	}
	
	
}

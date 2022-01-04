package bean;

//Bean
public class Contents implements java.io.Serializable {

	private int total; //合計金額
	private int count;  //人数
	private int price; //一人あたりの金額
	private String msg; //メッセージ
	private int gosa; //誤差の金額
	private double origin; //一人あたりの本来金額
	private String round;//端数処理
	private int kanpa;//カンパ額

	//ゲッター
	public int getTotal() {
		return total;
	}
	public int getCount() {
		return count;
	}
	public int getPrice() {
		return price;
	}
	public String getMsg() {
		return msg;
	}
	public int getGosa() {
		return gosa;
	}
	public double getOrigin() {
		return origin;
	}
	public String getRound(){
		return round;
	}
	public int getKanpa() {
		return kanpa;
	}


	//セッター
	public void setTotal(int total) {
		this.total=total;
	}
	public  void setCount(int count) {
		this.count=count;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public void setMsg(String msg) {
		this.msg=msg;
	}
	public void setGosa(int gosa) {
		this.gosa=gosa;
	}
	public void setOrigin(double origin) {
		this.origin=origin;
	}
	public void setRound(String round){
		this.round=round;
	}
	public void setKanpa(int kanpa) {
		this.kanpa = kanpa;
	}
}

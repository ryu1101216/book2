package bean;

public class Race implements java.io.Serializable {

	private String レース名;
	private String グレード;
	private String 競馬場;
	private String コース;
	private int 距離;
	private String 条件;
	private String 現行;
	private int 創設年;

	public String getレース名() {
		return レース名;
	}
	public String getグレード() {
		return グレード;
	}
	public String get競馬場() {
		return 競馬場;
	}
	public String getコース() {
		return コース;
	}
	public int get距離() {
		return 距離;
	}
	public String get条件() {
		return 条件;
	}
	public String get現行() {
		return 現行;
	}
	public int get創設年() {
		return 創設年;
	}
	
	public void setレース名(String レース名) {
		this.レース名 = レース名;
	}
	public void setグレード(String グレード) {
		this.グレード = グレード;
	}
	public void set競馬場(String 競馬場) {
		this.競馬場 = 競馬場;
	}
	public void setコース(String コース) {
		this.コース = コース;
	}
	public void set距離(int 距離) {
		this.距離 = 距離;
	}
	public void set条件(String 条件) {
		this.条件 = 条件;
	}
	public void set現行(String 現行) {
		this.現行 = 現行;
	}
	public void set創設年(int 創設年) {
		this.創設年 = 創設年;
	}

}

package bean;

import java.sql.Date;

public class Result implements java.io.Serializable {

	private String 回;
	private Date 開催日;	
	private String レース名;	
	private String グレード;
	private String 競馬場;
	private String コース;
	private int 距離;
	private String 条件;	
	private String 優勝馬;
	private Date 誕生日;
	private String 性別;
	private int 年齢;
	private String 毛色;

	public String get回() {
		return 回;
	}	
	public Date get開催日() {
		return 開催日;
	}	
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
	public String get優勝馬() {
		return 優勝馬;
	}
	public Date get誕生日() {
		return 誕生日;
	}
	public String get性別() {
		return 性別;
	}
	public int get年齢() {
		return 年齢;
	}	
	public String get毛色() {
		return 毛色;
	}

	public void set回(String 回) {
		this.回=回;
	}	
	public void set開催日(Date 開催日) {
		this.開催日=開催日;
	}	
	public void setレース名(String レース名) {
		this.レース名=レース名;
	}
	public void setグレード(String グレード) {
		this.グレード=グレード;
	}
	public void set競馬場(String 競馬場) {
		this.競馬場=競馬場;
	}
	public void setコース(String コース) {
		this.コース=コース;
	}
	public void set距離(int 距離) {
		this.距離=距離;
	}
	public void set条件(String 条件) {
		this.条件=条件;
	}
	public void set優勝馬(String 優勝馬) {
		this.優勝馬=優勝馬;
	}
	public void set誕生日(Date 誕生日) {
		this.誕生日=誕生日;
	}
	public void set性別(String 性別) {
		this.性別=性別;
	}
	public void set年齢(int 年齢) {
		this.年齢=年齢;
	}
	public void set毛色(String 毛色) {
		this.毛色=毛色;
	}

}

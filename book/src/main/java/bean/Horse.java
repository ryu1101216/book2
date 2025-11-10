package bean;

import java.sql.Date;

public class Horse implements java.io.Serializable {

	private String 馬名;
	private Date 誕生日;
	private String 性別;
	private String 毛色;
	
	public String get馬名() {
		return 馬名;
	}
	public Date get誕生日() {
		return 誕生日;
	}
	public String get性別() {
		return 性別;
	}
	public String get毛色() {
		return 毛色;
	}
	
	public void set馬名(String 馬名) {
		this.馬名=馬名;
	}
	public void set誕生日(Date 誕生日) {
		this.誕生日=誕生日;
	}
	public void set性別(String 性別) {
		this.性別=性別;
	}
	public void set毛色(String 毛色) {
		this.毛色=毛色;
	}

}

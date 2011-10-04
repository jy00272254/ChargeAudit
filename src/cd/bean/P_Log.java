package cd.bean;

import java.io.Serializable;
import java.util.Date;

/**
"LOGDATE"     VARCHAR(10),
"PROCNAME"    VARCHAR(100),
"SVC_ID"      VARCHAR(100),
"BEGIN_DATE"  TIMESTAMP,
"END_DATE"    TIMESTAMP,
"FLAG"        VARCHAR(20),
"DURATION"    INTEGER,
"ROWCOUNT"    INTEGER,
"NOTE"        VARCHAR(2000)
	 */
public class P_Log implements Serializable {

	private static final long serialVersionUID = -4034478054629884876L;

	//日志账期
	private String logDate;
	//存储过程名
	private String procname;
	//开始时间
	private Date BEGIN_DATE;
	//结束时间
	private Date END_DATE;
	//标志
	private String flag;
	//过程运行时间
	private Integer duration;
	//备注
	private String note;
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getProcname() {
		return procname;
	}
	public void setProcname(String procname) {
		this.procname = procname;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Date getBEGIN_DATE() {
		return BEGIN_DATE;
	}
	public void setBEGIN_DATE(Date bEGIN_DATE) {
		BEGIN_DATE = bEGIN_DATE;
	}
	public Date getEND_DATE() {
		return END_DATE;
	}
	public void setEND_DATE(Date eND_DATE) {
		END_DATE = eND_DATE;
	}
	
	@Override
	public String toString() {
		return "P_Log [logDate=" + logDate + ", procname=" + procname
				+ ", BEGIN_DATE=" + BEGIN_DATE + ", END_DATE=" + END_DATE
				+ ", flag=" + flag + ", duration=" + duration + ", note="
				+ note + "]";
	}
}

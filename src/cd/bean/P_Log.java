package cd.bean;

import java.io.Serializable;

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

	//��־����
	private String logDate;
	//�洢������
	private String procname;
	//��־
	private String flag;
	//��������ʱ��
	private Integer duration;
	//��ע
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
	
	@Override
	public String toString() {
		return "P_Log [logDate=" + logDate + ", procname=" + procname
				+ ", flag=" + flag + ", duration=" + duration + ", note="
				+ note + "]";
	}
}

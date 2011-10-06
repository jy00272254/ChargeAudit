package cd.bean;

public class Income_2G {

	private String acct_day;
	private Double call_fee;
	private Double incr_fee;
	private Double rent_fee;
	private Double last_jf_fee;
	private Double jf_fee;
	
	public String getAcct_day() {
		return acct_day;
	}
	public void setAcct_day(String acct_day) {
		this.acct_day = acct_day;
	}
	public Double getCall_fee() {
		return call_fee;
	}
	public void setCall_fee(Double call_fee) {
		this.call_fee = call_fee;
	}
	public Double getIncr_fee() {
		return incr_fee;
	}
	public void setIncr_fee(Double incr_fee) {
		this.incr_fee = incr_fee;
	}
	public Double getRent_fee() {
		return rent_fee;
	}
	public void setRent_fee(Double rent_fee) {
		this.rent_fee = rent_fee;
	}
	public Double getLast_jf_fee() {
		return last_jf_fee;
	}
	public void setLast_jf_fee(Double last_jf_fee) {
		this.last_jf_fee = last_jf_fee;
	}
	public Double getJf_fee() {
		return jf_fee;
	}
	public void setJf_fee(Double jf_fee) {
		this.jf_fee = jf_fee;
	}
	@Override
	public String toString() {
		return "Income_2G [acct_day=" + acct_day + ", call_fee=" + call_fee
				+ ", incr_fee=" + incr_fee + ", rent_fee=" + rent_fee
				+ ", last_jf_fee=" + last_jf_fee + ", jf_fee=" + jf_fee + "]";
	}
	
}

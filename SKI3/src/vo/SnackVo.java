package vo;

public class SnackVo {

	
	private int orderNum;
	private String snack;
	private String beverage;
	private String ramen;
	private String mem_id;
	
	public SnackVo() {
		
	}
	
	public SnackVo(String snack, String beverage, String ramen, String mem_id) {
		
		this.snack = snack;
		this.beverage = beverage;
		this.ramen = ramen;
		this.mem_id = mem_id;
	}
	
	public SnackVo(int orderNum, String snack, String beverage, String ramen, String mem_id) {
		this.orderNum = orderNum;
		this.snack = snack;
		this.beverage = beverage;
		this.ramen = ramen;
		this.mem_id = mem_id;
	}

	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getSnack() {
		return snack;
	}
	public void setSnack(String snack) {
		this.snack = snack;
	}
	public String getBeverage() {
		return beverage;
	}
	public void setBeverage(String beverage) {
		this.beverage = beverage;
	}
	public String getRamen() {
		return ramen;
	}
	public void setRamen(String ramen) {
		this.ramen = ramen;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	@Override
	public String toString() {
		return "\t\t" + orderNum + "\t│" + beverage + 
				"\t │" + snack + "\t │" + ramen ;
	}
	
}

package vo;

public class ReservVO {
	int reserv_num;
	String shoe_size;
	String equit;
	String ride;
	String date;
	String mem_id;
	
	public ReservVO() {}
	
	public ReservVO(String shoe_size, String equit, String ride, String date) {
		this.shoe_size = shoe_size;
		this.equit = equit;
		this.ride = ride;
		this.date = date;
	}
	
					
	
	public ReservVO(String shoe_size, String equit, String ride, String date, String mem_id) {
		super();
		this.shoe_size = shoe_size;
		this.equit = equit;
		this.ride = ride;
		this.date = date;
		this.mem_id = mem_id;
	}

	public ReservVO(String shoe_size, String equit, String ride, String date, String mem_id, int reserv_num) {
		super();
		this.shoe_size = shoe_size;
		this.equit = equit;
		this.ride = ride;
		this.date = date;
		this.mem_id = mem_id;
		this.reserv_num = reserv_num;
	}

	public ReservVO(int reserv_num, String shoe_size, String equit, String ride, String date, String mem_id) {
		this.reserv_num = reserv_num;
		this.shoe_size = shoe_size;
		this.equit = equit;
		this.ride = ride;
		this.date = date;
		this.mem_id = mem_id;
	}

	public int getReserv_num() {
		return reserv_num;
	}

	public void setReserv_num(int reserv_num) {
		this.reserv_num = reserv_num;
	}

	public String getShoe_size() {
		return shoe_size;
	}

	public void setShoe_size(String shoe_size) {
		this.shoe_size = shoe_size;
	}

	public String getEquit() {
		return equit;
	}

	public void setEquit(String equit) {
		this.equit = equit;
	}

	public String getRide() {
		return ride;
	}

	public void setRide(String ride) {
		this.ride = ride;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	@Override
	public String toString() {
		return "\t\t" + reserv_num + "\t│" + shoe_size + "\t\t│" + equit + "  \t│"
				 + ride+ "\t│" + date /*+ ", mem_id=" + mem_id + "] \n"*/;
	}
	
	
	
	
	
}

package vo;

public class AllprintVO {
   private String id;
   private String name;
   private String phone;
   private String email;
   
   private int reserv_num;
   private String shoe_size;
   private String equit;
   private String ride;
   private String date;
   
   private int orderNum;
   private String snack;
   private String beverage;
   private String ramen;
   
   
   
   public AllprintVO(String id, String name, String phone, 
         String email, int reserv_num, String shoe_size,
         String equit, String ride, String date, 
         int orderNum, String beverage,String snack,
         String ramen) {
      super();
      this.id = id;
      this.name = name;
      this.phone = phone;
      this.email = email;
      this.reserv_num = reserv_num;
      this.shoe_size = shoe_size;
      this.equit = equit;
      this.ride = ride;
      this.date = date;
      this.orderNum = orderNum;
      this.snack = snack;
      this.beverage = beverage;
      this.ramen = ramen;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
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
   
   
   @Override
   public String toString() {
      return id + "\t│" + name + "\t│" + phone + "\t│" + email
            + "\t│" + reserv_num + "\t│" + shoe_size + "\t\t│" + equit + "\t│" + ride
            + "\t│" + date +  "\t│" + orderNum + "\t│" + snack
            + "\t│" + beverage + "\t│" + ramen;
   }
   
   
   
   
   
   
}





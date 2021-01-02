package vo;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	
	public MemberVO() {}

	public MemberVO(String id, String pw, String name, String phone, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	@Override
	public String toString() {
		return "[ 아이디 = " + id + ", 비밀번호 = " + pw + ", 이름 = " + name + ", 핸드폰 번호 = " + phone + ", 이메일 = " + email + "]";
	}
	
	
	
}











package org.lanqiao.entity;
//修改过了,HAHA
public class Student {
	//学生信息
	private int id;
	private String name;
	private int age;
	private boolean stuSex;
	private String homeAddress;
	private String schoolAddress;
	private String classid;
	//学生证信息
//	private StudentCard card;//要联系两个类，起桥梁作用，相当于数据表里的外键
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String name, int age, boolean stuSex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.stuSex = stuSex;
	}

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isStuSex() {
		return stuSex;
	}

	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}
	
	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	
	/*public StudentCard getCard() {
		return card;
	}

	public void setCard(StudentCard card) {
		this.card = card;
	}
	*/
	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	@Override
	public String toString() {//注意：要是查一个班级有多少人，这个学生的card对象没创建会报空指针异常
		/*return id+"-"+name+"-"+age+"-"+stuSex+"-"+homeAddress+"-"+
	schoolAddress+"-"+card.getCardId()+"-"+card.getCardInfo()+"-"+classid;*/
		
		return id+"-"+name+"-"+age;
	}

}

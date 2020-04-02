package org.lanqiao.entity;

public class Student {
	//ѧ����Ϣ
	private int id;
	private String name;
	private int age;
	private boolean stuSex;
	private String homeAddress;
	private String schoolAddress;
	private String classid;
	//ѧ��֤��Ϣ
//	private StudentCard card;//Ҫ��ϵ�����࣬���������ã��൱�����ݱ�������
	
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
	public String toString() {//ע�⣺Ҫ�ǲ�һ���༶�ж����ˣ����ѧ����card����û�����ᱨ��ָ���쳣
		/*return id+"-"+name+"-"+age+"-"+stuSex+"-"+homeAddress+"-"+
	schoolAddress+"-"+card.getCardId()+"-"+card.getCardInfo()+"-"+classid;*/
		
		return id+"-"+name+"-"+age;
	}

}
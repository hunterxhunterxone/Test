package com.zzz.entity;

public class Resumes {
	private Integer id;
	private Integer uid;
	private Integer cid;
	private Integer did;
	private String name;
	private int age;
	private int sex;
	private String userNumber;
	private String selfInfo;
	private String phone;
	private String studentInfo;//学历
	private String major;//专业
	private String school;//毕业院校
	private String language;//所会语言
	private String experience;//获奖经历
	private String speciality;//特长
	private int statc;//简历状态 0:未读 1:已读 2:退回 3:已录取
	public Resumes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resumes(Integer id, Integer uid, Integer cid, Integer did, String name, int age, int sex, String userNumber,
			String selfInfo, String phone, String studentInfo, String major, String school, String language,
			String experience, String speciality) {
		super();
		this.id = id;
		this.uid = uid;
		this.cid = cid;
		this.did = did;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.userNumber = userNumber;
		this.selfInfo = selfInfo;
		this.phone = phone;
		this.studentInfo = studentInfo;
		this.major = major;
		this.school = school;
		this.language = language;
		this.experience = experience;
		this.speciality = speciality;
		this.statc = 0;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getSelfInfo() {
		return selfInfo;
	}
	public void setSelfInfo(String selfInfo) {
		this.selfInfo = selfInfo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(String studentInfo) {
		this.studentInfo = studentInfo;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getStatc() {
		return statc;
	}
	public void setStatc(int statc) {
		this.statc = statc;
	}
	@Override
	public String toString() {
		return "Resumes [id=" + id + ", uid=" + uid + ", cid=" + cid + ", did=" + did + ", name=" + name + ", age="
				+ age + ", sex=" + sex + ", userNumber=" + userNumber + ", selfInfo=" + selfInfo + ", phone=" + phone
				+ ", studentInfo=" + studentInfo + ", major=" + major + ", school=" + school + ", language=" + language
				+ ", experience=" + experience + ", speciality=" + speciality + ", statc=" + statc + "]";
	}
	
	
}

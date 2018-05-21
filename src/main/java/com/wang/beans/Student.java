package com.wang.beans;
import com.jason.annotations.Column;
import com.jason.annotations.Table;
@Table("student")	
public class Student{
	/**
	 * 
	 *
	 */
	@Column("sno")	
	private String sno;
	/**
	 * 
	 *
	 */
	@Column("sname")	
	private String sname;
	/**
	 * 
	 *
	 */
	@Column("sage")	
	private Integer sage;
	/**
	 * 
	 *
	 */
	@Column("ssex")	
	private String ssex;
	public Student(){
	}
	public Student(String sno){
		this.sno=sno;
	}
	public Student(String sno,String sname){
		this.sno=sno;
		this.sname=sname;
	}
	public Student(String sno,String sname,Integer sage){
		this.sno=sno;
		this.sname=sname;
		this.sage=sage;
	}
	public Student(String sno,String sname,Integer sage,String ssex){
		this.sno=sno;
		this.sname=sname;
		this.sage=sage;
		this.ssex=ssex;
	}
	/**
	 * 获取
	 */
	public String getSno(){
		return sno;
	}
	/**
	 * 设置
	 */
	public void setSno(String sno){
		this.sno=sno;
	}
	/**
	 * 获取
	 */
	public String getSname(){
		return sname;
	}
	/**
	 * 设置
	 */
	public void setSname(String sname){
		this.sname=sname;
	}
	/**
	 * 获取
	 */
	public Integer getSage(){
		return sage;
	}
	/**
	 * 设置
	 */
	public void setSage(Integer sage){
		this.sage=sage;
	}
	/**
	 * 获取
	 */
	public String getSsex(){
		return ssex;
	}
	/**
	 * 设置
	 */
	public void setSsex(String ssex){
		this.ssex=ssex;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sno == null) ? 0 : sno.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((sage == null) ? 0 : sage.hashCode());
		result = prime * result + ((ssex == null) ? 0 : ssex.hashCode());
		return result;
	}
		
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (sno == null) {
			if (other.sno != null)
				return false;
		} else if (!sno.equals(other.sno))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (ssex == null) {
			if (other.ssex != null)
				return false;
		} else if (!ssex.equals(other.ssex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno+",sname=" + sname+",sage=" + sage+",ssex=" + ssex+"]";
	}





}
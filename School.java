package com.ty.onetomany_uni1.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	private String name;
	private int fees;
	@OneToMany
	List<Student> slist;
	@OneToMany
	List<Teacher> tlist;

	
	/**
	 * @return the slist
	 */
	public List<Student> getSlist() {
		return slist;
	}
	/**
	 * @param slist the slist to set
	 */
	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}
	/**
	 * @return the tlist
	 */
	public List<Teacher> getTlist() {
		return tlist;
	}
	/**
	 * @param tlist the tlist to set
	 */
	public void setTlist(List<Teacher> tlist) {
		this.tlist = tlist;
	}
	/**
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}
	/**
	 * @param fees the fees to set
	 */
	public void setFees(int fees) {
		this.fees = fees;
	}
	@OneToMany
	private List<Student> list;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the list
	 */
	public List<Student> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<Student> list) {
		this.list = list;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "School [id=" + id + ", address=" + address + ", name=" + name + ", fees=" + fees + ", list=" + list
				+ "]";
	}
	
	
}

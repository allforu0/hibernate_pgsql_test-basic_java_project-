package com.test.www;

// Generated 2011. 8. 24 ���� 10:21:44 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Test1 generated by hbm2java
 */
@Entity
@Table(name = "test1", schema = "public")
@SequenceGenerator(
	    name="seq_idx",
	    allocationSize=1,
	    sequenceName="seq_id_test1"
	)
public class Test1 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idx;
	private String text1;
	private String text2;
	private Date created;
	private Date updated;

	public Test1() {
	}

	public Test1(int idx) {
		this.idx = idx;
	}

	public Test1(int idx, String text1, String text2, Date created, Date updated) {
		this.idx = idx;
		this.text1 = text1;
		this.text2 = text2;
		this.created = created;
		this.updated = updated;
	}

	@Id
	@Column(name = "idx", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_idx")
	public int getIdx() {
		return this.idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Column(name = "text1")
	public String getText1() {
		return this.text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	@Column(name = "text2")
	public String getText2() {
		return this.text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = true)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = true)
	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Test1 [idx=" + idx + ", text1=" + text1 + ", text2=" + text2
				+ ", created=" + created + ", updated=" + updated + "]";
	}
	
	

}

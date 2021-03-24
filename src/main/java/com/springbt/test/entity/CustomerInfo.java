package com.springbt.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_info")
public class CustomerInfo {

	@Id
	@SequenceGenerator(name = "seqCuiNum", sequenceName = "seq_cui_num", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCuiNum")
	@Column(name = "cui_num")
	private Integer cuiNum;
	@Column(name = "cui_name")
	private String cuiName;
	@Column(name = "cui_id")
	private String cuiId;
	@Column(name = "cui_pwd")
	private String cuiPwd;

}

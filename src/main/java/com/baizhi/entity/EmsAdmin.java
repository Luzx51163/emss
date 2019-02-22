package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmsAdmin {
	private Integer emsId;
	private String emsUsername;
	private String emsRealname;
	private String emsPassword;
	private Integer emsSex;
	private Integer emsAge;
	private Integer emsSalary;

}

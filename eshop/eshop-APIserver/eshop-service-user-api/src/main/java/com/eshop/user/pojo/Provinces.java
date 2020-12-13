package com.eshop.user.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
/****
 * @Author:shenkunlin
 * @Description:Provinces构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Provinces",value = "Provinces")
@Table(name="tb_provinces")
public class Provinces implements Serializable{

	@ApiModelProperty(value = "省份ID",required = false)
	@Id
    @Column(name = "provinceid")
	private String provinceid;//省份ID

	@ApiModelProperty(value = "省份名称",required = false)
    @Column(name = "province")
	private String province;//省份名称



	//get方法
	public String getProvinceid() {
		return provinceid;
	}

	//set方法
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	//get方法
	public String getProvince() {
		return province;
	}

	//set方法
	public void setProvince(String province) {
		this.province = province;
	}


}

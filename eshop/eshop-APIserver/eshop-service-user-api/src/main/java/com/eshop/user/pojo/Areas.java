package com.eshop.user.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
/****
 * @Author:shenkunlin
 * @Description:Areas构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Areas",value = "Areas")
@Table(name="tb_areas")
public class Areas implements Serializable{

	@ApiModelProperty(value = "区域ID",required = false)
	@Id
    @Column(name = "areaid")
	private String areaid;//区域ID

	@ApiModelProperty(value = "区域名称",required = false)
    @Column(name = "area")
	private String area;//区域名称

	@ApiModelProperty(value = "城市ID",required = false)
    @Column(name = "cityid")
	private String cityid;//城市ID



	//get方法
	public String getAreaid() {
		return areaid;
	}

	//set方法
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	//get方法
	public String getArea() {
		return area;
	}

	//set方法
	public void setArea(String area) {
		this.area = area;
	}
	//get方法
	public String getCityid() {
		return cityid;
	}

	//set方法
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}


}

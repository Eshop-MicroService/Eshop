package com.eshop.user.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
/****
 * @Author:shenkunlin
 * @Description:Cities构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Cities",value = "Cities")
@Table(name="tb_cities")
public class Cities implements Serializable{

	@ApiModelProperty(value = "城市ID",required = false)
	@Id
    @Column(name = "cityid")
	private String cityid;//城市ID

	@ApiModelProperty(value = "城市名称",required = false)
    @Column(name = "city")
	private String city;//城市名称

	@ApiModelProperty(value = "省份ID",required = false)
    @Column(name = "provinceid")
	private String provinceid;//省份ID



	//get方法
	public String getCityid() {
		return cityid;
	}

	//set方法
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	//get方法
	public String getCity() {
		return city;
	}

	//set方法
	public void setCity(String city) {
		this.city = city;
	}
	//get方法
	public String getProvinceid() {
		return provinceid;
	}

	//set方法
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}


}

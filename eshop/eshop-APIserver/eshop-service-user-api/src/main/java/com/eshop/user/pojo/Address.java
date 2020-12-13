package com.eshop.user.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:Address构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Address",value = "Address")
@Table(name="tb_address")
public class Address implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "username")
	private String username;//用户名

	@ApiModelProperty(value = "省",required = false)
    @Column(name = "provinceid")
	private String provinceid;//省

	@ApiModelProperty(value = "市",required = false)
    @Column(name = "cityid")
	private String cityid;//市

	@ApiModelProperty(value = "县/区",required = false)
    @Column(name = "areaid")
	private String areaid;//县/区

	@ApiModelProperty(value = "电话",required = false)
    @Column(name = "phone")
	private String phone;//电话

	@ApiModelProperty(value = "详细地址",required = false)
    @Column(name = "address")
	private String address;//详细地址

	@ApiModelProperty(value = "联系人",required = false)
    @Column(name = "contact")
	private String contact;//联系人

	@ApiModelProperty(value = "是否是默认 1默认 0否",required = false)
    @Column(name = "is_default")
	private String isDefault;//是否是默认 1默认 0否

	@ApiModelProperty(value = "别名",required = false)
    @Column(name = "alias")
	private String alias;//别名



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getProvinceid() {
		return provinceid;
	}

	//set方法
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	//get方法
	public String getCityid() {
		return cityid;
	}

	//set方法
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	//get方法
	public String getAreaid() {
		return areaid;
	}

	//set方法
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	//get方法
	public String getPhone() {
		return phone;
	}

	//set方法
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//get方法
	public String getAddress() {
		return address;
	}

	//set方法
	public void setAddress(String address) {
		this.address = address;
	}
	//get方法
	public String getContact() {
		return contact;
	}

	//set方法
	public void setContact(String contact) {
		this.contact = contact;
	}
	//get方法
	public String getIsDefault() {
		return isDefault;
	}

	//set方法
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	//get方法
	public String getAlias() {
		return alias;
	}

	//set方法
	public void setAlias(String alias) {
		this.alias = alias;
	}


}

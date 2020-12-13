package com.eshop.user.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:User构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "User",value = "User")
@Table(name="tb_user")
public class User implements Serializable{

	@ApiModelProperty(value = "用户名",required = false)
	@Id
    @Column(name = "username")
	private String username;//用户名

	@ApiModelProperty(value = "密码，加密存储",required = false)
    @Column(name = "password")
	private String password;//密码，加密存储

	@ApiModelProperty(value = "注册手机号",required = false)
    @Column(name = "phone")
	private String phone;//注册手机号

	@ApiModelProperty(value = "注册邮箱",required = false)
    @Column(name = "email")
	private String email;//注册邮箱

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "created")
	private Date created;//创建时间

	@ApiModelProperty(value = "修改时间",required = false)
    @Column(name = "updated")
	private Date updated;//修改时间

	@ApiModelProperty(value = "会员来源：1:PC，2：H5，3：Android，4：IOS",required = false)
    @Column(name = "source_type")
	private String sourceType;//会员来源：1:PC，2：H5，3：Android，4：IOS

	@ApiModelProperty(value = "昵称",required = false)
    @Column(name = "nick_name")
	private String nickName;//昵称

	@ApiModelProperty(value = "真实姓名",required = false)
    @Column(name = "name")
	private String name;//真实姓名

	@ApiModelProperty(value = "使用状态（1正常 0非正常）",required = false)
    @Column(name = "status")
	private String status;//使用状态（1正常 0非正常）

	@ApiModelProperty(value = "头像地址",required = false)
    @Column(name = "head_pic")
	private String headPic;//头像地址

	@ApiModelProperty(value = "QQ号码",required = false)
    @Column(name = "qq")
	private String qq;//QQ号码

	@ApiModelProperty(value = "手机是否验证 （0否  1是）",required = false)
    @Column(name = "is_mobile_check")
	private String isMobileCheck;//手机是否验证 （0否  1是）

	@ApiModelProperty(value = "邮箱是否检测（0否  1是）",required = false)
    @Column(name = "is_email_check")
	private String isEmailCheck;//邮箱是否检测（0否  1是）

	@ApiModelProperty(value = "性别，1男，0女",required = false)
    @Column(name = "sex")
	private String sex;//性别，1男，0女

	@ApiModelProperty(value = "会员等级",required = false)
    @Column(name = "user_level")
	private Integer userLevel;//会员等级

	@ApiModelProperty(value = "积分",required = false)
    @Column(name = "points")
	private Integer points;//积分

	@ApiModelProperty(value = "经验值",required = false)
    @Column(name = "experience_value")
	private Integer experienceValue;//经验值

	@ApiModelProperty(value = "出生年月日",required = false)
    @Column(name = "birthday")
	private Date birthday;//出生年月日

	@ApiModelProperty(value = "最后登录时间",required = false)
    @Column(name = "last_login_time")
	private Date lastLoginTime;//最后登录时间



	//get方法
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}

	//set方法
	public void setEmail(String email) {
		this.email = email;
	}
	//get方法
	public Date getCreated() {
		return created;
	}

	//set方法
	public void setCreated(Date created) {
		this.created = created;
	}
	//get方法
	public Date getUpdated() {
		return updated;
	}

	//set方法
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	//get方法
	public String getSourceType() {
		return sourceType;
	}

	//set方法
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	//get方法
	public String getNickName() {
		return nickName;
	}

	//set方法
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public String getHeadPic() {
		return headPic;
	}

	//set方法
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	//get方法
	public String getQq() {
		return qq;
	}

	//set方法
	public void setQq(String qq) {
		this.qq = qq;
	}
	//get方法
	public String getIsMobileCheck() {
		return isMobileCheck;
	}

	//set方法
	public void setIsMobileCheck(String isMobileCheck) {
		this.isMobileCheck = isMobileCheck;
	}
	//get方法
	public String getIsEmailCheck() {
		return isEmailCheck;
	}

	//set方法
	public void setIsEmailCheck(String isEmailCheck) {
		this.isEmailCheck = isEmailCheck;
	}
	//get方法
	public String getSex() {
		return sex;
	}

	//set方法
	public void setSex(String sex) {
		this.sex = sex;
	}
	//get方法
	public Integer getUserLevel() {
		return userLevel;
	}

	//set方法
	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}
	//get方法
	public Integer getPoints() {
		return points;
	}

	//set方法
	public void setPoints(Integer points) {
		this.points = points;
	}
	//get方法
	public Integer getExperienceValue() {
		return experienceValue;
	}

	//set方法
	public void setExperienceValue(Integer experienceValue) {
		this.experienceValue = experienceValue;
	}
	//get方法
	public Date getBirthday() {
		return birthday;
	}

	//set方法
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	//get方法
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	//set方法
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


}

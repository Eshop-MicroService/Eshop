package com.eshop.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:UndoLog构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "UndoLog",value = "UndoLog")
@Table(name="undo_log")
public class UndoLog implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "branch_id")
	private Long branchId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "xid")
	private String xid;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "rollback_info")
	private String rollbackInfo;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "log_status")
	private Integer logStatus;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "log_created")
	private Date logCreated;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "log_modified")
	private Date logModified;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "ext")
	private String ext;//



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Long getBranchId() {
		return branchId;
	}

	//set方法
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	//get方法
	public String getXid() {
		return xid;
	}

	//set方法
	public void setXid(String xid) {
		this.xid = xid;
	}
	//get方法
	public String getRollbackInfo() {
		return rollbackInfo;
	}

	//set方法
	public void setRollbackInfo(String rollbackInfo) {
		this.rollbackInfo = rollbackInfo;
	}
	//get方法
	public Integer getLogStatus() {
		return logStatus;
	}

	//set方法
	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}
	//get方法
	public Date getLogCreated() {
		return logCreated;
	}

	//set方法
	public void setLogCreated(Date logCreated) {
		this.logCreated = logCreated;
	}
	//get方法
	public Date getLogModified() {
		return logModified;
	}

	//set方法
	public void setLogModified(Date logModified) {
		this.logModified = logModified;
	}
	//get方法
	public String getExt() {
		return ext;
	}

	//set方法
	public void setExt(String ext) {
		this.ext = ext;
	}


}

package com.eshop.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
/****
 * @Author:shenkunlin
 * @Description:TaskHis构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "TaskHis",value = "TaskHis")
@Table(name="tb_task_his")
public class TaskHis implements Serializable{

	@ApiModelProperty(value = "任务id",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;//任务id

	@ApiModelProperty(value = "",required = false)
    @Column(name = "create_time")
	private Date createTime;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "update_time")
	private Date updateTime;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "delete_time")
	private Date deleteTime;//

	@ApiModelProperty(value = "任务类型",required = false)
    @Column(name = "task_type")
	private String taskType;//任务类型

	@ApiModelProperty(value = "交换机名称",required = false)
    @Column(name = "mq_exchange")
	private String mqExchange;//交换机名称

	@ApiModelProperty(value = "routingkey",required = false)
    @Column(name = "mq_routingkey")
	private String mqRoutingkey;//routingkey

	@ApiModelProperty(value = "任务请求的内容",required = false)
    @Column(name = "request_body")
	private String requestBody;//任务请求的内容

	@ApiModelProperty(value = "任务状态",required = false)
    @Column(name = "status")
	private String status;//任务状态

	@ApiModelProperty(value = "",required = false)
    @Column(name = "errormsg")
	private String errormsg;//



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public Date getDeleteTime() {
		return deleteTime;
	}

	//set方法
	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}
	//get方法
	public String getTaskType() {
		return taskType;
	}

	//set方法
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	//get方法
	public String getMqExchange() {
		return mqExchange;
	}

	//set方法
	public void setMqExchange(String mqExchange) {
		this.mqExchange = mqExchange;
	}
	//get方法
	public String getMqRoutingkey() {
		return mqRoutingkey;
	}

	//set方法
	public void setMqRoutingkey(String mqRoutingkey) {
		this.mqRoutingkey = mqRoutingkey;
	}
	//get方法
	public String getRequestBody() {
		return requestBody;
	}

	//set方法
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
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
	public String getErrormsg() {
		return errormsg;
	}

	//set方法
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}


}

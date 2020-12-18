package com.eshop.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:ReturnCause构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "ReturnCause",value = "ReturnCause")
@Table(name="tb_return_cause")
public class ReturnCause implements Serializable{

	@ApiModelProperty(value = "ID",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//ID

	@ApiModelProperty(value = "原因",required = false)
    @Column(name = "cause")
	private String cause;//原因

	@ApiModelProperty(value = "排序",required = false)
    @Column(name = "seq")
	private Integer seq;//排序

	@ApiModelProperty(value = "是否启用",required = false)
    @Column(name = "status")
	private String status;//是否启用



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getCause() {
		return cause;
	}

	//set方法
	public void setCause(String cause) {
		this.cause = cause;
	}
	//get方法
	public Integer getSeq() {
		return seq;
	}

	//set方法
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}


}

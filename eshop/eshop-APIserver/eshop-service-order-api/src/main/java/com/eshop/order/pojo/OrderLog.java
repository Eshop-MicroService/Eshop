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
 * @Description:OrderLog构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "OrderLog",value = "OrderLog")
@Table(name="tb_order_log")
public class OrderLog implements Serializable{

	@ApiModelProperty(value = "ID",required = false)
	@Id
    @Column(name = "id")
	private String id;//ID

	@ApiModelProperty(value = "操作员",required = false)
    @Column(name = "operater")
	private String operater;//操作员

	@ApiModelProperty(value = "操作时间",required = false)
    @Column(name = "operate_time")
	private Date operateTime;//操作时间

	@ApiModelProperty(value = "订单ID",required = false)
    @Column(name = "order_id")
	private Long orderId;//订单ID

	@ApiModelProperty(value = "订单状态",required = false)
    @Column(name = "order_status")
	private String orderStatus;//订单状态

	@ApiModelProperty(value = "付款状态",required = false)
    @Column(name = "pay_status")
	private String payStatus;//付款状态

	@ApiModelProperty(value = "发货状态",required = false)
    @Column(name = "consign_status")
	private String consignStatus;//发货状态

	@ApiModelProperty(value = "备注",required = false)
    @Column(name = "remarks")
	private String remarks;//备注



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getOperater() {
		return operater;
	}

	//set方法
	public void setOperater(String operater) {
		this.operater = operater;
	}
	//get方法
	public Date getOperateTime() {
		return operateTime;
	}

	//set方法
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	//get方法
	public Long getOrderId() {
		return orderId;
	}

	//set方法
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	//get方法
	public String getOrderStatus() {
		return orderStatus;
	}

	//set方法
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	//get方法
	public String getPayStatus() {
		return payStatus;
	}

	//set方法
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	//get方法
	public String getConsignStatus() {
		return consignStatus;
	}

	//set方法
	public void setConsignStatus(String consignStatus) {
		this.consignStatus = consignStatus;
	}
	//get方法
	public String getRemarks() {
		return remarks;
	}

	//set方法
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}

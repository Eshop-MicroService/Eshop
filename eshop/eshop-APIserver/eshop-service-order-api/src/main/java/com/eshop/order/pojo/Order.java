package com.eshop.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:Order构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Order",value = "Order")
@Table(name="tb_order")
public class Order implements Serializable{

	@ApiModelProperty(value = "订单id",required = false)
	@Id
    @Column(name = "id")
	private String id;//订单id

	@ApiModelProperty(value = "数量合计",required = false)
    @Column(name = "total_num")
	private Integer totalNum;//数量合计

	@ApiModelProperty(value = "金额合计",required = false)
    @Column(name = "total_money")
	private Integer totalMoney;//金额合计

	@ApiModelProperty(value = "优惠金额",required = false)
    @Column(name = "pre_money")
	private Integer preMoney;//优惠金额

	@ApiModelProperty(value = "邮费",required = false)
    @Column(name = "post_fee")
	private Integer postFee;//邮费

	@ApiModelProperty(value = "实付金额",required = false)
    @Column(name = "pay_money")
	private Integer payMoney;//实付金额

	@ApiModelProperty(value = "支付类型，1、在线支付、0 货到付款",required = false)
    @Column(name = "pay_type")
	private String payType;//支付类型，1、在线支付、0 货到付款

	@ApiModelProperty(value = "订单创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//订单创建时间

	@ApiModelProperty(value = "订单更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//订单更新时间

	@ApiModelProperty(value = "付款时间",required = false)
    @Column(name = "pay_time")
	private Date payTime;//付款时间

	@ApiModelProperty(value = "发货时间",required = false)
    @Column(name = "consign_time")
	private Date consignTime;//发货时间

	@ApiModelProperty(value = "交易完成时间",required = false)
    @Column(name = "end_time")
	private Date endTime;//交易完成时间

	@ApiModelProperty(value = "交易关闭时间",required = false)
    @Column(name = "close_time")
	private Date closeTime;//交易关闭时间

	@ApiModelProperty(value = "物流名称",required = false)
    @Column(name = "shipping_name")
	private String shippingName;//物流名称

	@ApiModelProperty(value = "物流单号",required = false)
    @Column(name = "shipping_code")
	private String shippingCode;//物流单号

	@ApiModelProperty(value = "用户名称",required = false)
    @Column(name = "username")
	private String username;//用户名称

	@ApiModelProperty(value = "买家留言",required = false)
    @Column(name = "buyer_message")
	private String buyerMessage;//买家留言

	@ApiModelProperty(value = "是否评价",required = false)
    @Column(name = "buyer_rate")
	private String buyerRate;//是否评价

	@ApiModelProperty(value = "收货人",required = false)
    @Column(name = "receiver_contact")
	private String receiverContact;//收货人

	@ApiModelProperty(value = "收货人手机",required = false)
    @Column(name = "receiver_mobile")
	private String receiverMobile;//收货人手机

	@ApiModelProperty(value = "收货人地址",required = false)
    @Column(name = "receiver_address")
	private String receiverAddress;//收货人地址

	@ApiModelProperty(value = "订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面",required = false)
    @Column(name = "source_type")
	private String sourceType;//订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面

	@ApiModelProperty(value = "交易流水号",required = false)
    @Column(name = "transaction_id")
	private String transactionId;//交易流水号

	@ApiModelProperty(value = "订单状态 ",required = false)
    @Column(name = "order_status")
	private String orderStatus;//订单状态 

	@ApiModelProperty(value = "支付状态 0:未支付 1:已支付",required = false)
    @Column(name = "pay_status")
	private String payStatus;//支付状态 0:未支付 1:已支付

	@ApiModelProperty(value = "发货状态 0:未发货 1:已发货 2:已送达",required = false)
    @Column(name = "consign_status")
	private String consignStatus;//发货状态 0:未发货 1:已发货 2:已送达

	@ApiModelProperty(value = "是否删除",required = false)
    @Column(name = "is_delete")
	private String isDelete;//是否删除



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public Integer getTotalNum() {
		return totalNum;
	}

	//set方法
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	//get方法
	public Integer getTotalMoney() {
		return totalMoney;
	}

	//set方法
	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}
	//get方法
	public Integer getPreMoney() {
		return preMoney;
	}

	//set方法
	public void setPreMoney(Integer preMoney) {
		this.preMoney = preMoney;
	}
	//get方法
	public Integer getPostFee() {
		return postFee;
	}

	//set方法
	public void setPostFee(Integer postFee) {
		this.postFee = postFee;
	}
	//get方法
	public Integer getPayMoney() {
		return payMoney;
	}

	//set方法
	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}
	//get方法
	public String getPayType() {
		return payType;
	}

	//set方法
	public void setPayType(String payType) {
		this.payType = payType;
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
	public Date getPayTime() {
		return payTime;
	}

	//set方法
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	//get方法
	public Date getConsignTime() {
		return consignTime;
	}

	//set方法
	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}
	//get方法
	public Date getEndTime() {
		return endTime;
	}

	//set方法
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	//get方法
	public Date getCloseTime() {
		return closeTime;
	}

	//set方法
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	//get方法
	public String getShippingName() {
		return shippingName;
	}

	//set方法
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}
	//get方法
	public String getShippingCode() {
		return shippingCode;
	}

	//set方法
	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
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
	public String getBuyerMessage() {
		return buyerMessage;
	}

	//set方法
	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}
	//get方法
	public String getBuyerRate() {
		return buyerRate;
	}

	//set方法
	public void setBuyerRate(String buyerRate) {
		this.buyerRate = buyerRate;
	}
	//get方法
	public String getReceiverContact() {
		return receiverContact;
	}

	//set方法
	public void setReceiverContact(String receiverContact) {
		this.receiverContact = receiverContact;
	}
	//get方法
	public String getReceiverMobile() {
		return receiverMobile;
	}

	//set方法
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	//get方法
	public String getReceiverAddress() {
		return receiverAddress;
	}

	//set方法
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
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
	public String getTransactionId() {
		return transactionId;
	}

	//set方法
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
	public String getIsDelete() {
		return isDelete;
	}

	//set方法
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}


}

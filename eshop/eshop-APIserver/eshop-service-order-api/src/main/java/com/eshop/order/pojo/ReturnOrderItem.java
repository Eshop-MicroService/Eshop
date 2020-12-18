package com.eshop.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:ReturnOrderItem构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "ReturnOrderItem",value = "ReturnOrderItem")
@Table(name="tb_return_order_item")
public class ReturnOrderItem implements Serializable{

	@ApiModelProperty(value = "ID",required = false)
	@Id
    @Column(name = "id")
	private String id;//ID

	@ApiModelProperty(value = "分类ID",required = false)
    @Column(name = "category_id")
	private Integer categoryId;//分类ID

	@ApiModelProperty(value = "SPU_ID",required = false)
    @Column(name = "spu_id")
	private String spuId;//SPU_ID

	@ApiModelProperty(value = "SKU_ID",required = false)
    @Column(name = "sku_id")
	private String skuId;//SKU_ID

	@ApiModelProperty(value = "订单ID",required = false)
    @Column(name = "order_id")
	private String orderId;//订单ID

	@ApiModelProperty(value = "订单明细ID",required = false)
    @Column(name = "order_item_id")
	private String orderItemId;//订单明细ID

	@ApiModelProperty(value = "退货订单ID",required = false)
    @Column(name = "return_order_id")
	private String returnOrderId;//退货订单ID

	@ApiModelProperty(value = "标题",required = false)
    @Column(name = "title")
	private String title;//标题

	@ApiModelProperty(value = "单价",required = false)
    @Column(name = "price")
	private Integer price;//单价

	@ApiModelProperty(value = "数量",required = false)
    @Column(name = "num")
	private Integer num;//数量

	@ApiModelProperty(value = "总金额",required = false)
    @Column(name = "money")
	private Integer money;//总金额

	@ApiModelProperty(value = "支付金额",required = false)
    @Column(name = "pay_money")
	private Integer payMoney;//支付金额

	@ApiModelProperty(value = "图片地址",required = false)
    @Column(name = "image")
	private String image;//图片地址

	@ApiModelProperty(value = "重量",required = false)
    @Column(name = "weight")
	private Integer weight;//重量



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public Integer getCategoryId() {
		return categoryId;
	}

	//set方法
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	//get方法
	public String getSpuId() {
		return spuId;
	}

	//set方法
	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}
	//get方法
	public String getSkuId() {
		return skuId;
	}

	//set方法
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	//get方法
	public String getOrderId() {
		return orderId;
	}

	//set方法
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	//get方法
	public String getOrderItemId() {
		return orderItemId;
	}

	//set方法
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	//get方法
	public String getReturnOrderId() {
		return returnOrderId;
	}

	//set方法
	public void setReturnOrderId(String returnOrderId) {
		this.returnOrderId = returnOrderId;
	}
	//get方法
	public String getTitle() {
		return title;
	}

	//set方法
	public void setTitle(String title) {
		this.title = title;
	}
	//get方法
	public Integer getPrice() {
		return price;
	}

	//set方法
	public void setPrice(Integer price) {
		this.price = price;
	}
	//get方法
	public Integer getNum() {
		return num;
	}

	//set方法
	public void setNum(Integer num) {
		this.num = num;
	}
	//get方法
	public Integer getMoney() {
		return money;
	}

	//set方法
	public void setMoney(Integer money) {
		this.money = money;
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
	public String getImage() {
		return image;
	}

	//set方法
	public void setImage(String image) {
		this.image = image;
	}
	//get方法
	public Integer getWeight() {
		return weight;
	}

	//set方法
	public void setWeight(Integer weight) {
		this.weight = weight;
	}


}

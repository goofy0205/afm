package com.kh.afm.cart.model.vo;

public class Cart {
	private String userId;
	private int cartNo;
	private int productNo;
	private int attachNo;
	private int productPrice;
	private int productQuantity;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String userId, int cartNo, int productNo, int attachNo, int productPrice, int productQuantity) {
		super();
		this.userId = userId;
		this.cartNo = cartNo;
		this.productNo = productNo;
		this.attachNo = attachNo;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getAttachNo() {
		return attachNo;
	}
	public void setAttachNo(int attachNo) {
		this.attachNo = attachNo;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", cartNo=" + cartNo + ", productNo=" + productNo + ", attachNo=" + attachNo
				+ ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + "]";
	}
	
}

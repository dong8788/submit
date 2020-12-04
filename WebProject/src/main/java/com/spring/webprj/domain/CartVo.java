package com.spring.webprj.domain;

public class CartVo {
	
	private int cartSeq;
	private int cusSeq;
	private int prodSeq;
	private int poQuantity;
	public int getCartSeq() {
		return cartSeq;
	}
	public void setCartSeq(int cartSeq) {
		this.cartSeq = cartSeq;
	}
	public int getCusSeq() {
		return cusSeq;
	}
	public void setCusSeq(int cusSeq) {
		this.cusSeq = cusSeq;
	}
	public int getProdSeq() {
		return prodSeq;
	}
	public void setProdSeq(int prodSeq) {
		this.prodSeq = prodSeq;
	}
	public int getPoQuantity() {
		return poQuantity;
	}
	public void setPoQuantity(int poQuantity) {
		this.poQuantity = poQuantity;
	}
	@Override
	public String toString() {
		return "CartVo [cartSeq=" + cartSeq + ", cusSeq=" + cusSeq + ", prodSeq=" + prodSeq + ", poQuantity="
				+ poQuantity + "]";
	}
	
	
}

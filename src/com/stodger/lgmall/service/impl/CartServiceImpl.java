package com.stodger.lgmall.service.impl;

import java.util.Map;

import com.stodger.lgmall.domain.Cart;
import com.stodger.lgmall.domain.CartItem;
import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.CartService;

public class CartServiceImpl implements CartService {
	
	/**
	 * 购物车添加商品
	 */
	@Override
	public Cart addCartProduct(Cart cart, CartItem cartItem, Product product) {
		Map<String, CartItem> cartItems = cart.getCartItems();
		String pid = product.getPid();
		double newSubtotal = cartItem.getBuyNum() * product.getP_price();
		//判断购物车是否已经存在该商品
		if(cartItems.containsKey(pid)){
			//取上次购买数量
			int oldBuyNum = cartItems.get(pid).getBuyNum();
			//取新购买数量
			int newBuyNum = cartItem.getBuyNum();
			//取上次小计
			double oldSubtotal = cartItems.get(pid).getSubtotal();
			//更新小计
			cartItems.get(pid).setSubtotal(newSubtotal + oldSubtotal);
			//更新购买数量
			cartItems.get(pid).setBuyNum(newBuyNum + oldBuyNum);
			//更新商品信息
			cart.setCartItems(cartItems);
		}else{
			cart.getCartItems().put(pid, cartItem);
		}
		//更新总计
		cart.setTotal(cart.getTotal() + newSubtotal);
		return cart;
	}
	
	/**
	 * 校验购买数量
	 */
	@Override
	public LGResult checkByNum(Product product, String byNum) {
		LGResult lgResult = new LGResult();
		int num = product.getP_num();
		int limitNum = product.getP_limitNum();
		
		//验证购买数量
		if(num < limitNum && num < Integer.parseInt(byNum)){
			lgResult.setMsg(Integer.toString(num));
			lgResult.setOk(false);
		}else if(limitNum < Integer.parseInt(byNum)){
			lgResult.setMsg(Integer.toString(limitNum));
			lgResult.setOk(false);
		}else{
			lgResult.setMsg(byNum);
			lgResult.setOk(true);
		}
		return lgResult;
	}
	
	/**
	 * 删除购物车某件商品
	 */
	@Override
	public Cart delCart(Cart cart, String pid) {
		Map<String, CartItem> cartItems = cart.getCartItems();
		if(cartItems.containsKey(pid)){
			double subTotal = cartItems.get(pid).getSubtotal();
			double oldTotal = cart.getTotal();
			double newTotal = oldTotal - subTotal;
			cart.setTotal(newTotal);
			cartItems.remove(pid);
			cart.setCartItems(cartItems);
		}
		return cart;
	}
}

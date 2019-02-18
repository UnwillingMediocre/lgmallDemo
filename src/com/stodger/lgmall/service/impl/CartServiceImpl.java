package com.stodger.lgmall.service.impl;

import java.util.Map;

import com.stodger.lgmall.domain.Cart;
import com.stodger.lgmall.domain.CartItem;
import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.CartService;

public class CartServiceImpl implements CartService {
	
	/**
	 * ���ﳵ�����Ʒ
	 */
	@Override
	public Cart addCartProduct(Cart cart, CartItem cartItem, Product product) {
		Map<String, CartItem> cartItems = cart.getCartItems();
		String pid = product.getPid();
		double newSubtotal = cartItem.getBuyNum() * product.getP_price();
		//�жϹ��ﳵ�Ƿ��Ѿ����ڸ���Ʒ
		if(cartItems.containsKey(pid)){
			//ȡ�ϴι�������
			int oldBuyNum = cartItems.get(pid).getBuyNum();
			//ȡ�¹�������
			int newBuyNum = cartItem.getBuyNum();
			//ȡ�ϴ�С��
			double oldSubtotal = cartItems.get(pid).getSubtotal();
			//����С��
			cartItems.get(pid).setSubtotal(newSubtotal + oldSubtotal);
			//���¹�������
			cartItems.get(pid).setBuyNum(newBuyNum + oldBuyNum);
			//������Ʒ��Ϣ
			cart.setCartItems(cartItems);
		}else{
			cart.getCartItems().put(pid, cartItem);
		}
		//�����ܼ�
		cart.setTotal(cart.getTotal() + newSubtotal);
		return cart;
	}
	
	/**
	 * У�鹺������
	 */
	@Override
	public LGResult checkByNum(Product product, String byNum) {
		LGResult lgResult = new LGResult();
		int num = product.getP_num();
		int limitNum = product.getP_limitNum();
		
		//��֤��������
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
	 * ɾ�����ﳵĳ����Ʒ
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

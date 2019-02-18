package com.stodger.lgmall.service;

import com.stodger.lgmall.domain.Cart;
import com.stodger.lgmall.domain.CartItem;
import com.stodger.lgmall.domain.LGResult;
import com.stodger.lgmall.domain.Product;

public interface CartService {
	Cart addCartProduct(Cart cart, CartItem cartItem, Product product);
	LGResult checkByNum(Product product, String byNum);
	Cart delCart(Cart cart, String pid);
}

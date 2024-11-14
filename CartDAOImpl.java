package com.FoodApp.DAOImpl;

import java.util.HashMap;
import java.util.Map;

import com.FoodApp.UserModel.CartItem;

public class CartDAOImpl {
	private Map<Integer, CartItem> items;

	public CartDAOImpl() {
		this.items=new HashMap<>();

	}
	public Map<Integer,CartItem> addItem(CartItem item) {
		int itemId=item.getItemId();
		if(items.containsKey(itemId)) {

			CartItem existingItem=items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
		}
		else {
			items.put(itemId,item);
		}
		return items;
	}

	public void updateItem(int itemId, int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity<=0) {
				items.remove(itemId);
			}
			else {
				items.get(itemId).setQuantity(quantity);
			}
		}
	}

	public void removeItem(int itemId) {
		items.remove(itemId);
	}

	public  Map<Integer, CartItem> getItems(){
		return items;
	}

	public void clear() {
		items.clear();
	}
}

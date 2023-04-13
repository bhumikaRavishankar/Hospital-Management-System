package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Items;

public interface ItemsDao {
	
	public Items saveItems(int mId, Items item);
	public boolean deleteItem(int iId);
	public Items getItemById(int iId);
	public Items updateItemById(int iId, Items item);
	public List<Items> getAllItems();
	
}

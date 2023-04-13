package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.ItemsDaoImp;
import com.ty.hospital_app.dto.Items;

public class ItemsService {
	
	public void saveItems(int mId, Items item) 
	{
		ItemsDaoImp itemsdaoimp = new ItemsDaoImp();
		Items item2 = itemsdaoimp.saveItems(mId, item);
		if(item2 != null)
		{
			System.out.println("Item saved");
		}
		else {
			System.out.println("Unfortunately item not saved");
		}
	}
	public Items getItemId(int iId)
	{
		ItemsDaoImp itemdaoimp = new ItemsDaoImp();
		Items item = itemdaoimp.getItemById(iId);
		if(item!=null)
		{
			return item;
		}
		else {
			return null;
		}
	}
	public void deleteItemId(int iId)
	{
		ItemsDaoImp daoimp = new ItemsDaoImp();
		Items item = daoimp.getItemById(iId);
		boolean flag = daoimp.deleteItem(iId);
		if(flag)
		{
			System.out.println("Item deleted");
		}
		else {
			System.out.println("Item not found");
		}
	}
	public Items updateItem(int iId, Items item)
	{
		ItemsDaoImp daoimp = new ItemsDaoImp();
		Items item1 = daoimp.updateItemById(iId, item);
		if(item1!= null)
		{
			return item1;
		}
		else {
			return null;
		}
	}
	
}





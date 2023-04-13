package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.BranchDaoImp;
import com.ty.hospital_app.dto.Branch;

public class BranchService 
{
	public void saveBranch(int hid, Branch branch) 
	{
		BranchDaoImp branchdaoimp = new BranchDaoImp();
		Branch branch2 = branchdaoimp.saveBranch(hid, branch);
		if(branch2 != null)
		{
			System.out.println("Branch saved");
		}
		else {
			System.out.println("Unfortunately branch not saved");
		}
	}
	public Branch getBranchId(int bid)
	{
		BranchDaoImp branchdaoimp = new BranchDaoImp();
		Branch branch = branchdaoimp.getBranchById(bid);
		if(branch!=null)
		{
			return branch;
		}
		else {
			return null;
		}
	}
	public void deleteBranchId(int bid)
	{
		BranchDaoImp daoimp = new BranchDaoImp();
		Branch branch = daoimp.getBranchById(bid);
		boolean flag = daoimp.deleteBranch(bid);
		if(flag)
		{
			System.out.println("Branch deleted");
		}
		else {
			System.out.println("Branch not found");
		}
	}
	public Branch updateBranch(int bid, Branch branch)
	{
		BranchDaoImp daoimp = new BranchDaoImp();
		Branch branch1 = daoimp.updateBranchById(bid, branch);
		if(branch1 != null)
		{
			return branch1;
		}
		else {
			return null;
		}
	}
	
}



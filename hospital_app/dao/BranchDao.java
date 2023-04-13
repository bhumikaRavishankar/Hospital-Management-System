package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Branch;

public interface BranchDao {
	
	public Branch saveBranch(int hId, Branch branch);
	public boolean deleteBranch(int bId);
	public Branch getBranchById(int bId);
	public Branch updateBranchById(int bId, Branch branch);
	public List<Branch> getAllBranch();
	
}

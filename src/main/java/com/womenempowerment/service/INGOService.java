package com.womenempowerment.service;

import java.util.List;

import com.womenempowerment.exception.NGOCreationException;
import com.womenempowerment.exception.NGONotFoundException;
import com.womenempowerment.model.NGO;

/**
 * 
 * Service interface for NGO
 * 
 *
 */
public interface INGOService {
	public NGO addNGO(NGO ngo) throws NGOCreationException;

	public NGO updateNGO(NGO ngo) throws NGONotFoundException;

	public NGO viewNGO(int ngoId) throws NGONotFoundException;

	public List<NGO> viewAllNGO() throws NGONotFoundException;

	public void deleteNGO(int ngoId) throws NGONotFoundException;

	public List<NGO> viewNGOByMotive(String motive) throws NGONotFoundException;

	public List<NGO> viewNGOByLocation(String location) throws NGONotFoundException;
}

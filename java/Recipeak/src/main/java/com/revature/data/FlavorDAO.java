package com.revature.data;

import com.revature.beans.Flavor;

public interface FlavorDAO {
	public Flavor addFlavor(Flavor flavor);
	public Flavor getFlavorById(int id);
	public Flavor updateFlavor(Flavor flavor);
	public void deleteFlavor(Flavor flavor);
	public int getIdFromName(String name);
}

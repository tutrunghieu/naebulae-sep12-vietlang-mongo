package org.naebulae.mc2.vector;

import java.util.ArrayList;
import java.util.List;

public class McVectorGenerator extends Sampler1970
{
	protected List<CategoricalDist> vocab = new ArrayList<CategoricalDist>();
	
	public void add(CategoricalDist v) 
	{
		vocab.add(v);
	}
	
	public int nextVectorLen()
	{
		return vocab.size();
	}
	
	public CategoricalDist nextCategoricalDist(int k) 
	{
		return vocab.get(k);
	}	

	public<T> McString<T> nextVectorUniform(Class<T> cl) 
	throws Exception
	{
		McString<T> res = new McString<T>();
		
		for(int n=nextVectorLen(), k=0; k<n; k++)
		{
			CategoricalDist pk = nextCategoricalDist(k);
			T wk = cl.cast( pk.nextCategory() );
			res.add(wk);
		}
		
		return res;
	}



}

package com.it.controller;

import java.util.Comparator;

import com.it.repository.signup.Mysqlentity;

class Ausernamesorting implements Comparator<Mysqlentity>{

	@Override
	public int compare(Mysqlentity o1, Mysqlentity o2) {
		// TODO Auto-generated method stub
		int au=o1.getUsername().compareTo(o2.getUsername());
		return au;
		}
}
class Dusernamesorting implements Comparator<Mysqlentity>{

	@Override
	public int compare(Mysqlentity o1, Mysqlentity o2) {
		// TODO Auto-generated method stub
		int du=o2.getUsername().compareTo(o1.getUsername());
		return du;
	}
	
}
class Dfirsnamesorting implements Comparator<Mysqlentity>{

	@Override
	public int compare(Mysqlentity o1, Mysqlentity o2) {
		// TODO Auto-generated method stub
		int dfn=o2.getUsername().compareTo(o1.getUsername());
		return dfn;
	}
	
}
class Afirsnamesorting implements Comparator<Mysqlentity>{

		@Override
		public int compare(Mysqlentity o1, Mysqlentity o2) {
			// TODO Auto-generated method stub
			int afn=o1.getUsername().compareTo(o2.getUsername());
			return afn;
		}
	
	
}
	




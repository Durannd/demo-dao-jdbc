package application;

import java.sql.Connection;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Department department = new Department(2,null);
		Seller newSeller = sellerDao.findById(11);
		newSeller.setName("Ricael Sim");
		sellerDao.update(newSeller);
		
	}

}

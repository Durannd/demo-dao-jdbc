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
		Seller newSeller = new Seller(null, "Rigael", "Rigael@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id: "+newSeller.getId());
	}

}

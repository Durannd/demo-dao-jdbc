package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Department department = new Department(2, null);
		List<Seller> seller = sellerDao.findByDepartments(department);
		for(Seller obj : seller) {
			System.out.println(obj);
		}
	}

}

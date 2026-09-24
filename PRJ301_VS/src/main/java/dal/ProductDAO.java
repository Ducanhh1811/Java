/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import java.sql.Date;

public class ProductDAO extends DBContext {

    public Vector<Product> getAllProduct(String sql) {
        Vector<Product> vector = new Vector<>();
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ResultSet rs = ptm.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt("productID"),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9));
                vector.add(p);

            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return vector;
    }

    public Product searchProduct(int productId) {
        String sql = "Select * From tblProducts\n"
                + "Where productID = ?";
        try {
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setInt(1, productId);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9));
                return p;
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return null;
    }

    public int insertProduct(Product p){
        String sql = "INSERT INTO [dbol. [tbIProducts]"
                + "             [productName]"
                + "             , [image] "
                + "             , [price]"
                + "             , [quantity] "
                + "             , [categoryID] "
                + "             , [importDate] "
                + "             , [usingDate] "
                + "             , [status] "
                + "VALUES (?, ?,?,?,?,?,?,?)";
        int n = 0;
        try{
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, p.getProductName());
            ptm.setString(2, p.getImage());
            ptm.setDouble(3, p.getPrice());
            ptm.setInt(4, p.getQuantity());
            ptm.setString(5, p.getCategoryID());
            ptm.setDate(6, p.getImportDate());
            ptm.setDate(7, p.getUsingDate());
            ptm.setInt(8, p.getStatus());
            n = ptm.executeUpdate();
        }catch(SQLException ex){
            ex.getStackTrace();
        }
        return n;
    }

    public int updateProduct(Product p){
        String sql = "UPDATE [dbo].[tblProducts]\n" +
                    "   SET [productName] = ?\n" +
                    "      ,[image] = ?\n" +
                    "      ,[price] = ?\n" +
                    "      ,[quantity] = ?\n" +
                    "      ,[categoryID] = ?\n" +
                    "      ,[importDate] = ?\n" +
                    "      ,[usingDate] = ?\n" +
                    "      ,[status] = ?\n" +
                    " WHERE productID = ?";
        int n = 0;
        try{
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setString(1, p.getProductName());
            ptm.setString(2, p.getImage());
            ptm.setDouble(3, p.getPrice());
            ptm.setInt(4, p.getQuantity());
            ptm.setString(5, p.getCategoryID());
            ptm.setDate(6, p.getImportDate());
            ptm.setDate(7, p.getUsingDate());
            ptm.setInt(8, p.getStatus());
            ptm.setInt(9, p.getProductID());
            n = ptm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return n;
    }

    public void chageStatus(int productID, int newStatus){
        String sql = "update tblProducts\n" +
                    "set status = ?\n" +
                    "where productID = ?";
        try{
            PreparedStatement ptm = connection.prepareStatement(sql);
            ptm.setInt(1, newStatus);
            ptm.setInt(2, productID);
            ptm.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public int deteleProduct(int productID){
        String sql1 = "DELETE FROM [dbo].[tblProducts]\n" +
                        "      WHERE productID = ?";
        // Kiem tra xem product da tung duoc ban chua
        // Case 1: Neu da ban: chuyen status = 0
        // Case 2: Neu ch ban: xoa khoi table Product
        String sql2 = "select * from tblOrderDetails\n" +
                        "where productID = ?";
        int n = 0;
        try{
            PreparedStatement ptm2 = connection.prepareStatement(sql2);
            ptm2.setInt(1, productID);
            ResultSet rs = ptm2.executeQuery();
            if(rs.next()){
                // Case 1: Change status
                chageStatus(productID, 0);
            }else{
                // Case 2: Delete
                PreparedStatement ptm1 = connection.prepareStatement(sql1);
                ptm1.setInt(1, productID);
                n = ptm1.executeUpdate();
                
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return n;
    }
    
    


    
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        String sql = "select * From tblProducts";
        Vector<Product> vector = dao.getAllProduct(sql);
        for (Product p : vector) {
            System.out.println(p);
        }
        Product pSearch = dao.searchProduct(3);
        if(pSearch == null){
            System.out.println("Not found!");
        }else{
            System.out.println("Product you have found: ");
            System.out.println(pSearch);
        }
//        
//        Product p = new Product("Iphone 18 plus", "c:prj301", 1000, 5, "C001", 
//                    new Date(2026 - 1900, 7, 13), 
//                    new Date(2027 - 1900, 7, 13), 1);
//        int n = dao.insertProduct(p);
//        System.out.println("Inserted: " + n);
//        
//        pSearch.setProductName("Ao khoac new update");
//        int n1 = dao.updateProduct(pSearch);
        
        dao.deteleProduct(2);
    }
    
    
    // Insert all cate, order, product, users,.....
    // getAll all cate, order, product, users,.....
    
}

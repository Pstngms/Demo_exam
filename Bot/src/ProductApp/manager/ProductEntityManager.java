package ProductApp.manager;

import ProductApp.App;
import ProductApp.entity.ProductEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductEntityManager {
    public static void insert(ProductEntity product) throws SQLException {
        try(Connection c = App.getConnection())
        {
            String sql= "INSERT INTO product (Title,ProductType,ArticleNumber,Description,Image,ProductionPersonCount,ProductionWorkshopNumber,MinCostForAgent)VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getTitle());
            ps.setString(2, product.getProductType());
            ps.setInt(3,product.getArticleNumber());
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getImage());
            ps.setInt(6,product.getProductionPersonCount());
            ps.setInt(7,product.getProductionWorkshopNumber());
            ps.setInt(8,product.getMinCostForAgent());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()){
                product.setId(keys.getInt(1));
                return;
            }
        }
        throw new SQLException("Не далось добавить");
    }
    public static List<ProductEntity> selectAll() throws SQLException {
        try(Connection c = App.getConnection())
        {
           String sql = "SELECT * FROM product";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);
            List<ProductEntity> list = new ArrayList<>();

            while (resultSet.next()){
                list.add(new ProductEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getString("ProductType"),
                        resultSet.getInt("ArticleNumber"),
                        resultSet.getString("Description"),
                        resultSet.getString("Image"),
                        resultSet.getInt("ProductionPersonCount"),
                        resultSet.getInt("ProductionWorkshopNumber"),
                        resultSet.getInt("MinCostForAgent")
                ));
            }
            return list;
        }
    }
    public static void update(ProductEntity product) throws SQLException {
        try(Connection c = App.getConnection())
        {
            String sql= "UPDATE product SET Title=?,ProductType=?,ArticleNumber=?,Description=?,Image=?,ProductionPersonCount=?,ProductionWorkshopNumber=?,MinCostForAgent=? WHERE ID=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setString(2, product.getProductType());
            ps.setInt(3,product.getArticleNumber());
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getImage());
            ps.setInt(6,product.getProductionPersonCount());
            ps.setInt(7,product.getProductionWorkshopNumber());
            ps.setInt(8,product.getMinCostForAgent());
            ps.setInt(9,product.getId());
            ps.executeUpdate();

        }

    }
    public static ProductEntity selectBtId(int id) throws SQLException {
        try(Connection c = App.getConnection())
        {
            String sql = "SELECT * FROM product WHERE ID=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1,id);
           ResultSet resultSet = s.executeQuery();

            if (resultSet.next()){
                return new ProductEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getString("ProductType"),
                        resultSet.getInt("ArticleNumber"),
                        resultSet.getString("Description"),
                        resultSet.getString("Image"),
                        resultSet.getInt("ProductionPersonCount"),
                        resultSet.getInt("ProductionWorkshopNumber"),
                        resultSet.getInt("MinCostForAgent")
                );
            }
            return null;
        }
    }
    public static void delete (int id) throws SQLException {
        try(Connection c = App.getConnection())
        {
            String sql = "DELETE FROM product WHERE ID=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setInt(1,id);
            s.executeUpdate();
        }
    }


}

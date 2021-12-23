package ServiceApp.manager;

import ServiceApp.App;
import ServiceApp.entity.ServiceEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceEntityManager {
    public static void insert(ServiceEntity service) throws SQLException {
        try(Connection c = App.getConnection())
        {
            String sql = "INSERT INTO service (Title,Cost,DurationInSeconds,Discount,MainImagePath) VALUES (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, service.getTitle());
            ps.setDouble(2,service.getCost());
            ps.setInt(3,service.getDuration());
            ps.setDouble(4,service.getDiscount());
            ps.setString(5, service.getImagePath());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next())
            {
                service.setId(keys.getInt(1));
                return;
            }
        }
        throw new SQLException("sss");
    }
    public static void update(ServiceEntity service) throws SQLException {
        try(Connection c = App.getConnection())
        {
            String sql = "UPDATE service SET Title=?,Cost=?,DurationInSeconds=?,Discount=?,MainImagePath=? WHERE ID=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, service.getTitle());
            ps.setDouble(2,service.getCost());
            ps.setInt(3,service.getDuration());
            ps.setDouble(4,service.getDiscount());
            ps.setString(5, service.getImagePath());
            ps.executeUpdate();

        }

    }
    public static void delete(int id) throws SQLException {
        try (Connection c = App.getConnection()) {
            String sql = "DELETE FROM service WHERE ID=?";
            PreparedStatement ps = c.prepareStatement(sql);
           ps.setInt(1,id);
            ps.executeUpdate();

        }
    }
    public static List<ServiceEntity> selectAll() throws SQLException {
        try (Connection c = App.getConnection()) {
            String sql = "SELECT * FROM service";
            Statement s= c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);
            List<ServiceEntity> list = new ArrayList<>();
            while (resultSet.next()){
                 list.add( new ServiceEntity(
                    resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getDouble("Cost"),
                        resultSet.getInt("DurationInSeconds"),
                        resultSet.getDouble("Discount"),
                        resultSet.getString("MainImagePath")
                 ));

            }
            return list;
        }

    }

}

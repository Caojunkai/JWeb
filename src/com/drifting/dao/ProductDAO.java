package com.drifting.dao;

import com.drifting.entity.Items;
import com.drifting.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public ArrayList<Items> getItems(String name ,int id ,String order){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        ArrayList<Items> items = new ArrayList<>();
        try{
            conn = DBHelper.getConnection();
            StringBuilder sql = new StringBuilder("SELECT * FROM `any_product`");
            sql.append(" WHERE 1 = 1 ");
            if (!"".equals(name)){
                sql.append(" AND `name` LIKE " + " '%" + name + "%' ");
            }
            if (id != 0){
                sql.append("AND `id` = " + id );
            }
            if ("".equals(order)){
                sql.append(" ORDER BY `price` ");
            }else {
                sql.append(" ORDER BY " + order);
            }
            stmt = conn.prepareStatement(sql.toString());
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Items item = new Items();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setOldPrice(resultSet.getDouble("oprice"));
                item.setProducer(resultSet.getString("producer"));
                item.setProductPlace(resultSet.getString("product_place"));
                item.setNum(resultSet.getInt("num"));
                item.setImgUrl(resultSet.getString("img"));
                item.setSn(resultSet.getString("sn"));
                item.setcTime(resultSet.getDate("ctime"));
                item.setuTime(resultSet.getDate("utime"));
                item.setcUid(resultSet.getInt("cuid"));
                item.setuUid(resultSet.getInt("uuid"));
                item.setDesc(resultSet.getString("desc"));
                item.setKeyWords(resultSet.getString("keywords"));
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                    resultSet = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) try {
                stmt.close();
                stmt = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return items;
    }

}

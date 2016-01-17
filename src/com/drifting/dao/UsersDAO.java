package com.drifting.dao;

import com.drifting.entity.Users;
import com.drifting.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDAO {
    public ArrayList<Users> getUsers(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        ArrayList<Users> list = new ArrayList<>();
        try {
            conn = DBHelper.getConnection();
            String sql = "SELECT * FROM any_user ORDER BY `id`";
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
            while (result.next()){
                Users user = new Users();
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
                user.setCtime(result.getDate("ctime"));
                user.setEmail(result.getString("email"));
                user.setSex(result.getInt("sex"));
                user.setFace(result.getString("face"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (result != null){
                try {
                    result.close();
                    result = null;
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
        return list;
    }
}

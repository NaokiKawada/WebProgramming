package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserInfo;

public class UserInfoDao {

    public UserInfo findbylogin(String loginId, String password) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "select * from userinfo where login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            if (!rs.next()) {
                return null;
            }
            String nameData = rs.getString("name");
            String loginIdData = rs.getString("login_id");
            String passwordData = rs.getString("password");
            return new UserInfo(nameData,loginIdData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

    public List<UserInfo> findAll() {
        Connection conn = null;
        List<UserInfo> userList = new ArrayList<UserInfo>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();


            // SELECT文を準備
            String sql = "select * from userinfo";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

			// Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                String loginIdData = rs.getString("login_id");
                String nameDATA = rs.getString("name");
                String birthdayDATA = rs.getString("birth_date");
                UserInfo userinfo = new UserInfo(loginIdData, nameDATA,birthdayDATA);
                userList.add(userinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

    public UserInfo findbylogin(String loginId) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "select * from userinfo where login_id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);


            ResultSet rs = pStmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            if (!rs.next()) {
                return null;
            }
            String loginIdData = rs.getString("login_id");
            String NameData = rs.getString("name");
            String BirthdayData = rs.getString("birth_date");
            String PasswordData = rs.getString("password");
            String CreatedateData = rs.getString("create_date");
            String UpdatedateData = rs.getString("update_date");

            return new UserInfo(loginIdData,NameData,BirthdayData,PasswordData,CreatedateData,UpdatedateData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }


}

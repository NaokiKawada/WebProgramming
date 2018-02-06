package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.SearchConditionBeans;
import beans.UserInfo;
public class UserDao extends DaoUtil{

	/**
	 * Userテーブルに登録された全てのデータを取得する(登録順)
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserInfo> findAll() throws SQLException {
		Connection con = DBManager.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM user order by id DESC");
		ResultSet rs = st.executeQuery();

		ArrayList<UserInfo> userList = new ArrayList<UserInfo>();

		while (rs.next()) {
			UserInfo user = new UserInfo();
			user.setLoginid(rs.getString("login_id"));
			user.setName(rs.getString("name"));
			user.setBirthday(rs.getString("birth_date"));
			user.setPassword(rs.getString("password"));


			userList.add(user);
		}

		return userList;
	}

	/**
	 * ユーザを検索する(引数に渡された値が空でないもののみ検索する)
	 * @param loginId
	 * @param userName
	 * @param birthdayFrom
	 * @param birthdayTo
	 * @return
	 * @throws SQLException
	 */
	public List<UserInfo> searchUser(String loginId, String userName, String birthdayFrom, String birthdayTo) throws SQLException {
		Connection con = DBManager.getConnection();

		String sql = "SELECT * FROM userinfo";

		// 各種検索要件を設定してSQLを生成
		List<SearchConditionBeans> conditions = new ArrayList<SearchConditionBeans>();
		conditions.add(new SearchConditionBeans("login_id", loginId, WHERE_TYPE_EQUAL));
		conditions.add(new SearchConditionBeans("name", userName, WHERE_TYPE_LIKE_PARTIAL_MATCH));
		conditions.add(new SearchConditionBeans("birth_date", birthdayFrom, WHERE_TYPE_GENDER_OR_EQUAL));
		conditions.add(new SearchConditionBeans("birth_date", birthdayTo, WHERE_TYPE_LESS_OR_EQUAL));
		sql = addWhereCondition(sql, conditions);

		// IDの降順に表示
		sql += " order by id desc";

		// TODO デバッグ用(納品時に消す)
		System.out.println(sql);

		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();


		ArrayList<UserInfo> userList = new ArrayList<UserInfo>();

		while (rs.next()) {
			UserInfo user = new UserInfo();
			user.setLoginid(rs.getString("login_id"));
			user.setName(rs.getString("name"));
			user.setBirthday(rs.getString("birth_date"));
			user.setPassword(rs.getString("password"));

			userList.add(user);
		}

		return userList;

	}


}
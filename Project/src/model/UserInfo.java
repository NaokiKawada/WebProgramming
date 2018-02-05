package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class UserInfo implements Serializable {
    private String loginid;
    private String password;
    private String name;
    private String birthday;
    private String createdate;
    private String updatedate;




    public UserInfo(String loginid) {
    	this.loginid = loginid;
    }

    public UserInfo(String name,String loginid) {
        this.name = name;
    	this.loginid = loginid;
    }


	public UserInfo(String loginid, String name, String birthday) {
		this.loginid = loginid;
		this.name = name;
		this.birthday = birthday;
	}

	public UserInfo(String loginid, String password, String name,String birthday) {
		this.loginid = loginid;
		this.name = password;
		this.birthday = name;
		this.birthday = birthday;
	}

	public UserInfo (String loginId,String name, String birthday , String password , String createdate , String updatedate) {
		this.loginid = loginId;
		this.name = name;
		this.birthday = birthday;
		this.password = password;
		this.createdate= createdate;
		this.updatedate = updatedate;
	}


	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public SimpleDateFormat getBirthdayFormat() {
		SimpleDateFormat birthday = new SimpleDateFormat("yyyy年MM月dd日");
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

}


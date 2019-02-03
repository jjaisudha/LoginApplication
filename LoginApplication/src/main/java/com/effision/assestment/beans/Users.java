package com.effision.assestment.beans;

public class Users {
private String userName;
private String password;
public Users() {
    super();
}

public Users(String uname, String pwd) {
    this.userName = uname;
    this.password = pwd;
}
/**
 * @return the userName
 */
public String getUserName() {
	return userName;
}
/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
	this.userName = userName;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}

/**
 * @return the password
 */
public String getdecryptedPassword() {
	return decrypt(password);
}
public String getencryptedPassword() {
	return encrypt(password);
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = encrypt(password);
}
public static String encrypt(String str){
    int code;
    String result = "";
    for (int i = 0; i < str.length(); i++) {
      code = Math.round((float) Math.random()*8+1);
      result += code + Integer.toHexString( ((int) str.charAt(i) ) ^ code )+"-";
    }
    return result.substring(0, result.lastIndexOf("-"));
  }

  public static String decrypt(String str){
    str = str.replace("-", "");
    String result = "";
    for (int i = 0; i < str.length(); i+=3) {
      String hex =  str.substring(i+1, i+3);
      result += (char) (Integer.parseInt(hex, 16) ^ (Integer.parseInt(String.valueOf(str.charAt(i)))));
    }
    return result;
  }
}

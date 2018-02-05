package common;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Utill {

	/**
	 * 渡したパスワードを暗号化して返す
	 * @param password
	 * @return
	 */
	public static String passwordMD5(String password) {
		String result = "";
		try {
			//ハッシュ生成前にバイト配列に置き換える際のCharset
			Charset charset = StandardCharsets.UTF_8;
			//ハッシュアルゴリズム
			String algorithm = "MD5";

			//ハッシュ生成処理
			byte[] bytes;

				bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));

			result = DatatypeConverter.printHexBinary(bytes);
			//標準出力
			;
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return result;
	}

}

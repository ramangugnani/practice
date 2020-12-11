package practice.leetcode.june.week1;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Test {
	public static void main(String[] args) {
		final SecretKeySpec secretKeySpec = new SecretKeySpec(Config.API_SECRET.getBytes("UTF-8"), "HmacSHA1");
		
		final Mac hmac = Mac.getInstance("HmacSHA1");
		hmac.init(secretKeySpec);
		
		hmac.update(query.getBytes("US-ASCII"));

		
		final String HMAC_SHA512 = "HmacSHA512";
		final String CHARSET = "ISO-8859-1";
		final String HMAC_KEY = "0123456789ABCDEF0123456789ABCDEF0123456789ABCDEF01...";

		String hmacFootprint = null;
		Mac mac = Mac.getInstance(HMAC_SHA512);
		mac.init(new SecretKeySpec(DatatypeConverter.parseHexBinary(HMAC_KEY), mac.getAlgorithm()));
		final byte[] macData = mac.doFinal(requestParameters.toString().getBytes());
		byte[] hex = new Hex().encode(macData);
		hmacFootprint = new String(hex, CHARSET).toUpperCase();
		
		
	}
}

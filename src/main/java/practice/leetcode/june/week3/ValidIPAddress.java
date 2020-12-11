package practice.leetcode.june.week3;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

public class ValidIPAddress {

	public static void main(String[] args) {
		String ip = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
		System.out.println(validIPAddress1(ip));
	}

	public String validateIPv4(String IP) {
		String[] nums = IP.split("\\.", -1);
		for (String x : nums) {
			// Validate integer in range (0, 255):
			// 1. length of chunk is between 1 and 3
			if (x.length() == 0 || x.length() > 3)
				return "Neither";
			// 2. no extra leading zeros
			if (x.charAt(0) == '0' && x.length() != 1)
				return "Neither";
			// 3. only digits are allowed
			for (char ch : x.toCharArray()) {
				if (!Character.isDigit(ch))
					return "Neither";
			}
			// 4. less than 255
			if (Integer.parseInt(x) > 255)
				return "Neither";
		}
		return "IPv4";
	}

	public String validateIPv6(String IP) {
		String[] nums = IP.split(":", -1);
		String hexdigits = "0123456789abcdefABCDEF";
		for (String x : nums) {
			// Validate hexadecimal in range (0, 2**16):
			// 1. at least one and not more than 4 hexdigits in one chunk
			if (x.length() == 0 || x.length() > 4)
				return "Neither";
			// 2. only hexdigits are allowed: 0-9, a-f, A-F
			for (Character ch : x.toCharArray()) {
				if (hexdigits.indexOf(ch) == -1)
					return "Neither";
			}
		}
		return "IPv6";
	}

	public String validIPAddress3(String IP) {
		if (IP.chars().filter(ch -> ch == '.').count() == 3) {
			return validateIPv4(IP);
		} else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
			return validateIPv6(IP);
		} else
			return "Neither";
	}

	public static String validIPAddress2(String IP) {
		String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
		Pattern pattenIPv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

		String chunkIPv6 = "([0-9a-fA-F]{1,4})";
		Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");
		if (pattenIPv4.matcher(IP).matches())
			return "IPv4";
		return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
	}

	public static String validIPAddress1(String IP) {
		try {
			return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
		} catch (Exception e) {

		}
		return "Neither";
	}

	public static String validIPAddress(String IP) {
		String ipv4 = "IPv4";
		String ipv6 = "IPv6";
		String neither = "Neither";
		if (IP.contains(".")) {
			System.out.println("ipv4-1 " + IP);
			String[] splits = IP.split("\\.");
			System.out.println(splits.length);
			if (null == splits || splits.length != 4) {
				return neither;
			} else {
				for (String split : splits) {
					Integer num = null;
					try {
						num = Integer.valueOf(split);
					} catch (Exception e) {

					}
					if (split.startsWith("0") || null == num || num < 1 || num > 255) {
						return neither;
					}
				}
				return ipv4;
			}
		} else if (IP.contains(":")) {
			IP = IP.toLowerCase();
			System.out.println("ipv6-1 " + IP);
			String[] splits = IP.split(":");
			if (IP.endsWith(":")) {
				return neither;
			}
			System.out.println(splits.length);
			if (null == splits || splits.length != 8) {
				return neither;
			} else {
				for (String split : splits) {
					Integer num = null;
					try {
						num = Integer.parseInt(split, 16);
						// System.out.println(split +" --> " + num);
					} catch (Exception e) {
						// System.out.println(e);
					}
					if (null == num) {
						return neither;
					}
				}
				return ipv6;
			}
		} else {
			return neither;
		}
	}
}

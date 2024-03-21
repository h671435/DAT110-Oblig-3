package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		// we use MD5 with 128 bits digest
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // compute the hash of the input 'entity'
		md.update(entity.getBytes());
		byte[] digest = md.digest();

		// convert the hash into hex format
		String hexString = toHex(digest);

		// convert the hex into BigInteger
		BigInteger hex = new BigInteger(hexString, 16);

		// return the BigInteger
		return hex;
	}

	public static BigInteger addressSize() {
		// compute the number of bits = bitSize()
		int numBits = bitSize();

		// compute the address size = 2 ^ number of bits
		BigInteger addressSize = BigInteger.valueOf(2).pow(numBits);

		// return the address size
		return addressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 16;
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}

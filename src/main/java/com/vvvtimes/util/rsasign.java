package com.vvvtimes.util;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;


public class rsasign {
    static String header = "<!-- 537606aed546c5ba42c0820ad7fd0d74ee7caf90c232a484d0464b3332c42a9189555aebdba3570fe6566842ba7b7bb88da360f202ae9536a2a12fcdf39600c7 --><ObtainTicketResponse><message></message><prolongationPeriod>607875500</prolongationPeriod><responseCode>OK</responseCode><salt>1508484258274</salt><ticketId>1</ticketId><ticketProperties>licensee=Administrator    licenseType=0   </ticketProperties></ObtainTicketResponse>";
    static String content = "<ObtainTicketResponse><message></message><prolongationPeriod>607875500</prolongationPeriod><responseCode>OK</responseCode><salt>1508484258274</salt><ticketId>1</ticketId><ticketProperties>licensee=Administrator    licenseType=0   </ticketProperties></ObtainTicketResponse>";
    String ASNKEY = "-----BEGIN RSA PRIVATE KEY-----\r\n"
            + "MIIBOgIBAAJBALecq3BwAI4YJZwhJ+snnDFj3lF3DMqNPorV6y5ZKXCiCMqj8OeOmxk4YZW9aaV9\r\n"
            + "ckl/zlAOI0mpB3pDT+Xlj2sCAwEAAQJAW6/aVD05qbsZHMvZuS2Aa5FpNNj0BDlf38hOtkhDzz/h\r\n"
            + "kYb+EBYLLvldhgsD0OvRNy8yhz7EjaUqLCB0juIN4QIhAOeCQp+NXxfBmfdG/S+XbRUAdv8iHBl+\r\n"
            + "F6O2wr5fA2jzAiEAywlDfGIl6acnakPrmJE0IL8qvuO3FtsHBrpkUuOnXakCIQCqdr+XvADI/UTh\r\n"
            + "TuQepuErFayJMBSAsNe3NFsw0cUxAQIgGA5n7ZPfdBi3BdM4VeJWb87WrLlkVxPqeDSbcGrCyMkC\r\n"
            + "IFSs5JyXvFTreWt7IQjDssrKDRIPmALdNjvfETwlNJyY\r\n"
            + "-----END RSA PRIVATE KEY-----";
    String PCKS8KEY = "-----BEGIN PRIVATE KEY-----\r\n"
            + "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAt5yrcHAAjhglnCEn\r\n"
            + "6yecMWPeUXcMyo0+itXrLlkpcKIIyqPw546bGThhlb1ppX1ySX/OUA4jSakHekNP\r\n"
            + "5eWPawIDAQABAkBbr9pUPTmpuxkcy9m5LYBrkWk02PQEOV/fyE62SEPPP+GRhv4Q\r\n"
            + "Fgsu+V2GCwPQ69E3LzKHPsSNpSosIHSO4g3hAiEA54JCn41fF8GZ90b9L5dtFQB2\r\n"
            + "/yIcGX4Xo7bCvl8DaPMCIQDLCUN8YiXppydqQ+uYkTQgvyq+47cW2wcGumRS46dd\r\n"
            + "qQIhAKp2v5e8AMj9ROFO5B6m4SsVrIkwFICw17c0WzDRxTEBAiAYDmftk990GLcF\r\n"
            + "0zhV4lZvztasuWRXE+p4NJtwasLIyQIgVKzknJe8VOt5a3shCMOyysoNEg+YAt02\r\n"
            + "O98RPCU0nJg=\r\n" + "-----END PRIVATE KEY-----";

    static String key22 = "MIIBOgIBAAJBALecq3BwAI4YJZwhJ+snnDFj3lF3DMqNPorV6y5ZKXCiCMqj8OeOmxk4YZW9aaV9"
            + "ckl/zlAOI0mpB3pDT+Xlj2sCAwEAAQJAW6/aVD05qbsZHMvZuS2Aa5FpNNj0BDlf38hOtkhDzz/h"
            + "kYb+EBYLLvldhgsD0OvRNy8yhz7EjaUqLCB0juIN4QIhAOeCQp+NXxfBmfdG/S+XbRUAdv8iHBl+"
            + "F6O2wr5fA2jzAiEAywlDfGIl6acnakPrmJE0IL8qvuO3FtsHBrpkUuOnXakCIQCqdr+XvADI/UTh"
            + "TuQepuErFayJMBSAsNe3NFsw0cUxAQIgGA5n7ZPfdBi3BdM4VeJWb87WrLlkVxPqeDSbcGrCyMkC"
            + "IFSs5JyXvFTreWt7IQjDssrKDRIPmALdNjvfETwlNJyY";

    static String key33 = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAt5yrcHAAjhglnCEn"
            + "6yecMWPeUXcMyo0+itXrLlkpcKIIyqPw546bGThhlb1ppX1ySX/OUA4jSakHekNP"
            + "5eWPawIDAQABAkBbr9pUPTmpuxkcy9m5LYBrkWk02PQEOV/fyE62SEPPP+GRhv4Q"
            + "Fgsu+V2GCwPQ69E3LzKHPsSNpSosIHSO4g3hAiEA54JCn41fF8GZ90b9L5dtFQB2"
            + "/yIcGX4Xo7bCvl8DaPMCIQDLCUN8YiXppydqQ+uYkTQgvyq+47cW2wcGumRS46dd"
            + "qQIhAKp2v5e8AMj9ROFO5B6m4SsVrIkwFICw17c0WzDRxTEBAiAYDmftk990GLcF"
            + "0zhV4lZvztasuWRXE+p4NJtwasLIyQIgVKzknJe8VOt5a3shCMOyysoNEg+YAt02"
            + "O98RPCU0nJg=";
	
	public static String Sign(String content){
	    return rsasign.Sign(content.getBytes(), key22);
	}
	
	public static String Sign2(String content){
        return rsasign.Sign2(content.getBytes(), key33);
    }
	
	//传入秘钥为ASN格式
    //私钥签名程序，privateKey是私钥base64编码字符串，即私钥文件数据中，中间的主体部分
    public static String Sign(byte[] content, String privateKey) {
	try {
		byte[] keybyte = Base64.decode(privateKey.toString());
		ASN1InputStream in = new ASN1InputStream(keybyte);
		ASN1Primitive obj = in.readObject();
		RSAPrivateKeyStructure pStruct = RSAPrivateKeyStructure.getInstance(obj);
		RSAPrivateKeySpec spec = new RSAPrivateKeySpec(pStruct.getModulus(), pStruct.getPrivateExponent());
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey priKey = keyFactory.generatePrivate(spec);
		java.security.Signature signature = java.security.Signature.getInstance("MD5WithRSA");
		signature.initSign(priKey);
		signature.update(content);
		byte[] signed = signature.sign();
		return Hex.bytesToHexString(signed);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	    
    //传入秘钥为PKCS#8私钥非加密格式
	//私钥签名程序，privateKey是私钥base64编码字符串，即私钥文件数据中，中间的主体部分
	public static String Sign2(byte[] content, String privateKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);
			java.security.Signature signature = java.security.Signature.getInstance("MD5WithRSA");
			signature.initSign(priKey);
			signature.update(content);
			byte[] signed = signature.sign();
			return Hex.bytesToHexString(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

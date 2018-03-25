package com.hainiu.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 蒲怀梓
 * URL学习
 *   1.创建一个资源对象（URL对象）
 *   2.打开连接，建立连接
 *   3.通过连接获得流
 */
public class HaiNiuURL {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://tieba.baidu.com/p/2314539885");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		InputStream inputStream = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
//		FileOutputStream fos = new FileOutputStream("D:/spark.html");
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		String line = br.readLine();
		Pattern compile = Pattern.compile("[\\d]{5,12}@qq.com");
		while (line != null) {
			Matcher matcher = compile.matcher(line);
			while (matcher.find()) {
				System.out.println(matcher.group());
			}
			line = br.readLine();
		}
		
		System.out.println("程序结束了");
	}
}

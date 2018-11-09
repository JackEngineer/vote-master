package com.cn.ssm.controller;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by KJA on 2018/3/20.
 */
public class FileUtil {
// c:///excel/xx.xls
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
		File targetFile = new File(filePath);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath+fileName);
		out.write(file);
		out.flush();
		out.close();
	}

}

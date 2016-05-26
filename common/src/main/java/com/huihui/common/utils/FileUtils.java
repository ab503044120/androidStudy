package com.huihui.common.utils;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class FileUtils {
	/***
	 * 获取文件大小
	 * @param filePath
	 * @return long
	 */
	public static long getFileByte(String filePath){
        File f = new File(filePath);   
        try{   
          FileInputStream fis = new FileInputStream(f) ;   
          try   {    
          System.out.println(fis.available());  
          return fis.available();  
          }catch(IOException e1){  //找不到指定路径 
          e1.printStackTrace(); 
          return 0;
          }   
          }catch(FileNotFoundException e2){//找不到文件   
          e2.printStackTrace();   
          return 0;
          }
    }
	
	
	/***
	 * 转换文件大小单位(b/kb/mb/gb)
	 * @param fileS
	 * @return String
	 */
	public static String formatFileSize(long fileS) {// 转换文件大小
	DecimalFormat df = new DecimalFormat("#.00"); 
	String fileSizeString = ""; 
	if (fileS < 1024) { 
	fileSizeString = df.format((double) fileS) + "B"; 
	} else if (fileS < 1048576) { 
	fileSizeString = df.format((double) fileS / 1024) + "K"; 
	} else if (fileS < 1073741824) { 
	fileSizeString = df.format((double) fileS / 1048576) + "M"; 
	} else { 
	fileSizeString = df.format((double) fileS / 1073741824) + "G"; 
	} 
	return fileSizeString; 
	} 
	
	/**
	 * 重命名
	 * @param oldFilePath
	 * @param newFilePath
	 */
	public static void renameFile(String  oldFilePath, String newFilePath){
		File oleFile=new File(oldFilePath);
		File newFile=new File(newFilePath);
	     if (!oleFile.exists()) {
	    	 oleFile.mkdirs();
			}
	     if (!newFile.exists()) {
	    	 newFile.mkdirs();
			}
	    oleFile.renameTo(newFile);  //执行重命名
	}

	/**
	 * 将文件转成base64编码
	 * @param path
	 * @return
	 */
	public static String encodeBase64File(String path){

		String base64Str = "iVBORw0KGgoAAAA";
		File file = new File(path);
		FileInputStream inputFile = null;
		try {
			inputFile = new FileInputStream(file);
			int length = (int) file.length();
			byte[] buffer = new byte[length];
			inputFile.read(buffer);
			inputFile.close();
			base64Str = Base64.encodeToString(buffer, Base64.DEFAULT);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return base64Str;
	}
}

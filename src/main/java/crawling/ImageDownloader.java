package crawling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImageDownloader {
	
	public static String saveImage(String uploadPath, String imgUrl, String fileName) {
		
		String filePath = uploadPath + File.separator + fileName;
		
		try(
			BufferedInputStream bis = new BufferedInputStream(new URL(imgUrl).openStream());
		    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))
		   ) {
			
			byte[] buffer = new byte[2048];
			int length;
			
			while((length = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, length);
			}
			
			System.out.println("이미지 저장 완료: " + filePath);
            return "/resources/news/" + fileName; 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
			System.err.println("이미지 저장 실패: " + e.getMessage());
            return null;
		} catch (IOException e) {
			e.printStackTrace();

			System.err.println("이미지 저장 실패: " + e.getMessage());
            return null;
		}
	}
}

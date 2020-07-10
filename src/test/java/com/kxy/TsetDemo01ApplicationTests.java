package com.kxy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kxy.entity.RegionCar;
import com.kxy.entity.UserInfo;
import com.kxy.mapper.CarMapper;
import com.kxy.mapper.UserMapper;
import com.kxy.utils.RedisUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TsetDemo01ApplicationTests {
	
	@Autowired
    private UserMapper mapper;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private CarMapper carMapper;

	@Test
	public void contextLoads() throws ParseException {
//		UserInfo userinfo = new UserInfo();
//		userinfo.setUid(2);
//		userinfo.setName("kxy");
//		userinfo.setPassword("123");
//		userinfo.setSalt("123");
//		userinfo.setState(0);
//		userinfo.setUsername("sys");
//		mapper.insertSelective(userinfo);
//		Map<String,Object> map = mapper.getUserInfo(1);
//		System.out.println("--------------"+map.toString());
//		System.out.println("成功");
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(6);
//		list.add(7);
//		StringBuilder append = new StringBuilder();
//		for(Integer num : list) {
//			if(7 == num) {
//				num = 1;
//			}else {
//				num = num + 1;
//			}
//			append.append(num).append(",");
//		}
//		String cronWeek = append.toString().substring(0, append.toString().lastIndexOf(","));
//		System.out.println(77);
		
//		System.out.println("1.00".equals(1));
//		String date = "0 30 7 ？* 1,2 ";
//		String [] arr = date.split("");
//		System.out.println(date.split(" ").length);
		
//		String str = "070";
//		String newStr = str.replaceAll("^(0+)", "");
//		System.out.println(newStr);
		redisUtil.getAllInfo("USER_TOKEN");
	}
	
	@Test
	public void testRedis() {
//		for(int i=0;i<10;i++) {
//			Object obj = redisUtil.lPush("kxy", i+"");
//			System.out.println(obj);
//		}
		
//		for(int i=0;i<9;i++) {
//			System.out.println(redisUtil.rPop("kxy"));
//		}
		
		redisUtil.del("kxy");
		
	}
	@Test
	public void load() {
		 String photoUrl = "D:/身份证.pdf";   //文件URL地址                                     
		    String fileName = photoUrl.substring(photoUrl.lastIndexOf("/"));     //为下载的文件命名
		    String filePath = "D:";      //保存目录
		    File file = saveUrlAs(photoUrl, filePath + fileName,"GET");
	}
	
	public File saveUrlAs(String url,String filePath,String method){  
	     //System.out.println("fileName---->"+filePath);  
	     //创建不同的文件夹目录  
	     File file=new File(filePath);  
	     //判断文件夹是否存在  
	     if (!file.exists())  
	    {  
	        //如果文件夹不存在，则创建新的的文件夹  
	         file.mkdirs();  
	    }  
	     FileOutputStream fileOut = null;  
	     HttpURLConnection conn = null;  
	     InputStream inputStream = null;  
	     try  
	    {  
	         // 建立链接  
	         URL httpUrl=new URL(url);  
	         conn=(HttpURLConnection) httpUrl.openConnection();  
	         //以Post方式提交表单，默认get方式  
	         conn.setRequestMethod(method);  
	         conn.setDoInput(true);    
	         conn.setDoOutput(true);  
	         // post方式不能使用缓存   
	         conn.setUseCaches(false);  
	         //连接指定的资源   
	         conn.connect();  
	         //获取网络输入流  
	         inputStream=conn.getInputStream();  
	         BufferedInputStream bis = new BufferedInputStream(inputStream);  
	         //判断文件的保存路径后面是否以/结尾  
	         if (!filePath.endsWith("/")) {  
	  
	             filePath += "/";  
	  
	             }  
	         //写入到文件（注意文件保存路径的后面一定要加上文件的名称）  
	         fileOut = new FileOutputStream(filePath+"123.png");  
	         BufferedOutputStream bos = new BufferedOutputStream(fileOut);  
	           
	         byte[] buf = new byte[4096];  
	         int length = bis.read(buf);  
	         //保存文件  
	         while(length != -1)  
	         {  
	             bos.write(buf, 0, length);  
	             length = bis.read(buf);  
	         }  
	         bos.close();  
	         bis.close();  
	         conn.disconnect();  
	    } catch (Exception e)  
	    {  
	         e.printStackTrace();  
	         System.out.println("抛出异常！！");  
	    }  
	       
	     return file;  
	       
	 }
	
	public HttpServletResponse download(String path, HttpServletResponse response) {  
		try {  
		// path是指欲下载的文件的路径。  
		File file = new File(path);  
		// 取得文件名。  
		String filename = file.getName();  
		// 取得文件的后缀名。  
		String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();  
		  
		// 以流的形式下载文件。  
		InputStream fis = new BufferedInputStream(new FileInputStream(path));  
		byte[] buffer = new byte[fis.available()];  
		fis.read(buffer);  
		fis.close();  
		// 清空response  
		response.reset();  
		// 设置response的Header  
		response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));  
		response.addHeader("Content-Length", "" + file.length());  
		OutputStream toClient = new BufferedOutputStream(response.getOutputStream());  
		response.setContentType("application/octet-stream");  
		toClient.write(buffer);  
		toClient.flush();  
		toClient.close();  
		} catch (IOException ex) {  
		ex.printStackTrace();  
		}  
		return response;  
		}  
	
	@Test
	public void testCollection() {
		List<RegionCar> list = carMapper.queryCarInfo();
		System.out.println(66);
	}

}

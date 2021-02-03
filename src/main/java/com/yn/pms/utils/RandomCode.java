package com.yn.pms.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**   
* 
* @Description: 
* @ClassName: RandomCode.java
* @author: yn 
* @date: 2021年1月6日 下午2:04:41 
*/
@Controller
public class RandomCode  {
	@RequestMapping("/imgCode")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			   int width=200;
			   int height=69;
			BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			//生成对应宽高的初始图片
			  String randomText = VerifyCode.drawRandomText(width,height,verifyImg);
			//单独的一个类方法，出于代码复用考虑，进行了封装。
			//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符                   
			req.getSession().setAttribute("rand", randomText);
			resp.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别
			 OutputStream os = resp.getOutputStream(); //获取文件输出流    
			 ImageIO.write(verifyImg,"png",os);//输出图片流
			 os.flush();
			 os.close();//关闭流
			   } catch (IOException e) {
			            e.printStackTrace();
			   }
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private String getRandom() {
		
		String sour = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] result = new char[5];
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			int index = random.nextInt(sour.length());
			result[i]=sour.charAt(index);
		}
		return String.valueOf(result);
	}
}

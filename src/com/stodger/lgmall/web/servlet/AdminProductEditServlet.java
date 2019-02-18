package com.stodger.lgmall.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.stodger.lgmall.domain.Product;
import com.stodger.lgmall.service.ProductService;
import com.stodger.lgmall.service.impl.ProductServiceImpl;
import com.stodger.lgmall.utils.CommonsUtils;

/**
 * @author lenovo
 * @version ����ʱ�䣺2019��1��9��  ����11:42:21
 */
@WebServlet("/adminProductEditUI")
public class AdminProductEditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Product product = new Product();
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			//1.���������ļ����
			DiskFileItemFactory disk = new DiskFileItemFactory();
			//2.�����ļ��ϴ����Ķ���
			ServletFileUpload upload = new ServletFileUpload(disk);
			//3.����request����ļ������
			List<FileItem> parseRequest = upload.parseRequest(request);
			for(FileItem item : parseRequest){
				//4.�ж��Ƿ�����ͨ����
				boolean formFile = item.isFormField();
				if(formFile){
					//4.1��ͨ����
					String filedName = item.getFieldName();
					String filedValue = item.getString("utf-8");
					map.put(filedName, filedValue);
					
				}else{
					//4.2�ļ����� ����ļ����� ����ļ�����
					String fileName = item.getName();
					System.out.println(fileName);
					String  path = this.getServletContext().getRealPath("/img/upload");
					System.out.println(fileName);
					InputStream in = item.getInputStream();
					OutputStream out = new FileOutputStream(path + "/" + fileName);
					IOUtils.copy(in, out);
					in.close();
					out.close();
					item.delete();
					map.put("p_image", "upload/" + fileName);
				}
			}
			BeanUtils.populate(product, map);
			Date date = new Date();
			SimpleDateFormat formart = new SimpleDateFormat("yyyy-MM-dd");
			product.setP_soldInTime(formart.format(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//5.����service��
		ProductService productService = new ProductServiceImpl();
		productService.updateProduct(product);
		response.sendRedirect("admin/product-list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
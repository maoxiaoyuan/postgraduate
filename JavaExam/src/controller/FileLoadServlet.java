package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import bean.College;
import bean.Files;

import dao.FileDao;

public class FileLoadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//创建一个自定义的文件类 并设置属性
	Files f=new Files();

	public FileLoadServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String symbol=(String)request.getParameter("symbol");
		//判断用户请求是上传还是下载，默认是管理员端上传文件，学生下载文件
		if("upload".equals(symbol)){
			doUpLoad(request,response);
			
		}else if("download".equals(symbol)){
			doDownLoad(request,response);
		}
	}
	//将文件上传到服务器的指定目录下
	private void doUpLoad(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//获取高校名称并封装为对象
		String college_name=(String)request.getSession().getAttribute("college_name");
		College college=new College(college_name);
		Map<String, Object> map = new HashMap<String, Object>();
		String savepath = "";
		// 打印map.size
		System.out.println("map.size--" + map.size());
		System.out.println("map.path---" + map.get("name"));
		//生成文件上传的路径和名称
		try {
			savepath = uploadFile(request, response, map);
			System.out.println("map.size--" + map.size());
			System.out.println("savepath===" + savepath);
			map.put("savepath", savepath);
			System.out.println("map====="+map.get(0));
			f.setFile_path("appupload/"+savepath);
			f.setCollege(college);
			FileDao fd=new FileDao();
			//将文件的信息录入数据库
			fd.add(f);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		response.getWriter().print("上传成功！");
		response.sendRedirect("/PostGraduate/JSP/rightFile.jsp");	
		
		
	}
	
	//将文件下载到本地
	private void doDownLoad(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//前几个文件无法下载是因为我删除了webapp下的文件被我删除啦,重新上传就可以下载啦
		
		String filename = request.getParameter("path");
		System.out.println(filename);
		// GET请求中，参数中包含中文需要自己动手来转换。
		// 如果使用了“全局编码过滤器”，那么这里就不用处理了
//		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		String filepath = this.getServletContext().getRealPath( filename);
		System.out.println(filepath);
		File file = new File(filepath);
		if(!file.exists()) {
			 response.getWriter().print("您要下载的文件不存在！");
			 return;
		}
		// 所有浏览器都会使用本地编码，即中文操作系统使用GBK
		// 浏览器收到这个文件名后，会使用iso-8859-1来解码
		filename = new String(filename.getBytes("GBK"), "ISO-8859-1");
		response.addHeader("content-disposition", "attachment;filename=" + filename);
		IOUtils.copy(new FileInputStream(file), response.getOutputStream());
		
	}
	//文件上传方法
	public String uploadFile(HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> map)
			throws IOException, FileUploadException {
		// 得到上传文件的保存目录，将要上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
//		String savePath = "D:\\appupload\\upload";
		String savePath ="D:\\学习软件\\tomcact8.5\\webapps\\PostGraduate\\appupload\\upload";
		// 上传生成的临时文件保存目录
//		String tempPath = "D:\\appupload\\temp";
		String tempPath ="D:\\学习软件\\tomcact8.5\\webapps\\PostGraduate\\appupload\\temp";
		File tmpFile = new File(tempPath);
		if (!tmpFile.exists()) {
			// 创建临时目录
			tmpFile.mkdir();
		}
		// 消息提示
		String message = "";
		String realSavePath = "";
		String saveFileName = "";
		// 使用Apache文件上传组件处理文件上传步骤：
		// 1.创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置工厂缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录中
		factory.setSizeThreshold(1024 * 100);// 设置缓冲区大小为100kb,如果不指定，那么缓冲区默认大小10kb
		// 设置上传时文件生成的临时文件的保存目录
		factory.setRepository(tmpFile);
		// 创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 监听文件上传进度
//		upload.setProgressListener(new ProgressListener() {
//
//			public void update(long pBytesRead, long pContentLength, int arg2) {
//				System.out.println("文件的大小为：" + pContentLength + "当前已处理："
//						+ pBytesRead);
//			}
//		});
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 3.判断提交上来的数据是否是上传表单的数据
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 按照传统方式获取数据
			return null;
		}

		// 设置上传单个文件的大小的最大值，目前设置的是1MB.即1024*1024字节
		upload.setFileSizeMax(1024 * 1024);
		// 设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
		upload.setSizeMax(10 * 1024 * 1024);
		// 4.使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FIleItem>集合，每一个FileItem对应一个Form表单的输入项
		List<FileItem> list;
		list = upload.parseRequest(request);
		for (FileItem item : list) {
			// 如果fileitem中封装的是普通输入项的数据
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString("UTF-8");
				System.out.println(name + "=" + value);
				map.put(name, value);
				System.out.println("mapsize=" + map.size());
			} else {
				// 如果fileitem中封装的是上传文件
				// 得到上传的文件名称
				String filename = item.getName();
				//设置文件对象的文件名属性
				f.setFile_name(filename);
				System.out.println("f.getFile_name()"+f.getFile_name());
				System.out.println("文件名为"+filename);
				if (filename == null || filename.trim().equals("")) {
					continue;
				}
				// 注意，不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：c:\a\b\1.txt,而有些只是单纯的文件名，如：1.txt
				// 处理获取到的上传文件的文件名的路径部分，只保留文件名的部分
				filename = filename.substring(filename.lastIndexOf("\\") + 1);
				// 得到上传文件的扩展名
				String fileExtName = filename.substring(filename
						.lastIndexOf(".") + 1);
				// 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
				System.out.println("上传的文件的扩展名是：" + fileExtName);
				// 获取item中的上传文件的输入流
				InputStream in = item.getInputStream();
				// 得到文件保存的名称
				saveFileName = makeFileName(filename);
				// 得到文件的保存目录
				realSavePath = makePath(saveFileName, savePath);
				System.out.println("path==" + realSavePath);
				System.out.println("filename==" + saveFileName);
				// realSavePath=realSavePath.i
				// 创建一个文件输出流
				OutputStream out = new FileOutputStream(realSavePath + "\\"
						+ saveFileName);
				// 创建一个缓冲区
				byte buffer[] = new byte[1024];
				// 判断输入流中的数据是否已经读完的标识
				int len = 0;
				// 循环将输入流督导缓冲区当中，(len = in.read(buffer)) > 0表示in里面还有数据
				while ((len = in.read(buffer)) > 0) {
					// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath+"\\"+filename)中
					out.write(buffer, 0, len);
				}
				// 关闭输入流
				in.close();
				// 关闭输出流
				out.close();
				// 删除处理文件上传时生成的临时文件
//				 item.delete();
				message = "文件上传成功！";
				realSavePath = realSavePath.substring(realSavePath
						.indexOf("\\upload") + 1);
				System.out.println("resavepath" + realSavePath);
				realSavePath = realSavePath.replaceAll("\\\\", "/");
				System.out.println("resavepath" + realSavePath);

			}
		}
		return realSavePath + "/" + saveFileName;
	}

	/**
	 * 为防止一个目录下面出现太多文件，要使用hash算法打散存储
	 * @Method:makePath
	 * @param filename   文件名，要根据文件名生成存储目录
	 * @param savePath   文件存储路径
	 * @return 新的存储目录
	 */
	private String makePath(String filename, String savePath) {
		// 得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		int hashcode = filename.hashCode();
		
		int dir1 = hashcode & 0xf;// 0-15
		int dir2 = (hashcode & 0xf0) >> 4;// 0-15
		// 构造新的保存目录
		String dir = savePath + "\\" + dir1 + "\\" + dir2;// upload\2\3
															// upload\3\5
		// File既可以代表文件也可以代表目录
		File file = new File(dir);
		if (!file.exists()) {
			// 创建目录
			file.mkdirs();
		}
		return dir;
	}
	private String makeFileName(String filename) {
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		return UUID.randomUUID().toString() + "_" + filename;
	}

}

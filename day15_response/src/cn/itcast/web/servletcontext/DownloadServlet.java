package cn.itcast.web.servletcontext;

import cn.itcast.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数
        String filename = request.getParameter("filename");
        System.out.println("filename: " + filename);
        // 2.获取文件路径，将字节输入流加载进内存
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/image/" + filename);
        System.out.println(realPath);
        FileInputStream fileInputStream = new FileInputStream(realPath);
        // 3.设置response响应头contentType
        String mimeType = servletContext.getMimeType(filename);
        response.setContentType(mimeType);
        // 解决中文文件名乱码问题 获取user-agent->使用downloadUtils
        String agent = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition","attachment;filename=" + filename);
        // 4.将输入流的数据写出到输出流中
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fileInputStream.read(buff)) != -1){
            outputStream.write(buff,0,len);
        }
        fileInputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

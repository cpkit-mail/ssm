package com.ssm.upload.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ssm.chat.web.socket.controller.ChatController;

@Controller
@RequestMapping("/upload")
public class UploadController {

    private static final Log log = LogFactory.getLog(ChatController.class);

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String upload() {

        return "/upload/upload";
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    // 读写简单
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request, Model model, @PathVariable("file") MultipartFile file) {

        log.info("文件上传开始");
        String path = request.getSession().getServletContext().getRealPath("//upload");
        String fileName = file.getOriginalFilename();
        log.info("路径：" + path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);
        log.info("文件上传完成");

        return "/upload/result";
    }

    /*
     * 通过流的方式上传文件
     * 
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    // 以写字节的方式写文件进度很慢
    @RequestMapping(value = "/streamfiles", method = RequestMethod.POST)
    public String uploadFiles(HttpServletRequest request, Model model,
            @RequestParam("file") CommonsMultipartFile[] files) {

        String uppath = request.getSession().getServletContext().getRealPath("//upload//");

        int fileCnt = 0;
        for (int i = 0; i < files.length; i++) {
            log.info("fileName---------->" + files[i].getOriginalFilename());
            if (!files[i].isEmpty()) {
                int pre = (int) System.currentTimeMillis();
                try (
                        // 拿到输出流，同时重命名上传的文件
                        FileOutputStream os = new FileOutputStream(
                                uppath + new Date().getTime() + files[i].getOriginalFilename());

                        // 拿到上传文件的输入流
                        FileInputStream in = (FileInputStream) files[i].getInputStream();) {

                    // 以写字节的方式写文件
                    // 进度很慢
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        os.write(b);
                    }
                    os.flush();
                    // os.close();
                    // in.close();
                    int finaltime = (int) System.currentTimeMillis();
                    log.info(finaltime - pre);
                    fileCnt++;

                } catch (Exception e) {
                    e.printStackTrace();
                    log.info("上传出错");
                }
            }
        }

        model.addAttribute("fileCnt", fileCnt);

        return "/upload/result";
    }

    /*
     * 采用spring提供的上传文件的方法
     */
    // 便于控制
    @RequestMapping("/multifiles")
    public String upload2(HttpServletRequest request, HttpServletResponse response)
            throws IllegalStateException, IOException {

        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        String uppath = request.getSession().getServletContext().getRealPath("//upload//");

        int fileCnt = 0;
        // 判断 request 是否有文件上传,即多部分请求
        // 检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {

                // 记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();

                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();

                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        log.info(myFileName);

                        // 重命名上传后的文件名
                        String fileName = new Date().getTime() + file.getOriginalFilename();

                        // 定义上传路径
                        String path = uppath + fileName;

                        File localFile = new File(path);
                        file.transferTo(localFile);

                        fileCnt++;
                    }
                }
                // 记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                log.info(finaltime - pre);
            }

        }

        // model.addAttribute("fileCnt", fileCnt);

        return "/upload/result";
    }

}

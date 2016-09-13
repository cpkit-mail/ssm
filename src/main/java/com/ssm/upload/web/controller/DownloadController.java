package com.ssm.upload.web.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/download")
public class DownloadController {

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String upload() {

        return "/upload/download";
    }

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public ResponseEntity<byte[]> download(@RequestParam("name") String name, @RequestParam("filePath") String path)
            throws IOException {
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        
        String fileName = name;
//        String fileName = new String(name.getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
//        String fileName = java.net.URLEncoder.encode(name, "UTF-8").replaceAll("\\+", "%20");
        
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}

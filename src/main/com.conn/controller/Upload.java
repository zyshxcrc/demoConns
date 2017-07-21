package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/21.
 */
@Controller
public class Upload {
    @RequestMapping("/doUpload")
    public String doLogin(@RequestPart("file") MultipartFile file, HttpServletRequest request) throws Exception{
        AsyncContext context = request.startAsync();
        new Thread(() -> {
            try {
                file.transferTo(new File("D:\\ideawork\\demoConn\\src\\main\\webapp\\WEB-INF\\static\\img\\"+file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            context.complete();
        }).start();
        return "main";
    }
}

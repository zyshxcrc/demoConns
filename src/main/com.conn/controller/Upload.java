package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/7/21.
 */
@Controller
public class Upload {
    private static final ExecutorService executor =  Executors.newFixedThreadPool(10);
    @RequestMapping("/doUpload")
    public DeferredResult<String> doUpload(final @RequestPart("file") MultipartFile file) throws Exception{
        final DeferredResult<String> result = new DeferredResult<>(100*1000L);
        executor.execute(() -> {
            try {
                Thread.sleep(10*1000L);
                file.transferTo(new File("D:\\ideawork\\demoConn\\src\\main\\webapp\\WEB-INF\\static\\img\\"+file.getOriginalFilename()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.setResult("main");
        });
        return result;
    }

    @RequestMapping("/doUpload1")
    public Callable<String> doUpload1(){
        return () -> "main";
    }

    @RequestMapping("/doUpload2")
    public WebAsyncTask<String> doUpload2(){
        return new WebAsyncTask<>(10 * 1000L, () -> "main");
    }
}

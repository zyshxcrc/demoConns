package util;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuziyang on 2017/7/21.
 */
public class HttpClientUtil {
    public static void doHttpPost() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://test.cbapay.com/user/servlet/appUserTest");
        List<NameValuePair> list = new ArrayList<>();

        list.add(new BasicNameValuePair("tranCode","900287"));
        list.add(new BasicNameValuePair("token","9cf8857ad58f09a69463f4982b8de72251b0b3bc9d09d6ee"));
        list.add(new BasicNameValuePair("ORDERTYPESEL","1"));
        list.add(new BasicNameValuePair("ORDERNO","P20170523145438"));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
        post.setEntity(entity);

        //提交post方法
        CloseableHttpResponse result = client.execute(post);

        int resultStatus = result.getStatusLine().getStatusCode() ;
        if(resultStatus == HttpStatus.SC_OK){
            System.out.println(EntityUtils.toString(result.getEntity()));
        }
    }

    public static void main(String[] args) {
        try {
            doHttpPost();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

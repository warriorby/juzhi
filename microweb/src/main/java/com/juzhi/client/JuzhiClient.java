package com.juzhi.client;


import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjwan on 5/9/14.
 */
public class JuzhiClient {

    public static void main(String[] args) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = null;
        try {
            post = new HttpPost("http://www.witsun.cn/app/infoList.php");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("categoryId", "12"));
            nameValuePairs.add(new BasicNameValuePair("pageSize", "10"));
            nameValuePairs.add(new BasicNameValuePair("pageNum", "1"));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = client.execute(post);

            System.out.println(response.getStatusLine());

            HttpEntity httpEntity = response.getEntity();

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

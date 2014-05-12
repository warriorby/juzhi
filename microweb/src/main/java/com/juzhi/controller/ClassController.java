package com.juzhi.controller;

import com.juzhi.entity.*;
import com.juzhi.wrapper.*;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjwan on 5/11/14.
 */
@Controller
@RequestMapping("/class")
public class ClassController {
    @RequestMapping(value = "/categorylist", method = RequestMethod.GET)
    public ModelAndView classCategoryList(Model model) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost("http://www.witsun.cn/app/classCategoryList.php");
            //List<NameValuePair> list = new ArrayList<>(1);
            // list.add(new BasicNameValuePair("infoid", "11245"));
//            httpPost.setEntity(new UrlEncodedFormEntity(list));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            ObjectMapper mapper = new ObjectMapper();

            InfoCategoryListWrapper wrapper = mapper.readValue(String.valueOf(result), InfoCategoryListWrapper.class);
            List<Category> categories = wrapper.getCategorylist();
            model.addAttribute("categories", categories);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("success");
    }


    @RequestMapping(value = "/classlist", method = RequestMethod.GET)
    public ModelAndView classList(Model model) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost("http://www.witsun.cn/app/classList.php");
            List<NameValuePair> list = new ArrayList<>(3);
            list.add(new BasicNameValuePair("categoryId", "43"));
            list.add(new BasicNameValuePair("pageSize", "50"));
            list.add(new BasicNameValuePair("pageNum", "1"));
            httpPost.setEntity(new UrlEncodedFormEntity(list));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            ObjectMapper mapper = new ObjectMapper();

            ClassListWrapper wrapper = mapper.readValue(String.valueOf(result), ClassListWrapper.class);
            List<Clazz> clazzs = wrapper.getClassList();
            model.addAttribute("clazzs", clazzs);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("success");
    }


    @RequestMapping(value = "/detailed", method = RequestMethod.GET)
    public ModelAndView infoDetailed(Model model) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost("http://www.witsun.cn/app/classDetailed.php");
            List<NameValuePair> list = new ArrayList<>(1);
            list.add(new BasicNameValuePair("classid", "11299"));
            httpPost.setEntity(new UrlEncodedFormEntity(list));

            HttpResponse httpResponse = httpClient.execute(httpPost);
            BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            ObjectMapper mapper = new ObjectMapper();

            ClassDetailedWrapper wrapper = mapper.readValue(String.valueOf(result), ClassDetailedWrapper.class);

            model.addAttribute("classDetailed", wrapper.getClassDetailed());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("success");
    }

}

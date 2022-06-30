package com.example.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class newsController {
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView data(@RequestParam(required = false) Map<String, String> allParams) {


        String query = "sports";
        String topic = allParams.get("topic");
        System.out.println(query);

        if (topic != null) {
            query = topic;
        }

        String apikey="<put your api key>";

        String target = "https://newsapi.org/v2/everything?q=" + query + "&pageSize=50&apiKey="+apikey;


        try {
//            String target = "https://newsapi.org/v2/everything?q=sports&pageSize=50&apiKey=2fbfbc294434437e8818f71739b32d00";
            newsfetcher newsdata = new newsfetcher();
            JSONObject feed = newsdata.fetcher(target);
            JSONArray articles = (JSONArray) feed.get("articles");
            System.out.println("no of articles(" + query + "): " + articles.size());

            ArrayList<news> datas = new ArrayList<>();

            for (int i = 0; i < articles.size(); i++) {
                JSONObject new_obj = (JSONObject) articles.get(i);

                try {
                    String title = new_obj.get("title").toString();
                    String desc = new_obj.get("description").toString();
                    String url = new_obj.get("url").toString();
                    String imageurl = new_obj.get("urlToImage").toString();
                    news thisnews = new news();
                    thisnews.setId(i);
                    thisnews.setTitle(title);
                    thisnews.setDesc(desc);
                    thisnews.setUrl(url);
                    thisnews.setImageurl(imageurl);

                    datas.add(thisnews);
                } catch (Exception e) {
                    continue;
                }


            }
            ModelAndView mv = new ModelAndView("page");
            System.out.println(datas.size());
            mv.addObject("query", query);
            mv.addObject("datas", datas);
            mv.addObject("batchsize", datas.size());
            return mv;
        } catch (Exception e) {
            System.out.println(e);
        }


        ModelAndView mv = new ModelAndView("page");

        return mv;
    }
}



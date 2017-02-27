package com.bookproject.util;

import com.bookproject.model.dto.ChapterDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.*;


/**
 * Created by Administrator on 2017/2/24.
 */
@Component
public class Util implements IUtil{

    public String getWebAbsolutePath() {
        return System.getProperty("user.dir")+"\\target\\projectbook-1.0-SNAPSHOT";
    }

    public String getProjectAbsolutePath() {
        return System.getProperty("user.dir");
    }

    public String getJavaAbsolutePath() {
        return getProjectAbsolutePath()+"\\src\\main\\java";
    }

    public Document getDocument(String url) {
        Document document=null;
        try {
            document=Jsoup.connect(url).get();
            if(document==null) {
                System.err.println(url + "\t页面抓取失败");
                return null;
            }
            else System.out.println(url+"\t页面抓取成功");
        } catch (IOException e) {
            System.err.println(url+"\t页面抓取失败");
            return null;
        }
        return document;
    }

    public Elements select(Document document, String select) {
        if(document==null) return null;
        System.out.println("正在进行匹配中...");
        Elements elements=document.select(select);
        if(elements.size()==0) {
            System.err.println("无匹配");
            return null;
        }
        else System.out.println("找到匹配项：["+elements.size()+"]项");
        return elements;
    }

    public ChapterDTO getChapterDTO(Element element,String url,String attrKey1,String attrKey2) {
        String key=element.attr(attrKey1);
        String value=element.attr(attrKey2);
        if(key==null || value ==null) return null;
        ChapterDTO chapterDTO=new ChapterDTO(key,url+value);
        System.out.println(chapterDTO);
        return chapterDTO;
    }


    @Test
    public void Test01(){
        String url="http://quanxiaoshuo.com/170950/";
        Document document=getDocument(url);
        Elements elements=select(document,".chapter a");
        for (Element element:elements) {
            getChapterDTO(element,"http://quanxiaoshuo.com","title","href");
        }
    }
}

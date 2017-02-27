package com.bookproject.util;

import com.bookproject.model.dto.ChapterDTO;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/24.
 */
public interface IUtil {
    /**
     * 获取基于webapp的绝对路径
     * @return
     */
    String getWebAbsolutePath();

    /**
     * 获取当前项目根目录的绝对路径
     * @return
     */
    String getProjectAbsolutePath();

    /**
     * 获取基于类路径的绝对路径
     * @return
     */
    String getJavaAbsolutePath();
    /**
     * 获取包含该地址内容的Dom文档
     * @return
     */
    Document getDocument(String url);
    /***
     * 装饰Jsoup的select方法加入成功和失败的提示
     */
    Elements select(Document document,String select);

    /**
     * 抓取章节名  和对应的URL地址
     * @param element
     * @return
     */
    ChapterDTO getChapterDTO(Element element,String url,String attrKey1,String attrKey2);
}

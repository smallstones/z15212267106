package com.bookproject.model.dto;

/**
 * Created by Administrator on 2017/2/26.
 */
public class ChapterDTO {
    private String chapter;
    private String url;

    public ChapterDTO() {
    }

    public ChapterDTO(String chapter, String url) {
        this.chapter = chapter;
        this.url = url;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "章节名："+chapter+"\tURL："+url;
    }
}

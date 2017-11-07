package com.testandroid;

import java.util.Arrays;
import java.util.List;


public class ImageUrls {
    static List<String> images;

    static {
        images = Arrays.asList(
                "http://cjtapp.wclub8.cn/uploads/2017/11/03/673eb68393f57516af314e7652a4451d.jpg",
                "http://cjtapp.wclub8.cn/uploads/2017/11/03/b2807ec4c8348a9f9194b52240a4f115.jpg",
                "http://cjtapp.wclub8.cn/uploads/2017/11/03/540c28aae988ad72aa4d46023c4579bf.jpg",
                "http://cjtapp.wclub8.cn/uploads/2017/11/03/b2807ec4c8348a9f9194b52240a4f115.jpg",
                "http://cjtapp.wclub8.cn/uploads/2017/11/03/540c28aae988ad72aa4d46023c4579bf.jpg",
                "http://cjtapp.wclub8.cn/uploads/2017/11/03/b2807ec4c8348a9f9194b52240a4f115.jpg",
                "http://cjtapp.wclub8.cn/uploads/2017/11/03/540c28aae988ad72aa4d46023c4579bf.jpg",
                "http://pic1.ytqmx.com:82/2015/1007/03/01.jpg"
        );

    }

    public static List<String> getImages() {

        return images;

    }
}

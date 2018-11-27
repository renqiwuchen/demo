package com.example.demo.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Model {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static void main(String[] args)throws Exception {
       /* File file = new File("e:\\excel");
        if(!file.exists()){//如果文件夹不存在
            file.mkdir();//创建文件夹
        }
        BufferedWriter bw=new BufferedWriter(new FileWriter("e:\\excel\\wuchen.html"));
        bw.write("Hello I/O!");//在创建好的文件中写入"Hello I/O"
        bw.close();//一定要关闭文件*/
    }
}

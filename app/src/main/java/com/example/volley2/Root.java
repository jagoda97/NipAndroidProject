package com.example.volley2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Root {
    public Result result;


    public Result getResult() {
        return result;
    }


    public void setResult(Result result) {
        this.result = result;
    }

    public Root(Result result) {
        this.result = result;
    }


//    @SerializedName("id")
//    @Expose
//    public String id;
//    @SerializedName("author")
//    @Expose
//    public String author;
//    @SerializedName("en")
//    @Expose
//    public String en;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getEn() {
//        return en;
//    }
//
//    public void setEn(String en) {
//        this.en = en;
//    }
//
//    @Override
//    public String toString() {
//        return  " id: " + id + " autor: " +
//                  author + " cytat: " +
//                  en  ;
//    }
}

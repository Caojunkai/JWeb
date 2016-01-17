package com.drifting.entity;


import java.util.Date;

public class Items {
    private int id;
    private String name;
    private double price;
    private int num;
    private String producer;
    private String productPlace;
    private String imgUrl;
    private double oldPrice;
    private String sn;
    private Date cTime;
    private Date uTime;
    private int cUid;
    private int uUid;
    private String desc;
    private String keyWords;

    public Items(){

    }

    public Items(int id, String name, double price, int num, String producer, String productPlace, String imgUrl, double oldPrice, String sn, Date cTime, Date uTime, int cUid, int uUid, String desc, String keyWords) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
        this.producer = producer;
        this.productPlace = productPlace;
        this.imgUrl = imgUrl;
        this.oldPrice = oldPrice;
        this.sn = sn;
        this.cTime = cTime;
        this.uTime = uTime;
        this.cUid = cUid;
        this.uUid = uUid;
        this.desc = desc;
        this.keyWords = keyWords;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProductPlace() {
        return productPlace;
    }

    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    public int getcUid() {
        return cUid;
    }

    public void setcUid(int cUid) {
        this.cUid = cUid;
    }

    public int getuUid() {
        return uUid;
    }

    public void setuUid(int uUid) {
        this.uUid = uUid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Items){
            Items items = (Items) obj;
            return items.getId() == this.getId() && items.getName().equals(this.getName());
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getId()+this.getName().hashCode();
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", producer='" + producer + '\'' +
                ", productPlace='" + productPlace + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", oldPrice=" + oldPrice +
                ", sn='" + sn + '\'' +
                ", cTime=" + cTime +
                ", uTime=" + uTime +
                ", cUid=" + cUid +
                ", uUid=" + uUid +
                ", desc='" + desc + '\'' +
                ", keyWords='" + keyWords + '\'' +
                '}';
    }
}

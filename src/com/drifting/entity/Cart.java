package com.drifting.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {
    private HashMap<Items,Integer> goods;
    private double totalPrice;

    public Cart(){
        goods = new HashMap<Items,Integer>();
        totalPrice = 0.0;
    }

    public HashMap<Items, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Items, Integer> goods) {
        this.goods = goods;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 购物车添加商品
     * @param item 商品
     * @param number 数量
     * @return 是否成功
     */
    public boolean addGoodsToCart(Items item,int number){
        if (goods.containsKey(item)){
            goods.put(item,goods.get(item) + number);
        }else {
            goods.put(item,number);
        }
        callTotalPrice();
        return true;
    }

    /**删除商品
     * @param item 商品
     * @return 是否成功
     */
    public boolean removeGoodsFromCart(Items item){
        goods.remove(item);
        callTotalPrice();
        return true;
    }

    public double callTotalPrice(){
        double sum = 0.0;
        Set<Map.Entry<Items, Integer>> map = goods.entrySet();
        for (Map.Entry<Items, Integer> i : map) {
            sum += i.getKey().getPrice() * i.getValue();
        }
        this.setTotalPrice(sum);
        return this.getTotalPrice();
    }

}

package com.fmg.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName cartService
 * @Description TODO
 * @Author fmg
 * @Date 2019-12-13 22:49
 * @Version 1.0.0
 **/
public class CartService {

    private static List<Sku> cartSkuList = new ArrayList<Sku>(){
        {
            add(new Sku(1, "java编程思想", 88.0, 1, 88.0, SkuCategoryEnum.BOOKS));
            add(new Sku(2, "java编程思想2", 87.0, 1, 87.0, SkuCategoryEnum.BOOKS));
            add(new Sku(3, "java编程思想3", 86.0, 1, 86.0, SkuCategoryEnum.BOOKS));
            add(new Sku(4, "java编程思想4", 83.0, 1, 83.0, SkuCategoryEnum.BOOKS));
            add(new Sku(5, "羽绒服", 188.0, 2, 376.0, SkuCategoryEnum.CLOTHING));
            add(new Sku(6, "无人机", 6666.0, 1, 6666.0, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(7, "NAS", 4500.0, 1, 4500.0, SkuCategoryEnum.ELECTRONICS));
            add(new Sku(8, "篮球", 50.0, 10, 500.0, SkuCategoryEnum.SPORTS));
            add(new Sku(9, "连衣裙", 200.0, 1, 200.0, SkuCategoryEnum.CLOTHING));
            add(new Sku(10, "java编程思想5", 89.0, 1, 89.0, SkuCategoryEnum.BOOKS));
        }
    };

    /***
     * @description 获取所有商品
     * @method getCartSkuList
     * @author fmg
     * @date 2019/12/14 10:00
     * @param:
     * @return: java.util.List<com.fmg.cart.Sku>
     * @throws
     **/
    public static List<Sku> getCartSkuList(){
        return cartSkuList;
    }

    /***
     * @description 获取所有的数码商品
     * @method filterElectronics
     * @author fmg
     * @date 2019/12/14 10:01
     * @param:
     * @return: java.util.List<com.fmg.cart.Sku>
     * @throws
     **/
    public static List<Sku> filterElectronics(List<Sku> cartSkuList){
        List<Sku> result = new ArrayList<>();
        for (Sku sku:
                cartSkuList) {
            if(sku.getSkuCategory().equals(SkuCategoryEnum.ELECTRONICS)){
                result.add(sku);
            }
        }
        return result;
    }


    public static List<Sku> filterSkuByCategory(List<Sku> cartSkuList, Enum skuCategoryEnum){
        List<Sku> result = new ArrayList<>();
        for (Sku sku:
                cartSkuList) {
            if(sku.getSkuCategory().equals(skuCategoryEnum)){
                result.add(sku);
            }
        }
        return result;
    }

    /***
     * @description 判断逻辑参数化
     * @method filterSkuByPredicate
     * @author fmg
     * @date 2019/12/15 9:11
     * @param: cartSkuList: 
     * @param: skuPredicate: 
     * @return: java.util.List<com.fmg.cart.Sku>
     * @throws
     **/
    public static List<Sku> filterSkuByPredicate(List<Sku> cartSkuList, SkuPredicate skuPredicate){
        List<Sku> result = new ArrayList<>();
        for (Sku sku:
                cartSkuList) {
            if(skuPredicate.test(sku)){
                result.add(sku);
            }
        }
        return result;
    }



}

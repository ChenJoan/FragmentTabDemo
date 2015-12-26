package com.chenchong.test;

import android.support.v4.app.Fragment;

/**
* @ClassName: FragmentFactory 
* @Description: 利用工厂模式去创建新的fragment
* @author ChenChong
* @date 2015-12-26 下午6:06:13 
*
 */
public class FragmentFactory {
	
	// 主页的底部导航菜单栏的选项
	public static final String INDEX_TAG = "index";
	public static final String CATEGORY_TAG = "category";
	public static final String SHOP_TAG = "shop";
	public static final String ME_TAG = "me";
	public static final String MORE_TAG = "more";
	
	// 根据tag值去创建不同的fragment对象
	public static Fragment getInstanceByTag(String tag) {  
        Fragment fragment = null;  
        if(INDEX_TAG.equals(tag)){
        	fragment = new OneFragment();  
        }else if(CATEGORY_TAG.equals(tag)){
        	fragment = new TwoFragment();  
        }else if(SHOP_TAG.equals(tag)){
        	fragment = new ThreeFragment();  
        }else if(ME_TAG.equals(tag)){
        	fragment = new OneFragment();  
        }else if(MORE_TAG.equals(tag)){
        	fragment = new ThreeFragment();   
        }
        return fragment;  
    }  
	
}

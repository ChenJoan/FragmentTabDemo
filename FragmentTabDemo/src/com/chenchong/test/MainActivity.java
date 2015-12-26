package com.chenchong.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * @ClassName: MainActivity
 * @Description:  主页面。本demo是利用radioButton+Fragment实现的底部导航
 * 在替换fragment的时候，使用add和hide方法，要比使用replace的方法要好。
 * 如果管理fragment中的子fragment的话，使用getChildFragmentManager管理。
 * @author ChenChong
 * @date 2015-12-25 下午6:39:05
 * 
 */
public class MainActivity extends FragmentActivity implements
		OnCheckedChangeListener {

	public static final String TAG = "IndexActivity";

	// 用于查找回退栈中的fragment，findFragmentByTag
	public static final String INDEX_TAG = "index";
	public static final String CATEGORY_TAG = "category";
	public static final String SHOP_TAG = "shop";
	public static final String ME_TAG = "me";
	public static final String MORE_TAG = "more";

	private FrameLayout fragContainer;

	// 底部菜单
	RadioGroup mTabMenu;

	// 保留当前的显示的fragment的标签
	String mLastFragmentTag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		// 初始化底部菜单
		mTabMenu = (RadioGroup) findViewById(R.id.tab_menu);
		mTabMenu.setOnCheckedChangeListener(this);
		fragContainer = (FrameLayout) findViewById(R.id.fragment_container);

		// 后退栈为空，添加第一个fragment，即默认显示的fragment
		if (fragContainer != null) {
			ContentFragment contentFragment = new ContentFragment();
			
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment_container, contentFragment, INDEX_TAG)
					.addToBackStack(null).commit();
			mLastFragmentTag = INDEX_TAG;//初始化的时候将首页作为上一页的标志
		}
	}
	
	// 切换fragment
	private void change(String Tag) {
		if (Tag != mLastFragmentTag) {
			Fragment lastFragment = getSupportFragmentManager()
					.findFragmentByTag(mLastFragmentTag);
			
			if (getSupportFragmentManager().findFragmentByTag(Tag) != null) {
				Fragment fragmentNow = getSupportFragmentManager()
						.findFragmentByTag(Tag);
				getSupportFragmentManager().beginTransaction()
				.show(fragmentNow).hide(lastFragment).commit();
			} else {
				//根据当前tag创建出来显得fragment
				Fragment fragment = FragmentFactory.getInstanceByTag(Tag);
				getSupportFragmentManager().beginTransaction()
				.add(R.id.fragment_container, fragment, Tag)
				.addToBackStack(null).hide(lastFragment).commit();
			}
			mLastFragmentTag = Tag;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.shop:
			change(SHOP_TAG);
			break;
		case R.id.category:
			change(CATEGORY_TAG);
			break;
		case R.id.index:
			change(INDEX_TAG);
			break;
		case R.id.me:
			change(ME_TAG);
			break;
		case R.id.more:
			change(MORE_TAG);
			break;
		}
	}

}

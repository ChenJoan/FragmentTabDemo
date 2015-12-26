package com.chenchong.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
* @ClassName:  ContentFragment
* @Description:  首页
* @author ChenChong
* @date 2015-12-25 下午6:39:14 
*
 */
public class ContentFragment extends Fragment{

	public static final String SHOW_TEXT = "show_text";
	
	public View mTotalView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 mTotalView = inflater.inflate(R.layout.index_frame, container, false);
		
		 TextView showText =  (TextView)mTotalView.findViewById(R.id.show_txt);
		 showText.setText("我是contentFragment");
		 
		 return mTotalView;
	}
}

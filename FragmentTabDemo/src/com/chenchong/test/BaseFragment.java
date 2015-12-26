package com.chenchong.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
* @ClassName: BaseFragment 
* @Description: TODO 
* @author ChenChong
* @date 2015-12-26 下午6:06:02 
*
 */
public abstract class BaseFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment, null);  
        TextView textView = (TextView) view.findViewById(R.id.txt_content);  
        textView.setText(initContent());  
        return view;  
    }  
  
    public abstract String initContent();  
}

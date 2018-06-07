package com.ds.app;

import com.ds.app.model.MemberModel;
import com.ds.app.view.JoinView;

public class Join {

	public static void main(String[] args) {
		//1.화면표시
		JoinView jObj = new JoinView();
		String id = jObj.jsp();
		System.out.println("C에서 : " + id);
		
		//2.DB로 전달 
		//클래스명 객체명 = new 클래스명()
		MemberModel mObj = new MemberModel();

		// 메소드호출: 객체명.시킬일();
		mObj.connOracle();
		mObj.memberJoin(id);
			
		
	}

}

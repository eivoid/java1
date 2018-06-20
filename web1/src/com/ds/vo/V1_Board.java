package com.ds.vo;

public class V1_Board {
	private int brd_no =0; //number
	private String brd_title= null; //varchar2
	private String brd_content =null; //clob
	private String brd_writer =null;//varchar2
	private int brd_hit =1; //number
	private String brd_hit1 = null; //TO_CHAR 을 사용.
	private byte[] brd_img=null; //blob :이미지, 비디오, 파일첨부
	private String brd_date =null; //date
	private String brd_file = null; //file명 보관
	
	
	
	public String getBrd_hit1() {
		return brd_hit1;
	}
	public void setBrd_hit1(String brd_hit1) {
		this.brd_hit1 = brd_hit1;
	}
	public String getBrd_file() {
		return brd_file;
	}
	public void setBrd_file(String brd_file) {
		this.brd_file = brd_file;
	}
	public int getBrd_no() {
		return brd_no;
	}
	public void setBrd_no(int brd_no) {
		this.brd_no = brd_no;
	}
	public String getBrd_title() {
		return brd_title;
	}
	public void setBrd_title(String brd_title) {
		this.brd_title = brd_title;
	}
	public String getBrd_content() {
		return brd_content;
	}
	public void setBrd_content(String brd_content) {
		this.brd_content = brd_content;
	}
	public String getBrd_writer() {
		return brd_writer;
	}
	public void setBrd_writer(String brd_writer) {
		this.brd_writer = brd_writer;
	}
	public int getBrd_hit() {
		return brd_hit;
	}
	public void setBrd_hit(int brd_hit) {
		this.brd_hit = brd_hit;
	}
	public byte[] getBrd_img() {
		return brd_img;
	}
	public void setBrd_img(byte[] brd_img) {
		this.brd_img = brd_img;
	}
	public String getBrd_date() {
		return brd_date;
	}
	public void setBrd_date(String brd_date) {
		this.brd_date = brd_date;
	}
	
	
}

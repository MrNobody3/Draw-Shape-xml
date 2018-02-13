package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
	private String id;
	private Point pa;
	private Point pb;
	private List<String> comments=new ArrayList<String>();
	
	public Rectangle() {
		super();
	}	
        public Rectangle(int x,int y,int width,int height){
            this.pa.setX(x);
            this.pa.setY(y);
            this.pa.setX(width);
            this.pa.setY(height);
        }
	public Rectangle(Point pa, Point pb) {
		super();
		this.pa = pa;
		this.pb = pb;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Point getPa() {
		return pa;
	}
	public void setPa(Point pa) {
		this.pa = pa;
	}
	public Point getPb() {
		return pb;
	}
	public void setPb(Point pb) {
		this.pb = pb;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Rectangle [id=" + id + ", pa=" + pa + ", pb=" + pb + ", comments=" + comments + "]";
	}
	
}

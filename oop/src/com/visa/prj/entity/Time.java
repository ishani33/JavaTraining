package com.visa.prj.entity;

public class Time {
	private int hrs;
	private int min;
	
	public Time() {
	}
	public Time(int hrs, int min) {
		this.hrs = hrs;
		this.min = min;
	}
	public static Time addtime(Time t1, Time t2) {
		Time t3 = new Time();
		t3.hrs = t1.hrs + t2.hrs;
		t3.min = t1.min + t2.min;
		if(t3.min > 59) {
			t3.hrs++;
			t3.min = t3.min - 60;
		}
		return t3;
	}
	public int getHours() {
		return this.hrs;
	}
	public int getMin() {
		return this.min;
	}
	public Time addTime(Time t2) {
		Time t = new Time();
		t.hrs = this.hrs + t2.hrs;
		t.min = this.min +t2.min;
		if(t.min > 59) {
			t.hrs++;
			t.min=t.min-60;
		}
		return t;
	}
}

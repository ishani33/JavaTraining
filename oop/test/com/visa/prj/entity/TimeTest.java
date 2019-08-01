package com.visa.prj.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void testAddtime() {
		Time t1 = new Time(8,15);
		Time t2 = new Time(4,10);
		
		assertEquals(12, Time.addtime(t1, t2).getHours());
		assertEquals(25, Time.addtime(t1, t2).getMin());
	}

	@Test
	public void testAddTime() {
		Time t1 = new Time(8,15);
		Time t2 = new Time(4,10);

		assertEquals(12, t1.addTime(t2).getHours());
		assertEquals(25, t1.addTime(t2).getMin());
	}

}

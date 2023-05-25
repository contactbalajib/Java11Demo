package com.java11.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class CollectionArrayDemo1 {
	public static void main(String[] args) {
		List<String> list = List.of("foo", "bar", "baz");

		Object[] strings1 = list.toArray();
		System.out.println("strings1 size: " + strings1.length);
		
		
		String[] strings2a = list.toArray(new String[list.size()]);
		System.out.println("strings2a size: " + strings2a.length);
		
		
		String[] strings2b = list.toArray(new String[0]);
		System.out.println("strings2b size: " + strings2b.length);
		
		
		String[] strings2c = list.toArray(String[]::new);
		System.out.println("strings2c size: " + strings2c.length);
		
		String[] arr = list.toArray(size -> new String[size]);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(list.toArray(String[]::new)));
		
		
		
		///@Valid String name = "balaji";
		///@Valid var nameNew = "balaji-new";
		//@Valid nameNew1 = "balaji-new";
		
		String blankvar1 = "";
		String blankvar2 = "   ";
		String blankvar3 = "	";
		String blankvar4 = "\r\n";
		String blankvar5 = "balaji";
		
		System.out.println("blankvar1 : " + blankvar1.isBlank());
		System.out.println("blankvar2 : " + blankvar2.isBlank());
		System.out.println("blankvar3 : " + blankvar3.isBlank());
		System.out.println("blankvar4 : " + blankvar4.isBlank());
		System.out.println("blankvar5 : " + blankvar5.isBlank());
		
		String multiline = "balaji \n"
							 + " is \n"
							 + " good \n" 
							 + "boy";
		multiline.lines().forEach(System.out::println);
		List<String> list1 = multiline.lines().collect(Collectors.toList());
		System.out.println(list1);
		
		
		
		String stripTxt1 = "   balaji   ";
		System.out.println("=" + stripTxt1.strip() + "=");
		System.out.println("=" + stripTxt1.stripLeading() + "=");
		System.out.println("=" + stripTxt1.stripTrailing() + "=");
		
		String stripTxt2 = "         \r\n";
		System.out.println("=" + stripTxt2.strip() + "=");
		System.out.println("=" + stripTxt2.stripLeading() + "=");
		System.out.println("=" + stripTxt2.stripTrailing() + "=");
		
		String repeatTxt = "hello";
		System.out.println(repeatTxt.repeat(3));
		
		Optional o = Optional.empty();
		System.out.println(o.isEmpty());
		
		
		
		
		
		
		
	}
}

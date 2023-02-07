package com.thinklikecoder.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Resistance Leader is the one who has 
 * 
 * leader has Green Eyes
 * 	if Red hair : Name has alteast one consecutive double letter
 * 	if leader wears glasses the name has exactly 2 vowles in name
 * 	otherwise the leader name has 3 vowles.
 * */

//details collected of each person related to wanted poster
class People{
	String name;
	String hairColor;
	String eyeColor;
	boolean wearGlasses;
	public People(String name, String hairColor, String eyeColor, boolean wearGlasses) {
		super();
		this.name = name;
		this.hairColor = hairColor;
		this.eyeColor = eyeColor;
		this.wearGlasses = wearGlasses;
	}
	public String getName() {
		return name;
	}
	public String getHairColor() {
		return hairColor;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public boolean isWearGlasses() {
		return wearGlasses;
	}
}

public class Eposide2 {

	public static void main(String[] args) {

		List<People> peoples = new ArrayList<People>();
		
		peoples.add(new People("adila","black","green",false));
		peoples.add(new People("adam","black","green",false));
		peoples.add(new People("cassy","red","brown",false));
		peoples.add(new People("cassy","red","brown",true));
		
		
		
		for(People person :peoples) {
			if(person.getEyeColor().equals("green")) {
				if(person.getHairColor().equals("red")) {
					if(doesNameConsDoubleLetter(person.getName()))
						System.out.println(person.getName());
				}
				if(person.isWearGlasses()) {
					if(doesNameHas2Vowels(person.getName()))
						System.out.println(person.getName());
				}
				if(doesNameHas3Vowels(person.getName())) {
					System.out.println(person.getName());
				}
			}
		}
	}

	private static boolean doesNameHas3Vowels(String name) {
		List<Character> vowels = Arrays.asList('a','e','i','o','u');
		int len = name.length();
		int cnt =0;
		for(int i=0;i<len;i++) {
			if(vowels.contains(name.charAt(i))) cnt++;
			if(cnt == 3) return true;
		}		
		return false;
	}

	private static boolean doesNameHas2Vowels(String name) {
		// TODO Auto-generated method stub
		List<Character> vowels = Arrays.asList('a','e','i','o','u');
		int len = name.length();
		int cnt =0;
		for(int i=0;i<len;i++) {
			if(vowels.contains(name.charAt(i))) cnt++;
			if(cnt == 2) return true;
		}
		return false;
	}

	private static boolean doesNameConsDoubleLetter(String name) {
		int n = name.length();
		for(int i=1;i<n;i++) {
			if(name.charAt(i-1) == name.charAt(i)) return true; //for 1st consecutive sequence only we get true as it is atleast 
		}
		return false;
	}
}


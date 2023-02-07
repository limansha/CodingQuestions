package com.thinklikecoder.tasks;

import java.util.ArrayList;
import java.util.List;

/*
 * The Furnance Bots
 * Years ago there is only one furnance bot it has zero inside the furnance and unknown randomly generated serial number outside then it has relicated nad creted thousands of bots
 * having parent serial number inside its furnance and an unknown serial number outside and replicating as childs following the pattern 
 * 
 * 
 * bot1 : [f:0,s:123] has two children botCh1 : [f:123,s:789] botCh2 : [f:123,s:456] so on replicating each other 
 * */

class Bot{
	int furnance;
	int serialNo;
	public Bot(int furnance, int serialNo) {
		super();
		this.furnance = furnance;
		this.serialNo = serialNo;
	}
	public int getFurnance() {
		return furnance;
	}
	public void setFurnance(int furnance) {
		this.furnance = furnance;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
}
public class Eposide3 {

	//find the furnace bot whose furnance has value zero
	 
	public static void main(String[] args) {
		List<Bot> bots = new ArrayList<Bot>();
		bots.add(new Bot(0,123));
		bots.add(new Bot(123,786));
		bots.add(new Bot(123,456));
		bots.add(new Bot(786,345));
		bots.add(new Bot(786,1234));
		bots.add(new Bot(456,1238));
		
		Bot botPicked = bots.get(5);
		int furance = botPicked.getFurnance(); //variable data stored 
		
		while(furance != 0) {
			for(Bot bot:bots) {
				if(bot.getSerialNo() == furance) {
					botPicked = bot;
					furance = botPicked.getFurnance();
					break;
				}
			}
		}
		System.out.println(botPicked.getSerialNo());
	}

}

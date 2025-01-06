package com.hms.generic.javautilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	public StringBuilder getRandomPhoneNumber() {
		Random random = new Random();
		int firstdigit = random.nextInt(4) + 6;
		StringBuilder mobilenumber = new StringBuilder();
		mobilenumber.append(firstdigit);
		for(int i=0;i<9;i++) {
			mobilenumber.append(random.nextInt(10));
		}
		return mobilenumber;
	}
	
	public String getLocalDateTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
	
	public String getSystemDateDDMMYYYY() {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy");
		return simple.format(date);
	}
	
	public String getCalculatedDateDDMMYYY(int days) {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy");
		simple.format(date);
		Calendar calendar = simple.getCalendar();
		calendar.add(Calendar.DAY_OF_MONTH,days);
		return simple.format(calendar.getTime());
		
	}
	
	public String getSystemDateYYYYMMDD() {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		return simple.format(date);
	}
	
	public String getCalculatedDateYYYYMMDD(int days) {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		simple.format(date);
		Calendar calendar = simple.getCalendar();
		calendar.add(Calendar.DAY_OF_MONTH,days);
		return simple.format(calendar.getTime());
		
	}

	public String getRandomFirstName() {
		String[] firstNames = { "John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Ava", "Ethan","Isabella","Thomas" };
		Random random = new Random();
		int randomFirstNameIndex = random.nextInt(firstNames.length);
		return firstNames[randomFirstNameIndex];

	}
	
	public String getRandomLastName() {
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis","Martinez", "Hernandez" ,"Shelby","Wick"};
		Random random = new Random();
		int randomLastNameIndex = random.nextInt(lastNames.length);
		return lastNames[randomLastNameIndex];

	}

}

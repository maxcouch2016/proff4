package tools;

import java.util.ArrayList;
import java.util.Scanner;

public class Validator {
	
	public Validator(){
	}
	
	
	@SuppressWarnings("resource")
	public boolean validateName(String name){
		if (name==null) return false;
		name = name.trim();
		Scanner scan = new Scanner(name);
		name = scan.next();
		if (scan.hasNext() || name.equals("")){
			return false;
		} 
		scan.close();
		return true;
	}
	
	public Integer validateSalary(String salary){
		salary.trim();
		Integer salaryInt = null;
		try{
			salaryInt = Integer.parseInt(salary);
		} catch(Exception e ){
			System.out.println("Contains words");
		} 
		
		if (salaryInt != null && salaryInt > 0){
			return salaryInt;
		}
		return 0;
	}
	public String validateDate(String date){
		date.trim();
		
		char[] dateArray = date.toCharArray();
		ArrayList<Integer> dateList = new ArrayList<>();
		
		for (int i = 0; i < dateArray.length; i++){
			if (Character.isDigit(dateArray[i]) ){
				Integer integers =  Character.getNumericValue(dateArray[i]);
				System.out.println(dateArray[i]);
				dateList.add(integers);
			}
			
		}
	if (dateList.size() >= 8){
		date = (dateList.get(0) +""+dateList.get(1)+"/"+dateList.get(2)+""+dateList.get(3)+""+
				"/"+dateList.get(4)+""+dateList.get(5)+""+dateList.get(6)+""+dateList.get(7));
		return date;
	} else if (dateList.size() ==7){
		
			date = (dateList.get(0) +"/"+dateList.get(1)+""+dateList.get(2)+"/"+dateList.get(3)+""+
					""+dateList.get(4)+""+dateList.get(5)+""+dateList.get(6));
			return date;
		
	}
		return "";
	}
}

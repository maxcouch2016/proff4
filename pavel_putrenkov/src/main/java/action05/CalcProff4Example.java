//package action05;
//
//public class CalcProff4Example extends AbstractCalc{
//   
//	@Override
//	public void inChar(char p) {
//		if(p=='='){
//			if(operation=='+') result = temp + strToInt(result)+"";
//			if(operation=='-') result = temp - strToInt(result)+"";
//			if(operation=='*') result = temp * strToInt(result)+"";
//			if(operation=='/') result = temp / strToInt(result)+"";
//			operation='0';
//			temp=0;
//		} else if('0'<=p && p<='9'){
//			if(operation!='0' && temp==0){
//				temp = strToInt(result);
//				result = "0";
//			} 
//				result = result + (p-'0');
//		} else {
//			operation = p;			
//		}		
//		printResult();
//	}
//	public int strToInt(String str){
//		int res = 0;
//		
//		try{
//			for(int i = 0; i<str.length();i++){
//				int k = Integer.parseInt(str.substring(0,i));
//				res = k;
//			}
//		} catch(Exception e){			
//		}
//		return res;
//	}
//	
//}
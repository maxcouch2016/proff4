package action03;

public enum MyEnum {
	oNE("один"), tWO("два"), fREE("три");
	String name;
	MyEnum(String n){
		name = n;
	}
	public String toString(){
		return name;
	}
	
	public void f() {
		MyEnum obj = MyEnum.tWO;
		String s = obj.toString();
		MyEnum obj1 = MyEnum.valueOf(s);
		MyEnum[] vector = MyEnum.values();
		System.out.println(obj.name());
	}
}

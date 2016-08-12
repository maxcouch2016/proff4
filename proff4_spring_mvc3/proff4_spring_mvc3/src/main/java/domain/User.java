package domain;

import javax.persistence.Entity;

@Entity
public class User {
	String name;
	String age;
	
	public String toTableString(){
		return "<tr><td>"+name+"</td><td>"+age+"</td></tr>";
	}
}

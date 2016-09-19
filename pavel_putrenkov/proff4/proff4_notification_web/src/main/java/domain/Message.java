package domain;

public class Message {
	private String text;
	private String date;
	private String catalog;
	
	public Message(String text, String date, String catalog) {
		this.text = text;
		this.date = date;
		this.catalog = catalog;
	}

	public String toPage(){
       StringBuilder sb =  new StringBuilder();
       sb.append("<p class=\"messageDate\" >"+date+"</p>");
       sb.append("<p class=\"messageCatalog\">"+catalog+"</p>");
       sb.append("<div class=\"messageText\">"+text+"</div>");
       return sb.toString();

	}
	
}

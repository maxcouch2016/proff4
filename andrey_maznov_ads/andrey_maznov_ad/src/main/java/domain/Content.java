package domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="content")
public class Content {
	
	@Id
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	private Long id;
	
	@Column(name="text")
	private String text;

	@Column(name="date")
	private GregorianCalendar date;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="catalog_id")
	private Catalog catalog;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="user_id")
	private User user;

	public Content(String text, GregorianCalendar date, Catalog catalog, User user) {
		this.text = text;
		this.date = date;
		this.catalog = catalog;
		this.user = user;
	}
	
	public Content() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String toPage(){
       StringBuilder sb =  new StringBuilder();
       
       SimpleDateFormat fmt = new SimpleDateFormat("dd-MMM-yyyy");
       fmt.setCalendar(date);
       
       sb.append("<p class=\"messageDate\" >"+fmt.format(date.getTime())+"</p>");
       sb.append("<p class=\"messageCatalog\">"+catalog+"</p>");
       sb.append("<div class=\"messageText\">"+text+"</div>");
       return sb.toString();
	}
	
}

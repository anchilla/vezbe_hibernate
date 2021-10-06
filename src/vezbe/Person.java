package vezbe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persons")
public class Person {

	//GenerationType.AUTO
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int per_id;

	@Column(name="ime")
	private String ime;
	@Column(name="text")
	private String text;
	
	 @OneToMany(cascade = CascadeType.ALL, mappedBy="person")
	 private List<Dao> persons;//=new ArrayList<Dao>();
	
	public List<Dao> getPersons() {
		return persons;
	}
	public void setPersons(List<Dao> persons) {
		this.persons = persons;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public int getPer_id() {
		return per_id;
	}
	public void setPer_id(int per_id) {
		this.per_id = per_id;
	
	}	
	public String toString() {
		return "Ime: "+ime+ " Text: "+text;
	}
}

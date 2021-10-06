package vezbe;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="datumi")
public class Dao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="day")
	private String day;
	@Column(name="month")
	private String month;
	@Column(name="year")
	private String year;
	@Column(name="date")
	private LocalDate date;
	@Column(name="time")
	private LocalDate time;
	//ako stavim join ona ide u klasu koja own vezu/
	@ManyToOne(cascade = CascadeType.ALL) //  , mappedBy="airline") u onu drugu bez join table, ide u klasu koja ne own vezu
	@JoinColumn(name="per_id")//stavis ovu klasu koju spajas
	//@JoinTable(name="DAO_PERSON", joinColumns=@JoinColumn(name="per_id"),
	//inverseJoinColumns=@JoinColumn(name="id"))
	 private Person person;//= new Person(); //mozda nema geter i seter

	//mozda da dodam konstruktore
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getTime() {
		return time;
	}
	public void setTime(LocalDate time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return "Dan: "+day+ " mesec: "+month+" Godina: "+year;
	}
}

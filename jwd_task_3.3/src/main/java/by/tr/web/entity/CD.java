package by.tr.web.entity;


import java.io.Serializable;

public class CD implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private final int PRIME = 31;
	
	private int id;
	private String title;
	private String artist;
	private String country;
	private String company;
	private double price;
	private int year;
	

	public CD(){ }

	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	public String getArtist(){
		return artist;
	}

	public void setCountry(String country){
		this.country = country;
	}
	
	public String getCountry(){
		return country;
	}

	public void setCompany(String company){
		this.company = company;
	}
	
	public String getCompany(){
		return company;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public int getYear(){
		return year;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = PRIME * result + ((artist == null) ? 0 : artist.hashCode());
		result = PRIME * result + ((company == null) ? 0 : company.hashCode());
		result = PRIME * result + ((country == null) ? 0 : country.hashCode());
		result = PRIME * result + ((title == null) ? 0 : title.hashCode());
		result = PRIME * result + id;
		result = PRIME * result + (int)price;
		result = PRIME * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CD other = (CD) obj;
		if (artist == null) {
			if (other.artist != null) {
				return false;
			}
		} else if (!artist.equals(other.artist)) {
			return false;
		}
		if (company == null) {
			if (other.company != null) {
				return false;
			}
		} else if (!company.equals(other.company)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (year != other.year) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CD [ id=" + id + 
				", title=" + title + 
				", artist=" + artist + 
				", country=" + country + 
				", company=" + company + 
				", price=" + price + 
				", year=" + year + "]";
	}

}

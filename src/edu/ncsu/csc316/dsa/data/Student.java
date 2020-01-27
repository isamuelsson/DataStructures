package edu.ncsu.csc316.dsa.data;

/**
 * A student is comparable and identifiable.
 * Students have a first name, last name, id number, 
 * number of credit hours, gpa, and unityID.
 * 
 * @author Isabella Samuelsson
 *
 */
public class Student implements Comparable<Student>, Identifiable {
	/** first name */
	private String first;
	/** last name */
	private String last;
	/** id */
	private int id;
	/** credit hours */
	private int creditHours;
	/** gpa */
	private double gpa;
	/** unity id */
	private String unityID;
	
	/**
	 * Creates a student object.
	 * @param first first name
	 * @param last last name
	 * @param id student id
	 * @param creditHours credit hours
	 * @param gpa student gpa
	 * @param unityID unityId
	 */
	public Student(String first, String last, int id, int creditHours, double gpa, String unityID) {
		setFirst(first);
		setLast(last);
		setId(id);
		setCreditHours(creditHours);
		setGpa(gpa);
		setUnityID(unityID);
	}
	
	
	
	/**
	 * Creates a string representation of a student using all fields.
	 * @return String representation of an object
	 */
	@Override
	public String toString() {
		return "Student first=" + first + ", last=" + last + ", id=" + id + ", creditHours=" + creditHours + ", gpa="
				+ gpa + ", unityID=" + unityID;
	}



	/**
	 * Creates a hashcode for an object.        
	 * @return hashcode value
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditHours;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((unityID == null) ? 0 : unityID.hashCode());
		return result;
	}



	/**
	 * Returns if two students are the same. Evaluation based on first name, last name and student ID.
	 * @return true/false depending on if the objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		if (first == null) {
			return false;
		} else if (!first.equals(other.first))
			return false;
		if (id != other.id)
			return false;
		if (last == null) {
			return false;
		} else if (!last.equals(other.last))
			return false;
		return true;
	}




	/**
	 * Returns a students first name.
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}




	/**
	 * Sets a students first name.
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}




	/**
	 * Returns a students first name.
	 * @return the last
	 */
	public String getLast() {
		return last;
	}




	/**
	 * Sets a students last name.
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	
	
	/**
	 * Returns a students last name.
	 * @return the id
	 */
	public int getId() {
		return id;
	}




	/**
	 * Sets a students id.
	 * @param id a students id 
	 */
	public void setId(int id) {
		this.id = id;
	}




	/**
	 * Returns a students credit hours.
	 * @return the creditHours
	 */
	public int getCreditHours() {
		return creditHours;
	}




	/**
	 * Sets a students credit hours.
	 * @param creditHours a students credit hours
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}




	/**
	 * Returns a students gpa.
	 * @return the gpa
	 */
	public double getGpa() {
		return gpa;
	}




	/**
	 * Sets a students gpa.
	 * @param gpa a students gpa to set
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}




	/**
	 * Returns a students unityid.
	 * @return the unityID
	 */
	public String getUnityID() {
		return unityID;
	}




	/**
	 * Sets a students unityid.
	 * @param unityID a students unityID to set
	 */
	public void setUnityID(String unityID) {
		this.unityID = unityID;
	}



	/**
	 * Compares two students and determines their order.
	 * @param o student comparing against
	 */
	@Override
	public int compareTo(Student o) {
		if(this.last.compareTo(o.last) == 0) {
			if(this.first.compareTo(o.first) == 0) {
				if(this.id == o.id) {
					return 0;
				}
				if(this.id < o.id) {
					System.out.println(this.last.compareTo(o.last));
					return -1;
				}
				System.out.println(this.last.compareTo(o.last));
				return 1;
			}
			System.out.println(this.last.compareTo(o.last));
			if(this.first.compareTo(o.first) > 0) {
				return 1;
			}
			return -1;
		}
		System.out.println(this.last.compareTo(o.last));
		if(this.last.compareTo(o.last) > 0) {
			return 1;
		}
		return -1;
	}
}

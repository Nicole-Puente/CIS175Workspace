/**
 * @author Nicole Puente - npuente
 * CIS175 - Spring 2024
 * Feb 1, 2024
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CofeeBeanOrders")
public class RoastInventory {
	@Id
	@GeneratedValue
	private int roastId;
	private String roastName;
	private String roastType;
	/**
	 * constructors
	 */
	public RoastInventory() {
		super();
	}
	/**
	 * @param roastName
	 * @param roastType
	 */
	public RoastInventory(String roastName, String roastType) {
		super();
		this.roastName = roastName;
		this.roastType = roastType;
	}
	
	//getters and setters
	
	/**
	 * @return the roastId
	 */
	public int getRoastId() {
		return roastId;
	}
	/**
	 * @param roastId the roastId to set
	 */
	public void setRoastId(int roastId) {
		this.roastId = roastId;
	}
	/**
	 * @return the roastName
	 */
	public String getRoastName() {
		return roastName;
	}
	/**
	 * @param roastName the roastName to set
	 */
	public void setRoastName(String roastName) {
		this.roastName = roastName;
	}
	/**
	 * @return the roastType
	 */
	public String getRoastType() {
		return roastType;
	}
	/**
	 * @param roastType the roastType to set
	 */
	public void setRoastType(String roastType) {
		this.roastType = roastType;
	}
	
	
	public String returnRoastDetails() {
		return this.roastName + ":" + this.roastType;
	}
	
	

}

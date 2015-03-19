package com.addrbook.json;

/**
 * Specialized person data for REST layer.
 * 
 * @author Trey
 */
public class PersonJson {

	private Integer id;
	private String  fullname;


	public Integer getId() {
		return id;
	}
    public String getFullname() {
        return fullname;
    }

	public void setId(Integer id) {
		this.id = id;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}

package com.revature.repository.DTO;

import java.util.Objects;

public class AccessTypesDTO {
	
	protected Integer access_level;
	protected String lvlname;
	
	public AccessTypesDTO(Integer access_level, String lvlname) {
		super();
		this.access_level = access_level;
		this.lvlname = lvlname;
	}
	public Integer getAccess_level() {
		return access_level;	
	}
	
	public void setAccess_level(Integer access_level) {
		this.access_level = access_level;	
	}
	
	public String getLvlname() {
		return lvlname;
	}
	
	public void setLvlname(String lvlname) {
		this.lvlname = lvlname;
	}
	@Override
	public int hashCode() {
		return Objects.hash(access_level, lvlname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccessTypesDTO other = (AccessTypesDTO) obj;
		return Objects.equals(access_level, other.access_level) && Objects.equals(lvlname, other.lvlname);
	}
}

package com.org.dabbaa.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = Role.class, name = "Role"), @JsonSubTypes.Type(value = UserRole.class, name = "UserRole")})

public abstract class ConfigMaster {
	
	@Override
	public abstract String toString();

}

package com.itc.apti.entity;

public interface Processor<I,O> {
	
	O get(I i);

}

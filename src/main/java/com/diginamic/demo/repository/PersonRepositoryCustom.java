package com.diginamic.demo.repository;

public interface PersonRepositoryCustom {
	public void insertMany(final int count);
	public void deleteWhereAnimalsIsEmpty();
}
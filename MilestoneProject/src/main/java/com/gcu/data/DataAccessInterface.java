package com.gcu.data;

import java.util.List;
/**
 * Allows services to interact with a data source
 * @param <T> The entity type that the data service will manage
 */
public interface DataAccessInterface <T> {
	/**
	 * Returns all records of the given entity type.
	 * @return A list containing all entities stored in the database.
	 */
	public List<T> findAll();
	/**
	 * Finds a single entity using its id
	 * 
	 * @param id the primary key of the entity
	 * @return The entity if found, or else return null
	 */
	public T findById(int id);
	/**
	 * Creates a new record in the database.
	 * 
	 * @param t The entity to be created
	 * @return true if the record was successfully created, false otherwise.
	 */
	public boolean create(T t);
	
	/**
	 * Updates an existing record in the database.
	 * 
	 * @param t The entity containing updated information
	 * @return true if the update was successful, false otherwise
	 */
	public boolean update (T t);
	/**
	 * Deletes a record from the database
	 * 
	 * @param id The primary key of the entity to delete
	 * @return true if the record was deleted successfully
	 */
	public boolean delete (int id);
}

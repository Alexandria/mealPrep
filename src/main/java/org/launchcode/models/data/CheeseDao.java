package org.launchcode.models.data;

import org.launchcode.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by LaunchCode
 */

// this tells spring that this interface is an repository
    // this will tell Spring to create a class that implements this interface
@Repository
// this will force all methods to be wrapped by a transaction
@Transactional
public interface CheeseDao extends CrudRepository<Cheese, Integer> {
}

//This interface will alow us to interact with the data base and
//        retrieved objects from the database
//CRUD will provide  a bunch of ways for use to interact with the data in our database
//IE add or remove data
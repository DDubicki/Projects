package com.codecool.supersprinter3000.repository;

import com.codecool.supersprinter3000.model.UserStory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserStoryRepository extends CrudRepository<UserStory, Long> {

    /*
        Methods that are absent in CrudRepository
     */

    //    @Query("SELECT u from UserStory u")
    List<UserStory> findAllByEstimation(double estimation);



}

package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepositoryStub implements ActivityRepository {

    @Override
    public List<Activity> findAllActivities() {

        List<Activity> activities = new ArrayList<>();

        Activity activity_1 = new Activity();
        activity_1.setDescription("Swimming");
        activity_1.setDuration(55);

        Activity activity_2 = new Activity();
        activity_2.setDescription("Cycling");
        activity_2.setDuration(120);

        activities.add(activity_1);
        activities.add(activity_2);

        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {

        if (activityId.equals("7777")) {
            return null;
        }
        Activity activity_1 = new Activity();
        activity_1.setDescription("Running");
        activity_1.setDuration(33);
        activity_1.setId(activityId);

        User user = new User();
        user.setId("youuuuuser");
        user.setName("Edward");

        activity_1.setUser(user);

        return activity_1;
    }

    @Override
    public void create(Activity activity) {

        // issue insert statement into db
    }

    @Override
    public Activity update(Activity activity) {

        Activity updatedActivity;
        // search db for existing activity w/ same id
        // insert if resultSet empty
        // else update that activity
        updatedActivity = activity; // from db

        return updatedActivity;
    }

}

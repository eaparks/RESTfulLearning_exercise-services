package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;
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

    @Override
    public void delete(String activityId) {

        System.out.println("activityId in delete method is: " + activityId);
        // delete from activity where activityId = ?
    }

    @Override
    public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {

        // select * from activities
        // where description in (?,?,?)
        // and duration > ? and duration < ?

        Activity activity = new Activity();
        activity.setDescription("running");
        activity.setDuration(10);
        activity.setId("2345");

        List<Activity> activities = new ArrayList<>();
        activities.add(activity);

        return activities;
    }

    @Override
    public List<Activity> findByConstraints(ActivitySearch search) {

        System.out.println(search.getDurationFrom());
        System.out.println(search.getSearchType());

        Activity activity = new Activity();
        activity.setDescription("running");
        activity.setDuration(10);
        activity.setId("2345");

        List<Activity> activities = new ArrayList<>();
        activities.add(activity);

        return activities;
    }

}

package com.pluralsight.repository;

import com.pluralsight.model.Activity;

import java.util.List;

public interface ActivityRepository {

    List<Activity> findAllActivities();

    Activity findActivity(String activityId);

    void create(Activity activity);

    Activity update(Activity activity);

    void delete(String activityId);
}

package com.pluralsight;

import com.pluralsight.client.ActivitySearchClient;
import com.pluralsight.model.Activity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ActivitySearchResourceTest {

    @Test
    public void searchForActivities() {

        ActivitySearchClient client = new ActivitySearchClient();

        String param = "description";
        List<String> searchValues = new ArrayList<>();
        searchValues.add("swimming");
        searchValues.add("running");

        String secondParam = "durationFrom";
        int durationFrom = 30;

        String thirdParam = "durationTo";
        int durationTo =55;

        List<Activity> activities = client.search(param, searchValues, secondParam, durationFrom,
                thirdParam, durationTo);

        System.out.println("activities: " + activities);

        assertNotNull(activities);
    }
}
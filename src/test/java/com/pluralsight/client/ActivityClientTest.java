package com.pluralsight.client;

import com.pluralsight.model.Activity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ActivityClientTest {

    @Test
    public void put() {

        Activity activity = new Activity();
        activity.setId("3456");
        activity.setDescription("Bikram yoga");
        activity.setDuration(90);

        ActivityClient client = new ActivityClient();

        activity = client.update(activity);

        assertNotNull(activity);
    }

    @Test
    public void create() {

        ActivityClient client = new ActivityClient();

        Activity activity = new Activity();
        activity.setDescription("swimming");
        activity.setDuration(66);

        activity = client.create(activity);

        assertNotNull(activity);
    }

    @Test
    public void get() {

        ActivityClient client = new ActivityClient();
        Activity activity = client.get("12345");

        System.out.println(activity);

        assertNotNull(activity);
    }

    @Test
    public void testGetList() {

        ActivityClient client = new ActivityClient();

        List<Activity> activityList = client.get();

        System.out.println(activityList);

        assertNotNull(activityList);
    }

    @Test(expected = RuntimeException.class)
    public void getWithBadRequest() {

        ActivityClient client = new ActivityClient();
        client.get("132");
    }

    @Test(expected = RuntimeException.class)
    public void getWithNotFound() {

        ActivityClient client = new ActivityClient();
        client.get("7777");
    }
}
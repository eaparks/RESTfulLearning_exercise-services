package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.accessibility.AccessibleIcon;
import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("activities")     // http://localhost:8080/exercise-services/webapi/activities
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() {

        return activityRepository.findAllActivities();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}")    // http://localhost:8080/exercise-services/webapi/activities/1234
    public Response getActivity(@PathParam("activityId") String activityId) {

        if(activityId == null || activityId.length() < 4) {
            return Response.status(Response.Status.BAD_REQUEST).build();    // 400
        }

        Activity activity = activityRepository.findActivity(activityId);

        if(activity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();  // 404
        }

        return Response.ok().entity(activity).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}/user")   // http://localhost:8080/exercise-services/webapi/activities/1234/user
    public User getActivityUser(@PathParam("activityId") String activityId) {

        return activityRepository.findActivity(activityId).getUser();
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {

        System.out.println(activity.getDescription());
        System.out.println(activity.getDuration());

        activityRepository.create(activity);

        return activity;
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {

        System.out.println(formParams.getFirst("description"));
        System.out.println(formParams.getFirst("duration"));

        Activity activity = new Activity();
        activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
        activity.setDescription(formParams.getFirst("description"));

        activityRepository.create(activity);

        return activity;
    }

    @PUT
    @Path("{activityId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response update(Activity activity) {

        System.out.println(activity.getId());

        activity = activityRepository.update(activity);

        return Response.ok().entity(activity).build();
    }
}

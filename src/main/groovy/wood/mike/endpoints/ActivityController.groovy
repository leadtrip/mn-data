package wood.mike.endpoints

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject
import wood.mike.models.Activity
import wood.mike.services.ActivityService

@Controller('/api/activities')
class ActivityController {

    @Inject
    ActivityService activityService

    @Get
    List<Activity> allActivities() {
        activityService.allActivities()
    }

    @Get('/allForLocation')
    List<Activity> allForLocation(@QueryValue String location) {
        activityService.allForLocation(location)
    }

    @Post
    Activity create(@Body Activity activity) {
        activityService.create(activity)
    }
}

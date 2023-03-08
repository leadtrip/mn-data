package wood.mike.services

import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import wood.mike.models.Activity

@Singleton
class ActivityService {

    private static Logger logger = LoggerFactory.getLogger(ActivityService.class)

    @Inject
    ActivityRepository activityRepository

    List<Activity> allActivities() {
        activityRepository.findAll()
    }

    List<Activity> allForLocation( String location ) {
        activityRepository.findAllByLocationName( location )
    }
}

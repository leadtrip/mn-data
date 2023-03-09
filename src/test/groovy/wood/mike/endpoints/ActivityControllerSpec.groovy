package wood.mike.endpoints

import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import wood.mike.models.Activity
import wood.mike.models.Equipment
import wood.mike.models.Location
import wood.mike.services.ActivityRepository

@MicronautTest
class ActivityControllerSpec extends Specification{

    @Inject
    @Client("/api/activities")
    HttpClient httpClient

    @Inject
    ActivityRepository activityRepository

    void "test create"() {
        given:
            Activity activity = new Activity()
            activity.name = 'Brick session'
            activity.location = new Location(name: 'Bath')
            activity.equipment = [new Equipment(name: 'Trainers'), new Equipment(name: 'Bike')]

            HttpRequest<?> request = HttpRequest.POST('/', activity)
        when:
            def response = httpClient.toBlocking().exchange(request, Activity)
        then:
            response.status == HttpStatus.OK
            Activity persistedActivity = activityRepository.findByName(activity.name)
            persistedActivity.id
            persistedActivity.location.id
            persistedActivity.equipment*.id
    }

    void "test findAll"() {
        when:
            HttpRequest<?> request = HttpRequest.GET('/')
            def response = httpClient.toBlocking().exchange(request, Argument.listOf(Activity))
        then:
            response.status == HttpStatus.OK
            response.body().size() == 3 // added in flyway script
    }
}

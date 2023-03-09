package wood.mike.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonValue
import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column

@Serdeable
@MappedEntity('location')
class Location {

    @Id
    @AutoPopulated
    @JsonIgnore
    UUID id

    //@JsonValue  // this works in that only the location name is output in the JSON but it doesn't play well with tests
    @Column
    String name
}

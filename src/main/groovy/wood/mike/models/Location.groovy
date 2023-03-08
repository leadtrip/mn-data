package wood.mike.models


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
    UUID id

    @Column
    String name
}

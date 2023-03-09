package wood.mike.models

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column

@Serdeable
@MappedEntity("equipment")
class Equipment {

    @JsonIgnore
    @Id
    @AutoPopulated
    UUID id

    @Column
    String name
}

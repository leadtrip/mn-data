package wood.mike.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.MappedProperty
import io.micronaut.data.annotation.Relation
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column

@Serdeable
@MappedEntity('heart_rate')
class HeartRate {

    @JsonIgnore
    @Id
    @AutoPopulated
    UUID id

    @Column
    Integer minute

    @Column
    Integer avgHr

    @Relation(
        value = Relation.Kind.MANY_TO_ONE,
        cascade = Relation.Cascade.ALL
    )
    @MappedProperty('activity_id')
    @JsonBackReference
    Activity activity
}

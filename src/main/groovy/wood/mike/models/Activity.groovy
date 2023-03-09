package wood.mike.models

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonManagedReference
import io.micronaut.data.annotation.*
import io.micronaut.data.jdbc.annotation.JoinColumn
import io.micronaut.data.jdbc.annotation.JoinTable
import io.micronaut.data.model.DataType
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column

import java.time.LocalDateTime

@Serdeable
@MappedEntity("activity")
class Activity {

    @Id
    @AutoPopulated
    UUID id

    @Column
    String name

    @Column
    @DateCreated
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime dateCreated

    @Relation(
            value = Relation.Kind.ONE_TO_ONE,
            cascade = Relation.Cascade.PERSIST
    )
    @Column(name = 'location_id')
    Location location

    @JoinTable(
            name = "activity_equipment",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    @Relation(
            value = Relation.Kind.MANY_TO_MANY,
            cascade = Relation.Cascade.PERSIST
    )
    List<Equipment> equipment

    @TypeDef(type = DataType.JSON)
    @Relation(
            value = Relation.Kind.ONE_TO_MANY,
            mappedBy = 'activity',
            cascade = Relation.Cascade.ALL
    )
    @JsonManagedReference
    List<HeartRate> heartRates
}

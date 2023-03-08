package wood.mike.models


import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.data.jdbc.annotation.JoinColumn
import io.micronaut.data.jdbc.annotation.JoinTable
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column

@Serdeable
@MappedEntity("activity")
class Activity {

    @Id
    @AutoPopulated
    UUID id

    @Column
    String name

    @Relation(
        value = Relation.Kind.ONE_TO_ONE
    )
    @Column(name = 'location_id')
    Location location

    @JoinTable(
            name = "activity_equipment",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    @Relation(value = Relation.Kind.MANY_TO_MANY, cascade = Relation.Cascade.PERSIST)
    List<Equipment> equipment
}

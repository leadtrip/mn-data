package wood.mike.services

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import wood.mike.models.Activity

@JdbcRepository(dialect = Dialect.POSTGRES)
interface ActivityRepository extends CrudRepository<Activity, UUID>{

    @Join(value = 'location', type = Join.Type.LEFT_FETCH)
    @Join(value = 'equipment', type = Join.Type.LEFT_FETCH)
    List<Activity> findAll()

    @Join(value = 'location', type = Join.Type.LEFT_FETCH)
    @Join(value = 'equipment', type = Join.Type.LEFT_FETCH)
    List<Activity> findAllByLocationName( String loc )
}

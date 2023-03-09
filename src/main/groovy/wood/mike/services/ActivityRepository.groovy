package wood.mike.services

import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import wood.mike.models.Activity

@Join(value = 'location', type = Join.Type.LEFT_FETCH)
@Join(value = 'equipment', type = Join.Type.LEFT_FETCH)
@Join(value = 'heartRates', type = Join.Type.LEFT_FETCH)
@JdbcRepository(dialect = Dialect.POSTGRES)
interface ActivityRepository extends CrudRepository<Activity, UUID>{

    List<Activity> findAll()

    List<Activity> findAllByLocationName( String loc )

    Activity findByName(String name)
}

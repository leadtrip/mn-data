CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists location (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name varchar(128) not null
);

CREATE TABLE IF NOT EXISTS activity (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name varchar(128) not null,
    location_id UUID not null,

    CONSTRAINT fk_activity_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)
);

create table equipment (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   name varchar(128) not null
);

create table activity_equipment(
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   activity_id UUID not null,
   equipment_id UUID not null,

   CONSTRAINT fk_activity_equipment_activity
   FOREIGN KEY (activity_id)
   REFERENCES activity (id),

   constraint fk_activity_equipment_equipment
   foreign key (equipment_id)
   references equipment(id)
);
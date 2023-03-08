insert into equipment(id, name) values (uuid_generate_v4(), 'Specialized Tarmac');
insert into equipment(id, name) values (uuid_generate_v4(), 'Brooks Adrenaline');
insert into equipment(id, name) values (uuid_generate_v4(), 'Montane jacket');
insert into equipment(id, name) values (uuid_generate_v4(), 'Deuter backpack');

insert into location (id, name) values (uuid_generate_v4(), 'Bath park');
insert into location (id, name) values (uuid_generate_v4(), 'Melksham campus');

insert into activity(id, name, location_id) values (uuid_generate_v4(), 'Brick session 1', (select id from location where name = 'Bath park'));
insert into activity(id, name, location_id) values (uuid_generate_v4(), 'Easy run', (select id from location where name = 'Melksham campus'));

insert into activity_equipment (id, activity_id, equipment_id) values (uuid_generate_v4(), (select id from activity where name = 'Brick session 1'), (select id from equipment where name = 'Specialized Tarmac'));
insert into activity_equipment (id, activity_id, equipment_id) values (uuid_generate_v4(), (select id from activity where name = 'Brick session 1'), (select id from equipment where name = 'Brooks Adrenaline'));

insert into activity_equipment (id, activity_id, equipment_id) values (uuid_generate_v4(), (select id from activity where name = 'Easy run'), (select id from equipment where name = 'Brooks Adrenaline'));
insert into activity_equipment (id, activity_id, equipment_id) values (uuid_generate_v4(), (select id from activity where name = 'Easy run'), (select id from equipment where name = 'Deuter backpack'));
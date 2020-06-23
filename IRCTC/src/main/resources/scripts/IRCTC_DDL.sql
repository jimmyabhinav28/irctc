drop database if exists irctc;
create database irctc;
use irctc;

drop table if exists coach_type;
create table coach_type(
id int(5) not null primary key auto_increment,
coach_class varchar(20),
total_seats int not null, 
window_seats int not null,
aisle_seats int not null,
fare_per_km float(5,2) not null,
created_at timestamp,
updated_at timestamp);


drop table if exists train_details;
create table train_details 
(
id bigint(20) not null primary key auto_increment, 
train_number bigint(10) not null unique,
name varchar(200),
is_active boolean,
created_at timestamp,
updated_at timestamp
);

drop table if exists train_coach;
create table train_coach
(
id bigint(20) not null primary key auto_increment,
train_id bigint(20) not null references train_details(id),
coach_type_id int(5) not null references coach_type(id),
coach_identifier varchar(10) not null,
created_at timestamp,
updated_at timestamp
);

-- put a unique constraint on train coach for train_id,coach_identifier
 

drop table if exists station_details;
create table station_details
(
id bigint(20) primary key not null auto_increment, 
station_code varchar(6) unique not null,
station_name varchar(200),
created_at timestamp,
updated_at timestamp
);


drop table if exists passenger_type;
create table passenger_type
(
id int not null primary key auto_increment,
type_name varchar(20),
type_desc varchar(200),
discount_percentage decimal(4,2),
created_at timestamp,
updated_at timestamp
);

drop table if exists train_schedule;
create table train_schedule
(
id bigint(20) primary key not null auto_increment,
train_id bigint(20) not null references train_details(id),
station_id bigint(20) not null references station_details(id),
stop_number int not null,
source_start_day_of_week int not null,-- Monday, Tuesday, Wed..
arrival_day_of_week int not null, -- Monday, Tuesday, Wed..
arrival_day_from_source int not null,-- integer number 1,2,3
arrival_time time not null, -- arrival time at source can be put as 0
departure_time time not null,
distance_from_source int not null,
created_at timestamp,
updated_at timestamp
);

drop table if exists user;
create table user
(
id bigint(20) primary key not null auto_increment,
given_name varchar(20) not null,
user_name varchar(20) unique not null,
password varchar(20) not null,
email_id varchar(70) unique,
phone_number varchar(20),
created_at timestamp,
updated_at timestamp
);

drop table if exists seat_availability;
create table seat_availability
(
id bigint(20) not null primary key auto_increment,
train_id bigint(20) references train_details(id),
journey_start_date date not null,
coach_type_id int(5) references coach_type(id),
seats_available int(5),
created_at timestamp,
updated_at timestamp
);

-- use indexes in seat availability for faster search, create index on train number and journey_start_date

drop table if exists booking;
create table booking
(
id bigint(20) primary key auto_increment not null,
user_id bigint(20) not null references user(id),
train_id bigint(20) not null references train_details(id),
source_station_id bigint(20) not null references station_details(id),
destination_station_id bigint(20) not null references station_details(id),
journey_start date not null,
status varchar(20) not null, -- status is better modelled as an enum maybe statuses are  pending, confirmed, cancelled
created_at timestamp,
updated_at timestamp
);


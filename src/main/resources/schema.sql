create table if not exists Taco_Order (
id identity,
delivery_Name varchar(50) not null,
delivery_Street varchar(50) not null,
delivery_City varchar(50) not null,
delivery_State varchar(2) not null,
delivery_Zip varchar(10) not null,
cc_number varchar(16) not null,
cc_expiration varchar(5) not null,
cc_cvv varchar(3) not null,
placed_at timestamp WITHOUT TIME ZONE not null);

create table if not exists Taco (
id identity,
name varchar(50) not null,
/*taco_order bigint not null,
taco_order_key bigint not null,*/
created_at timestamp WITHOUT TIME ZONE not null
);
create table if not exists Ingredient_Ref (
id identity,
ingredient_id varchar(4) references Ingredient(id) not null,
taco_id bigint not null references taco(id)
);
create table if not exists Ingredient (
id varchar(4) unique not null,
name varchar(25) not null,
type varchar(10) not null
);


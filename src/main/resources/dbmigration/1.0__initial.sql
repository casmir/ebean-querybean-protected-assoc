-- apply changes
create table product_history (
  id                            bigint(19) not null,
  other                         varchar(50) not null,
  name                          varchar(50),
  constraint pk_product_history primary key (id,other)
);


--prompt Creating PRODUCT...
create table PRODUCT
(
  id NUMBER not null AUTO_INCREMENT,
  name VARCHAR2(1000),
  description VARCHAR2(1000),
  parent_product_id  NUMBER,
  foreign key (parent_product_id) references product(id)
)
;
create unique index IDX_ID_PRODUCT on PRODUCT (ID);

--prompt Creating IMAGE...
create table IMAGE
(
  id NUMBER not null AUTO_INCREMENT,
  image_type VARCHAR2(1000),
  product_id NUMBER,
  foreign key (product_id) references product(id)
)
;
create unique index IDX_ID_IMAGE on IMAGE (ID);
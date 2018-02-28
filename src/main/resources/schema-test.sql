--prompt Creating PRODUCT...
create table PRODUCT
(
  id NUMBER,
  name VARCHAR2(1000),
  description VARCHAR2(1000),
  parent_product_id  NUMBER
)
;
create unique index IDX_ID_PRODUCT on PRODUCT (ID);

--prompt Creating IMAGE...
create table IMAGE
(
  id NUMBER,
  image_type VARCHAR2(1000),
  product_id NUMBER
)
;
create unique index IDX_ID_IMAGE on IMAGE (ID);
create index IDX_FK_PRODUCT on IMAGE (PRODUCT_ID);
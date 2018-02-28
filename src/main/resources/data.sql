--prompt Loading PRODUCT...
insert into PRODUCT (id, name, description)
values (1, 'mouse', 'Gamer mouse');
insert into PRODUCT (id, name, description)
values (2, 'keyboard', 'Microsoft keyboard');
insert into PRODUCT (id, name, description, parent_product_id)
values (3, 'keyboard holder', 'Microsoft keyboard Holder', 2);
--prompt 3 records loaded
--prompt Loading IMAGE...
insert into IMAGE (id, image_type, product_id)
values (1, 'png', 1);
insert into IMAGE (id, image_type, product_id)
values (2, 'jpeg', 1);
insert into IMAGE (id, image_type, product_id)
values (3, 'gif', 2);
--prompt 3 records loaded
--prompt Loading PRODUCT...
insert into PRODUCT (id, name, description)
values (1, 'mouse', 'Gamer mouse');
insert into PRODUCT (id, name, description)
values (2, 'keyboard', 'Microsoft keyboard');
--prompt 2 records loaded
--prompt Loading IMAGE...
insert into IMAGE (id, image_type, product_id)
values (1, 'png', 1);
insert into IMAGE (id, image_type, product_id)
values (2, 'gif', 2);
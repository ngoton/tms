
-- -----------------------------------------------------
-- Table `tms`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`role` ;

CREATE TABLE IF NOT EXISTS `tms`.`role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`staff`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`staff` ;

CREATE TABLE IF NOT EXISTS `tms`.`staff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `staff_code` VARCHAR(20) NULL,
  `full_name` VARCHAR(45) NOT NULL,
  `birth_date` DATE NULL,
  `gender` TINYINT(1) NULL,
  `address` VARCHAR(200) NULL,
  `phone` VARCHAR(20) NULL,
  `email` VARCHAR(45) NULL,
  `id_number` VARCHAR(20) NULL,
  `driver_license` VARCHAR(45) NULL,
  `bank_account` VARCHAR(45) NULL,
  `bank_name` VARCHAR(100) NULL,
  `bank_branch` VARCHAR(100) NULL,
  `position` VARCHAR(45) NULL,
  `department` TINYINT(1) NULL,
  `start_working` DATE NULL,
  `end_working` DATE NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`user` ;

CREATE TABLE IF NOT EXISTS `tms`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `active` TINYINT(1) NULL,
  `staff_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `tms`.`staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`permission` ;

CREATE TABLE IF NOT EXISTS `tms`.`permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`user_has_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`user_has_role` ;

CREATE TABLE IF NOT EXISTS `tms`.`user_has_role` (
  `user_id` INT NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  CONSTRAINT `fk_user_has_role_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `tms`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `tms`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`user_has_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`user_has_permission` ;

CREATE TABLE IF NOT EXISTS `tms`.`user_has_permission` (
  `user_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `permission_id`),
  CONSTRAINT `fk_user_has_permission_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `tms`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `tms`.`permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`role_has_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`role_has_permission` ;

CREATE TABLE IF NOT EXISTS `tms`.`role_has_permission` (
  `role_id` INT(11) NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`),
  CONSTRAINT `fk_role_has_permission_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `tms`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `tms`.`permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`vehicle` ;

CREATE TABLE IF NOT EXISTS `tms`.`vehicle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vehicle_number` VARCHAR(10) NOT NULL,
  `vehicle_symbol` VARCHAR(10) NULL,
  `brand` VARCHAR(45) NULL,
  `model_code` VARCHAR(45) NULL,
  `year_manufacture` YEAR NULL,
  `type` TINYINT(1) NULL,
  `owner` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`romooc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`romooc` ;

CREATE TABLE IF NOT EXISTS `tms`.`romooc` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `romooc_number` VARCHAR(10) NOT NULL,
  `romooc_symbol` VARCHAR(10) NULL,
  `cont_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`lease`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`lease` ;

CREATE TABLE IF NOT EXISTS `tms`.`lease` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lease_date` DATE NULL,
  `expired_date` DATE NULL,
  `price` DECIMAL(10,2) NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_lease_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`vehicle_has_romooc`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`vehicle_has_romooc` ;

CREATE TABLE IF NOT EXISTS `tms`.`vehicle_has_romooc` (
  `vehicle_id` INT NOT NULL,
  `romooc_id` INT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`vehicle_id`, `romooc_id`, `start_date`),
  CONSTRAINT `fk_vehicle_has_romooc_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_has_romooc_romooc1`
    FOREIGN KEY (`romooc_id`)
    REFERENCES `tms`.`romooc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`staff_has_vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`staff_has_vehicle` ;

CREATE TABLE IF NOT EXISTS `tms`.`staff_has_vehicle` (
  `staff_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`staff_id`, `vehicle_id`, `start_date`),
  CONSTRAINT `fk_staff_has_vehicle_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `tms`.`staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_staff_has_vehicle_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`province`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`province` ;

CREATE TABLE IF NOT EXISTS `tms`.`province` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`customer` ;

CREATE TABLE IF NOT EXISTS `tms`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_code` VARCHAR(45) NULL,
  `name` VARCHAR(45) NOT NULL,
  `company` VARCHAR(100) NULL,
  `id_number` VARCHAR(20) NULL,
  `address` VARCHAR(200) NULL,
  `phone` VARCHAR(20) NULL,
  `fax` VARCHAR(20) NULL,
  `email` VARCHAR(45) NULL,
  `bank_account` VARCHAR(45) NULL,
  `bank_name` VARCHAR(100) NULL,
  `bank_branch` VARCHAR(100) NULL,
  `staff_id` INT NULL,
  `province_id` INT NULL,
  `is_supplier` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_customer_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `tms`.`staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_province1`
    FOREIGN KEY (`province_id`)
    REFERENCES `tms`.`province` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`commodity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`commodity` ;

CREATE TABLE IF NOT EXISTS `tms`.`commodity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`contact` ;

CREATE TABLE IF NOT EXISTS `tms`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birth_date` DATE NULL,
  `gender` TINYINT(1) NULL,
  `phone` VARCHAR(20) NULL,
  `email` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_contact_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `tms`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`place`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`place` ;

CREATE TABLE IF NOT EXISTS `tms`.`place` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `longitude` FLOAT NULL,
  `latitude` FLOAT NULL,
  `province_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_place_province1`
    FOREIGN KEY (`province_id`)
    REFERENCES `tms`.`province` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`route`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`route` ;

CREATE TABLE IF NOT EXISTS `tms`.`route` (
  `start` INT NOT NULL,
  `finish` INT NOT NULL,
  `distance` FLOAT NULL,
  `time` FLOAT NULL,
  `way` TINYINT(1) NULL,
  `oil` FLOAT NULL,
  `trans_fee` DECIMAL(10,2) NULL,
  `salary` DECIMAL(10,2) NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL,
  PRIMARY KEY (`start`, `finish`, `start_date`),
  CONSTRAINT `fk_route_place1`
    FOREIGN KEY (`start`)
    REFERENCES `tms`.`place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_route_place2`
    FOREIGN KEY (`finish`)
    REFERENCES `tms`.`place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`road`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`road` ;

CREATE TABLE IF NOT EXISTS `tms`.`road` (
  `start` INT NOT NULL,
  `finish` INT NOT NULL,
  PRIMARY KEY (`start`, `finish`),
  CONSTRAINT `fk_road_place1`
    FOREIGN KEY (`start`)
    REFERENCES `tms`.`place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_road_place2`
    FOREIGN KEY (`finish`)
    REFERENCES `tms`.`place` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`price`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`price` ;

CREATE TABLE IF NOT EXISTS `tms`.`price` (
  `customer_id` INT NOT NULL,
  `commodity_id` INT NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL,
  `unit` TINYINT(1) NULL,
  `price` DECIMAL(10,2) NULL,
  PRIMARY KEY (`customer_id`, `commodity_id`, `start_date`),
  CONSTRAINT `fk_customer_has_commodity1_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `tms`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_commodity1_commodity1`
    FOREIGN KEY (`commodity_id`)
    REFERENCES `tms`.`commodity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`booking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`booking` ;

CREATE TABLE IF NOT EXISTS `tms`.`booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `booking_number` VARCHAR(45) NOT NULL,
  `booking_date` DATE NULL,
  `booking_type` TINYINT(1) NULL,
  `note` VARCHAR(45) NULL,
  `staff_id` INT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_booking_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `tms`.`staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_booking_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `tms`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`invoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`invoice` ;

CREATE TABLE IF NOT EXISTS `tms`.`invoice` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `invoice_number` VARCHAR(20) NOT NULL,
  `invoice_date` DATE NULL,
  `form` VARCHAR(20) NULL,
  `serial` VARCHAR(45) NULL,
  `buyer` VARCHAR(45) NULL,
  `company` VARCHAR(100) NULL,
  `id_number` VARCHAR(20) NULL,
  `address` VARCHAR(200) NULL,
  `payment` VARCHAR(45) NULL,
  `subtotal` DECIMAL(12,2) NULL,
  `tax` DECIMAL(12,2) NULL,
  `tax_rate` FLOAT NULL,
  `total` DECIMAL(12,2) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`shipping_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`shipping_list` ;

CREATE TABLE IF NOT EXISTS `tms`.`shipping_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `shipping_list_date` DATE NULL,
  `shipping_list_number` VARCHAR(45) NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `amount` DECIMAL(12,2) NULL,
  `invoice_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_shipping_list_invoice1`
    FOREIGN KEY (`invoice_id`)
    REFERENCES `tms`.`invoice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`waybill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`waybill` ;

CREATE TABLE IF NOT EXISTS `tms`.`waybill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bill_date` DATE NULL,
  `DO` VARCHAR(45) NULL,
  `cont_number` VARCHAR(45) NULL,
  `receive_quantity` FLOAT NULL,
  `delivery_quantity` FLOAT NULL,
  `unit` TINYINT(1) NULL,
  `receive_date` DATETIME NULL,
  `delivery_date` DATETIME NULL,
  `note` VARCHAR(255) NULL,
  `waybill_type` TINYINT(1) NULL,
  `waybill_from` INT NULL,
  `waybill_to` INT NULL,
  `empty_from` INT NULL,
  `empty_to` INT NULL,
  `shipping_list_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_waybill_shipping_list1`
    FOREIGN KEY (`shipping_list_id`)
    REFERENCES `tms`.`shipping_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`operation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`operation` ;

CREATE TABLE IF NOT EXISTS `tms`.`operation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vehicle_id` INT NOT NULL,
  `booking_id` INT NULL,
  `operation_code` VARCHAR(45) NULL,
  `operation_date` DATE NULL,
  `quantity` FLOAT NULL,
  `unit` TINYINT(1) NULL,
  `note` VARCHAR(255) NULL,
  `road_start` INT NOT NULL,
  `road_finish` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_operation_detail_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operation_detail_booking1`
    FOREIGN KEY (`booking_id`)
    REFERENCES `tms`.`booking` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_operation_road1`
    FOREIGN KEY (`road_start` , `road_finish`)
    REFERENCES `tms`.`road` (`start` , `finish`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`waybill_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`waybill_detail` ;

CREATE TABLE IF NOT EXISTS `tms`.`waybill_detail` (
  `vehicle_id` INT NOT NULL,
  `romooc_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `staff_id` INT NOT NULL,
  `commodity_id` INT NOT NULL,
  `waybill_id` INT NOT NULL,
  PRIMARY KEY (`waybill_id`),
  CONSTRAINT `fk_waybill_detail_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_waybill_detail_romooc1`
    FOREIGN KEY (`romooc_id`)
    REFERENCES `tms`.`romooc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_waybill_detail_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `tms`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_waybill_detail_staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `tms`.`staff` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_waybill_detail_commodity1`
    FOREIGN KEY (`commodity_id`)
    REFERENCES `tms`.`commodity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_waybill_detail_waybill1`
    FOREIGN KEY (`waybill_id`)
    REFERENCES `tms`.`waybill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`cost_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`cost_list` ;

CREATE TABLE IF NOT EXISTS `tms`.`cost_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cost_list_date` DATE NULL,
  `cost_list_number` VARCHAR(45) NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `amount` DECIMAL(12,2) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`cost`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`cost` ;

CREATE TABLE IF NOT EXISTS `tms`.`cost` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `document_number` VARCHAR(45) NULL,
  `document_date` DATE NULL,
  `amount` DECIMAL(10,2) NOT NULL,
  `tax` DECIMAL(10,2) NULL,
  `tax_rate` FLOAT NULL,
  `total` DECIMAL(10,2) NULL,
  `customer_id` INT NULL,
  `driver_payed` TINYINT(1) NULL,
  `cost_type` TINYINT(1) NOT NULL,
  `waybill_id` INT NOT NULL,
  `cost_list_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cost_waybill1`
    FOREIGN KEY (`waybill_id`)
    REFERENCES `tms`.`waybill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cost_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `tms`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cost_cost_list1`
    FOREIGN KEY (`cost_list_id`)
    REFERENCES `tms`.`cost_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`oil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`oil` ;

CREATE TABLE IF NOT EXISTS `tms`.`oil` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `oil_date` DATE NULL,
  `volume` FLOAT NULL,
  `contermet` INT NULL,
  `gps_contermet` INT NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_oil_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`invoice_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`invoice_detail` ;

CREATE TABLE IF NOT EXISTS `tms`.`invoice_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NULL,
  `quantity` FLOAT NULL,
  `price` DECIMAL(12,2) NULL,
  `unit` VARCHAR(20) NULL,
  `amount` DECIMAL(12,2) NULL,
  `invoice_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_invoice_detail_invoice1`
    FOREIGN KEY (`invoice_id`)
    REFERENCES `tms`.`invoice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`bank`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`bank` ;

CREATE TABLE IF NOT EXISTS `tms`.`bank` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `bank_account` VARCHAR(45) NULL,
  `bank_name` VARCHAR(100) NULL,
  `bank_branch` VARCHAR(100) NULL,
  `opening_balance` DECIMAL(12,2) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`fee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`fee` ;

CREATE TABLE IF NOT EXISTS `tms`.`fee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fee_date` DATE NULL,
  `description` VARCHAR(255) NULL,
  `document_number` VARCHAR(45) NULL,
  `document_date` DATE NULL,
  `amount` DECIMAL(10,2) NULL,
  `tax` DECIMAL(10,2) NULL,
  `tax_rate` FLOAT NULL,
  `total` DECIMAL(10,2) NULL,
  `actived` DATE NULL,
  `expired` DATE NULL,
  `divided` INT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_fee_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `tms`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`order` ;

CREATE TABLE IF NOT EXISTS `tms`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_date` DATE NOT NULL,
  `order_number` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `document_number` VARCHAR(45) NULL,
  `document_date` DATE NULL,
  `amount` DECIMAL(10,2) NULL,
  `tax` DECIMAL(10,2) NULL,
  `tax_rate` FLOAT NULL,
  `exchange_rate` FLOAT NULL,
  `currency` VARCHAR(20) NULL,
  `total` DECIMAL(12,2) NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `tms`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`debit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`debit` ;

CREATE TABLE IF NOT EXISTS `tms`.`debit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `debit_date` DATE NOT NULL,
  `total` DECIMAL(12,2) NULL,
  `description` VARCHAR(255) NULL,
  `debit_type` TINYINT(1) NULL,
  `invoice_id` INT NULL,
  `cost_id` INT NULL,
  `cost_list_id` INT NULL,
  `fee_id` INT NULL,
  `order_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_debit_invoice1`
    FOREIGN KEY (`invoice_id`)
    REFERENCES `tms`.`invoice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_debit_cost1`
    FOREIGN KEY (`cost_id`)
    REFERENCES `tms`.`cost` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_debit_fee1`
    FOREIGN KEY (`fee_id`)
    REFERENCES `tms`.`fee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_debit_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `tms`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_debit_cost_list1`
    FOREIGN KEY (`cost_list_id`)
    REFERENCES `tms`.`cost_list` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`transfer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`transfer` ;

CREATE TABLE IF NOT EXISTS `tms`.`transfer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `transfer_date` DATE NOT NULL,
  `transfer_number` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `amount` DECIMAL(12,2) NULL,
  `exchange_rate` FLOAT NULL,
  `total` DECIMAL(12,2) NULL,
  `currency` VARCHAR(20) NULL,
  `transfer_type` TINYINT(1) NULL,
  `bank_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_transfer_bank1`
    FOREIGN KEY (`bank_id`)
    REFERENCES `tms`.`bank` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`balance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`balance` ;

CREATE TABLE IF NOT EXISTS `tms`.`balance` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `balance_date` DATE NULL,
  `amount` DECIMAL(12,2) NULL,
  `exchange_rate` FLOAT NULL,
  `total` DECIMAL(12,2) NULL,
  `currency` VARCHAR(20) NULL,
  `description` VARCHAR(255) NULL,
  `debit_id` INT NULL,
  `transfer_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_balance_debit1`
    FOREIGN KEY (`debit_id`)
    REFERENCES `tms`.`debit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_balance_transfer1`
    FOREIGN KEY (`transfer_id`)
    REFERENCES `tms`.`transfer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`account` ;

CREATE TABLE IF NOT EXISTS `tms`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `parent` INT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`ledger`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`ledger` ;

CREATE TABLE IF NOT EXISTS `tms`.`ledger` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `ledger_date` DATE NOT NULL,
  `money` DECIMAL(12,2) NULL,
  `description` VARCHAR(255) NULL,
  `document_number` VARCHAR(45) NULL,
  `document_date` DATE NULL,
  `debit` INT NOT NULL,
  `credit` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ledger_account1`
    FOREIGN KEY (`debit`)
    REFERENCES `tms`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ledger_account2`
    FOREIGN KEY (`credit`)
    REFERENCES `tms`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`receipt`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`receipt` ;

CREATE TABLE IF NOT EXISTS `tms`.`receipt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `receipt_date` DATE NOT NULL,
  `receipt_number` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `quantity` FLOAT NULL,
  `total` DECIMAL(10,2) NULL,
  `order_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_receipt_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `tms`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`issue`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`issue` ;

CREATE TABLE IF NOT EXISTS `tms`.`issue` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `issue_date` DATE NOT NULL,
  `issue_number` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `quantity` FLOAT NULL,
  `total` DECIMAL(10,2) NULL,
  `invoice_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_issue_invoice1`
    FOREIGN KEY (`invoice_id`)
    REFERENCES `tms`.`invoice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`ledger_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`ledger_detail` ;

CREATE TABLE IF NOT EXISTS `tms`.`ledger_detail` (
  `ledger_id` BIGINT NOT NULL,
  `invoice_id` INT NULL,
  `cost_id` INT NULL,
  `waybill_id` INT NULL,
  `fee_id` INT NULL,
  `balance_id` BIGINT NULL,
  `receipt_id` INT NULL,
  `issue_id` INT NULL,
  PRIMARY KEY (`ledger_id`),
  CONSTRAINT `fk_ledger_detail_ledger1`
    FOREIGN KEY (`ledger_id`)
    REFERENCES `tms`.`ledger` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ledger_detail_invoice1`
    FOREIGN KEY (`invoice_id`)
    REFERENCES `tms`.`invoice` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ledger_detail_cost1`
    FOREIGN KEY (`cost_id`)
    REFERENCES `tms`.`cost` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ledger_detail_waybill1`
    FOREIGN KEY (`waybill_id`)
    REFERENCES `tms`.`waybill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ledger_detail_fee1`
    FOREIGN KEY (`fee_id`)
    REFERENCES `tms`.`fee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ledger_detail_balance1`
    FOREIGN KEY (`balance_id`)
    REFERENCES `tms`.`balance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ledger_detail_receipt1`
    FOREIGN KEY (`receipt_id`)
    REFERENCES `tms`.`receipt` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ledger_detail_issue1`
    FOREIGN KEY (`issue_id`)
    REFERENCES `tms`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`road_has_route`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`road_has_route` ;

CREATE TABLE IF NOT EXISTS `tms`.`road_has_route` (
  `road_start` INT NOT NULL,
  `road_finish` INT NOT NULL,
  `route_start` INT NOT NULL,
  `route_finish` INT NOT NULL,
  `route_start_date` DATE NOT NULL,
  PRIMARY KEY (`road_start`, `road_finish`, `route_start`, `route_finish`, `route_start_date`),
  CONSTRAINT `fk_road_has_route_road1`
    FOREIGN KEY (`road_start` , `road_finish`)
    REFERENCES `tms`.`road` (`start` , `finish`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_road_has_route_route1`
    FOREIGN KEY (`route_start` , `route_finish` , `route_start_date`)
    REFERENCES `tms`.`route` (`start` , `finish` , `start_date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`vehicle_has_fee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`vehicle_has_fee` ;

CREATE TABLE IF NOT EXISTS `tms`.`vehicle_has_fee` (
  `vehicle_id` INT NOT NULL,
  `fee_id` INT NOT NULL,
  PRIMARY KEY (`vehicle_id`, `fee_id`),
  CONSTRAINT `fk_vehicle_has_fee_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_has_fee_fee1`
    FOREIGN KEY (`fee_id`)
    REFERENCES `tms`.`fee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`romooc_has_fee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`romooc_has_fee` ;

CREATE TABLE IF NOT EXISTS `tms`.`romooc_has_fee` (
  `romooc_id` INT NOT NULL,
  `fee_id` INT NOT NULL,
  PRIMARY KEY (`romooc_id`, `fee_id`),
  CONSTRAINT `fk_romooc_has_fee_romooc1`
    FOREIGN KEY (`romooc_id`)
    REFERENCES `tms`.`romooc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_romooc_has_fee_fee1`
    FOREIGN KEY (`fee_id`)
    REFERENCES `tms`.`fee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`accessary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`accessory` ;

CREATE TABLE IF NOT EXISTS `tms`.`accessory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `accessory_code` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `brand` VARCHAR(45) NULL,
  `manufacture` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `tms`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`item` ;

CREATE TABLE IF NOT EXISTS `tms`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `serial` VARCHAR(45) NULL,
  `mfg` DATE NULL,
  `exp` DATE NULL,
  `accessory_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_item_accessory1`
    FOREIGN KEY (`accessory_id`)
    REFERENCES `tms`.`accessory` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`issue_has_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`issue_has_item` ;

CREATE TABLE IF NOT EXISTS `tms`.`issue_has_item` (
  `issue_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `quantity` FLOAT NULL,
  `price` DECIMAL(10,2) NULL,
  `unit` VARCHAR(20) NULL,
  PRIMARY KEY (`issue_id`, `item_id`),
  CONSTRAINT `fk_issue_has_item_issue1`
    FOREIGN KEY (`issue_id`)
    REFERENCES `tms`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_issue_has_item_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `tms`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`receipt_has_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`receipt_has_item` ;

CREATE TABLE IF NOT EXISTS `tms`.`receipt_has_item` (
  `receipt_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `quantity` FLOAT NULL,
  `price` DECIMAL(10,2) NULL,
  `unit` VARCHAR(20) NULL,
  PRIMARY KEY (`receipt_id`, `item_id`),
  CONSTRAINT `fk_receipt_has_item_receipt1`
    FOREIGN KEY (`receipt_id`)
    REFERENCES `tms`.`receipt` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_receipt_has_item_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `tms`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`vehicle_removal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`vehicle_removal` ;

CREATE TABLE IF NOT EXISTS `tms`.`vehicle_removal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `removal_date` DATE NOT NULL,
  `quantity` FLOAT NULL,
  `vehicle_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_removal_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_removal_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `tms`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`romooc_removal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`romooc_removal` ;

CREATE TABLE IF NOT EXISTS `tms`.`romooc_removal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `removal_date` DATE NOT NULL,
  `quantity` FLOAT NULL,
  `romooc_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_romooc_removal_romooc1`
    FOREIGN KEY (`romooc_id`)
    REFERENCES `tms`.`romooc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_romooc_removal_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `tms`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`vehicle_insert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`vehicle_insert` ;

CREATE TABLE IF NOT EXISTS `tms`.`vehicle_insert` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `insert_date` DATE NOT NULL,
  `quantity` FLOAT NULL,
  `vehicle_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `issue_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_vehicle_insert_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `tms`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_insert_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `tms`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_insert_issue1`
    FOREIGN KEY (`issue_id`)
    REFERENCES `tms`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`romooc_insert`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`romooc_insert` ;

CREATE TABLE IF NOT EXISTS `tms`.`romooc_insert` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `insert_date` DATE NOT NULL,
  `quantity` FLOAT NULL,
  `romooc_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `issue_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_romooc_insert_romooc1`
    FOREIGN KEY (`romooc_id`)
    REFERENCES `tms`.`romooc` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_romooc_insert_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `tms`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_romooc_insert_issue1`
    FOREIGN KEY (`issue_id`)
    REFERENCES `tms`.`issue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `tms`.`action`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tms`.`action` ;

CREATE TABLE IF NOT EXISTS `tms`.`action` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `act` VARCHAR(20) NULL,
  `data` TEXT NULL,
  `time` DATETIME NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_action_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `tms`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

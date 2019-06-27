CREATE TABLE `bonus` (
  `bonus_id` int(11) NOT NULL,
  `bonus_plus` decimal(10,0) DEFAULT NULL,
  `bonus_minus` decimal(10,0) DEFAULT NULL,
  `bonus_start_date` int(11) DEFAULT NULL,
  `bonus_end_date` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `booking_date` int(11) DEFAULT NULL,
  `booking_code` varchar(20) DEFAULT NULL,
  `booking_customer` int(11) DEFAULT NULL,
  `booking_number` varchar(100) DEFAULT NULL,
  `booking_type` int(11) DEFAULT NULL COMMENT '1:Hàng nhập | 2:Hàng xuất | 3:Khác',
  `booking_shipping` int(11) DEFAULT NULL,
  `booking_shipping_name` varchar(50) DEFAULT NULL,
  `booking_shipping_number` varchar(50) DEFAULT NULL,
  `booking_place_from` int(11) DEFAULT NULL,
  `booking_place_to` int(11) DEFAULT NULL,
  `booking_start_date` int(11) DEFAULT NULL,
  `booking_end_date` int(11) DEFAULT NULL,
  `booking_comment` text,
  `booking_sum` float DEFAULT NULL,
  `booking_total` decimal(16,2) DEFAULT NULL,
  `booking_create_user` int(11) DEFAULT NULL,
  `booking_update_user` int(11) DEFAULT NULL,
  `booking_status` int(11) DEFAULT NULL COMMENT '1:Đã nhận | 2:Đang chạy | 3:Hoàn thành',
  `booking_sum_receive` float DEFAULT NULL,
  `booking_sum_run` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking_detail`
--

CREATE TABLE `booking_detail` (
  `booking_detail_id` int(11) NOT NULL,
  `booking` int(11) DEFAULT NULL,
  `booking_detail_container` varchar(50) DEFAULT NULL,
  `booking_detail_seal` varchar(50) DEFAULT NULL,
  `booking_detail_number` float DEFAULT NULL,
  `booking_detail_unit` int(11) DEFAULT NULL,
  `booking_detail_customer_sub` varchar(200) DEFAULT NULL,
  `booking_detail_price` decimal(14,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand`
--

CREATE TABLE `brand` (
  `brand_id` int(11) NOT NULL,
  `brand_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `checking_cost`
--

CREATE TABLE `checking_cost` (
  `checking_cost_id` int(11) NOT NULL,
  `checking_cost_date` int(11) DEFAULT NULL,
  `checking_cost_code` varchar(20) DEFAULT NULL,
  `checking_cost_customer` int(11) DEFAULT NULL,
  `checking_cost_vat` decimal(10,0) DEFAULT NULL,
  `checking_cost_price` decimal(10,0) DEFAULT NULL,
  `checking_cost_start_date` int(11) DEFAULT NULL,
  `checking_cost_end_date` int(11) DEFAULT NULL,
  `checking_cost_vehicle` varchar(200) DEFAULT NULL,
  `checking_cost_romooc` varchar(200) DEFAULT NULL,
  `checking_cost_comment` varchar(255) DEFAULT NULL,
  `checking_cost_total_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `contact_person`
--

CREATE TABLE `contact_person` (
  `contact_person_id` int(11) NOT NULL,
  `contact_person_name` varchar(50) DEFAULT NULL,
  `contact_person_address` varchar(100) DEFAULT NULL,
  `contact_person_phone` varchar(20) DEFAULT NULL,
  `contact_person_mobile` varchar(20) DEFAULT NULL,
  `contact_person_birthday` int(11) DEFAULT NULL,
  `contact_person_email` varchar(50) DEFAULT NULL,
  `contact_person_position` varchar(20) DEFAULT NULL,
  `contact_person_department` varchar(20) DEFAULT NULL,
  `contact_person_customer` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `coordinate`
--

CREATE TABLE `coordinate` (
  `coordinate_id` int(11) NOT NULL,
  `coordinate_date` int(11) DEFAULT NULL,
  `coordinate_create_user` int(11) DEFAULT NULL,
  `coordinate_update_user` int(11) DEFAULT NULL,
  `coordinate_code` varchar(20) DEFAULT NULL,
  `coordinate_vehicle` int(11) DEFAULT NULL,
  `coordinate_booking` int(11) DEFAULT NULL,
  `coordinate_booking_number` varchar(100) DEFAULT NULL,
  `coordinate_type` int(11) DEFAULT NULL,
  `coordinate_number` float DEFAULT NULL,
  `coordinate_unit` int(11) DEFAULT NULL,
  `coordinate_place` int(11) DEFAULT NULL,
  `coordinate_comment` text,
  `coordinate_status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cost_list`
--

CREATE TABLE `cost_list` (
  `cost_list_id` int(11) NOT NULL,
  `cost_list_code` varchar(20) DEFAULT NULL,
  `cost_list_name` varchar(50) DEFAULT NULL,
  `cost_list_type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cost_type`
--

CREATE TABLE `cost_type` (
  `cost_type_id` int(11) NOT NULL,
  `cost_type_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `country`
--

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `country_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `customer_code` varchar(50) DEFAULT NULL,
  `customer_name` varchar(100) DEFAULT NULL,
  `customer_company` varchar(200) DEFAULT NULL,
  `customer_mst` varchar(20) DEFAULT NULL,
  `customer_address` varchar(255) DEFAULT NULL,
  `customer_province` int(11) DEFAULT NULL,
  `customer_phone` varchar(20) DEFAULT NULL,
  `customer_mobile` varchar(20) DEFAULT NULL,
  `customer_email` varchar(50) DEFAULT NULL,
  `customer_bank_account` int(11) DEFAULT NULL,
  `customer_bank_name` varchar(50) DEFAULT NULL,
  `customer_bank_branch` varchar(50) DEFAULT NULL,
  `customer_sub` varchar(200) DEFAULT NULL,
  `customer_type` int(11) DEFAULT NULL COMMENT '1:Khách hàng | 2:Đối tác | 3:Cá nhân'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer_sub`
--

CREATE TABLE `customer_sub` (
  `customer_sub_id` int(11) NOT NULL,
  `customer_sub_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `department`
--

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL,
  `department_code` varchar(20) DEFAULT NULL,
  `department_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dispatch`
--

CREATE TABLE `dispatch` (
  `dispatch_id` int(11) NOT NULL,
  `dispatch_date` int(11) DEFAULT NULL,
  `dispatch_code` varchar(20) DEFAULT NULL,
  `dispatch_shipment_temp` int(11) DEFAULT NULL,
  `dispatch_customer` int(11) DEFAULT NULL,
  `dispatch_booking_type` int(11) DEFAULT NULL,
  `dispatch_booking` int(11) DEFAULT NULL,
  `dispatch_booking_detail` int(11) DEFAULT NULL,
  `dispatch_booking_detail_number` float DEFAULT NULL,
  `dispatch_place_from` int(11) DEFAULT NULL,
  `dispatch_place_to` int(11) DEFAULT NULL,
  `dispatch_vehicle` int(11) DEFAULT NULL,
  `dispatch_romooc` int(11) DEFAULT NULL,
  `dispatch_staff` int(11) DEFAULT NULL,
  `dispatch_start_date` int(11) DEFAULT NULL,
  `dispatch_end_date` int(11) DEFAULT NULL,
  `dispatch_port_from` int(11) DEFAULT NULL,
  `dispatch_port_to` int(11) DEFAULT NULL,
  `dispatch_ton` float DEFAULT NULL,
  `dispatch_unit` int(11) DEFAULT NULL,
  `dispatch_comment` text NOT NULL,
  `dispatch_create_user` int(11) DEFAULT NULL,
  `dispatch_update_user` int(11) DEFAULT NULL,
  `dispatch_status` int(11) DEFAULT NULL,
  `dispatch_shipment_number` int(11) DEFAULT NULL,
  `dispatch_shipment_temp_sub` int(11) DEFAULT NULL,
  `dispatch_customer_sub` int(11) DEFAULT NULL,
  `dispatch_booking_type_sub` int(11) DEFAULT NULL,
  `dispatch_booking_sub` int(11) DEFAULT NULL,
  `dispatch_booking_detail_sub` int(11) DEFAULT NULL,
  `dispatch_booking_detail_number_sub` float DEFAULT NULL,
  `dispatch_place_from_sub` int(11) DEFAULT NULL,
  `dispatch_place_to_sub` int(11) DEFAULT NULL,
  `dispatch_start_date_sub` int(11) DEFAULT NULL,
  `dispatch_end_date_sub` int(11) DEFAULT NULL,
  `dispatch_port_from_sub` int(11) DEFAULT NULL,
  `dispatch_port_to_sub` int(11) DEFAULT NULL,
  `dispatch_ton_sub` float DEFAULT NULL,
  `dispatch_unit_sub` int(11) DEFAULT NULL,
  `dispatch_comment_sub` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `driver`
--

CREATE TABLE `driver` (
  `driver_id` int(11) NOT NULL,
  `driver_vehicle` int(11) DEFAULT NULL,
  `driver_staff` int(11) DEFAULT NULL,
  `driver_start_date` int(11) DEFAULT NULL,
  `driver_end_date` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `export_stock`
--

CREATE TABLE `export_stock` (
  `export_stock_id` int(11) NOT NULL,
  `export_stock_code` varchar(50) DEFAULT NULL,
  `export_stock_date` int(11) DEFAULT NULL,
  `export_stock_total` float DEFAULT NULL,
  `export_stock_price` decimal(10,0) DEFAULT NULL,
  `export_stock_vat` decimal(10,0) DEFAULT NULL,
  `export_stock_comment` varchar(255) DEFAULT NULL,
  `export_stock_house` int(11) DEFAULT NULL,
  `export_stock_create_user` int(11) DEFAULT NULL,
  `export_stock_update_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `gas`
--

CREATE TABLE `gas` (
  `gas_id` int(11) NOT NULL,
  `gas_date` int(11) DEFAULT NULL,
  `gas_vehicle` int(11) DEFAULT NULL,
  `gas_km` int(11) DEFAULT NULL,
  `gas_km_gps` int(11) DEFAULT NULL,
  `gas_lit` float DEFAULT NULL,
  `gas_create_user` int(11) DEFAULT NULL,
  `gas_update_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `house`
--

CREATE TABLE `house` (
  `house_id` int(11) NOT NULL,
  `house_code` varchar(20) DEFAULT NULL,
  `house_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import_stock`
--

CREATE TABLE `import_stock` (
  `import_stock_id` int(11) NOT NULL,
  `import_stock_code` varchar(50) DEFAULT NULL,
  `import_stock_date` int(11) DEFAULT NULL,
  `import_stock_total` float DEFAULT NULL,
  `import_stock_price` decimal(10,0) DEFAULT NULL,
  `import_stock_vat` decimal(10,0) DEFAULT NULL,
  `import_stock_comment` varchar(255) DEFAULT NULL,
  `import_stock_invoice_number` varchar(20) DEFAULT NULL,
  `import_stock_invoice_date` int(11) DEFAULT NULL,
  `import_stock_customer` int(11) DEFAULT NULL,
  `import_stock_deliver` varchar(50) DEFAULT NULL,
  `import_stock_deliver_address` varchar(200) DEFAULT NULL,
  `import_stock_house` int(11) DEFAULT NULL,
  `import_stock_create_user` int(11) DEFAULT NULL,
  `import_stock_update_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `import_stock_cost`
--

CREATE TABLE `import_stock_cost` (
  `import_stock_cost_id` int(11) NOT NULL,
  `import_stock_cost_list` int(11) DEFAULT NULL,
  `import_stock_cost_money` decimal(10,0) DEFAULT NULL,
  `import_stock_cost_money_vat` int(11) DEFAULT NULL,
  `import_stock_cost_comment` text,
  `import_stock_cost_customer` int(11) DEFAULT NULL,
  `import_stock_cost_invoice` varchar(20) DEFAULT NULL,
  `import_stock_cost_invoice_date` int(11) DEFAULT NULL,
  `import_stock` int(11) DEFAULT NULL,
  `import_stock_cost_create_user` int(11) DEFAULT NULL,
  `import_stock_cost_update_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `info`
--

CREATE TABLE `info` (
  `info_id` int(11) NOT NULL,
  `info_company` varchar(100) DEFAULT NULL,
  `info_mst` varchar(20) DEFAULT NULL,
  `info_address` varchar(200) DEFAULT NULL,
  `info_phone` varchar(20) DEFAULT NULL,
  `info_email` varchar(50) DEFAULT NULL,
  `info_director` varchar(50) DEFAULT NULL,
  `info_general_accountant` varchar(50) DEFAULT NULL,
  `info_accountant` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `insurance_cost`
--

CREATE TABLE `insurance_cost` (
  `insurance_cost_id` int(11) NOT NULL,
  `insurance_cost_date` int(11) DEFAULT NULL,
  `insurance_cost_code` varchar(20) DEFAULT NULL,
  `insurance_cost_customer` int(11) DEFAULT NULL,
  `insurance_cost_vat` decimal(10,0) DEFAULT NULL,
  `insurance_cost_price` decimal(10,0) DEFAULT NULL,
  `insurance_cost_start_date` int(11) DEFAULT NULL,
  `insurance_cost_end_date` int(11) DEFAULT NULL,
  `insurance_cost_vehicle` varchar(200) DEFAULT NULL,
  `insurance_cost_romooc` varchar(200) DEFAULT NULL,
  `insurance_cost_comment` varchar(255) DEFAULT NULL,
  `insurance_cost_total_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lift`
--

CREATE TABLE `lift` (
  `lift_id` int(11) NOT NULL,
  `lift_on` decimal(10,0) DEFAULT NULL,
  `lift_off` decimal(10,0) DEFAULT NULL,
  `lift_on_null` decimal(10,0) DEFAULT NULL,
  `lift_off_null` decimal(10,0) DEFAULT NULL,
  `lift_unit` int(11) DEFAULT NULL,
  `lift_place` int(11) DEFAULT NULL,
  `lift_start_date` int(11) DEFAULT NULL,
  `lift_end_date` int(11) DEFAULT NULL,
  `lift_customer` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `oil`
--

CREATE TABLE `oil` (
  `oil_id` int(11) NOT NULL,
  `oil_way` varchar(20) DEFAULT NULL,
  `oil_lit` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `place`
--

CREATE TABLE `place` (
  `place_id` int(11) NOT NULL,
  `place_code` varchar(20) DEFAULT NULL,
  `place_name` varchar(50) DEFAULT NULL,
  `place_province` int(11) DEFAULT NULL,
  `place_lat` decimal(10,6) DEFAULT NULL,
  `place_long` decimal(10,6) DEFAULT NULL,
  `place_port` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `port`
--

CREATE TABLE `port` (
  `port_id` int(11) NOT NULL,
  `port_name` varchar(50) DEFAULT NULL,
  `port_province` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `position`
--

CREATE TABLE `position` (
  `position_id` int(11) NOT NULL,
  `position_code` varchar(20) DEFAULT NULL,
  `position_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `province`
--

CREATE TABLE `province` (
  `province_id` int(11) NOT NULL,
  `province_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `repair`
--

CREATE TABLE `repair` (
  `repair_id` int(11) NOT NULL,
  `repair_date` int(11) DEFAULT NULL,
  `repair_number` varchar(20) DEFAULT NULL,
  `repair_code` int(11) DEFAULT NULL,
  `repair_vehicle` int(11) DEFAULT NULL,
  `repair_romooc` int(11) DEFAULT NULL,
  `repair_price` decimal(10,0) DEFAULT NULL,
  `repair_staff` int(11) DEFAULT NULL,
  `repair_create_user` int(11) DEFAULT NULL,
  `repair_update_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `repair_code`
--

CREATE TABLE `repair_code` (
  `repair_code_id` int(11) NOT NULL,
  `repair_code_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `repair_list`
--

CREATE TABLE `repair_list` (
  `repair_list_id` int(11) NOT NULL,
  `repair` int(11) DEFAULT NULL,
  `repair_list_comment` varchar(200) DEFAULT NULL,
  `repair_list_price` decimal(10,0) DEFAULT NULL,
  `repair_list_end_date` int(11) DEFAULT NULL,
  `repair_list_date` int(11) DEFAULT NULL,
  `repair_list_vehicle` int(11) DEFAULT NULL,
  `repair_list_romooc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `road`
--

CREATE TABLE `road` (
  `road_id` int(11) NOT NULL,
  `road_place_from` int(11) DEFAULT NULL,
  `road_place_to` int(11) DEFAULT NULL,
  `road_route_from` int(11) DEFAULT NULL,
  `road_route_to` int(11) DEFAULT NULL,
  `road_time` float DEFAULT NULL,
  `road_km` float DEFAULT NULL,
  `road_oil` float DEFAULT NULL,
  `road_oil_ton` float DEFAULT NULL,
  `road_bridge` decimal(10,0) DEFAULT NULL,
  `road_police` decimal(10,0) DEFAULT NULL,
  `road_tire` decimal(10,0) DEFAULT NULL,
  `road_over` decimal(10,0) DEFAULT NULL,
  `road_add` decimal(10,0) DEFAULT NULL,
  `road_salary` decimal(10,0) DEFAULT NULL,
  `road_start_date` int(11) DEFAULT NULL,
  `road_end_date` int(11) DEFAULT NULL,
  `road_salary_import` decimal(10,0) DEFAULT NULL,
  `road_salary_export` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `road_cost`
--

CREATE TABLE `road_cost` (
  `road_cost_id` int(11) NOT NULL,
  `road_cost_date` int(11) DEFAULT NULL,
  `road_cost_code` varchar(20) DEFAULT NULL,
  `road_cost_customer` int(11) DEFAULT NULL,
  `road_cost_vat` decimal(10,0) DEFAULT NULL,
  `road_cost_price` decimal(10,0) DEFAULT NULL,
  `road_cost_start_date` int(11) DEFAULT NULL,
  `road_cost_end_date` int(11) DEFAULT NULL,
  `road_cost_vehicle` varchar(200) DEFAULT NULL,
  `road_cost_romooc` varchar(200) DEFAULT NULL,
  `road_cost_comment` varchar(255) DEFAULT NULL,
  `road_cost_total_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `road_oil`
--

CREATE TABLE `road_oil` (
  `road_oil_id` int(11) NOT NULL,
  `road` int(11) DEFAULT NULL,
  `road_oil_way` int(11) DEFAULT NULL,
  `road_oil_km` float DEFAULT NULL,
  `road_oil_lit` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `road_toll`
--

CREATE TABLE `road_toll` (
  `road_toll_id` int(11) NOT NULL,
  `road` int(11) DEFAULT NULL,
  `toll` int(11) DEFAULT NULL,
  `road_toll_money` decimal(10,0) DEFAULT NULL,
  `road_toll_vat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_status` int(1) NOT NULL DEFAULT '1' COMMENT '1:active|0:inactive',
  `role_permission` text,
  `role_permission_action` text
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `romooc`
--

CREATE TABLE `romooc` (
  `romooc_id` int(11) NOT NULL,
  `romooc_number` varchar(20) DEFAULT NULL,
  `romooc_license` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `route`
--

CREATE TABLE `route` (
  `route_id` int(11) NOT NULL,
  `route_name` varchar(50) DEFAULT NULL,
  `route_province` int(11) DEFAULT NULL,
  `route_lat` decimal(10,6) DEFAULT NULL,
  `route_long` decimal(10,6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shipdeposit`
--

CREATE TABLE `shipdeposit` (
  `shipdeposit_id` int(11) NOT NULL,
  `shipdeposit_shipping` int(11) DEFAULT NULL,
  `shipdeposit_unit` int(11) DEFAULT NULL,
  `shipdeposit_money` decimal(10,0) DEFAULT NULL,
  `shipdeposit_start_date` int(11) DEFAULT NULL,
  `shipdeposit_end_date` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shipment`
--

CREATE TABLE `shipment` (
  `shipment_id` int(11) NOT NULL,
  `shipment_date` int(11) DEFAULT NULL,
  `shipment_dispatch` int(11) DEFAULT NULL,
  `shipment_customer` int(11) DEFAULT NULL,
  `shipment_type` int(11) DEFAULT NULL,
  `shipment_do` varchar(100) DEFAULT NULL,
  `shipment_vehicle` int(11) DEFAULT NULL,
  `shipment_romooc` int(11) DEFAULT NULL,
  `shipment_staff` int(11) DEFAULT NULL,
  `shipment_booking` int(11) DEFAULT NULL,
  `shipment_booking_detail` int(11) DEFAULT NULL,
  `shipment_container` varchar(20) DEFAULT NULL,
  `shipment_ton_receive` float DEFAULT NULL,
  `shipment_ton` float DEFAULT NULL,
  `shipment_unit` int(11) DEFAULT NULL,
  `shipment_place_from` int(11) DEFAULT NULL,
  `shipment_place_to` int(11) DEFAULT NULL,
  `shipment_start_date` int(11) DEFAULT NULL,
  `shipment_end_date` int(11) DEFAULT NULL,
  `shipment_port_from` int(11) DEFAULT NULL,
  `shipment_port_to` int(11) DEFAULT NULL,
  `shipment_comment` varchar(255) DEFAULT NULL,
  `shipment_create_user` int(11) DEFAULT NULL,
  `shipment_update_user` int(11) DEFAULT NULL,
  `shipment_status` int(11) DEFAULT NULL,
  `shipment_lock` int(11) DEFAULT NULL,
  `shipment_price` decimal(14,2) DEFAULT NULL,
  `shipment_cost` decimal(14,2) DEFAULT NULL,
  `shipment_sub` int(11) DEFAULT NULL,
  `shipment_road` text,
  `shipment_cost_detail` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shipment_cost`
--

CREATE TABLE `shipment_cost` (
  `shipment_cost_id` int(11) NOT NULL,
  `shipment_cost_list` int(11) DEFAULT NULL,
  `shipment_cost_money` decimal(10,0) DEFAULT NULL,
  `shipment_cost_money_vat` int(11) DEFAULT NULL,
  `shipment_cost_comment` text,
  `shipment_cost_customer` int(11) DEFAULT NULL,
  `shipment_cost_invoice` varchar(20) DEFAULT NULL,
  `shipment_cost_invoice_date` int(11) DEFAULT NULL,
  `shipment_cost_shipment` int(11) DEFAULT NULL,
  `shipment_cost_create_user` int(11) DEFAULT NULL,
  `shipment_cost_update_user` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shipment_temp`
--

CREATE TABLE `shipment_temp` (
  `shipment_temp_id` int(11) NOT NULL,
  `shipment_temp_date` int(11) DEFAULT NULL,
  `shipment_temp_owner` int(11) DEFAULT NULL,
  `shipment_temp_booking` int(11) DEFAULT NULL,
  `shipment_temp_status` int(11) DEFAULT NULL,
  `shipment_temp_ton` float DEFAULT NULL,
  `shipment_temp_ton_use` float DEFAULT NULL,
  `shipment_temp_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shipping`
--

CREATE TABLE `shipping` (
  `shipping_id` int(11) NOT NULL,
  `shipping_name` varchar(50) DEFAULT NULL,
  `shipping_country` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `spare_drap`
--

CREATE TABLE `spare_drap` (
  `spare_drap_id` int(11) NOT NULL,
  `spare_part` int(11) DEFAULT NULL,
  `spare_part_number` float DEFAULT NULL,
  `spare_vehicle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `spare_part`
--

CREATE TABLE `spare_part` (
  `spare_part_id` int(11) NOT NULL,
  `spare_part_code` int(11) DEFAULT NULL,
  `spare_part_name` varchar(50) DEFAULT NULL,
  `spare_part_seri` varchar(50) DEFAULT NULL,
  `spare_part_brand` varchar(50) DEFAULT NULL,
  `spare_part_date_manufacture` int(11) DEFAULT NULL,
  `spare_part_unit` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `spare_part_code`
--

CREATE TABLE `spare_part_code` (
  `spare_part_code_id` int(11) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `spare_stock`
--

CREATE TABLE `spare_stock` (
  `spare_stock_id` int(11) NOT NULL,
  `spare_stock_date` int(11) DEFAULT NULL,
  `spare_stock_code` int(11) DEFAULT NULL,
  `spare_part` int(11) DEFAULT NULL,
  `spare_stock_unit` varchar(20) DEFAULT NULL,
  `spare_stock_number` float DEFAULT NULL,
  `spare_stock_price` decimal(10,0) DEFAULT NULL,
  `spare_stock_vat` int(11) DEFAULT NULL,
  `spare_stock_vat_percent` float DEFAULT NULL,
  `spare_stock_vat_price` decimal(10,0) DEFAULT NULL,
  `import_stock` int(11) DEFAULT NULL,
  `export_stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `spare_vehicle`
--

CREATE TABLE `spare_vehicle` (
  `spare_vehicle_id` int(11) NOT NULL,
  `vehicle` int(11) DEFAULT NULL,
  `romooc` int(11) DEFAULT NULL,
  `spare_part` int(11) DEFAULT NULL,
  `start_time` int(11) DEFAULT NULL,
  `end_time` int(11) DEFAULT NULL,
  `spare_part_number` float DEFAULT NULL,
  `export_stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `staff`
--

CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `staff_code` varchar(20) DEFAULT NULL,
  `staff_name` varchar(100) DEFAULT NULL,
  `staff_address` varchar(200) DEFAULT NULL,
  `staff_cmnd` varchar(12) DEFAULT NULL,
  `staff_birthday` int(11) DEFAULT NULL,
  `staff_phone` varchar(15) DEFAULT NULL,
  `staff_email` varchar(50) DEFAULT NULL,
  `staff_bank_account` varchar(20) DEFAULT NULL,
  `staff_bank` varchar(50) DEFAULT NULL,
  `staff_gender` int(11) DEFAULT NULL COMMENT '0:Nam | 1:Nữ',
  `staff_position` int(11) DEFAULT NULL,
  `staff_department` int(11) DEFAULT NULL,
  `staff_start_date` int(11) DEFAULT NULL,
  `staff_end_date` int(11) DEFAULT NULL,
  `staff_account` int(11) DEFAULT NULL,
  `staff_gplx` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `toll`
--

CREATE TABLE `toll` (
  `toll_id` int(11) NOT NULL,
  `toll_code` varchar(50) DEFAULT NULL,
  `toll_name` varchar(200) DEFAULT NULL,
  `toll_mst` varchar(20) DEFAULT NULL,
  `toll_type` int(11) DEFAULT NULL COMMENT '1:Vé thu phí | 2:Cước đường bộ',
  `toll_symbol` varchar(10) DEFAULT NULL,
  `toll_province` int(11) DEFAULT NULL,
  `toll_lat` decimal(11,7) DEFAULT NULL,
  `toll_long` decimal(11,7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `unit`
--

CREATE TABLE `unit` (
  `unit_id` int(11) NOT NULL,
  `unit_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `user_email` varchar(100) DEFAULT NULL,
  `create_time` int(11) NOT NULL,
  `role` int(11) NOT NULL,
  `user_lock` int(11) DEFAULT NULL,
  `user_group` int(11) DEFAULT NULL,
  `user_dept` int(11) DEFAULT NULL,
  `permission` text,
  `permission_action` text,
  `lasted_online` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_log`
--

CREATE TABLE `user_log` (
  `user_log_id` int(11) NOT NULL,
  `user_log` int(11) DEFAULT NULL,
  `user_log_date` int(11) DEFAULT NULL,
  `user_log_table` varchar(50) DEFAULT NULL,
  `user_log_action` varchar(100) DEFAULT NULL,
  `user_log_data` text,
  `user_log_table_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicle_id` int(11) NOT NULL,
  `vehicle_number` varchar(20) DEFAULT NULL,
  `vehicle_brand` varchar(20) DEFAULT NULL,
  `vehicle_model` varchar(20) DEFAULT NULL,
  `vehicle_year` int(11) DEFAULT NULL,
  `vehicle_country` int(11) DEFAULT NULL,
  `vehicle_owner` int(11) DEFAULT NULL COMMENT '1:Thuê',
  `vehicle_oil` float DEFAULT NULL,
  `vehicle_volume` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vehicle_romooc`
--

CREATE TABLE `vehicle_romooc` (
  `vehicle_romooc_id` int(11) NOT NULL,
  `vehicle` int(11) DEFAULT NULL,
  `romooc` int(11) DEFAULT NULL,
  `start_time` int(11) DEFAULT NULL,
  `end_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vehicle_work`
--

CREATE TABLE `vehicle_work` (
  `vehicle_work_id` int(11) NOT NULL,
  `vehicle` int(11) DEFAULT NULL,
  `vehicle_work_start_date` int(11) DEFAULT NULL,
  `vehicle_work_end_date` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `warehouse`
--

CREATE TABLE `warehouse` (
  `warehouse_id` int(11) NOT NULL,
  `warehouse_place` int(11) DEFAULT NULL,
  `warehouse_cont` decimal(14,2) DEFAULT NULL,
  `warehouse_ton` decimal(14,2) DEFAULT NULL,
  `warehouse_add` decimal(14,2) DEFAULT NULL,
  `warehouse_weight` decimal(14,2) DEFAULT NULL,
  `warehouse_clean` decimal(14,2) DEFAULT NULL,
  `warehouse_gate` decimal(14,2) DEFAULT NULL,
  `warehouse_start_date` int(11) DEFAULT NULL,
  `warehouse_end_date` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
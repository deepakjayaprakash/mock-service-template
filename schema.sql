create database mock_service;

CREATE TABLE `api_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `key_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `response_mapping` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
`response` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
);
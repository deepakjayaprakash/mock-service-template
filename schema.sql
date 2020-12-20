create database mock_service;

CREATE TABLE `api_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `key_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `response_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `response_json` json DEFAULT NULL,
  PRIMARY KEY (`id`)
)
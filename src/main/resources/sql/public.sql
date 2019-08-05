/*
 Navicat Premium Data Transfer

 Source Server         : PostgreSQL localhost
 Source Server Type    : PostgreSQL
 Source Server Version : 90603
 Source Host           : localhost:5432
 Source Catalog        : project-builder
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90603
 File Encoding         : 65001

 Date: 14/03/2019 13:06:33
*/


-- ----------------------------
-- Sequence structure for menu_item_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."menu_item_id_seq";
CREATE SEQUENCE "public"."menu_item_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for settings_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."settings_id_seq";
CREATE SEQUENCE "public"."settings_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for step_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."step_id_seq";
CREATE SEQUENCE "public"."step_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sub_menu_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sub_menu_id_seq";
CREATE SEQUENCE "public"."sub_menu_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for template_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."template_id_seq";
CREATE SEQUENCE "public"."template_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for url_catalog_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."url_catalog_id_seq";
CREATE SEQUENCE "public"."url_catalog_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for url_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."url_id_seq";
CREATE SEQUENCE "public"."url_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for url_mapping_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."url_mapping_id_seq";
CREATE SEQUENCE "public"."url_mapping_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for url_view_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."url_view_id_seq";
CREATE SEQUENCE "public"."url_view_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for view_catalog_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."view_catalog_id_seq";
CREATE SEQUENCE "public"."view_catalog_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for view_page_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."view_page_id_seq";
CREATE SEQUENCE "public"."view_page_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for application_property
-- ----------------------------
DROP TABLE IF EXISTS "public"."application_property";
CREATE TABLE "public"."application_property" (
  "key" varchar(255) COLLATE "pg_catalog"."default",
  "value" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for menu_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."menu_item";
CREATE TABLE "public"."menu_item" (
  "id" int8 NOT NULL DEFAULT nextval('menu_item_id_seq'::regclass),
  "value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "url_id" int8 NOT NULL,
  "sub_menu_id" int8 NOT NULL
)
;

-- ----------------------------
-- Table structure for settings
-- ----------------------------
DROP TABLE IF EXISTS "public"."settings";
CREATE TABLE "public"."settings" (
  "id" int8 NOT NULL DEFAULT nextval('settings_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "pom_template" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "start_step_url" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "cancell_step_url" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "finish_step_url" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "default_order_number" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of settings
-- ----------------------------
INSERT INTO "public"."settings" VALUES (1, 'main', 'основные настройки', 'pom', '/new-project/new-project', '/home', '/new-project/finish', NULL);

-- ----------------------------
-- Table structure for step
-- ----------------------------
DROP TABLE IF EXISTS "public"."step";
CREATE TABLE "public"."step" (
  "id" int8 NOT NULL DEFAULT nextval('step_id_seq'::regclass),
  "current_view" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "display_name" varchar(255) COLLATE "pg_catalog"."default",
  "next_view" varchar(255) COLLATE "pg_catalog"."default",
  "order_number" int8 DEFAULT 0,
  "previous_view" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of step
-- ----------------------------
INSERT INTO "public"."step" VALUES (1, '/view/new-project/new-project.xhtml', 'Шаг 1', '/view/not-implemeted.xhtml', 1, '');

-- ----------------------------
-- Table structure for sub_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sub_menu";
CREATE TABLE "public"."sub_menu" (
  "id" int8 NOT NULL DEFAULT nextval('sub_menu_id_seq'::regclass),
  "label" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS "public"."template";
CREATE TABLE "public"."template" (
  "id" int8 NOT NULL DEFAULT nextval('template_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "content" text COLLATE "pg_catalog"."default",
  "order_number" int8,
  "template_type" varchar(255) COLLATE "pg_catalog"."default",
  "parent_id" int8,
  "default_order_number" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO "public"."template" VALUES (2, '111', 'test', 222, NULL, NULL, NULL);
INSERT INTO "public"."template" VALUES (1, 'pom', '<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    
    {{modelVersion}}
    
    {{coordinates}}
    {{packaging}}
    
    {{properties}}
    
</project>', 1, 'POM', NULL, NULL);

-- ----------------------------
-- Table structure for url
-- ----------------------------
DROP TABLE IF EXISTS "public"."url";
CREATE TABLE "public"."url" (
  "id" int8 NOT NULL DEFAULT nextval('url_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "url_catalog_id" int8 NOT NULL
)
;

-- ----------------------------
-- Records of url
-- ----------------------------
INSERT INTO "public"."url" VALUES (2, '', 1);
INSERT INTO "public"."url" VALUES (3, 'list', 3);
INSERT INTO "public"."url" VALUES (4, 'create', 3);
INSERT INTO "public"."url" VALUES (5, 'list', 16);
INSERT INTO "public"."url" VALUES (6, 'create', 16);
INSERT INTO "public"."url" VALUES (7, '2', 2);

-- ----------------------------
-- Table structure for url_catalog
-- ----------------------------
DROP TABLE IF EXISTS "public"."url_catalog";
CREATE TABLE "public"."url_catalog" (
  "id" int8 NOT NULL DEFAULT nextval('url_catalog_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "parent_id" int8
)
;

-- ----------------------------
-- Records of url_catalog
-- ----------------------------
INSERT INTO "public"."url_catalog" VALUES (1, '', NULL);
INSERT INTO "public"."url_catalog" VALUES (2, 'catalog', 1);
INSERT INTO "public"."url_catalog" VALUES (4, 'url-view', 2);
INSERT INTO "public"."url_catalog" VALUES (3, 'url-catalog', 2);
INSERT INTO "public"."url_catalog" VALUES (16, 'url', 2);

-- ----------------------------
-- Table structure for url_mapping
-- ----------------------------
DROP TABLE IF EXISTS "public"."url_mapping";
CREATE TABLE "public"."url_mapping" (
  "id" int8 NOT NULL DEFAULT nextval('url_mapping_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "url" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "view" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of url_mapping
-- ----------------------------
INSERT INTO "public"."url_mapping" VALUES (12, 'specification', '/help/specification', '/view/help/specification.xhtml');
INSERT INTO "public"."url_mapping" VALUES (9, 'template-create', '/template/create', '/view/settings/templateCreate.xhtml');
INSERT INTO "public"."url_mapping" VALUES (8, 'template-list', '/template/list', '/view/settings/templateList.xhtml');
INSERT INTO "public"."url_mapping" VALUES (19, 'finish', '/new-project/finish', '/view/new-project/finish.xhtml');
INSERT INTO "public"."url_mapping" VALUES (3, 'new-application', '/new-project/new-project', '/view/new-project/new-project.xhtml');

-- ----------------------------
-- Table structure for url_view
-- ----------------------------
DROP TABLE IF EXISTS "public"."url_view";
CREATE TABLE "public"."url_view" (
  "id" int8 NOT NULL DEFAULT nextval('url_view_id_seq'::regclass),
  "url_id" int8 NOT NULL,
  "view_id" int8 NOT NULL
)
;

-- ----------------------------
-- Records of url_view
-- ----------------------------
INSERT INTO "public"."url_view" VALUES (1, 2, 1);
INSERT INTO "public"."url_view" VALUES (3, 3, 7);
INSERT INTO "public"."url_view" VALUES (4, 4, 8);
INSERT INTO "public"."url_view" VALUES (5, 5, 9);
INSERT INTO "public"."url_view" VALUES (6, 6, 11);

-- ----------------------------
-- Table structure for view_catalog
-- ----------------------------
DROP TABLE IF EXISTS "public"."view_catalog";
CREATE TABLE "public"."view_catalog" (
  "id" int8 NOT NULL DEFAULT nextval('view_catalog_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "parent_id" int8
)
;

-- ----------------------------
-- Records of view_catalog
-- ----------------------------
INSERT INTO "public"."view_catalog" VALUES (1, '', NULL);
INSERT INTO "public"."view_catalog" VALUES (2, 'view', 1);
INSERT INTO "public"."view_catalog" VALUES (3, 'catalog', 2);
INSERT INTO "public"."view_catalog" VALUES (4, 'url-catalog', 3);
INSERT INTO "public"."view_catalog" VALUES (6, 'url', 3);

-- ----------------------------
-- Table structure for view_page
-- ----------------------------
DROP TABLE IF EXISTS "public"."view_page";
CREATE TABLE "public"."view_page" (
  "id" int8 NOT NULL DEFAULT nextval('view_page_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "view_catalog_id" int8
)
;

-- ----------------------------
-- Records of view_page
-- ----------------------------
INSERT INTO "public"."view_page" VALUES (1, 'index.xhtml', 1);
INSERT INTO "public"."view_page" VALUES (2, 'not-implemeted.xhtml', 2);
INSERT INTO "public"."view_page" VALUES (8, 'create.xhtml', 4);
INSERT INTO "public"."view_page" VALUES (7, 'list.xhtml', 4);
INSERT INTO "public"."view_page" VALUES (9, 'list.xhtml', 6);
INSERT INTO "public"."view_page" VALUES (11, 'create.xhtml', 6);

-- ----------------------------
-- View structure for url_view_mapping
-- ----------------------------
DROP VIEW IF EXISTS "public"."url_view_mapping";
CREATE VIEW "public"."url_view_mapping" AS  SELECT '

 SELECT uv.url_id,
    uv.view_id,
    ((u.location)::text || (u.name)::text) AS url_full,
    ((v.location)::text || (v.name)::text) AS view_full
   FROM ((url_view uv
     JOIN url u ON ((uv.url_id = u.id)))
     JOIN view_page v ON ((uv.view_id = v.id)))
		 
		 ';

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."menu_item_id_seq"
OWNED BY "public"."menu_item"."id";
SELECT setval('"public"."menu_item_id_seq"', 2, false);
ALTER SEQUENCE "public"."settings_id_seq"
OWNED BY "public"."settings"."id";
SELECT setval('"public"."settings_id_seq"', 2, true);
ALTER SEQUENCE "public"."step_id_seq"
OWNED BY "public"."step"."id";
SELECT setval('"public"."step_id_seq"', 4, true);
ALTER SEQUENCE "public"."sub_menu_id_seq"
OWNED BY "public"."sub_menu"."id";
SELECT setval('"public"."sub_menu_id_seq"', 2, false);
ALTER SEQUENCE "public"."template_id_seq"
OWNED BY "public"."template"."id";
SELECT setval('"public"."template_id_seq"', 6, true);
ALTER SEQUENCE "public"."url_catalog_id_seq"
OWNED BY "public"."url_catalog"."id";
SELECT setval('"public"."url_catalog_id_seq"', 17, true);
ALTER SEQUENCE "public"."url_id_seq"
OWNED BY "public"."url"."id";
SELECT setval('"public"."url_id_seq"', 8, true);
ALTER SEQUENCE "public"."url_mapping_id_seq"
OWNED BY "public"."url_mapping"."id";
SELECT setval('"public"."url_mapping_id_seq"', 20, true);
ALTER SEQUENCE "public"."url_view_id_seq"
OWNED BY "public"."url_view"."id";
SELECT setval('"public"."url_view_id_seq"', 7, true);
ALTER SEQUENCE "public"."view_catalog_id_seq"
OWNED BY "public"."view_catalog"."id";
SELECT setval('"public"."view_catalog_id_seq"', 7, true);
ALTER SEQUENCE "public"."view_page_id_seq"
OWNED BY "public"."view_page"."id";
SELECT setval('"public"."view_page_id_seq"', 12, true);

-- ----------------------------
-- Uniques structure for table menu_item
-- ----------------------------
ALTER TABLE "public"."menu_item" ADD CONSTRAINT "uk_7o1etisp8mf0c7poopcfbee7p" UNIQUE ("value");

-- ----------------------------
-- Primary Key structure for table menu_item
-- ----------------------------
ALTER TABLE "public"."menu_item" ADD CONSTRAINT "menu_item_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table settings
-- ----------------------------
ALTER TABLE "public"."settings" ADD CONSTRAINT "settings_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table step
-- ----------------------------
ALTER TABLE "public"."step" ADD CONSTRAINT "uk_o5fpulpb9pkmlp6gj9yl72ca1" UNIQUE ("current_view");
ALTER TABLE "public"."step" ADD CONSTRAINT "uk_1axvf08xeqlybpkh1wt7xbpyu" UNIQUE ("display_name");
ALTER TABLE "public"."step" ADD CONSTRAINT "uk_stgf0w1x1ideg0r3rgum4l4xc" UNIQUE ("next_view");
ALTER TABLE "public"."step" ADD CONSTRAINT "uk_8ugs39svs9fjte0v9il6a7onr" UNIQUE ("previous_view");

-- ----------------------------
-- Primary Key structure for table step
-- ----------------------------
ALTER TABLE "public"."step" ADD CONSTRAINT "step_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table sub_menu
-- ----------------------------
ALTER TABLE "public"."sub_menu" ADD CONSTRAINT "uk_4lvp7yi9exvd4vwmlw384wgwd" UNIQUE ("label");

-- ----------------------------
-- Primary Key structure for table sub_menu
-- ----------------------------
ALTER TABLE "public"."sub_menu" ADD CONSTRAINT "sub_menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table template
-- ----------------------------
ALTER TABLE "public"."template" ADD CONSTRAINT "template_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table url
-- ----------------------------
ALTER TABLE "public"."url" ADD CONSTRAINT "ukppcity6o9yvbnd8ema308horh" UNIQUE ("name", "url_catalog_id");

-- ----------------------------
-- Primary Key structure for table url
-- ----------------------------
ALTER TABLE "public"."url" ADD CONSTRAINT "url_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table url_catalog
-- ----------------------------
ALTER TABLE "public"."url_catalog" ADD CONSTRAINT "uk_j7pn78p8a9a9kwnimrtaslkwa" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table url_catalog
-- ----------------------------
ALTER TABLE "public"."url_catalog" ADD CONSTRAINT "url_catalog_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table url_mapping
-- ----------------------------
ALTER TABLE "public"."url_mapping" ADD CONSTRAINT "uk_fbuxyfish7r2rbhy64qltc5dr" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table url_mapping
-- ----------------------------
ALTER TABLE "public"."url_mapping" ADD CONSTRAINT "url_mapping_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table url_view
-- ----------------------------
ALTER TABLE "public"."url_view" ADD CONSTRAINT "uk7ddumtkwk9xilaainqc8v7fuk" UNIQUE ("url_id", "view_id");

-- ----------------------------
-- Primary Key structure for table url_view
-- ----------------------------
ALTER TABLE "public"."url_view" ADD CONSTRAINT "url_view_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table view_catalog
-- ----------------------------
ALTER TABLE "public"."view_catalog" ADD CONSTRAINT "uk_jk2ekuh0vpxmfo0x3lwmhccwp" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table view_catalog
-- ----------------------------
ALTER TABLE "public"."view_catalog" ADD CONSTRAINT "view_catalog_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table view_page
-- ----------------------------
ALTER TABLE "public"."view_page" ADD CONSTRAINT "ukonwaswkisfmoa4rtobfu4cihv" UNIQUE ("name", "view_catalog_id");

-- ----------------------------
-- Primary Key structure for table view_page
-- ----------------------------
ALTER TABLE "public"."view_page" ADD CONSTRAINT "view_page_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table menu_item
-- ----------------------------
ALTER TABLE "public"."menu_item" ADD CONSTRAINT "fkkb1l3xrmxw37ukxkierlh655e" FOREIGN KEY ("url_id") REFERENCES "url" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "public"."menu_item" ADD CONSTRAINT "fknw8wsvh49psmnd0y6icms3ja5" FOREIGN KEY ("sub_menu_id") REFERENCES "sub_menu" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table url
-- ----------------------------
ALTER TABLE "public"."url" ADD CONSTRAINT "fktfjn1inma4tt116t1cc0w8ciu" FOREIGN KEY ("url_catalog_id") REFERENCES "url_catalog" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table url_catalog
-- ----------------------------
ALTER TABLE "public"."url_catalog" ADD CONSTRAINT "url_catalog_parent_id_fkey" FOREIGN KEY ("parent_id") REFERENCES "url_catalog" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Keys structure for table url_view
-- ----------------------------
ALTER TABLE "public"."url_view" ADD CONSTRAINT "fk6e6se50qf7oa3mtflf2kmw4e9" FOREIGN KEY ("view_id") REFERENCES "view_page" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "public"."url_view" ADD CONSTRAINT "fkic3qmj2iqmdjbwqbcl1a3ymnm" FOREIGN KEY ("url_id") REFERENCES "url" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table view_page
-- ----------------------------
ALTER TABLE "public"."view_page" ADD CONSTRAINT "fkgbx58e60eluprvf7qpjysy1wf" FOREIGN KEY ("view_catalog_id") REFERENCES "view_catalog" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;

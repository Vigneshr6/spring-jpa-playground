-- "create" "tables"
-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE "category_seq";

CREATE TABLE "category" (
	"category_id" INT DEFAULT NEXTVAL ('category_seq')  PRIMARY KEY,
	"category_name" VARCHAR (255) NOT NULL
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE "brand_seq";

CREATE TABLE "brand" (
	"brand_id" INT DEFAULT NEXTVAL ('brand_seq')  PRIMARY KEY,
	"brand_name" VARCHAR (255) NOT NULL
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE "product_seq";

CREATE TABLE "product" (
	"product_id" INT DEFAULT NEXTVAL ('product_seq')  PRIMARY KEY,
	"product_name" VARCHAR (255) NOT NULL,
	"brand_id" INT NOT NULL,
	"category_id" INT NOT NULL,
	"model_year" INT NOT NULL,
	"list_price" DECIMAL (10, 2) NOT NULL,
	FOREIGN KEY ("category_id") REFERENCES "category" ("category_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("brand_id") REFERENCES "brand" ("brand_id") ON DELETE CASCADE ON UPDATE CASCADE
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE "customer_seq";

CREATE TABLE "customer" (
	"customer_id" INT DEFAULT NEXTVAL ('customer_seq')  PRIMARY KEY,
	"first_name" VARCHAR (255) NOT NULL,
	"last_name" VARCHAR (255) NOT NULL,
	"phone" VARCHAR (25),
	"email" VARCHAR (255) NOT NULL,
	"street" VARCHAR (255),
	"city" VARCHAR (50),
	"state" VARCHAR (25),
	"zip_code" VARCHAR (5)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE "store_seq";

CREATE TABLE "store" (
	"store_id" INT DEFAULT NEXTVAL ('store_seq')  PRIMARY KEY,
	"store_name" VARCHAR (255) NOT NULL,
	"phone" VARCHAR (25),
	"email" VARCHAR (255),
	"street" VARCHAR (255),
	"city" VARCHAR (255),
	"state" VARCHAR (10),
	"zip_code" VARCHAR (5)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE "staff_seq";

CREATE TABLE "staff" (
	"staff_id" INT DEFAULT NEXTVAL ('staff_seq')  PRIMARY KEY,
	"first_name" VARCHAR (50) NOT NULL,
	"last_name" VARCHAR (50) NOT NULL,
	"email" VARCHAR (255) NOT NULL UNIQUE,
	"phone" VARCHAR (25),
	"active" INT NOT NULL,
	"store_id" INT NOT NULL,
	"manager_id" INT,
	FOREIGN KEY ("store_id") REFERENCES "store" ("store_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("manager_id") REFERENCES "staff" ("staff_id") ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE SEQUENCE "order_seq";

CREATE TABLE "order" (
	"order_id" INT DEFAULT NEXTVAL ('order_seq')  PRIMARY KEY,
	"customer_id" INT,
	"order_status" INT NOT NULL,
	-- SQLINES DEMO ***  Pending; 2 = Processing; 3 = Rejected; 4 = Completed
	"order_date" DATE NOT NULL,
	"required_date" DATE NOT NULL,
	"shipped_date" DATE,
	"store_id" INT NOT NULL,
	"staff_id" INT NOT NULL,
	FOREIGN KEY ("customer_id") REFERENCES "customer" ("customer_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("store_id") REFERENCES "store" ("store_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("staff_id") REFERENCES "staff" ("staff_id") ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE "order_item" (
	"order_id" INT,
	"item_id" INT,
	"product_id" INT NOT NULL,
	"quantity" INT NOT NULL,
	"list_price" DECIMAL (10, 2) NOT NULL,
	"discount" DECIMAL (4, 2) NOT NULL DEFAULT 0,
	PRIMARY KEY ("order_id", "item_id"),
	FOREIGN KEY ("order_id") REFERENCES "order" ("order_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("product_id") REFERENCES "product" ("product_id") ON DELETE CASCADE ON UPDATE CASCADE
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE "stock" (
	"store_id" INT,
	"product_id" INT,
	"quantity" INT,
	PRIMARY KEY ("store_id", "product_id"),
	FOREIGN KEY ("store_id") REFERENCES "store" ("store_id") ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY ("product_id") REFERENCES "product" ("product_id") ON DELETE CASCADE ON UPDATE CASCADE
);

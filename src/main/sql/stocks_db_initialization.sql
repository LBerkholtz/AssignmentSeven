/** create the stocks model */

CREATE DATABASE IF NOT EXISTS stocks;

/** create the stocks_info table*/

DROP TABLE IF EXISTS stocks.stock_info CASCADE;
CREATE TABLE stocks.stock_info
(
  id        INT        NOT NULL AUTO_INCREMENT,
  symbol    VARCHAR(4) NOT NULL,
  time      DATETIME   NOT NULL,
  price     DECIMAL(10,2)    NOT NULL,
  PRIMARY KEY (id)
);






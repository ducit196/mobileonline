-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mobileonline
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mobileonline
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mobileonline` DEFAULT CHARACTER SET utf8 ;
USE `mobileonline` ;

-- -----------------------------------------------------
-- Table `mobileonline`.`CATEGORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`CATEGORY` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `PATENT_CATEGORY_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_CATEGORY_CATEGORY_idx` (`PATENT_CATEGORY_ID` ASC),
  CONSTRAINT `fk_CATEGORY_CATEGORY`
    FOREIGN KEY (`PATENT_CATEGORY_ID`)
    REFERENCES `mobileonline`.`CATEGORY` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`MANUFACTURER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`MANUFACTURER` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `IMAGE` VARCHAR(45) NULL,
  `DESCRIPTION` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`PRODUCT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`PRODUCT` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `DESCRIPTION` VARCHAR(45) NULL,
  `PRICE` FLOAT NULL,
  `AMOUNT` FLOAT NULL,
  `LENGTH` FLOAT NULL,
  `WIDTH` FLOAT NULL,
  `HEIGHT` FLOAT NULL,
  `WEIGHT` FLOAT NULL,
  `RAM` FLOAT NULL,
  `ROM` VARCHAR(45) NULL,
  `MANUFACTURER_ID` INT NOT NULL,
  `CATEGORY_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_PRODUCT_MANUFACTURER1_idx` (`MANUFACTURER_ID` ASC),
  INDEX `fk_PRODUCT_CATEGORY1_idx` (`CATEGORY_ID` ASC),
  CONSTRAINT `fk_PRODUCT_MANUFACTURER1`
    FOREIGN KEY (`MANUFACTURER_ID`)
    REFERENCES `mobileonline`.`MANUFACTURER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCT_CATEGORY1`
    FOREIGN KEY (`CATEGORY_ID`)
    REFERENCES `mobileonline`.`CATEGORY` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`ACCOUNT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`ACCOUNT` (
  `ID` INT NOT NULL,
  `USERNAME` VARCHAR(45) NULL,
  `EMAIL` VARCHAR(45) NULL,
  `PASSWORD` VARCHAR(45) NULL,
  `CREATE_TIME` DATE NULL,
  `LAST_ACCESS` DATE NULL,
  `ACTIVE` TINYINT(1) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`ADDRESS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`ADDRESS` (
  `ID` INT NOT NULL,
  `SECTION` VARCHAR(45) NULL,
  `ROAD` VARCHAR(45) NULL,
  `TOWN` VARCHAR(45) NULL,
  `DISTRICT` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`CUSTOMER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`CUSTOMER` (
  `ID` INT NOT NULL,
  `FIRST_NAME` VARCHAR(45) NULL,
  `MIDDLE_NAME` VARCHAR(45) NULL,
  `LAST_NAME` VARCHAR(45) NULL,
  `GENDR` INT NULL,
  `BIRTH_DAY` DATE NULL,
  `PHONE` VARCHAR(45) NULL,
  `ACCOUNT_ID` INT NOT NULL,
  `ADDRESS_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_CUSTOMER_ACCOUNT1_idx` (`ACCOUNT_ID` ASC),
  INDEX `fk_CUSTOMER_ADDRESS1_idx` (`ADDRESS_ID` ASC),
  CONSTRAINT `fk_CUSTOMER_ACCOUNT1`
    FOREIGN KEY (`ACCOUNT_ID`)
    REFERENCES `mobileonline`.`ACCOUNT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CUSTOMER_ADDRESS1`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `mobileonline`.`ADDRESS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`EMPLOYEE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`EMPLOYEE` (
  `ID` INT NOT NULL,
  `FIRST_NAME` VARCHAR(45) NULL,
  `MIDDLE_NAME` VARCHAR(45) NULL,
  `LAST_NAME` VARCHAR(45) NULL,
  `GENDER` INT NULL,
  `BIRTH_DAY` VARCHAR(45) NULL,
  `PHONE` VARCHAR(45) NULL,
  `SALARY` FLOAT NULL,
  `ACCOUNT_ID` INT NOT NULL,
  `ADDRESS_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_EMPLOYEE_ACCOUNT1_idx` (`ACCOUNT_ID` ASC),
  INDEX `fk_EMPLOYEE_ADDRESS1_idx` (`ADDRESS_ID` ASC),
  CONSTRAINT `fk_EMPLOYEE_ACCOUNT1`
    FOREIGN KEY (`ACCOUNT_ID`)
    REFERENCES `mobileonline`.`ACCOUNT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EMPLOYEE_ADDRESS1`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `mobileonline`.`ADDRESS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`PRODUCT_IMAGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`PRODUCT_IMAGE` (
  `ID` INT NOT NULL,
  `URL` VARCHAR(45) NULL,
  `ALTER` VARCHAR(45) NULL,
  `IS_MAIN` TINYINT(1) NULL,
  `PRODUCT_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `PRODUCT_ID`),
  INDEX `fk_PRODUCT_IMAGE_PRODUCT1_idx` (`PRODUCT_ID` ASC),
  CONSTRAINT `fk_PRODUCT_IMAGE_PRODUCT1`
    FOREIGN KEY (`PRODUCT_ID`)
    REFERENCES `mobileonline`.`PRODUCT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`ATTRIBUTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`ATTRIBUTE` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`ATTRIBUTE_VALUE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`ATTRIBUTE_VALUE` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  `ATTRIBUTE_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `ATTRIBUTE_ID`),
  INDEX `fk_ATTRIBUTE_VALUE_ATTRIBUTE1_idx` (`ATTRIBUTE_ID` ASC),
  CONSTRAINT `fk_ATTRIBUTE_VALUE_ATTRIBUTE1`
    FOREIGN KEY (`ATTRIBUTE_ID`)
    REFERENCES `mobileonline`.`ATTRIBUTE` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`PRODUCT_ATTRIBUTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`PRODUCT_ATTRIBUTE` (
  `PRODUCT_ID` INT NOT NULL,
  `ATTRIBUTE_VALUE_ID` INT NOT NULL,
  `ADDITIONAL_PRICE` FLOAT NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`, `ATTRIBUTE_VALUE_ID`),
  INDEX `fk_PRODUCT_ATTRIBUTE_ATTRIBUTE_VALUE1_idx` (`ATTRIBUTE_VALUE_ID` ASC),
  CONSTRAINT `fk_PRODUCT_ATTRIBUTE_PRODUCT1`
    FOREIGN KEY (`PRODUCT_ID`)
    REFERENCES `mobileonline`.`PRODUCT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCT_ATTRIBUTE_ATTRIBUTE_VALUE1`
    FOREIGN KEY (`ATTRIBUTE_VALUE_ID`)
    REFERENCES `mobileonline`.`ATTRIBUTE_VALUE` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`PRODUCT_REVIEW`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`PRODUCT_REVIEW` (
  `ID` INT NOT NULL,
  `REVIEW_RATING` INT NULL,
  `REVIEW_DATE` DATE NULL,
  `REVIEW_CONTENT` VARCHAR(45) NULL,
  `PRODUCT_ID` INT NOT NULL,
  `CUSTOMER_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_PRODUCT_REVIEW_PRODUCT1_idx` (`PRODUCT_ID` ASC),
  INDEX `fk_PRODUCT_REVIEW_CUSTOMER1_idx` (`CUSTOMER_ID` ASC),
  CONSTRAINT `fk_PRODUCT_REVIEW_PRODUCT1`
    FOREIGN KEY (`PRODUCT_ID`)
    REFERENCES `mobileonline`.`PRODUCT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRODUCT_REVIEW_CUSTOMER1`
    FOREIGN KEY (`CUSTOMER_ID`)
    REFERENCES `mobileonline`.`CUSTOMER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`COUPON`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`COUPON` (
  `ID` INT NOT NULL,
  `CODE` VARCHAR(45) NULL,
  `SALE` FLOAT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`SHIPPING`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`SHIPPING` (
  `ID` INT NOT NULL,
  `SHIPPING_TYPE` INT NULL,
  `SHIPPING_COST` FLOAT NULL,
  `ADDRESS_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_SHIPPING_ADDRESS1_idx` (`ADDRESS_ID` ASC),
  CONSTRAINT `fk_SHIPPING_ADDRESS1`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `mobileonline`.`ADDRESS` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mobileonline`.`ORDER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mobileonline`.`ORDER` (
  `ID` INT NOT NULL,
  `DATE_ORDER` DATE NULL,
  `LAST_MODIFIED` DATE NULL,
  `PAYMENT_TYPE` INT NULL,
  `STATUS` INT NULL,
  `COUPON_ID` INT NOT NULL,
  `SHIPPING_ID` INT NOT NULL,
  `CUSTOMER_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ORDER_COUPON1_idx` (`COUPON_ID` ASC),
  INDEX `fk_ORDER_SHIPPING1_idx` (`SHIPPING_ID` ASC),
  INDEX `fk_ORDER_CUSTOMER1_idx` (`CUSTOMER_ID` ASC),
  CONSTRAINT `fk_ORDER_COUPON1`
    FOREIGN KEY (`COUPON_ID`)
    REFERENCES `mobileonline`.`COUPON` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ORDER_SHIPPING1`
    FOREIGN KEY (`SHIPPING_ID`)
    REFERENCES `mobileonline`.`SHIPPING` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ORDER_CUSTOMER1`
    FOREIGN KEY (`CUSTOMER_ID`)
    REFERENCES `mobileonline`.`CUSTOMER` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

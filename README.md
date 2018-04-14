# s18-bookmarks

# Configure dbConn.properties
You will need to configure your dbConn.properties and context.xml files before using this code.
Instructions can be found on ICON.

---

# Databases
These database scripts are for Oracle 11g

Create a 'bookmarks' table to hold some sample data:
---
```
CREATE TABLE bookmarks(
bookmark_id number(38) NOT NULL,
page_name varchar2(255) NOT NULL,
url varchar2(255) NOT NULL,
username varchar2(125) NOT NULL,
category varchar2(125),
description varchar2(255),
date_saved timestamp(6),
date_modified timestamp(6),
CONSTRAINT pk_bookmark_id PRIMARY KEY(bookmark_id)
CONSTRAINT fk_bookmarks_category FOREIGN KEY (category) REFERENCES bookmarks_categories (cat_name)
);

CREATE sequence bookmarks_seq start with 1
increment by 1;

SET DEFINE off;
CREATE OR REPLACE TRIGGER bookmarks_trigger
BEFORE INSERT ON bookmarks
FOR EACH ROW
BEGIN
    :new.bookmark_id := bookmarks_seq.NEXTVAL;
END;

INSERT INTO bookmarks (page_name, url, username, category, description, date_saved, date_modified)
VALUES ('Google', 'https://google.com', 'mike@mike.com', '1', 'The Google home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, category, description, date_saved, date_modified)
VALUES ('ESPN', 'https://espn.com', 'test@test.com', '2', 'The ESPN home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, category, description, date_saved, date_modified)
VALUES ('Facebook', 'https://facebook.com', 'mike@mike.com', '3', 'Facebook's home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO bookmarks (page_name, url, username, category, description, date_saved, date_modified)
VALUES ('Twitter', 'https://twitter.com', 'test@test.com', '3', 'Twitter's home page.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

SELECT * FROM bookmarks;
```

Create a 'categories' table to hold some sample data:
---
```
CREATE TABLE bookmarks_categories(
cat_id number(38) NOT NULL,
cat_name varchar2(255) NOT NULL,
CONSTRAINT pk_cat_id PRIMARY KEY(cat_id)
);

CREATE sequence bookmarks_categories_seq start with 1
increment by 1;

SET DEFINE off;
CREATE OR REPLACE TRIGGER bookmarks_categories_trigger
BEFORE INSERT ON bookmarks_categories
FOR EACH ROW
BEGIN
    :new.cat_id := bookmarks_categories_seq.NEXTVAL;
END;

INSERT INTO bookmarks_categories (cat_name) VALUES ('utiliities');
INSERT INTO bookmarks_categories (cat_name) VALUES ('news');
INSERT INTO bookmarks_categories (cat_name) VALUES ('social media');

SELECT * FROM bookmarks_categories;
```

Create a 'Site Users' table and insert two sample users:
---
```
CREATE TABLE bookmarks_siteusers(
email varchar2(50) NOT NULL,
passwd varchar2(50) NOT NULL,
firstname varchar2(50),
lastname varchar2(50),
CONSTRAINT pk__bookmarks_siteusers PRIMARY KEY (email)
);

INSERT INTO bookmarks_siteusers (email, passwd, firstname, lastname) VALUES ('mike@mike.com', 'password', 'Mike', 'Colbert');
INSERT INTO bookmarks_siteusers (email, passwd, firstname, lastname) VALUES ('test@test.com', 'password', 'Test', 'User');

SELECT * FROM bookmarks_siteusers;
```


Create a 'Users In Roles' table and insert user to role mappings:
---
```
CREATE TABLE bookmarks_usersinroles(
email varchar2(50) NOT NULL,
rolename varchar2(50) NOT NULL,
CONSTRAINT pk_bookmarks_usersinroles PRIMARY KEY (email, rolename)
);

INSERT INTO bookmarks_usersinroles (email, rolename) VALUES ('mike@mike.com', 'admin');
INSERT INTO bookmarks_usersinroles (email, rolename) VALUES ('test@test.com', 'user');

SELECT * FROM bookmarks_usersinroles;
```

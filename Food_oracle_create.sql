/*drop user mustard_chef;
create user mustard_chef identified by admin;
grant connect, resource, dba to mustard_chef;*/

drop table preferences;
drop table instructions;
drop table recipe_ingredients;
drop table ingredient;
drop table history;
drop table recipe;
drop table recipeak_user;
drop table flavor_profile;

drop sequence preferences_seq;
drop sequence instructions_seq;
drop sequence recipe_ingredients_seq;
drop sequence ingredient_seq;
drop sequence history_seq;
drop sequence recipe_seq;
drop sequence user_seq;
drop sequence flavor_profile_seq;

CREATE TABLE Recipeak_User (
	User_id number(10),
	Type varchar2(20),
	Username varchar2(30),
	Password varchar2(30),
	Firstname varchar2(30),
	Lastname varchar2(30),
	constraint USER_PK PRIMARY KEY (User_id));
CREATE sequence USER_SEQ
/
CREATE trigger BI_USER
  before insert on Recipeak_USER
  for each row
begin
  select USER_SEQ.nextval into :NEW.User_id from dual;
end;
/

CREATE TABLE Recipe (
	Recipe_id number(10),
	Name varchar2(100),
	Flavor number(10),
	Creator number(10),
	Privacy varchar2(15),
	Burns number(20),
	Promoted number(2),
	Notes varchar2(400),
	constraint RECIPE_PK PRIMARY KEY (Recipe_id));
CREATE sequence RECIPE_SEQ
/
CREATE trigger BI_RECIPE
  before insert on RECIPE
  for each row
begin
  select RECIPE_SEQ.nextval into :NEW.Recipe_id from dual;
end;
/

CREATE TABLE Recipe_Ingredients (
	RecipeIngredient_id number(10),
	Recipe_id number(10),
	Ingredient number(10),
	Amount number(10),
	Unit varchar2(30),
	constraint RECIPE_INGREDIENTS_PK PRIMARY KEY (RecipeIngredient_id));
CREATE sequence RECIPE_INGREDIENTS_SEQ
/
CREATE trigger BI_RECIPE_INGREDIENTS
  before insert on RECIPE_INGREDIENTS
  for each row
begin
  select RECIPE_INGREDIENTS_SEQ.nextval into :NEW.RecipeIngredient_id from dual;
end;
/

CREATE TABLE Instructions (
	Instruction_id number(10),
	Recipe_id number(10),
	Step_Number number(10),
	Step varchar2(500),
	constraint INSTRUCTIONS_PK PRIMARY KEY (Instruction_id));
CREATE sequence INSTRUCTIONS_SEQ
/
CREATE trigger BI_INSTRUCTIONS
  before insert on INSTRUCTIONS
  for each row
begin
  select INSTRUCTIONS_SEQ.nextval into :NEW.Instruction_id from dual;
end;
/

CREATE TABLE Flavor_Profile (
	Flavor_id number(10),
	Name varchar2(20),
	constraint FLAVOR_PROFILE_PK PRIMARY KEY (Flavor_id));
CREATE sequence FLAVOR_PROFILE_SEQ
/
CREATE trigger BI_FLAVOR_PROFILE
  before insert on FLAVOR_PROFILE
  for each row
begin
  select FLAVOR_PROFILE_SEQ.nextval into :NEW.Flavor_id from dual;
end;
/

CREATE TABLE History (
	History_id number(10),
	User_id number(10),
	Recipe number(10),
	Saved number(2),
	Score number(20),
	Review varchar2(400),
	constraint HISTORY_PK PRIMARY KEY (History_id));
CREATE sequence HISTORY_SEQ
/
CREATE trigger BI_HISTORY
  before insert on HISTORY
  for each row
begin
  select HISTORY_SEQ.nextval into :NEW.History_id from dual;
end;
/

CREATE TABLE Preferences (
	Preferences_id number(10),
	User_id number(10),
	Flavor number(10),
	Score number(5),
	constraint PREFERENCES_PK PRIMARY KEY (Preferences_id));
CREATE sequence PREFERENCES_SEQ
/
CREATE trigger BI_PREFERENCES
  before insert on PREFERENCES
  for each row
begin
  select PREFERENCES_SEQ.nextval into :NEW.Preferences_id from dual;
end;
/

CREATE TABLE Ingredient (
	Ingredient_id number(10),
	Ingredient varchar2(50),
	constraint INGREDIENT_PK PRIMARY KEY (Ingredient_id));
CREATE sequence INGREDIENT_SEQ
/
CREATE trigger BI_INGREDIENT
  before insert on INGREDIENT
  for each row
begin
  select INGREDIENT_SEQ.nextval into :NEW.Ingredient_id from dual;
end;
/


ALTER TABLE Recipe ADD CONSTRAINT Recipe_fk0 FOREIGN KEY (Flavor) REFERENCES Flavor_Profile(Flavor_id);
ALTER TABLE Recipe ADD CONSTRAINT Recipe_fk1 FOREIGN KEY (Creator) REFERENCES Recipeak_User(User_id);

ALTER TABLE Recipe_Ingredients ADD CONSTRAINT Recipe_Ingredients_fk0 FOREIGN KEY (Recipe_id) REFERENCES Recipe(Recipe_id);
ALTER TABLE Recipe_Ingredients ADD CONSTRAINT Recipe_Ingredients_fk1 FOREIGN KEY (Ingredient) REFERENCES Ingredient(Ingredient_id);

ALTER TABLE Instructions ADD CONSTRAINT Instructions_fk0 FOREIGN KEY (Recipe_id) REFERENCES Recipe(Recipe_id);


ALTER TABLE History ADD CONSTRAINT History_fk0 FOREIGN KEY (User_id) REFERENCES Recipeak_User(User_id);
ALTER TABLE History ADD CONSTRAINT History_fk1 FOREIGN KEY (Recipe) REFERENCES Recipe(Recipe_id);

ALTER TABLE Preferences ADD CONSTRAINT Preferences_fk0 FOREIGN KEY (User_id) REFERENCES Recipeak_User(User_id);
ALTER TABLE Preferences ADD CONSTRAINT Preferences_fk1 FOREIGN KEY (Flavor) REFERENCES Flavor_Profile(Flavor_id);
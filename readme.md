This project represents some opportunity to modify our database tables via liquibase

Basically there are two entity as follows.

* Evaluation
* Period

At the beginning there are no relationship between those entites and all of them has only one primary key, columns called id. 

# [1. change set](src/main/resources/db/changelog/000001_create_tables.xml)
* creates own sequences for the two different, non-existing entities
* creates tables to represent the entities
* inserts default data from [evaluation.csv](src/main/resources/db/data/evaluation.csv) and [period.csv](src/main/resources/db/data/period.csv)

| evaluations |
|---|
|1|
|2|
|3|
|4|
|5|

| period |
|---|
|1|
|2|

# [2. change set](src/main/resources/db/changelog/000002_add_column.xml)
* adds "period _id" column to "evaluations" table in order to handle a one-to-many relationship between "evaluations" and "periods" tables
* adds a foreign key to period_id to protect the table from wrong data or mistaken modifications
* updates "evaluations"` "period_id" columns with value "1" as a default period id where "period_id" is null, so everywhere because this is column just added to the table at the first step of this change-set. After this change, all evaluation record will be related to the first record from the "periods" table by the end

| evaluation | period |
|---|---|
|1|1|
|2|1|
|3|1|
|4|1|
|5|1|

# [3. change set](src/main/resources/db/changelog/000003_update_period_ids.xml)
* loads and updates "evaluations"` "period_id" columns according the [evaluation_update.csv](src/main/resources/db/data/evaluation_update.csv) which content as follows
```
id;period_id
3;2
4;2
5;2
```

| evaluation | period |
|---|---|
|1|1|
|2|1|
|3|2|
|4|2|
|5|2|

responses

* http://localhost:8080/periods
    ```json
    [
      {
        "id": 1
      },
      {
        "id": 2
      }
    ]
    ```
* http://localhost:8080/evaluations
    ```json
    [
      {
        "id": 1,
        "period": {
          "id": 1
        }
      },
      {
        "id": 2,
        "period": {
          "id": 1
        }
      },
      {
        "id": 3,
        "period": {
          "id": 2
        }
      },
      {
        "id": 4,
        "period": {
          "id": 2
        }
      },
      {
        "id": 5,
        "period": {
          "id": 2
        }
      }
    ]
    ```
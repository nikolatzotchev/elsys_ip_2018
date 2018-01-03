# Домашно №2 - REST

Използвайки за основа Github репозиторито с примерите от час: ([repo](https://github.com/mmitropolitsky/elsys_ip_2018/tree/master/3_REST)), всеки ученик трябва да си избере тема - например *Автомобили*, или *Книги* (всяка тема е уникална за всеки ученик)

* За целта на задаване на условието, задачите ще бъдат описвани с помощта на клас *User[id, firstName, lastName, age, gender, email]*
##### Задачи
- Добавяне на функционалност, позволяваща търсенето по всички полета на обекта поотделно или едновременно през даден ендпойнт **(*20%*)**
-- *Например*: 
```sh
/api/users?firstName=First&lastName=Last&age=20&gender=male&email=asd@asd.com
```
- Ендпойнтът за търсене на `User`-и да поддържа търсене по **списък** от `id`-та **(*20%*)**
-- *Например*: 
```sh
/api/users?id=1&id=2
```
-  Да се добави функционалност за `upload` на *.csv* файл, съдържащ списък с потребители **(*20%*)**
-  Да се добави функционалност за `download` на *.csv* файл, съдържащ списък с всички съществуващи потребители и добавянето им към съществуващия списък **(*20%*)**
- Да се добави функционалност за създаване на множество обекти с една заявка **(*20%*)**
-- *Пояснение*: да се подава **JSON**, съдържащ списък от обекти, като всеки един от тях да се запази към ендпойнт `POST api/users/multiple`


> Всеки ученик трябва да разшири примера от даденото репо, като изпълни задачите на база избраната си тема.

> Eндпойнтите и обектите трябва да са именувани спрямо избраната тема и трябва да се придържат към установените конвенции.

> Темите трябва да бъдат съгласувани с преподавателя и ще бъдат обявени публично, с цел избягване на повторения.

> Срок за предаване на домашно: `16.01.2018, 23:59ч.`
## (PL) Aplikacja Szkoła Programowania
### Dostępna wersja online: www.szak.io/w3

#### Wykorzystane technologie:
* JEE: Servlets + Filters + JSP 
* MySQL
* Bootstrap 4
* Https: Certyfikat SSL
* Logowanie za pomocą BCrypt 
* Wzorce projektowe: Mvc + Dao

#### Funkcje:
* Administracja (Admin panel): CRUD dla Users, Groups, Exercises.
* Panel użytkownika (User panel): CRUD dla rozwiązań (Solutions) dla zalogowanego użytkownika.
* Wyświetlanie ostatnio dodanych, lub zmodyfikowanych rozwiązań na stronie głównej.
* Wyświetlanie grup oraz ich użytkowników.

#### Quick start dla osób chcących przetestować:
* Logujemy się do 'Admin panel' (user/pass) - mamy dostęp do CRUD dla Users, Groups, Exercises.
* Tworzymy swojego użytkownika (hasło jest szyfrowane SHA256 i bezpieczne w bazie danych).
* Logujemy się do 'User panel' i mamy dostęp do CRUD dla rozwiązań dla naszego konta.


## (ENG) Programming school web app
### Deployed online version: www.szak.io/w3

#### Technologies used in project:
* JEE: Servlets + Filters + JSP 
* MySQL
* Bootstrap 4
* Https: SSL Certified
* BCrypt (SHA256) encrypted user password storage
* Design patterns: Mvc + Dao

#### Functions:
* Administration (Admin panel): CRUD for Users, Groups, Exercises.
* User administration (User panel): CRUD for Solutions for the logged in user.
* Lists most recently added or modified solutions. From newest to oldest.
* Lists all user groups, and its users.

#### A quick start for testing purposes:
* Login to 'Admin panel' (user/pass) - you gain access to CRUD for Users, Groups, Exercises.
* Create your own user (the password is encrypted and safely stored in DB).
* Login with your newly created user in 'User panel', and gain CRUD access to your personal Solutions.



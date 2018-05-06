## Warsztat 3 - Aplikacja Szkoła Programowania
### Dostępna wersja online: www.szak.io/w3

#### Wykorzystane technologie:
* JEE: Servlets + Filters + JSP 
* Mysql
* Bootstrap 4
* Https: Certyfikat SSL
* Logowanie za pomocą BCrypt 
* Wzorce projektowe: Mvc + Dao

#### Funkcje:
* Administracja (Admin panel): CRUD dla Users, Groups, Exercises
* Panel użytkownika (User panel): CRUD dla rozwiązań (Solutions) dla zalogowanego użytkownika
* Wyświetlanie ostatnio dodanych, lub zmodyfikowanych rozwiązań na stronie głównej.
* Wyświetlanie grup oraz ich użytkowników

#### Quick start dla osób chcących przetestować:
* Logujemy się do 'Admin panel' (user/pass) - mamy dostęp do CRUD dla Users, Groups, Exercises
* Tworzymy swojego użytkownika (hasło jest szyfrowane SHA256 i bezpieczne w bazie danych).
* Logujemy się do 'User panel' i mamy dostęp do CRUD dla rozwiązań dla naszego konta.

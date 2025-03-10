# Employee Management API

Une API REST pour gérer les employés avec Spring Boot, JPA et Spring Security.

## Fonctionnalités

- **CRUD complet** : Ajouter, modifier, supprimer et récupérer des employés.
- **Sécurisation des endpoints** avec Spring Security et des rôles (`EMPLOYEE`, `MANAGER`, `ADMIN`).
- **Base de données relationnelle** gérée via JPA/Hibernate.
- **Gestion des utilisateurs** avec JDBC pour l’authentification.

## 🛠Technologies utilisées

- **Java 17**  
- **Spring Boot 3** (Spring MVC, Spring Security)  
- **Spring Data JPA** (avec Hibernate)  
- **Base de données** : MySQL 
- **Maven** pour la gestion des dépendances  

## Sécurité

L'accès aux endpoints est restreint en fonction du rôle de l'utilisateur :  

- `GET /api/employees` → **EMPLOYEE, MANAGER, AMIN**
- `GET /api/employees{id}` → **EMPLOYEE, MANAGER, ADMIN**  
- `POST /api/employees` → **MANAGER**  
- `PUT /api/employees` → **MANAGER**  
- `DELETE /api/employees/{id}` → **ADMIN**  

L’authentification se fait via **Basic Auth**.

## Installation et exécution

1. **Cloner le repo**  
   ```sh
   git clone https://github.com/tony044/employee-management-api.git
   ```
   ```sh
   cd employee-management-api
   ```
   
Configurer la base de données
Modifier application.properties selon votre configuration.

## Lancer l’application

Copier - Coller :
```sh
mvn spring-boot:run
```
## Tester l'API
Utiliser Postman ou cURL pour interagir avec les endpoints.

## Structure du projet
```sh
src/main/java/com/luv2code/springboot/cruddemo
│── dao/               # Interface JpaRepository
│── entity/            # Classe Employee (JPA)
│── rest/              # Contrôleur REST (EmployeeRestController)
│── security/          # Config Spring Security (roles, accès)
│── service/           # Service pour la gestion des employés
└── SpringBootApp.java  # Classe principale
```

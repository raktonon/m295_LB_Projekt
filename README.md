# 🍹 Cocktail Backend – Spring Boot (LB 295)

## 📌 Projektbeschreibung
Dieses Projekt ist ein **Spring Boot Backend** für eine Cocktail-Webanwendung.  
Es stellt sowohl eine **interne CRUD-API** als auch eine **öffentliche API im TheCocktailDB-Format** bereit, sodass das M294-Frontend ohne Änderungen weiterverwendet werden kann.

Das Backend nutzt **PostgreSQL** (Docker-Container) als Hauptdatenbank und **H2** als In-Memory-Datenbank für Tests.  
Es wurde nach den Vorgaben der LB 295 modular aufgebaut.

---

## 📂 Projektstruktur
```
src/main/java/com/wiss/cocktailbackend
│
├── config/            # SwaggerConfig, WebConfig
├── controller/        # CocktailController (CRUD), CocktailPublicController (Public API)
├── dto/               # CocktailDTO, CocktailListItemDTO, CocktailApiDto
├── entity/            # Cocktail JPA-Entity
├── mapper/            # CocktailMapper, CocktailApiMapper
├── repository/        # CocktailRepository
├── service/           # CocktailService
└── CocktailBackendApplication.java
```

---

## 🐳 Docker-Setup für PostgreSQL

Das Projekt nutzt PostgreSQL in einem Docker-Container.  
Die Konfiguration ist in der Datei **`docker-compose-cocktails.yml`** enthalten.

### 1️⃣ Docker-Container starten
```bash
docker compose -f docker-compose-cocktails.yml up -d
```
- Erstellt einen Container mit dem Namen `cocktail_postgres`
- Nutzt die Zugangsdaten aus `application.properties`
- Standard-Port: **5433** (falls 5432 bereits belegt ist)

### 2️⃣ Umgebungsvariablen (aus `docker-compose-cocktails.yml`)
```yaml
environment:
  POSTGRES_DB: cocktail_app
  POSTGRES_USER: cocktail_user
  POSTGRES_PASSWORD: cocktail_password
```

### 3️⃣ Container stoppen
```bash
docker compose -f docker-compose-cocktails.yml down
```

### 4️⃣ Initialdaten
Beim ersten Start wird das SQL-Skript **`data.sql`** ausgeführt und befüllt die Datenbank mit Beispieldaten.  
💡 **Hinweis:**  
Falls du die Initialdaten erneut laden möchtest, musst du das zugehörige Docker-Volume löschen:
```bash
docker volume rm <volume-name>
```
(Ersetze `<volume-name>` durch den Namen aus `docker volume ls`, z. B. `cocktail_postgres_data`)

---

## 🗂 API-Endpunkte

### 🔹 **Interne CRUD-API** (`/api/cocktails`)
| Methode | Pfad                      | Beschreibung                      |
|---------|---------------------------|------------------------------------|
| GET     | `/api/cocktails`           | Liste aller Cocktails (Paged)     |
| GET     | `/api/cocktails/{id}`      | Einzelcocktail abrufen            |
| POST    | `/api/cocktails`           | Neuen Cocktail anlegen            |
| PUT     | `/api/cocktails/{id}`      | Cocktail aktualisieren            |
| DELETE  | `/api/cocktails/{id}`      | Cocktail löschen                   |

### 🔹 **Öffentliche API** (`/api/public`)
Im **TheCocktailDB-Format** – kompatibel mit M294-Frontend.
| Methode | Pfad                              | Beschreibung                                   |
|---------|-----------------------------------|-----------------------------------------------|
| GET     | `/api/public/cocktails`           | Array aller Cocktails (max. 100)              |
| GET     | `/api/public/cocktails?q=mojito`  | Suche nach Name                               |
| GET     | `/api/public/cocktails/{id}`      | Einzelcocktail im TheCocktailDB-Format        |

---

## 🧪 Tests
Das Projekt enthält **8 Unit- und Integrationstests**:

- `CocktailApiMapperTest` (API-Mapping)
- `CocktailRepositoryTest` (Suchlogik)
- `CocktailServiceTest` (Fehlerfälle)
- `CocktailPublicControllerTest` (Public API)
- `CocktailMapperTest` (Core-Mapping)
- `CocktailControllerCrudTest` (CRUD-Controller)
- `CocktailPersistenceTest` (JPA Persistenz)

Tests ausführen:
```bash
mvn test
```

---

## 🛠 Technologie-Stack
- **Java 21**
- **Spring Boot 3.5.x**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**
- **H2 Database (Tests)**
- **Jakarta Validation**
- **Swagger / Springdoc OpenAPI**
- **Maven**

---

## 📜 Lizenz
Dieses Projekt wurde im Rahmen der **LB 295 – Backend mit Spring Boot realisieren** erstellt.  
Die Verwendung ist zu Ausbildungszwecken frei.

---

## 👤 Autor
**Sascha Ritter**  


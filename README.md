# Toxic Plant Region Assessment System — Java Edition

Academic project — Programming Languages II  
Developed by Izabella Miranda Silva

---

## Overview

A desktop management system for evaluating regions based on the presence of toxic
and medicinal plants, designed to support environmental risk analysis and monitoring.

Built with Java Swing and backed by a relational database via JDBC, the system
provides full CRUD operations and advanced filtering for toxicity assessments.

**Core capabilities:**
- Register plants (toxic and medicinal) with type-specific attributes
- Register botanists and geographic regions
- Record toxicity assessments linking a botanist to a region, with counts of
  high and low toxicity plants
- Search assessments using multiple filters: botanist specialty, region
  accessibility, plant origin, used part, toxic compound, and minimum
  high-toxicity plant count
- View detailed assessment reports including botanist, region, and associated plants

---

## Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Java_Swing-007396?style=flat&logo=java&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-4479A1?style=flat&logo=mysql&logoColor=white)

- Java 8+
- Java Swing (GUI)
- JDBC for database connectivity
- Relational database (schema defined in `banco.sql`)
- NetBeans IDE (visual form editor)

---

**Domain entities:**

| Entity | Key attributes |
|---|---|
| `Plant` | name, toxicity, origin |
| `MedicinalPlant` (extends Plant) | used_part, therapeutic_property |
| `ToxicPlant` (extends Plant) | toxic_compound, side_effect |
| `Botanist` | name, specialty, qualification |
| `Region` | ecosystem, state, accessibility, risk_season |
| `ToxicityAssessment` | botanist, region, high/low toxicity plant counts |

---

## Getting Started

**Prerequisites:**
- Java 8+
- A relational database configured using the provided `banco.sql` script

**Setup:**

```bash
# 1. Clone the repository
git clone https://github.com/bellchilk/avaliacao-regioes-plantas-toxicas-java.git

# 2. Import the project into NetBeans (or any Java IDE)

# 3. Run the banco.sql script to create the required tables

# 4. Configure your database connection in BD.java
#    Set the correct URL, username, and password

# 5. Run App.java to launch the application
```

**Navigation:** Use the top menu bar to access all features:

| Menu | Action |
|---|---|
| Planta → Cadastrar | Register a new plant |
| Botânico → Cadastrar | Register a new botanist |
| Região → Cadastrar | Register a new region |
| Avaliação → Cadastrar | Record a toxicity assessment |
| Avaliação → Pesquisar | Search and filter assessments |

Closing the main window terminates the database connection and exits the application.

---

## Key Concepts Practiced

- GUI development with Java Swing and NetBeans visual editor
- Relational database design and SQL schema definition
- JDBC for database connectivity and query execution
- Object-oriented modeling with inheritance (`Plant` → `MedicinalPlant`, `ToxicPlant`)
- Multi-criteria search and filtering logic

---

*Submitted for Programming Languages II — November 2025*

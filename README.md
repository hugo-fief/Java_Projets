# PROJETS RÉALISÉS EN JAVA

## Sommaire

* [Projet Fight Game](#projet-fight-game)
  * [Arborescence du projet Fight Game](#arborescence-du-projet-fight-game)
  * [Bonnes pratiques de Développement pour le projet Fight Game](#bonnes-pratiques-de-developpement-pour-le-projet-fight-game)
  * [Forces du projet Fight Game](#forces-du-projet-fight-game)
* [Projet Todo List](#projet-todo-list)
  * [Arborescence du projet Todo List](#arborescence-du-projet-todo-list)
  * [Bonnes pratiques de Développement pour le projet Todo List](#bonnes-pratiques-de-developpement-pour-le-projet-todo-list)
  * [Forces du projet Todo List](#forces-du-projet-todo-list)
* [Commandes Maven a connaitre](#commandes-maven-a-connaitre)

## Projet Fight Game

### Arborescence du Projet Fight Game
```
fight_game/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── mygame/
│   │   │   │   │   ├── Game.java
│   │   │   │   │   ├── battle/
│   │   │   │   │   │   ├── Battle.java
│   │   │   │   │   ├── player/
│   │   │   │   │   │   ├── Player.java
│   │   │   │   │   │   ├── PlayerFactory.java
│   │   │   │   │   ├── strategy/
│   │   │   │   │   │   ├── AttackStrategy.java
│   │   │   │   │   │   ├── NormalAttack.java
│   │   │   │   │   │   ├── SpecialAttack.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── mygame/
│   │   │   │   │   ├── GameTest.java
│   │   │   │   │   ├── battle/
│   │   │   │   │   │   ├── BattleTest.java
│   │   │   │   │   ├── player/
│   │   │   │   │   │   ├── PlayerTest.java
│   │   │   │   │   │   ├── PlayerFactoryTest.java
│   │   │   │   │   ├── strategy/
│   │   │   │   │   │   ├── AttackStrategyTest.java
│   │   │   │   │   │   ├── NormalAttackTest.java
│   │   │   │   │   │   ├── SpecialAttackTest.java
```

### Bonnes pratiques de Developpement pour le projet Fight Game
- Utilisation du `pattern Strategy` pour les différentes attaques
- Utilisation du `pattern Factory` pour la création des joueurs
- Respect des `principes SOLID` pour un code maintenable et extensible

### Forces du projet Fight Game
- `Configuration Maven` : Utilisation de Maven pour la gestion des dépendances et l'organisation du projet.
- `Logging avec SLF4J et Logback` : Utilisation de SLF4J pour des logs propres et professionnels.
- `Ajout de probabilités d'attaque` : Introduction de la logique de succès/échec des attaques pour rendre le jeu plus intéressant.
- `Coloration des logs` : Utilisation de la bibliothèque Jansi pour ajouter des couleurs aux messages de log, améliorant ainsi la lisibilité.

---

## Projet Todo List

### Arborescence du projet Todo List
```
task-manager/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── taskmanager/
│   │   │           ├── Main.java
│   │   │           ├── Task.java
│   │   │           ├── TaskManager.java
│   │   │           ├── TaskPriority.java
│   │   │           └── TaskStatus.java
│   │   └── resources/
│   │       └── logback.xml
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── taskmanager/
│       │           └── TaskManagerTest.java
```

### Bonnes pratiques de Developpement pour le projet Todo List
- Utilisation du `pattern Strategy` pour les différentes priorités et statuts
- Utilisation du `pattern Factory` pour la création des tâches
- Respect des `principes SOLID` pour un code maintenable et extensible

### Forces du projet Todo List
- `Configuration Maven` : Utilisation de Maven pour la gestion des dépendances et l'organisation du projet.
- `Logging avec SLF4J et Logback` : Utilisation de SLF4J pour des logs propres et professionnels.
- `Coloration des logs` : Utilisation de la bibliothèque Jansi pour ajouter des couleurs aux messages de log, améliorant ainsi la lisibilité.

---

## Commandes Maven a connaitre

- `mvn clean install` : Supprime tous les fichiers générés par le build précédent + Compile le projet, exécute les tests et installe le fichier JAR du projet
- `mvn compile` : Compile le code source du projet & génère les fichiers du build en cours
- `mvn test` : Compile le code source & exécute les tests unitaires
- `mvn exec:java -Dexec.mainClass="com.taskmanager.Main"` : Exécute une classe java spécifique
